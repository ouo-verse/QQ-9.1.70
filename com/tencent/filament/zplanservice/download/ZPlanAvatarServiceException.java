package com.tencent.filament.zplanservice.download;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/filament/zplanservice/download/ZPlanAvatarServiceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;)V", "getError", "()Lcom/tencent/filament/zplanservice/download/ZPlanAvatarError;", "toString", "", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class ZPlanAvatarServiceException extends Exception {

    @NotNull
    private final ZPlanAvatarError error;

    public ZPlanAvatarServiceException(@NotNull ZPlanAvatarError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
    }

    @NotNull
    public final ZPlanAvatarError getError() {
        return this.error;
    }

    @Override // java.lang.Throwable
    @NotNull
    public String toString() {
        if (this.error.getCheckResult() == null) {
            return "errorCode:" + this.error.getErrorCode() + ", errMsg:" + this.error.getErrorMsg();
        }
        return "errorCode:" + this.error.getErrorCode() + ", errMsg:" + this.error.getErrorMsg() + ", checkResult:" + this.error.getCheckResult();
    }
}
