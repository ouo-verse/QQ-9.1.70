package cooperation.qzone.statistic.access;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class HttpMultiServer {
    protected String defaultServer;
    protected boolean optionalEnabled;

    public HttpMultiServer() {
        this(null);
    }

    public abstract String acquireOptionalServer();

    public String getDefaultServer() {
        return this.defaultServer;
    }

    public String getOptionalRedirectHost() {
        return null;
    }

    public String getOptionalServer() {
        if (isOptionalEnabled()) {
            return acquireOptionalServer();
        }
        return null;
    }

    public boolean isOptionalEnabled() {
        return this.optionalEnabled;
    }

    public void setDefaultServer(String str) {
        this.defaultServer = str;
    }

    public void setOptionalEnabled(boolean z16) {
        this.optionalEnabled = z16;
    }

    public HttpMultiServer(String str) {
        this(str, false);
    }

    public HttpMultiServer(String str, boolean z16) {
        this.defaultServer = null;
        this.optionalEnabled = false;
        setDefaultServer(str);
        setOptionalEnabled(z16);
    }
}
