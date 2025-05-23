package com.tencent.state.square;

import android.net.SSLCertificateSocketFactory;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.File;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/square/SimpleHttpDownloader;", "Lcom/tencent/state/square/IHttpDownloader;", "()V", "threadPool", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPool", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPool$delegate", "Lkotlin/Lazy;", "download", "", "task", "Lcom/tencent/state/square/IHttpDownloader$Task;", "listener", "Lcom/tencent/state/square/IDownloadListener;", "executeTask", "Lkotlin/Function0;", "getIp", "", "getReplaceHost", "getTmpFile", "Ljava/io/File;", "needIpConnect", "", "Companion", "SniSSLSocketFactory", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public class SimpleHttpDownloader implements IHttpDownloader {
    private static final int BUFFER_SIZE = 2048;
    private static final String KEY_REQUEST_HOST = "Host";
    private static final String TAG = "Square_SimpleHttpDownloader";
    private static final int TIMEOUT = 10000;

    /* renamed from: threadPool$delegate, reason: from kotlin metadata */
    private final Lazy threadPool;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J.\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nH\u0016J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J.\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/SimpleHttpDownloader$SniSSLSocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", UploadQualityReportBuilder.STATE_CONNECT, "Ljavax/net/ssl/HttpsURLConnection;", "(Ljavax/net/ssl/HttpsURLConnection;)V", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", ReportConstant.COSTREPORT_PREFIX, "", "autoClose", "", "localHost", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class SniSSLSocketFactory extends SSLSocketFactory {
        private static final int HANDSHAKE_TIMEOUT_MILLIS = 1000;
        private static final String TAG = "SniSSLSocketFactory";
        private final HttpsURLConnection connect;

        public SniSSLSocketFactory(@NotNull HttpsURLConnection connect) {
            Intrinsics.checkNotNullParameter(connect, "connect");
            this.connect = connect;
        }

        @Override // javax.net.SocketFactory
        @Nullable
        public Socket createSocket(@Nullable String host, int port) {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        @NotNull
        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        @NotNull
        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        @Override // javax.net.SocketFactory
        @Nullable
        public Socket createSocket(@Nullable String host, int port, @Nullable InetAddress localHost, int localPort) {
            return null;
        }

        @Override // javax.net.SocketFactory
        @Nullable
        public Socket createSocket(@Nullable InetAddress host, int port) {
            return null;
        }

        @Override // javax.net.SocketFactory
        @Nullable
        public Socket createSocket(@Nullable InetAddress address, int port, @Nullable InetAddress localAddress, int localPort) {
            return null;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        @NotNull
        public Socket createSocket(@NotNull Socket s16, @NotNull String host, int port, boolean autoClose) {
            Intrinsics.checkNotNullParameter(s16, "s");
            Intrinsics.checkNotNullParameter(host, "host");
            String requestProperty = this.connect.getRequestProperty("Host");
            if (requestProperty != null) {
                host = requestProperty;
            }
            SquareBaseKt.getSquareLog().i(TAG, "customized createSocket host is: " + host);
            InetAddress inetAddress = s16.getInetAddress();
            if (autoClose) {
                s16.close();
            }
            SocketFactory socketFactory = SSLCertificateSocketFactory.getDefault(1000);
            if (socketFactory != null) {
                SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) socketFactory;
                Socket createSocket = sSLCertificateSocketFactory.createSocket(inetAddress, port);
                if (createSocket != null) {
                    SSLSocket sSLSocket = (SSLSocket) createSocket;
                    sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                    sSLCertificateSocketFactory.setHostname(sSLSocket, host);
                    SSLSession session = sSLSocket.getSession();
                    Intrinsics.checkNotNullExpressionValue(session, "ssl.session");
                    if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, session)) {
                        SquareBaseKt.getSquareLog().i(TAG, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
                        return sSLSocket;
                    }
                    throw new SSLPeerUnverifiedException("Cannot verify hostname: " + host);
                }
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.SSLCertificateSocketFactory");
        }
    }

    public SimpleHttpDownloader() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.tencent.state.square.SimpleHttpDownloader$threadPool$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ThreadPoolExecutor invoke() {
                return new BaseThreadPoolExecutor(4, 20, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
            }
        });
        this.threadPool = lazy;
    }

    private final ThreadPoolExecutor getThreadPool() {
        return (ThreadPoolExecutor) this.threadPool.getValue();
    }

    @Override // com.tencent.state.square.IHttpDownloader
    public void download(@NotNull IHttpDownloader.Task task, @NotNull IDownloadListener listener) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(listener, "listener");
        executeTask(new SimpleHttpDownloader$download$1(this, listener, task));
    }

    public void executeTask(@NotNull Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        getThreadPool().execute(new SquareConfigKt$sam$java_lang_Runnable$0(task));
    }

    @Override // com.tencent.state.square.IHttpDownloader
    @Nullable
    public String getIp() {
        return null;
    }

    @Override // com.tencent.state.square.IHttpDownloader
    @NotNull
    public String getReplaceHost() {
        return "record.superqqshow.qq.com";
    }

    @NotNull
    public File getTmpFile(@NotNull IHttpDownloader.Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        File tmpFile = File.createTempFile(task.hashCode() + "_square", System.nanoTime() + ".tmp");
        if (!tmpFile.exists()) {
            Intrinsics.checkNotNullExpressionValue(tmpFile, "tmpFile");
            File parentFile = tmpFile.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            tmpFile.createNewFile();
        }
        Intrinsics.checkNotNullExpressionValue(tmpFile, "tmpFile");
        return tmpFile;
    }

    @Override // com.tencent.state.square.IHttpDownloader
    public boolean needIpConnect() {
        return false;
    }
}
