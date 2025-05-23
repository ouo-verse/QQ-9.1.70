package com.tencent.mobileqq.transfile.http2;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes19.dex */
public class OkHttpURLConnectionFactory {
    static IPatchRedirector $redirector_;
    private final ConfigAwareInstance configAwareConnectionPool;
    private final OkUrlFactory mOkUrlFactory;

    public OkHttpURLConnectionFactory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.configAwareConnectionPool = ConfigAwareInstance.getInstance();
            this.mOkUrlFactory = createOkUrlFactory();
        }
    }

    private OkUrlFactory createOkUrlFactory() {
        return new OkUrlFactory(this.configAwareConnectionPool.getOkHttpClient());
    }

    private URLConnection internalOpenConnection(URL url, Proxy proxy) throws IOException {
        String protocol2 = url.getProtocol();
        if (!protocol2.equals("http") && !protocol2.equals("https")) {
            throw new MalformedURLException("Invalid URL or unrecognized protocol " + protocol2);
        }
        if (proxy == null) {
            return this.mOkUrlFactory.open(url);
        }
        return this.mOkUrlFactory.open(url, proxy);
    }

    public URLConnection openConnection(URL url) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? internalOpenConnection(url, null) : (URLConnection) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
    }

    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (URLConnection) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) proxy);
        }
        Objects.requireNonNull(proxy);
        return internalOpenConnection(url, proxy);
    }
}
