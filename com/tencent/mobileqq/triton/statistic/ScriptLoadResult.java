package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "", "isSuccess", "", "(Ljava/lang/String;IZ)V", "()Z", "FAIL_INVALID_STATE", "FAIL_EXECUTE", "FAIL_COMPILE", "FAIL_READ_SCRIPT", "SUCCESS_WITH_CACHE", "SUCCESS_WITHOUT_CACHE", "SUCCESS_BUT_CACHE_REJECTED", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public enum ScriptLoadResult {
    FAIL_INVALID_STATE(false),
    FAIL_EXECUTE(false),
    FAIL_COMPILE(false),
    FAIL_READ_SCRIPT(false),
    SUCCESS_WITH_CACHE(true),
    SUCCESS_WITHOUT_CACHE(true),
    SUCCESS_BUT_CACHE_REJECTED(true);

    private final boolean isSuccess;

    ScriptLoadResult(boolean z16) {
        this.isSuccess = z16;
    }

    /* renamed from: isSuccess, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}
