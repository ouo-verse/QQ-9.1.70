package com.tencent.mobileqq.transfile.http2.internal;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
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
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
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
import okhttp3.internal.Util;
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
    static IPatchRedirector $redirector_;
    private static final Set<String> METHODS;
    public static final String RESPONSE_SOURCE;
    public static final String SELECTED_PROTOCOL;
    private static final ExecutorService executorService;
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

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class InputStreamWrapClose extends InputStream {
        static IPatchRedirector $redirector_;

        /* renamed from: is, reason: collision with root package name */
        private final InputStream f293470is;
        private final Response response;

        public InputStreamWrapClose(InputStream inputStream, Response response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputStream, (Object) response);
            } else {
                this.f293470is = inputStream;
                this.response = response;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                super.close();
                this.response.close();
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f293470is.read();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public final class NetworkInterceptor implements Interceptor {
        static IPatchRedirector $redirector_;
        private boolean proceed;

        NetworkInterceptor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OkHttpURLConnection.this);
            }
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Response) iPatchRedirector.redirect((short) 3, (Object) this, (Object) chain);
            }
            Request request = chain.request();
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (OkHttpURLConnection.this.lock) {
                    this.proceed = true;
                    OkHttpURLConnection.this.lock.notifyAll();
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class UnexpectedException extends IOException {
        static IPatchRedirector $redirector_;
        static final Interceptor INTERCEPTOR;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40292);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INTERCEPTOR = new Interceptor() { // from class: com.tencent.mobileqq.transfile.http2.internal.OkHttpURLConnection.UnexpectedException.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // okhttp3.Interceptor
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (Response) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chain);
                        }
                        try {
                            return chain.proceed(chain.request());
                        } catch (Error | RuntimeException e16) {
                            throw new UnexpectedException(e16);
                        }
                    }
                };
            }
        }

        UnexpectedException(Throwable th5) {
            super(th5);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        SELECTED_PROTOCOL = Platform.get().getPrefix() + "-Selected-Protocol";
        RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
        METHODS = new LinkedHashSet(Arrays.asList(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, "DELETE", "TRACE", "PATCH"));
        executorService = new BaseThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) okHttpClient);
            return;
        }
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
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
            newBuilder.networkInterceptors().clear();
            newBuilder.networkInterceptors().add(this.networkInterceptor);
            newBuilder.dispatcher(new Dispatcher(executorService));
            if (!getUseCaches()) {
                newBuilder.cache(null);
            }
            Call newCall = newBuilder.build().newCall(build);
            this.call = newCall;
            return newCall;
        } catch (IllegalArgumentException e16) {
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
        return Util.userAgent;
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!((HttpURLConnection) this).connected) {
            if (str != null) {
                if (str2 == null) {
                    Platform.get().log("Ignoring header " + str + " because its value was null.", 5, null);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            getResponse(false);
        }
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.call == null) {
            return;
        }
        this.networkInterceptor.proceed();
        this.call.cancel();
        Response response = this.response;
        if (response != null) {
            response.close();
        }
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.client.connectTimeoutMillis();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InputStream) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        try {
            Response response = getResponse(true);
            if (HttpHeaders.hasBody(response) && response.code() >= 400) {
                return new InputStreamWrapClose(response.body().byteStream(), response);
            }
        } catch (IOException unused) {
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        try {
            return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.INSTANCE.get(getResponse(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (InputStream) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (((HttpURLConnection) this).doInput) {
            Response response = getResponse(false);
            if (response.code() < 400) {
                return new InputStreamWrapClose(response.body().byteStream(), response);
            }
            throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.client.followRedirects();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (OutputStream) iPatchRedirector.redirect((short) 11, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Permission) iPatchRedirector.redirect((short) 12, (Object) this);
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return this.client.readTimeoutMillis();
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        if (!((HttpURLConnection) this).connected) {
            return JavaNetHeaders.toMultimap(this.requestHeaders.build(), null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        return this.requestHeaders.get(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return getResponse(true).code();
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return getResponse(true).message();
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) call, (Object) iOException);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) call, (Object) response);
            return;
        }
        synchronized (this.lock) {
            this.response = response;
            this.handshake = response.handshake();
            ((HttpURLConnection) this).url = response.request().url().url();
            this.lock.notifyAll();
        }
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.client = this.client.newBuilder().connectTimeout(i3, TimeUnit.MILLISECONDS).build();
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            setFixedLengthStreamingMode(i3);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, j3);
            return;
        }
        super.setIfModifiedSince(j3);
        if (((HttpURLConnection) this).ifModifiedSince != 0) {
            this.requestHeaders.set("If-Modified-Since", new Date(((HttpURLConnection) this).ifModifiedSince));
        } else {
            this.requestHeaders.removeAll("If-Modified-Since");
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.client = this.client.newBuilder().followRedirects(z16).build();
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
        } else {
            this.client = this.client.newBuilder().readTimeout(i3, TimeUnit.MILLISECONDS).build();
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
            return;
        }
        Set<String> set = METHODS;
        if (set.contains(str)) {
            ((HttpURLConnection) this).method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + set + " but was " + str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!((HttpURLConnection) this).connected) {
            if (str != null) {
                if (str2 == null) {
                    Platform.get().log("Ignoring header " + str + " because its value was null.", 5, null);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, j3);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        try {
            if (str == null) {
                str2 = StatusLine.INSTANCE.get(getResponse(true)).toString();
            } else {
                str2 = getHeaders().get(str);
            }
            return str2;
        } catch (IOException unused) {
            return null;
        }
    }
}
