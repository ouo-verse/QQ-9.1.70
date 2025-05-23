package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.viewmodel;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/viewmodel/TemplateShareException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(ILjava/lang/Throwable;)V", "getCode", "()I", "message", "", "getMessage", "()Ljava/lang/String;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class TemplateShareException extends Exception {
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemplateShareException(int i3, @NotNull Throwable cause) {
        super(cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
        this.code = i3;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return super.getMessage() + " code: " + this.code;
    }
}
