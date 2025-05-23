package com.tencent.mobileqq.transfile.http2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HttpConnectionService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HttpConnectionService";
    private boolean isEnableHttp2;
    private volatile OkHttpURLConnectionFactory mUrlConnectionFactory;

    public HttpConnectionService() {
        this(false);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private OkHttpURLConnectionFactory getUrlConnectionFactory() {
        if (this.mUrlConnectionFactory == null) {
            synchronized (HttpConnectionService.class) {
                if (this.mUrlConnectionFactory == null) {
                    this.mUrlConnectionFactory = new OkHttpURLConnectionFactory();
                }
            }
        }
        return this.mUrlConnectionFactory;
    }

    private HttpURLConnection internalOpenConnection(URL url, Proxy proxy) throws IOException {
        if (this.isEnableHttp2) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "internalOpenConnection url:", url, ", isEnableHttp2:", Boolean.valueOf(this.isEnableHttp2));
            }
            OkHttpURLConnectionFactory urlConnectionFactory = getUrlConnectionFactory();
            if (proxy == null) {
                return (HttpURLConnection) urlConnectionFactory.openConnection(url);
            }
            return (HttpURLConnection) urlConnectionFactory.openConnection(url, proxy);
        }
        if (proxy == null) {
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection(proxy);
    }

    public void enableHttp2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isEnableHttp2 = z16;
        }
    }

    public boolean isEnableHttp2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isEnableHttp2;
    }

    public HttpURLConnection openConnection(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? openConnection(new URL(str)) : (HttpURLConnection) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public HttpConnectionService(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.isEnableHttp2 = z16;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        }
    }

    public HttpURLConnection openConnection(String str, String str2, int i3) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? openConnection(new URL(str), new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str2, i3))) : (HttpURLConnection) iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
    }

    public HttpURLConnection openConnection(URL url) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? internalOpenConnection(url, null) : (HttpURLConnection) iPatchRedirector.redirect((short) 7, (Object) this, (Object) url);
    }

    public HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? internalOpenConnection(url, proxy) : (HttpURLConnection) iPatchRedirector.redirect((short) 8, (Object) this, (Object) url, (Object) proxy);
    }
}
