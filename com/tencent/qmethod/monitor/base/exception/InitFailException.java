package com.tencent.qmethod.monitor.base.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/base/exception/InitFailException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "type", "Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;", "(Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;)V", "getType", "()Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;", "InitFailType", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class InitFailException extends IllegalStateException {

    @NotNull
    private final InitFailType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qmethod/monitor/base/exception/InitFailException$InitFailType;", "", "(Ljava/lang/String;I)V", "PROTECTION", "NETWORK", "DYNAMIC_CONFIG", "DELAY_MODE", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum InitFailType {
        PROTECTION,
        NETWORK,
        DYNAMIC_CONFIG,
        DELAY_MODE
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitFailException(@NotNull InitFailType type) {
        super("\u521d\u59cb\u5316\u9519\u8bef,\u7c7b\u578b:" + type);
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.type = type;
    }

    @NotNull
    public final InitFailType getType() {
        return this.type;
    }
}
