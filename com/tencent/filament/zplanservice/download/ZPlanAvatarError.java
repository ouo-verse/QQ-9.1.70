package com.tencent.filament.zplanservice.download;

import androidx.annotation.Keep;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = false, allMethods = false)
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "", "intCode", "", "errorMsg", "", "checkResult", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "(ILjava/lang/String;Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;)V", "getCheckResult", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarCheckResult;", "errorCode", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarErrorCode;", "getErrorCode", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarErrorCode;", "getErrorMsg", "()Ljava/lang/String;", "toString", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarError {

    @Nullable
    private final ZPlanAvatarCheckResult checkResult;

    @NotNull
    private final ZPlanAvatarErrorCode errorCode;

    @NotNull
    private final String errorMsg;

    @NativeMethodProxy
    public ZPlanAvatarError(int i3, @NotNull String errorMsg, @Nullable ZPlanAvatarCheckResult zPlanAvatarCheckResult) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorMsg = errorMsg;
        this.checkResult = zPlanAvatarCheckResult;
        this.errorCode = ZPlanAvatarErrorCode.INSTANCE.a(i3);
    }

    @Nullable
    public final ZPlanAvatarCheckResult getCheckResult() {
        return this.checkResult;
    }

    @NotNull
    public final ZPlanAvatarErrorCode getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    @NotNull
    public String toString() {
        return "ZPlanAvatarError errorCode:" + this.errorCode + ", errorMsg:" + this.errorMsg + '}';
    }
}
