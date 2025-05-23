package com.tencent.mobileqq.triton.statistic;

import com.tencent.mobileqq.triton.exception.TritonException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/ErrorCallback;", "", "onError", "", "message", "", "exception", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "onScriptError", "stack", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public interface ErrorCallback {
    void onError(@NotNull String message, @NotNull TritonException exception);

    void onScriptError(@NotNull String message, @NotNull String stack);
}
