package com.tencent.biz.qqcircle.immersive.redpacket.task;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getCode", "()I", "code", "b", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.task.k, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class ErrorCode {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ErrorCode f89554d = new ErrorCode(-1, "");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String msg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k$a;", "", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "ERROR_DEFAULT", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "a", "()Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "", "CODE_DEFAULT", "I", "", "MSG_DEFAULT", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.redpacket.task.k$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ErrorCode a() {
            return ErrorCode.f89554d;
        }

        Companion() {
        }
    }

    public ErrorCode(int i3, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.code = i3;
        this.msg = msg2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorCode)) {
            return false;
        }
        ErrorCode errorCode = (ErrorCode) other;
        if (this.code == errorCode.code && Intrinsics.areEqual(this.msg, errorCode.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "ErrorCode(code=" + this.code + ", msg=" + this.msg + ")";
    }
}
