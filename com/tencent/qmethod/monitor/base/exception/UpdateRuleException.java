package com.tencent.qmethod.monitor.base.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qmethod/monitor/base/exception/UpdateRuleException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "type", "Lcom/tencent/qmethod/monitor/base/exception/UpdateRuleException$UpdateRuleFailType;", "msg", "", "(Lcom/tencent/qmethod/monitor/base/exception/UpdateRuleException$UpdateRuleFailType;Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "getType", "()Lcom/tencent/qmethod/monitor/base/exception/UpdateRuleException$UpdateRuleFailType;", "UpdateRuleFailType", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes22.dex */
public final class UpdateRuleException extends IllegalStateException {

    @NotNull
    private final String msg;

    @NotNull
    private final UpdateRuleFailType type;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qmethod/monitor/base/exception/UpdateRuleException$UpdateRuleFailType;", "", "(Ljava/lang/String;I)V", "EMPTY_INFO", "EMPTY_API_RULE", "REPEAT_PAGE", "EMPTY_PAGE", "CACHE_TIME_ONLY_USE_IN_CACHE_OR_STORAGE_RULE", "API_LIMIT_BY_PERMISSION_CANT_FRONT_BAN", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum UpdateRuleFailType {
        EMPTY_INFO,
        EMPTY_API_RULE,
        REPEAT_PAGE,
        EMPTY_PAGE,
        CACHE_TIME_ONLY_USE_IN_CACHE_OR_STORAGE_RULE,
        API_LIMIT_BY_PERMISSION_CANT_FRONT_BAN
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateRuleException(@NotNull UpdateRuleFailType type, @NotNull String msg2) {
        super("\u66f4\u65b0\u914d\u7f6e\u9519\u8bef,\u7c7b\u578b:" + type + ",\u9644\u52a0\u4fe1\u606f" + msg2);
        Intrinsics.checkParameterIsNotNull(type, "type");
        Intrinsics.checkParameterIsNotNull(msg2, "msg");
        this.type = type;
        this.msg = msg2;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    @NotNull
    public final UpdateRuleFailType getType() {
        return this.type;
    }

    public /* synthetic */ UpdateRuleException(UpdateRuleFailType updateRuleFailType, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(updateRuleFailType, (i3 & 2) != 0 ? "" : str);
    }
}
