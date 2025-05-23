package android.net.http;

/* compiled from: P */
/* loaded from: classes.dex */
public class LoggingEventHandler implements EventHandler {
    public LoggingEventHandler() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void certificate(SslCertificate sslCertificate) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void data(byte[] bArr, int i3) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void endData() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void error(int i3, String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public boolean handleSslErrorRequest(SslError sslError) {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void headers(Headers headers) {
        throw new RuntimeException("Stub!");
    }

    public void locationChanged(String str, boolean z16) {
        throw new RuntimeException("Stub!");
    }

    public void requestSent() {
        throw new RuntimeException("Stub!");
    }

    @Override // android.net.http.EventHandler
    public void status(int i3, int i16, int i17, String str) {
        throw new RuntimeException("Stub!");
    }
}
