package com.tencent.mobileqq.vas.perception.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u0002H&\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/perception/api/VipPerceptionRequestResult;", "T", "", "failure", "", "code", "", "msg", "", "result", "(ILjava/lang/String;Ljava/lang/Object;)V", "success", "data", "(Ljava/lang/Object;Ljava/lang/Object;)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface VipPerceptionRequestResult<T> {
    void failure(int code, @NotNull String msg2, @Nullable T result);

    void success(T result, @NotNull Object data);
}
