package kotlinx.coroutines;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\b*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0080\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001\u00a8\u0006\n"}, d2 = {"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "addSuppressedThrowable", "", "other", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ExceptionsKt {
    @NotNull
    public static final CancellationException CancellationException(@Nullable String str, @Nullable Throwable th5) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th5);
        return cancellationException;
    }

    public static final void addSuppressedThrowable(@NotNull Throwable th5, @NotNull Throwable th6) {
        ExceptionsKt__ExceptionsKt.addSuppressed(th5, th6);
    }
}
