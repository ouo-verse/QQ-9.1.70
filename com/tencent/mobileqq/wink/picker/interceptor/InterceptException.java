package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/InterceptException;", "Ljava/lang/InterruptedException;", "interceptorName", "", "errorCode", "Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;", "(Ljava/lang/String;Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;)V", "getErrorCode", "()Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;", "getInterceptorName", "()Ljava/lang/String;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class InterceptException extends InterruptedException {

    @NotNull
    private final MediaPickerErrorCode errorCode;

    @NotNull
    private final String interceptorName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterceptException(@NotNull String interceptorName, @NotNull MediaPickerErrorCode errorCode) {
        super(errorCode.getMessage());
        Intrinsics.checkNotNullParameter(interceptorName, "interceptorName");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.interceptorName = interceptorName;
        this.errorCode = errorCode;
    }

    @NotNull
    public final MediaPickerErrorCode getErrorCode() {
        return this.errorCode;
    }

    @NotNull
    public final String getInterceptorName() {
        return this.interceptorName;
    }
}
