package okio;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", com.tencent.mobileqq.msf.core.d.f247918u, "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "timedOut", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {

    @NotNull
    private final Socket socket;

    public SocketAsyncTimeout(@NotNull Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
    }

    @Override // okio.AsyncTimeout
    @NotNull
    protected IOException newTimeoutException(@Nullable IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.socket.close();
        } catch (AssertionError e16) {
            if (Okio.isAndroidGetsocknameError(e16)) {
                logger2 = Okio__JvmOkioKt.logger;
                logger2.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), (Throwable) e16);
                return;
            }
            throw e16;
        } catch (Exception e17) {
            logger = Okio__JvmOkioKt.logger;
            logger.log(Level.WARNING, Intrinsics.stringPlus("Failed to close timed out socket ", this.socket), (Throwable) e17);
        }
    }
}
