package org.apache.http.client.params;

import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

@Deprecated
/* loaded from: classes29.dex */
public class ClientParamBean extends HttpAbstractParamBean {
    public ClientParamBean(HttpParams httpParams) {
        super(null);
        throw new RuntimeException("Stub!");
    }

    public void setAllowCircularRedirects(boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactory(ClientConnectionManagerFactory clientConnectionManagerFactory) {
        throw new RuntimeException("Stub!");
    }

    public void setConnectionManagerFactoryClassName(String str) {
        throw new RuntimeException("Stub!");
    }

    public void setCookiePolicy(String str) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHeaders(Collection<Header> collection) {
        throw new RuntimeException("Stub!");
    }

    public void setDefaultHost(HttpHost httpHost) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleAuthentication(boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public void setHandleRedirects(boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public void setMaxRedirects(int i3) {
        throw new RuntimeException("Stub!");
    }

    public void setRejectRelativeRedirect(boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public void setVirtualHost(HttpHost httpHost) {
        throw new RuntimeException("Stub!");
    }
}
