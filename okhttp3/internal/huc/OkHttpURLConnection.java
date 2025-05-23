package okhttp3.internal.huc;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    Call call;
    private Throwable callFailure;
    OkHttpClient client;
    boolean connectPending;
    private boolean executed;
    private long fixedContentLength;
    Handshake handshake;
    private final Object lock;
    private final NetworkInterceptor networkInterceptor;
    Response networkResponse;
    Proxy proxy;
    private Headers.Builder requestHeaders;
    private Response response;
    private Headers responseHeaders;
    URLFilter urlFilter;
    public static final String SELECTED_PROTOCOL = Platform.get().getPrefix() + "-Selected-Protocol";
    public static final String RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
    private static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, "DELETE", "TRACE", "PATCH"));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public final class NetworkInterceptor implements Interceptor {
        private boolean proceed;

        NetworkInterceptor() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            URLFilter uRLFilter = OkHttpURLConnection.this.urlFilter;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(request.url().url());
            }
            synchronized (OkHttpURLConnection.this.lock) {
                OkHttpURLConnection okHttpURLConnection = OkHttpURLConnection.this;
                okHttpURLConnection.connectPending = false;
                okHttpURLConnection.proxy = chain.connection().getRoute().proxy();
                OkHttpURLConnection.this.handshake = chain.connection().getHandshake();
                OkHttpURLConnection.this.lock.notifyAll();
                while (!this.proceed) {
                    try {
                        LockMethodProxy.wait(OkHttpURLConnection.this.lock);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            if (request.body() instanceof OutputStreamRequestBody) {
                request = ((OutputStreamRequestBody) request.body()).prepareToSendRequest(request);
            }
            Response proceed = chain.proceed(request);
            synchronized (OkHttpURLConnection.this.lock) {
                OkHttpURLConnection okHttpURLConnection2 = OkHttpURLConnection.this;
                okHttpURLConnection2.networkResponse = proceed;
                ((HttpURLConnection) okHttpURLConnection2).url = proceed.request().url().url();
            }
            return proceed;
        }

        public void proceed() {
            synchronized (OkHttpURLConnection.this.lock) {
                this.proceed = true;
                OkHttpURLConnection.this.lock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class UnexpectedException extends IOException {
        static final Interceptor INTERCEPTOR = new Interceptor() { // from class: okhttp3.internal.huc.OkHttpURLConnection.UnexpectedException.1
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (Error | RuntimeException e16) {
                    throw new UnexpectedException(e16);
                }
            }
        };

        UnexpectedException(Throwable th5) {
            super(th5);
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        this.networkInterceptor = new NetworkInterceptor();
        this.requestHeaders = new Headers.Builder();
        this.fixedContentLength = -1L;
        this.lock = new Object();
        this.connectPending = true;
        this.client = okHttpClient;
    }

    private Call buildCall() throws IOException {
        OutputStreamRequestBody outputStreamRequestBody;
        Call call = this.call;
        if (call != null) {
            return call;
        }
        boolean z16 = true;
        ((HttpURLConnection) this).connected = true;
        if (((HttpURLConnection) this).doOutput) {
            if (((HttpURLConnection) this).method.equals("GET")) {
                ((HttpURLConnection) this).method = "POST";
            } else if (!HttpMethod.permitsRequestBody(((HttpURLConnection) this).method)) {
                throw new ProtocolException(((HttpURLConnection) this).method + " does not support writing");
            }
        }
        if (this.requestHeaders.get("User-Agent") == null) {
            this.requestHeaders.add("User-Agent", defaultUserAgent());
        }
        if (HttpMethod.permitsRequestBody(((HttpURLConnection) this).method)) {
            if (this.requestHeaders.get("Content-Type") == null) {
                this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
            }
            long j3 = -1;
            if (this.fixedContentLength == -1 && ((HttpURLConnection) this).chunkLength <= 0) {
                z16 = false;
            }
            String str = this.requestHeaders.get("Content-Length");
            long j16 = this.fixedContentLength;
            if (j16 != -1) {
                j3 = j16;
            } else if (str != null) {
                j3 = Long.parseLong(str);
            }
            if (z16) {
                outputStreamRequestBody = new StreamedRequestBody(j3);
            } else {
                outputStreamRequestBody = new BufferedRequestBody(j3);
            }
            outputStreamRequestBody.timeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            outputStreamRequestBody = null;
        }
        try {
            Request build = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.requestHeaders.build()).method(((HttpURLConnection) this).method, outputStreamRequestBody).build();
            URLFilter uRLFilter = this.urlFilter;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(build.url().url());
            }
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
            newBuilder.networkInterceptors().clear();
            newBuilder.networkInterceptors().add(this.networkInterceptor);
            newBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
            if (!getUseCaches()) {
                newBuilder.cache(null);
            }
            Call newCall = newBuilder.build().newCall(build);
            this.call = newCall;
            return newCall;
        } catch (IllegalArgumentException e16) {
            if (Internal.instance.isInvalidHttpUrlHost(e16)) {
                UnknownHostException unknownHostException = new UnknownHostException();
                unknownHostException.initCause(e16);
                throw unknownHostException;
            }
            MalformedURLException malformedURLException = new MalformedURLException();
            malformedURLException.initCause(e16);
            throw malformedURLException;
        }
    }

    private String defaultUserAgent() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return toHumanReadableAscii(property);
        }
        return Version.userAgent();
    }

    private Headers getHeaders() throws IOException {
        if (this.responseHeaders == null) {
            Response response = getResponse(true);
            this.responseHeaders = response.headers().newBuilder().add(SELECTED_PROTOCOL, response.protocol().getProtocol()).add(RESPONSE_SOURCE, responseSourceHeader(response)).build();
        }
        return this.responseHeaders;
    }

    private Response getResponse(boolean z16) throws IOException {
        Response response;
        synchronized (this.lock) {
            Response response2 = this.response;
            if (response2 != null) {
                return response2;
            }
            Throwable th5 = this.callFailure;
            if (th5 != null) {
                if (z16 && (response = this.networkResponse) != null) {
                    return response;
                }
                throw propagate(th5);
            }
            Call buildCall = buildCall();
            this.networkInterceptor.proceed();
            OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall.request().body();
            if (outputStreamRequestBody != null) {
                outputStreamRequestBody.outputStream().close();
            }
            if (this.executed) {
                synchronized (this.lock) {
                    while (this.response == null && this.callFailure == null) {
                        try {
                            try {
                                LockMethodProxy.wait(this.lock);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                throw new InterruptedIOException();
                            }
                        } finally {
                        }
                    }
                }
            } else {
                this.executed = true;
                try {
                    onResponse(buildCall, buildCall.execute());
                } catch (IOException e16) {
                    onFailure(buildCall, e16);
                }
            }
            synchronized (this.lock) {
                Throwable th6 = this.callFailure;
                if (th6 == null) {
                    Response response3 = this.response;
                    if (response3 != null) {
                        return response3;
                    }
                    throw new AssertionError();
                }
                throw propagate(th6);
            }
        }
    }

    private static IOException propagate(Throwable th5) throws IOException {
        if (!(th5 instanceof IOException)) {
            if (!(th5 instanceof Error)) {
                if (th5 instanceof RuntimeException) {
                    throw ((RuntimeException) th5);
                }
                throw new AssertionError();
            }
            throw ((Error) th5);
        }
        throw ((IOException) th5);
    }

    private static String responseSourceHeader(Response response) {
        if (response.networkResponse() == null) {
            if (response.cacheResponse() == null) {
                return "NONE";
            }
            return "CACHE " + response.code();
        }
        if (response.cacheResponse() == null) {
            return "NETWORK " + response.code();
        }
        return "CONDITIONAL_CACHE " + response.networkResponse().code();
    }

    private static String toHumanReadableAscii(String str) {
        int i3;
        int length = str.length();
        int i16 = 0;
        while (i16 < length) {
            int codePointAt = str.codePointAt(i16);
            if (codePointAt > 31 && codePointAt < 127) {
                i16 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i16);
                buffer.writeUtf8CodePoint(63);
                while (true) {
                    i16 += Character.charCount(codePointAt);
                    if (i16 < length) {
                        codePointAt = str.codePointAt(i16);
                        if (codePointAt > 31 && codePointAt < 127) {
                            i3 = codePointAt;
                        } else {
                            i3 = 63;
                        }
                        buffer.writeUtf8CodePoint(i3);
                    } else {
                        return buffer.readUtf8();
                    }
                }
            }
        }
        return str;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        if (!((HttpURLConnection) this).connected) {
            if (str != null) {
                if (str2 == null) {
                    Platform.get().log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
                    return;
                }
                this.requestHeaders.add(str, str2);
                return;
            }
            throw new NullPointerException("field == null");
        }
        throw new IllegalStateException("Cannot add request property after connection is made");
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        if (this.executed) {
            return;
        }
        Call buildCall = buildCall();
        this.executed = true;
        buildCall.enqueue(this);
        synchronized (this.lock) {
            while (this.connectPending && this.response == null && this.callFailure == null) {
                try {
                    LockMethodProxy.wait(this.lock);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
            Throwable th5 = this.callFailure;
            if (th5 != null) {
                throw propagate(th5);
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        if (this.call == null) {
            return;
        }
        this.networkInterceptor.proceed();
        this.call.cancel();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.client.connectTimeoutMillis();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        try {
            Response response = getResponse(true);
            if (HttpHeaders.hasBody(response) && response.code() >= 400) {
                return response.body().byteStream();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        try {
            Headers headers = getHeaders();
            if (i3 >= 0 && i3 < headers.size()) {
                return headers.value(i3);
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i3) {
        try {
            Headers headers = getHeaders();
            if (i3 >= 0 && i3 < headers.size()) {
                return headers.name(i3);
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        try {
            return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (((HttpURLConnection) this).doInput) {
            Response response = getResponse(false);
            if (response.code() < 400) {
                return response.body().byteStream();
            }
            throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.client.followRedirects();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall().request().body();
        if (outputStreamRequestBody != null) {
            if (outputStreamRequestBody instanceof StreamedRequestBody) {
                connect();
                this.networkInterceptor.proceed();
            }
            if (!outputStreamRequestBody.isClosed()) {
                return outputStreamRequestBody.outputStream();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        throw new ProtocolException("method does not support a request body: " + ((HttpURLConnection) this).method);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        int defaultPort;
        URL url = getURL();
        String host = url.getHost();
        if (url.getPort() != -1) {
            defaultPort = url.getPort();
        } else {
            defaultPort = HttpUrl.defaultPort(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.client.proxy().address();
            host = inetSocketAddress.getHostName();
            defaultPort = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + defaultPort, "connect, resolve");
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.client.readTimeoutMillis();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        if (!((HttpURLConnection) this).connected) {
            return JavaNetHeaders.toMultimap(this.requestHeaders.build(), null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.requestHeaders.get(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return getResponse(true).code();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        return getResponse(true).message();
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        synchronized (this.lock) {
            boolean z16 = iOException instanceof UnexpectedException;
            Throwable th5 = iOException;
            if (z16) {
                th5 = iOException.getCause();
            }
            this.callFailure = th5;
            this.lock.notifyAll();
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        synchronized (this.lock) {
            this.response = response;
            this.handshake = response.handshake();
            ((HttpURLConnection) this).url = response.request().url().url();
            this.lock.notifyAll();
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        this.client = this.client.newBuilder().connectTimeout(i3, TimeUnit.MILLISECONDS).build();
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        setFixedLengthStreamingMode(i3);
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        super.setIfModifiedSince(j3);
        if (((HttpURLConnection) this).ifModifiedSince != 0) {
            this.requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(((HttpURLConnection) this).ifModifiedSince)));
        } else {
            this.requestHeaders.removeAll("If-Modified-Since");
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        this.client = this.client.newBuilder().followRedirects(z16).build();
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        this.client = this.client.newBuilder().readTimeout(i3, TimeUnit.MILLISECONDS).build();
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Set<String> set = METHODS;
        if (set.contains(str)) {
            ((HttpURLConnection) this).method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + set + " but was " + str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        if (!((HttpURLConnection) this).connected) {
            if (str != null) {
                if (str2 == null) {
                    Platform.get().log(5, "Ignoring header " + str + " because its value was null.", (Throwable) null);
                    return;
                }
                this.requestHeaders.set(str, str2);
                return;
            }
            throw new NullPointerException("field == null");
        }
        throw new IllegalStateException("Cannot set request property after connection is made");
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        if (this.proxy != null) {
            return true;
        }
        Proxy proxy = this.client.proxy();
        if (proxy != null && proxy.type() != Proxy.Type.DIRECT) {
            return true;
        }
        return false;
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j3) {
        if (!((HttpURLConnection) this).connected) {
            if (((HttpURLConnection) this).chunkLength > 0) {
                throw new IllegalStateException("Already in chunked mode");
            }
            if (j3 >= 0) {
                this.fixedContentLength = j3;
                ((HttpURLConnection) this).fixedContentLength = (int) Math.min(j3, TTL.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("contentLength < 0");
        }
        throw new IllegalStateException("Already connected");
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        String str2;
        try {
            if (str == null) {
                str2 = StatusLine.get(getResponse(true)).toString();
            } else {
                str2 = getHeaders().get(str);
            }
            return str2;
        } catch (IOException unused) {
            return null;
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(url, okHttpClient);
        this.urlFilter = uRLFilter;
    }
}
