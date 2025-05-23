package com.tencent.mobileqq.matchfriend.aio.interactive;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\t\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/interactive/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "success", "b", "I", "()I", "retCode", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(ZILjava/lang/String;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.aio.interactive.a, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class AIOInteractiveResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean success;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int retCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String msg;

    public AIOInteractiveResult(boolean z16, int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.success = z16;
        this.retCode = i3;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: b, reason: from getter */
    public final int getRetCode() {
        return this.retCode;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.success;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.retCode) * 31) + this.msg.hashCode();
    }

    public String toString() {
        return "AIOInteractiveResult(success=" + this.success + ", retCode=" + this.retCode + ", msg=" + this.msg + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIOInteractiveResult)) {
            return false;
        }
        AIOInteractiveResult aIOInteractiveResult = (AIOInteractiveResult) other;
        return this.success == aIOInteractiveResult.success && this.retCode == aIOInteractiveResult.retCode && Intrinsics.areEqual(this.msg, aIOInteractiveResult.msg);
    }
}
