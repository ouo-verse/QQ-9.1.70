package com.tencent.mobileqq.triton.exception;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/triton/exception/TritonInitException;", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "message", "", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/exception/ErrorCodes;Ljava/lang/Throwable;)V", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public class TritonInitException extends TritonException {
    @JvmOverloads
    public TritonInitException(@NotNull String str) {
        this(str, null, null, 6, null);
    }

    @JvmOverloads
    public TritonInitException(@NotNull String str, @NotNull ErrorCodes errorCodes) {
        this(str, errorCodes, null, 4, null);
    }

    public /* synthetic */ TritonInitException(String str, ErrorCodes errorCodes, Throwable th5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? ErrorCodes.INITIALIZE : errorCodes, (i3 & 4) != 0 ? null : th5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TritonInitException(@NotNull String message, @NotNull ErrorCodes error, @Nullable Throwable th5) {
        super(message, error, th5);
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(error, "error");
    }
}
