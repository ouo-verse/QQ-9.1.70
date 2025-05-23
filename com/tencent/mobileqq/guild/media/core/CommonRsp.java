package com.tencent.mobileqq.guild.media.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/a;", "", "", "c", "", "toString", "", "hashCode", "other", "equals", "a", "I", "()I", "code", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "<init>", "(ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.media.core.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class CommonRsp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int code;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String msg;

    public CommonRsp(int i3, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.code = i3;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final boolean c() {
        if (this.code == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonRsp)) {
            return false;
        }
        CommonRsp commonRsp = (CommonRsp) other;
        if (this.code == commonRsp.code && Intrinsics.areEqual(this.msg, commonRsp.msg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + this.msg.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommonRsp(code=" + this.code + ", msg=" + this.msg + ")";
    }
}
