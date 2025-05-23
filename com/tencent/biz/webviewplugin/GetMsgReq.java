package com.tencent.biz.webviewplugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/biz/webviewplugin/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "uin", "I", "c", "()I", "uinType", "maxCount", "<init>", "(Ljava/lang/String;II)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.webviewplugin.f, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class GetMsgReq {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int uinType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxCount;

    public GetMsgReq(@NotNull String uin, int i3, int i16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.uinType = i3;
        this.maxCount = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: c, reason: from getter */
    public final int getUinType() {
        return this.uinType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetMsgReq)) {
            return false;
        }
        GetMsgReq getMsgReq = (GetMsgReq) other;
        if (Intrinsics.areEqual(this.uin, getMsgReq.uin) && this.uinType == getMsgReq.uinType && this.maxCount == getMsgReq.maxCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.uin.hashCode() * 31) + this.uinType) * 31) + this.maxCount;
    }

    @NotNull
    public String toString() {
        return "GetMsgReq(uin=" + this.uin + ", uinType=" + this.uinType + ", maxCount=" + this.maxCount + ")";
    }
}
