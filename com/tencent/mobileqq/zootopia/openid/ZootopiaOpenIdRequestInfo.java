package com.tencent.mobileqq.zootopia.openid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\n\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "requestTime", "b", "I", "()I", "requestFlag", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "Lwp3/b;", "d", "Lwp3/b;", "()Lwp3/b;", "listener", "<init>", "(JILjava/lang/String;Lwp3/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.openid.g, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class ZootopiaOpenIdRequestInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long requestTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestFlag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final wp3.b listener;

    public ZootopiaOpenIdRequestInfo(long j3, int i3, String uin, wp3.b listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.requestTime = j3;
        this.requestFlag = i3;
        this.uin = uin;
        this.listener = listener;
    }

    /* renamed from: a, reason: from getter */
    public final wp3.b getListener() {
        return this.listener;
    }

    /* renamed from: b, reason: from getter */
    public final int getRequestFlag() {
        return this.requestFlag;
    }

    /* renamed from: c, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    public int hashCode() {
        return (((((com.tencent.mobileqq.vas.banner.c.a(this.requestTime) * 31) + this.requestFlag) * 31) + this.uin.hashCode()) * 31) + this.listener.hashCode();
    }

    public String toString() {
        return "ZootopiaOpenIdRequestInfo(requestTime=" + this.requestTime + ", requestFlag=" + this.requestFlag + ", uin=" + this.uin + ", listener=" + this.listener + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaOpenIdRequestInfo)) {
            return false;
        }
        ZootopiaOpenIdRequestInfo zootopiaOpenIdRequestInfo = (ZootopiaOpenIdRequestInfo) other;
        return this.requestTime == zootopiaOpenIdRequestInfo.requestTime && this.requestFlag == zootopiaOpenIdRequestInfo.requestFlag && Intrinsics.areEqual(this.uin, zootopiaOpenIdRequestInfo.uin) && Intrinsics.areEqual(this.listener, zootopiaOpenIdRequestInfo.listener);
    }
}
