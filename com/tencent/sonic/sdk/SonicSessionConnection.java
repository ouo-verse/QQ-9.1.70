package com.tencent.sonic.sdk;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class SonicSessionConnection {
    static IPatchRedirector $redirector_ = null;
    public static final String CUSTOM_HEAD_FILED_ACCEPT_DIFF = "accept-diff";
    public static final String CUSTOM_HEAD_FILED_CACHE_OFFLINE = "cache-offline";
    public static final String CUSTOM_HEAD_FILED_DNS_PREFETCH = "sonic-dns-prefetch";
    public static final String CUSTOM_HEAD_FILED_ETAG = "eTag";
    public static final String CUSTOM_HEAD_FILED_HTML_SHA1 = "sonic-html-sha1";
    public static final String CUSTOM_HEAD_FILED_LINK = "sonic-link";
    public static final String CUSTOM_HEAD_FILED_SDK_VERSION = "sonic-sdk-version";
    public static final String CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK = "X-sonic-chunk";
    public static final String CUSTOM_HEAD_FILED_TEMPLATE_CHANGE = "template-change";
    public static final String CUSTOM_HEAD_FILED_TEMPLATE_TAG = "template-tag";
    public static final String DNS_PREFETCH_ADDRESS = "dns-prefetch-address";
    public static final String HTTP_HEAD_CSP = "Content-Security-Policy";
    public static final String HTTP_HEAD_CSP_REPORT_ONLY = "Content-Security-Policy-Report-Only";
    public static final String HTTP_HEAD_FIELD_CACHE_CONTROL = "Cache-Control";
    public static final String HTTP_HEAD_FIELD_CONTENT_LENGTH = "Content-Length";
    public static final String HTTP_HEAD_FIELD_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_HEAD_FIELD_COOKIE = "Cookie";
    public static final String HTTP_HEAD_FIELD_EXPIRES = "Expires";
    public static final String HTTP_HEAD_FIELD_PRAGMA = "Pragma";
    public static final String HTTP_HEAD_FILED_IF_NOT_MATCH = "If-None-Match";
    public static final String HTTP_HEAD_FILED_SET_COOKIE = "Set-Cookie";
    public static final String HTTP_HEAD_FILED_USER_AGENT = "User-Agent";
    private static final String TAG = "SonicSdk_SonicSessionConnection";
    protected final Intent intent;
    protected BufferedInputStream responseStream;
    protected final SonicSession session;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class SessionConnectionDefaultImpl extends SonicSessionConnection {
        static IPatchRedirector $redirector_;
        protected final URLConnection connectionImpl;

        public SessionConnectionDefaultImpl(SonicSession sonicSession, Intent intent) {
            super(sonicSession, intent);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sonicSession, (Object) intent);
                return;
            }
            URLConnection createConnection = createConnection();
            this.connectionImpl = createConnection;
            initConnection(createConnection);
        }

        protected URLConnection createConnection() {
            URLConnection uRLConnection;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (URLConnection) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String str2 = this.session.srcUrl;
            URLConnection uRLConnection2 = null;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            try {
                URL url = new URL(str2);
                String stringExtra = this.intent.getStringExtra(SonicSessionConnection.DNS_PREFETCH_ADDRESS);
                if (!TextUtils.isEmpty(stringExtra)) {
                    String host = url.getHost();
                    URL url2 = new URL(str2.replace(host, stringExtra));
                    SonicUtils.log(SonicSessionConnection.TAG, 4, "create UrlConnection with DNS-Prefetch(" + host + " -> " + stringExtra + ").");
                    str = host;
                    url = url2;
                } else {
                    str = null;
                }
                uRLConnection = url.openConnection();
                if (uRLConnection != null) {
                    try {
                        if (uRLConnection instanceof HttpURLConnection) {
                            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            uRLConnection.setRequestProperty("Host", str);
                            uRLConnection.setRequestProperty(SonicSessionConnection.CUSTOM_HEAD_FILED_DNS_PREFETCH, url.getHost());
                            if (uRLConnection instanceof HttpsURLConnection) {
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                                httpsURLConnection.setSSLSocketFactory(new SonicSniSSLSocketFactory(SonicEngine.getInstance().getRuntime().getContext(), str));
                                httpsURLConnection.setHostnameVerifier(new HostnameVerifier(url, str) { // from class: com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.1
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ String val$finalOriginHost;
                                    final /* synthetic */ URL val$finalUrl;

                                    {
                                        this.val$finalUrl = url;
                                        this.val$finalOriginHost = str;
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                            iPatchRedirector2.redirect((short) 1, this, SessionConnectionDefaultImpl.this, url, str);
                                        }
                                    }

                                    @Override // javax.net.ssl.HostnameVerifier
                                    public boolean verify(String str3, SSLSession sSLSession) {
                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                            return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) str3, (Object) sSLSession)).booleanValue();
                                        }
                                        long currentTimeMillis = System.currentTimeMillis();
                                        if (this.val$finalUrl.getHost().equals(str3)) {
                                            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$finalOriginHost, sSLSession);
                                            SonicUtils.log(SonicSessionConnection.TAG, 3, "verify hostname cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
                                            return verify;
                                        }
                                        return false;
                                    }
                                });
                                return uRLConnection;
                            }
                            return uRLConnection;
                        }
                        return uRLConnection;
                    } catch (Throwable th5) {
                        th = th5;
                        if (uRLConnection == null) {
                            uRLConnection2 = uRLConnection;
                        }
                        SonicUtils.log(SonicSessionConnection.TAG, 6, "create UrlConnection fail, error:" + th.getMessage() + ".");
                        return uRLConnection2;
                    }
                }
                return uRLConnection;
            } catch (Throwable th6) {
                th = th6;
                uRLConnection = null;
            }
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        public void disconnect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            URLConnection uRLConnection = this.connectionImpl;
            if (uRLConnection instanceof HttpURLConnection) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    SonicEngine.getInstance().getRuntime().postTaskToThread(new Runnable(httpURLConnection) { // from class: com.tencent.sonic.sdk.SonicSessionConnection.SessionConnectionDefaultImpl.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ HttpURLConnection val$httpURLConnection;

                        {
                            this.val$httpURLConnection = httpURLConnection;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SessionConnectionDefaultImpl.this, (Object) httpURLConnection);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                this.val$httpURLConnection.disconnect();
                            } catch (Throwable th5) {
                                SonicUtils.log(SonicSessionConnection.TAG, 6, "disconnect error:" + th5.getMessage());
                            }
                        }
                    }, 0L);
                    return;
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e16) {
                    SonicUtils.log(SonicSessionConnection.TAG, 6, "disconnect error:" + e16.getMessage());
                }
            }
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        public int getResponseCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            URLConnection uRLConnection = this.connectionImpl;
            if (uRLConnection instanceof HttpURLConnection) {
                try {
                    return ((HttpURLConnection) uRLConnection).getResponseCode();
                } catch (Throwable th5) {
                    String message = th5.getMessage();
                    SonicUtils.log(SonicSessionConnection.TAG, 6, "getResponseCode error:" + message);
                    if (th5 instanceof IOException) {
                        if (th5 instanceof SocketTimeoutException) {
                            return SonicConstants.ERROR_CODE_CONNECT_TOE;
                        }
                        if (!TextUtils.isEmpty(message) && message.contains("timeoutexception")) {
                            return SonicConstants.ERROR_CODE_CONNECT_TOE;
                        }
                        return SonicConstants.ERROR_CODE_CONNECT_IOE;
                    }
                    if (th5 instanceof NullPointerException) {
                        return SonicConstants.ERROR_CODE_CONNECT_NPE;
                    }
                    return -1;
                }
            }
            return -1;
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        public String getResponseHeaderField(String str) {
            List<String> list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            }
            Map<String, List<String>> responseHeaderFields = getResponseHeaderFields();
            if (responseHeaderFields != null && responseHeaderFields.size() != 0 && (list = responseHeaderFields.get(str.toLowerCase())) != null && list.size() != 0) {
                StringBuilder sb5 = new StringBuilder(list.get(0));
                int size = list.size();
                for (int i3 = 1; i3 < size; i3++) {
                    sb5.append(',');
                    sb5.append(list.get(i3));
                }
                return sb5.toString();
            }
            return null;
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        public Map<String, List<String>> getResponseHeaderFields() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            URLConnection uRLConnection = this.connectionImpl;
            if (uRLConnection == null) {
                return null;
            }
            try {
                return uRLConnection.getHeaderFields();
            } catch (Throwable th5) {
                SonicUtils.log(SonicSessionConnection.TAG, 6, "getHeaderFields error:" + th5.getMessage());
                return new HashMap();
            }
        }

        protected boolean initConnection(URLConnection uRLConnection) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLConnection)).booleanValue();
            }
            if (uRLConnection != null) {
                SonicSessionConfig sonicSessionConfig = this.session.config;
                uRLConnection.setConnectTimeout(sonicSessionConfig.CONNECT_TIMEOUT_MILLIS);
                uRLConnection.setReadTimeout(sonicSessionConfig.READ_TIMEOUT_MILLIS);
                if (sonicSessionConfig.ACCEPT_DIFF_DATA) {
                    str = "true";
                } else {
                    str = "false";
                }
                uRLConnection.setRequestProperty(SonicSessionConnection.CUSTOM_HEAD_FILED_ACCEPT_DIFF, str);
                String stringExtra = this.intent.getStringExtra("eTag");
                String str2 = "";
                if (stringExtra == null) {
                    stringExtra = "";
                }
                uRLConnection.setRequestProperty("If-None-Match", stringExtra);
                String stringExtra2 = this.intent.getStringExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG);
                if (stringExtra2 != null) {
                    str2 = stringExtra2;
                }
                uRLConnection.setRequestProperty(SonicSessionConnection.CUSTOM_HEAD_FILED_TEMPLATE_TAG, str2);
                uRLConnection.setRequestProperty("method", "GET");
                uRLConnection.setRequestProperty("Accept-Encoding", "gzip");
                uRLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;");
                uRLConnection.setRequestProperty(SonicSessionConnection.CUSTOM_HEAD_FILED_SDK_VERSION, "Sonic/3.0.2");
                if (this.intent.hasExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK)) {
                    uRLConnection.setRequestProperty(SonicSessionConnection.CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK, this.intent.getStringExtra(SonicSessionConnection.CUSTOM_HEAD_FILED_SONIC_DATA_CHUNK));
                }
                Map<String, String> map = sonicSessionConfig.customRequestHeaders;
                if (map != null && map.size() != 0) {
                    for (Map.Entry<String, String> entry : sonicSessionConfig.customRequestHeaders.entrySet()) {
                        uRLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                String stringExtra3 = this.intent.getStringExtra("Cookie");
                if (!TextUtils.isEmpty(stringExtra3)) {
                    uRLConnection.setRequestProperty("Cookie", stringExtra3);
                } else {
                    SonicUtils.log(SonicSessionConnection.TAG, 6, "create UrlConnection cookie is empty");
                }
                uRLConnection.setRequestProperty("User-Agent", this.intent.getStringExtra("User-Agent"));
                return true;
            }
            return false;
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        protected synchronized int internalConnect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            URLConnection uRLConnection = this.connectionImpl;
            if (uRLConnection instanceof HttpURLConnection) {
                try {
                    ((HttpURLConnection) uRLConnection).connect();
                    return 0;
                } catch (Throwable th5) {
                    String message = th5.getMessage();
                    SonicUtils.log(SonicSessionConnection.TAG, 6, "connect error:" + message);
                    if (th5 instanceof IOException) {
                        if (th5 instanceof SocketTimeoutException) {
                            return SonicConstants.ERROR_CODE_CONNECT_TOE;
                        }
                        if (!TextUtils.isEmpty(message) && message.contains("timeoutexception")) {
                            return SonicConstants.ERROR_CODE_CONNECT_TOE;
                        }
                        return SonicConstants.ERROR_CODE_CONNECT_IOE;
                    }
                    if (th5 instanceof NullPointerException) {
                        return SonicConstants.ERROR_CODE_CONNECT_NPE;
                    }
                }
            }
            return -1;
        }

        @Override // com.tencent.sonic.sdk.SonicSessionConnection
        protected BufferedInputStream internalGetResponseStream() {
            URLConnection uRLConnection;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (BufferedInputStream) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            if (this.responseStream == null && (uRLConnection = this.connectionImpl) != null) {
                try {
                    InputStream inputStream = uRLConnection.getInputStream();
                    if ("gzip".equalsIgnoreCase(this.connectionImpl.getContentEncoding())) {
                        this.responseStream = new BufferedInputStream(new GZIPInputStream(inputStream));
                    } else {
                        this.responseStream = new BufferedInputStream(inputStream);
                    }
                } catch (Throwable th5) {
                    SonicUtils.log(SonicSessionConnection.TAG, 6, "getResponseStream error:" + th5.getMessage() + ".");
                }
            }
            return this.responseStream;
        }
    }

    public SonicSessionConnection(SonicSession sonicSession, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sonicSession, (Object) intent);
        } else {
            this.session = sonicSession;
            this.intent = intent == null ? new Intent() : intent;
        }
    }

    public synchronized int connect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return internalConnect();
    }

    public abstract void disconnect();

    public abstract int getResponseCode();

    public abstract String getResponseHeaderField(String str);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    public synchronized BufferedInputStream getResponseStream() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BufferedInputStream) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.responseStream == null) {
            this.responseStream = internalGetResponseStream();
        }
        return this.responseStream;
    }

    protected abstract int internalConnect();

    protected abstract BufferedInputStream internalGetResponseStream();
}
