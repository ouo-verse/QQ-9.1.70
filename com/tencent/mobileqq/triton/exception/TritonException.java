package com.tencent.mobileqq.triton.exception;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/triton/exception/TritonException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "error", "Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/exception/ErrorCodes;Ljava/lang/Throwable;)V", "getError", "()Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "getMessage", "()Ljava/lang/String;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public class TritonException extends Exception {

    @NotNull
    private final ErrorCodes error;

    @JvmOverloads
    public TritonException(@NotNull String str) {
        this(str, null, null, 6, null);
    }

    @NotNull
    public final ErrorCodes getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String getMessage() {
        return this.error + TokenParser.SP + super.getMessage();
    }

    @JvmOverloads
    public TritonException(@NotNull String str, @NotNull ErrorCodes errorCodes) {
        this(str, errorCodes, null, 4, null);
    }

    public /* synthetic */ TritonException(String str, ErrorCodes errorCodes, Throwable th5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? ErrorCodes.UNKNOWN : errorCodes, (i3 & 4) != 0 ? null : th5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TritonException(@NotNull String message, @NotNull ErrorCodes error, @Nullable Throwable th5) {
        super(message, th5);
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(error, "error");
        this.error = error;
    }
}
