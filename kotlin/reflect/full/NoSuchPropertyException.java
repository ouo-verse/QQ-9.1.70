package kotlin.reflect.full;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/full/NoSuchPropertyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "(Ljava/lang/Exception;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class NoSuchPropertyException extends Exception {
    public NoSuchPropertyException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public NoSuchPropertyException(@Nullable Exception exc) {
        super(exc);
    }

    public /* synthetic */ NoSuchPropertyException(Exception exc, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : exc);
    }
}
