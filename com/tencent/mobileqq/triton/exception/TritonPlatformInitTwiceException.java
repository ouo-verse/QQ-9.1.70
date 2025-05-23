package com.tencent.mobileqq.triton.exception;

import com.tencent.mobileqq.triton.TritonPlatform;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/exception/TritonPlatformInitTwiceException;", "Lcom/tencent/mobileqq/triton/exception/TritonInitException;", "message", "", "previouslyBuiltPlatform", "Lcom/tencent/mobileqq/triton/TritonPlatform;", "previouslyBuildingStackTrace", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/TritonPlatform;Ljava/lang/Throwable;)V", "getPreviouslyBuildingStackTrace", "()Ljava/lang/Throwable;", "getPreviouslyBuiltPlatform", "()Lcom/tencent/mobileqq/triton/TritonPlatform;", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TritonPlatformInitTwiceException extends TritonInitException {

    @NotNull
    private final Throwable previouslyBuildingStackTrace;

    @NotNull
    private final TritonPlatform previouslyBuiltPlatform;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TritonPlatformInitTwiceException(@NotNull String message, @NotNull TritonPlatform previouslyBuiltPlatform, @NotNull Throwable previouslyBuildingStackTrace) {
        super(message, null, previouslyBuildingStackTrace, 2, null);
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(previouslyBuiltPlatform, "previouslyBuiltPlatform");
        Intrinsics.checkParameterIsNotNull(previouslyBuildingStackTrace, "previouslyBuildingStackTrace");
        this.previouslyBuiltPlatform = previouslyBuiltPlatform;
        this.previouslyBuildingStackTrace = previouslyBuildingStackTrace;
    }

    @NotNull
    public final Throwable getPreviouslyBuildingStackTrace() {
        return this.previouslyBuildingStackTrace;
    }

    @NotNull
    public final TritonPlatform getPreviouslyBuiltPlatform() {
        return this.previouslyBuiltPlatform;
    }
}
