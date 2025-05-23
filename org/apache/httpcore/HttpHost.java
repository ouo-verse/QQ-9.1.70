package org.apache.httpcore;

import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.httpcore.annotation.Contract;
import org.apache.httpcore.annotation.ThreadingBehavior;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.LangUtils;

/* compiled from: P */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
/* loaded from: classes29.dex */
public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String str, int i3, String str2) {
        this.hostname = (String) Args.containsNoBlanks(str, "Host name");
        Locale locale = Locale.ROOT;
        this.lcHostname = str.toLowerCase(locale);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(locale);
        } else {
            this.schemeName = "http";
        }
        this.port = i3;
        this.address = null;
    }

    public static HttpHost create(String str) {
        String str2;
        int i3;
        Args.containsNoBlanks(str, "HTTP Host");
        int indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        if (indexOf > 0) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 3);
        } else {
            str2 = null;
        }
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf > 0) {
            try {
                i3 = Integer.parseInt(str.substring(lastIndexOf + 1));
                str = str.substring(0, lastIndexOf);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException("Invalid HTTP host: " + str);
            }
        } else {
            i3 = -1;
        }
        return new HttpHost(str, i3, str2);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        HttpHost httpHost = (HttpHost) obj;
        if (this.lcHostname.equals(httpHost.lcHostname) && this.port == httpHost.port && this.schemeName.equals(httpHost.schemeName)) {
            InetAddress inetAddress = this.address;
            InetAddress inetAddress2 = httpHost.address;
            if (inetAddress == null) {
                if (inetAddress2 == null) {
                    return true;
                }
            } else if (inetAddress.equals(inetAddress2)) {
                return true;
            }
        }
        return false;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public int hashCode() {
        int hashCode = LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
        InetAddress inetAddress = this.address;
        if (inetAddress != null) {
            return LangUtils.hashCode(hashCode, inetAddress);
        }
        return hashCode;
    }

    public String toHostString() {
        if (this.port != -1) {
            StringBuilder sb5 = new StringBuilder(this.hostname.length() + 6);
            sb5.append(this.hostname);
            sb5.append(":");
            sb5.append(Integer.toString(this.port));
            return sb5.toString();
        }
        return this.hostname;
    }

    public String toString() {
        return toURI();
    }

    public String toURI() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.schemeName);
        sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        sb5.append(this.hostname);
        if (this.port != -1) {
            sb5.append(':');
            sb5.append(Integer.toString(this.port));
        }
        return sb5.toString();
    }

    public HttpHost(String str, int i3) {
        this(str, i3, (String) null);
    }

    public HttpHost(String str) {
        this(str, -1, (String) null);
    }

    public HttpHost(InetAddress inetAddress, int i3, String str) {
        this((InetAddress) Args.notNull(inetAddress, "Inet address"), inetAddress.getHostName(), i3, str);
    }

    public HttpHost(InetAddress inetAddress, String str, int i3, String str2) {
        this.address = (InetAddress) Args.notNull(inetAddress, "Inet address");
        String str3 = (String) Args.notNull(str, "Hostname");
        this.hostname = str3;
        Locale locale = Locale.ROOT;
        this.lcHostname = str3.toLowerCase(locale);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(locale);
        } else {
            this.schemeName = "http";
        }
        this.port = i3;
    }

    public HttpHost(InetAddress inetAddress, int i3) {
        this(inetAddress, i3, (String) null);
    }

    public HttpHost(InetAddress inetAddress) {
        this(inetAddress, -1, (String) null);
    }

    public HttpHost(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.hostname = httpHost.hostname;
        this.lcHostname = httpHost.lcHostname;
        this.schemeName = httpHost.schemeName;
        this.port = httpHost.port;
        this.address = httpHost.address;
    }
}
