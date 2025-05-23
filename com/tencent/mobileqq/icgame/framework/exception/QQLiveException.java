package com.tencent.mobileqq.icgame.framework.exception;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/exception/QQLiveException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "message", "", "(Ljava/lang/String;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "enableSuppression", "", "writableStackTrace", "(Ljava/lang/String;Ljava/lang/Throwable;ZZ)V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public class QQLiveException extends RuntimeException {
    public QQLiveException() {
    }

    public QQLiveException(@Nullable String str) {
        super(str);
    }

    public QQLiveException(@Nullable String str, @Nullable Throwable th5) {
        super(str, th5);
    }

    public QQLiveException(@Nullable Throwable th5) {
        super(th5);
    }

    public QQLiveException(@Nullable String str, @Nullable Throwable th5, boolean z16, boolean z17) {
        super(str, th5, z16, z17);
    }
}
