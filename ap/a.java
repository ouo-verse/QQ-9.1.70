package ap;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.video.TVK_SDK.mediaplayer.http.AsyncHttpRequest;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f26614a;

    /* renamed from: b, reason: collision with root package name */
    private int f26615b;

    /* renamed from: c, reason: collision with root package name */
    private final DefaultHttpClient f26616c;

    /* renamed from: d, reason: collision with root package name */
    private final HttpContext f26617d;

    /* renamed from: e, reason: collision with root package name */
    private ExecutorService f26618e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Context, List<ap.c>> f26619f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, String> f26620g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f26621h;

    /* compiled from: P */
    /* renamed from: ap.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0061a implements HttpRequestInterceptor {
        C0061a() {
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader("Accept-Encoding")) {
                httpRequest.addHeader("Accept-Encoding", "gzip");
            }
            for (String str : a.this.f26620g.keySet()) {
                if (httpRequest.containsHeader(str)) {
                    Header firstHeader = httpRequest.getFirstHeader(str);
                    Log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", str, a.this.f26620g.get(str), firstHeader.getName(), firstHeader.getValue()));
                }
                httpRequest.addHeader(str, (String) a.this.f26620g.get(str));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements HttpResponseInterceptor {
        b() {
        }

        @Override // org.apache.http.HttpResponseInterceptor
        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            Header contentEncoding;
            HttpEntity entity = httpResponse.getEntity();
            if (entity == null || (contentEncoding = entity.getContentEncoding()) == null) {
                return;
            }
            for (HeaderElement headerElement : contentEncoding.getElements()) {
                if (headerElement.getName().equalsIgnoreCase("gzip")) {
                    httpResponse.setEntity(new e(entity));
                    return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements HttpRequestInterceptor {
        c() {
        }

        @Override // org.apache.http.HttpRequestInterceptor
        public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
            Credentials credentials;
            AuthState authState = (AuthState) httpContext.getAttribute(ClientContext.TARGET_AUTH_STATE);
            CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute(ClientContext.CREDS_PROVIDER);
            HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
            if (authState.getAuthScheme() != null || (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) == null) {
                return;
            }
            authState.setAuthScheme(new BasicScheme());
            authState.setCredentials(credentials);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements ThreadFactory {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f26625d = new AtomicInteger(1);

        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new BaseThread(runnable, "AsyncHttpClient#" + this.f26625d.addAndGet(1));
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class e extends HttpEntityWrapper {

        /* renamed from: d, reason: collision with root package name */
        InputStream f26627d;

        /* renamed from: e, reason: collision with root package name */
        PushbackInputStream f26628e;

        /* renamed from: f, reason: collision with root package name */
        GZIPInputStream f26629f;

        public e(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public void consumeContent() throws IOException {
            a.t(this.f26627d);
            a.t(this.f26628e);
            a.t(this.f26629f);
            super.consumeContent();
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public InputStream getContent() throws IOException {
            this.f26627d = this.wrappedEntity.getContent();
            PushbackInputStream pushbackInputStream = new PushbackInputStream(this.f26627d, 2);
            this.f26628e = pushbackInputStream;
            if (a.i(pushbackInputStream)) {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(this.f26628e);
                this.f26629f = gZIPInputStream;
                return gZIPInputStream;
            }
            return this.f26628e;
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public long getContentLength() {
            return -1L;
        }
    }

    public a() {
        this(false, 80, WebSocketImpl.DEFAULT_WSS_PORT);
    }

    public static void c(HttpEntity httpEntity) {
        Field field;
        if (httpEntity instanceof HttpEntityWrapper) {
            try {
                Field[] declaredFields = HttpEntityWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i3];
                    if (field.getName().equals("wrappedEntity")) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (field != null) {
                    field.setAccessible(true);
                    HttpEntity httpEntity2 = (HttpEntity) field.get(httpEntity);
                    if (httpEntity2 != null) {
                        httpEntity2.consumeContent();
                    }
                }
            } catch (Throwable th5) {
                Log.e("AsyncHttpClient", "wrappedEntity consume", th5);
            }
        }
    }

    private static SchemeRegistry f(boolean z16, int i3, int i16) {
        if (z16) {
            Log.d("AsyncHttpClient", "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i3 < 1) {
            Log.d("AsyncHttpClient", "Invalid HTTP port number specified, defaulting to 80");
            i3 = 80;
        }
        if (i16 < 1) {
            Log.d("AsyncHttpClient", "Invalid HTTPS port number specified, defaulting to 443");
            i16 = WebSocketImpl.DEFAULT_WSS_PORT;
        }
        SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), i3));
        schemeRegistry.register(new Scheme("https", socketFactory, i16));
        return schemeRegistry;
    }

    public ap.c d(Context context, String str, ap.d dVar, ap.e eVar) {
        return r(this.f26616c, this.f26617d, new HttpGet(h(this.f26621h, str, dVar)), null, eVar, context);
    }

    protected ExecutorService g() {
        return ProxyExecutors.newCachedThreadPool(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AsyncHttpRequest j(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ap.e eVar, Context context) {
        return new AsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, eVar);
    }

    protected AsyncHttpRequest k(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ap.e eVar, Context context, ap.d dVar) {
        return new AsyncHttpRequest(defaultHttpClient, httpContext, httpUriRequest, eVar, dVar);
    }

    public ap.c m(Context context, String str, ap.d dVar, ap.e eVar) {
        return o(context, str, l(dVar, eVar), null, eVar);
    }

    public ap.c o(Context context, String str, HttpEntity httpEntity, String str2, ap.e eVar) {
        return r(this.f26616c, this.f26617d, b(new HttpPost(URI.create(str).normalize()), httpEntity), str2, eVar, context);
    }

    public ap.c p(Context context, String str, Header[] headerArr, ap.d dVar, String str2, ap.e eVar) {
        HttpPost httpPost = new HttpPost(URI.create(str).normalize());
        if (dVar != null) {
            httpPost.setEntity(l(dVar, eVar));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        return r(this.f26616c, this.f26617d, httpPost, str2, eVar, context);
    }

    public a(boolean z16, int i3, int i16) {
        this(f(z16, i3, i16));
    }

    public ap.c e(String str, ap.d dVar, ap.e eVar) {
        return d(null, str, dVar, eVar);
    }

    public ap.c q(String str, ap.d dVar, ap.e eVar) {
        return m(null, str, dVar, eVar);
    }

    public a(SchemeRegistry schemeRegistry) {
        this.f26614a = 10;
        this.f26615b = 10000;
        this.f26621h = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, this.f26615b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.f26614a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.f26615b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.f26615b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f26618e = g();
        this.f26619f = Collections.synchronizedMap(new WeakHashMap());
        this.f26620g = new HashMap();
        this.f26617d = new SyncBasicHttpContext(new BasicHttpContext());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f26616c = defaultHttpClient;
        defaultHttpClient.addRequestInterceptor(new C0061a());
        defaultHttpClient.addResponseInterceptor(new b());
        defaultHttpClient.addRequestInterceptor(new c(), 0);
        defaultHttpClient.setHttpRequestRetryHandler(new f(5, 1500));
    }

    private HttpEntityEnclosingRequestBase b(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public static void t(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e16) {
                Log.w("AsyncHttpClient", "Cannot close input stream", e16);
            }
        }
    }

    private HttpEntity l(ap.d dVar, ap.e eVar) {
        if (dVar == null) {
            return null;
        }
        try {
            return dVar.b(eVar);
        } catch (IOException e16) {
            if (eVar != null) {
                eVar.j(0, null, null, e16);
                return null;
            }
            e16.printStackTrace();
            return null;
        }
    }

    public ap.c n(Context context, String str, String str2, Header[] headerArr, ap.d dVar, String str3, ap.e eVar) {
        URI create = URI.create(str);
        PlayerUtils.log(4, "AsyncHttpClient", "Async http client request safe url: " + str);
        HttpPost httpPost = new HttpPost(create.normalize());
        if (dVar != null) {
            httpPost.setEntity(l(dVar, eVar));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
            httpPost.addHeader("Host", str2);
            httpPost.addHeader("x-online-host", str2);
        }
        return s(this.f26616c, this.f26617d, httpPost, str3, eVar, context, dVar);
    }

    protected ap.c r(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ap.e eVar, Context context) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (eVar != null) {
            if (!eVar.e()) {
                if (str != null) {
                    httpUriRequest.setHeader("Content-Type", str);
                }
                eVar.h(httpUriRequest.getAllHeaders());
                eVar.c(httpUriRequest.getURI());
                AsyncHttpRequest j3 = j(defaultHttpClient, httpContext, httpUriRequest, str, eVar, context);
                this.f26618e.submit(j3);
                ap.c cVar = new ap.c(j3);
                if (context != null) {
                    List<ap.c> list = this.f26619f.get(context);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f26619f.put(context, list);
                    }
                    list.add(cVar);
                    Iterator<ap.c> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().c()) {
                            it.remove();
                        }
                    }
                }
                return cVar;
            }
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        throw new IllegalArgumentException("ResponseHandler must not be null");
    }

    protected ap.c s(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, ap.e eVar, Context context, ap.d dVar) {
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        }
        if (eVar != null) {
            if (!eVar.e()) {
                if (str != null) {
                    httpUriRequest.setHeader("Content-Type", str);
                }
                eVar.h(httpUriRequest.getAllHeaders());
                eVar.c(httpUriRequest.getURI());
                AsyncHttpRequest k3 = k(defaultHttpClient, httpContext, httpUriRequest, str, eVar, context, dVar);
                this.f26618e.submit(k3);
                ap.c cVar = new ap.c(k3);
                if (context != null) {
                    List<ap.c> list = this.f26619f.get(context);
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f26619f.put(context, list);
                    }
                    list.add(cVar);
                    Iterator<ap.c> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().c()) {
                            it.remove();
                        }
                    }
                }
                return cVar;
            }
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
        throw new IllegalArgumentException("ResponseHandler must not be null");
    }

    public static boolean i(PushbackInputStream pushbackInputStream) throws IOException {
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int read = pushbackInputStream.read(bArr);
        pushbackInputStream.unread(bArr);
        return read == 2 && 35615 == ((bArr[0] & 255) | ((bArr[1] << 8) & 65280));
    }

    public static String h(boolean z16, String str, ap.d dVar) {
        if (str == null) {
            return null;
        }
        if (z16) {
            str = str.replace(" ", "%20");
        }
        if (dVar == null) {
            return str;
        }
        String trim = dVar.c().trim();
        if (trim.equals("")) {
            return str;
        }
        String str2 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (trim.equals(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str2 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str2);
        return sb5.toString() + trim;
    }
}
