package com.tenpay.sdk.net.http.tls;

import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.TlsVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\u0004\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J,\u0010\u0004\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\tH\u0016J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\tH\u0016J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016\u00a2\u0006\u0002\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/sdk/net/http/tls/Tls12SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "delegate", "(Ljavax/net/ssl/SSLSocketFactory;)V", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", ReportConstant.COSTREPORT_PREFIX, "", "autoClose", "", "localHost", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "patch", d.f247918u, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class Tls12SocketFactory extends SSLSocketFactory {

    @NotNull
    private static final String[] TLS_ENABLE_PROTOCOLS = {TlsVersion.TLS_1_2.javaName(), TlsVersion.TLS_1_1.javaName()};

    @NotNull
    private final SSLSocketFactory delegate;

    public Tls12SocketFactory(@NotNull SSLSocketFactory delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    private final Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_ENABLE_PROTOCOLS);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    @NotNull
    public Socket createSocket(@Nullable Socket s16, @Nullable String host, int port, boolean autoClose) {
        Socket createSocket = this.delegate.createSocket(s16, host, port, autoClose);
        Intrinsics.checkNotNullExpressionValue(createSocket, "delegate.createSocket(s, host, port, autoClose)");
        return patch(createSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    @NotNull
    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.delegate.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, "delegate.defaultCipherSuites");
        return defaultCipherSuites;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    @NotNull
    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.delegate.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, "delegate.supportedCipherSuites");
        return supportedCipherSuites;
    }

    @Override // javax.net.SocketFactory
    @NotNull
    public Socket createSocket(@Nullable String host, int port) {
        Socket createSocket = this.delegate.createSocket(host, port);
        Intrinsics.checkNotNullExpressionValue(createSocket, "delegate.createSocket(host, port)");
        return patch(createSocket);
    }

    @Override // javax.net.SocketFactory
    @NotNull
    public Socket createSocket(@Nullable String host, int port, @Nullable InetAddress localHost, int localPort) {
        Socket createSocket = this.delegate.createSocket(host, port, localHost, localPort);
        Intrinsics.checkNotNullExpressionValue(createSocket, "delegate.createSocket(ho\u2026rt, localHost, localPort)");
        return patch(createSocket);
    }

    @Override // javax.net.SocketFactory
    @NotNull
    public Socket createSocket(@Nullable InetAddress host, int port) {
        Socket createSocket = this.delegate.createSocket(host, port);
        Intrinsics.checkNotNullExpressionValue(createSocket, "delegate.createSocket(host, port)");
        return patch(createSocket);
    }

    @Override // javax.net.SocketFactory
    @NotNull
    public Socket createSocket(@Nullable InetAddress address, int port, @Nullable InetAddress localAddress, int localPort) {
        Socket createSocket = this.delegate.createSocket(address, port, localAddress, localPort);
        Intrinsics.checkNotNullExpressionValue(createSocket, "delegate.createSocket(ad\u2026 localAddress, localPort)");
        return patch(createSocket);
    }
}
