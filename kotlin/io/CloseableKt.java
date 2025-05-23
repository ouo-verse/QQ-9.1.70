package kotlin.io;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.io.Closeable;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\b\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000b"}, d2 = {"closeFinally", "", "Ljava/io/Closeable;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", TransFileControllerImpl.VALUE_USE_PRE_CONN, BdhLogUtil.LogTag.Tag_Req, "T", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "CloseableKt")
/* loaded from: classes28.dex */
public final class CloseableKt {
    @SinceKotlin(version = "1.1")
    @PublishedApi
    public static final void closeFinally(@Nullable Closeable closeable, @Nullable Throwable th5) {
        if (closeable != null) {
            if (th5 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th6) {
                ExceptionsKt__ExceptionsKt.addSuppressed(th5, th6);
            }
        }
    }

    @InlineOnly
    private static final <T extends Closeable, R> R use(T t16, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R invoke = block.invoke(t16);
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                closeFinally(t16, null);
            } else if (t16 != null) {
                t16.close();
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                InlineMarker.finallyStart(1);
                if (!PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    if (t16 != null) {
                        try {
                            t16.close();
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    closeFinally(t16, th5);
                }
                InlineMarker.finallyEnd(1);
                throw th6;
            }
        }
    }
}
