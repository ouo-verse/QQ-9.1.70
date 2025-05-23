package com.tencent.mobileqq.icgame.push;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/icgame/push/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "delayMs", "Lbz0/c;", "b", "Lbz0/c;", "()Lbz0/c;", "msg", "<init>", "(JLbz0/c;)V", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.push.f, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class SmoothMsgInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long delayMs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final bz0.c msg;

    public SmoothMsgInfo(long j3, @NotNull bz0.c msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.delayMs = j3;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final long getDelayMs() {
        return this.delayMs;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final bz0.c getMsg() {
        return this.msg;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SmoothMsgInfo)) {
            return false;
        }
        SmoothMsgInfo smoothMsgInfo = (SmoothMsgInfo) other;
        if (this.delayMs == smoothMsgInfo.delayMs && Intrinsics.areEqual(this.msg, smoothMsgInfo.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (androidx.fragment.app.a.a(this.delayMs) * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "SmoothMsgInfo(delayMs=" + this.delayMs + ", msg=" + this.msg + ")";
    }
}
