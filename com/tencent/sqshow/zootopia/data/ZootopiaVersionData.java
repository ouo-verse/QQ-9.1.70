package com.tencent.sqshow.zootopia.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/aa;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "versionUpdateTime", "Ljava/lang/String;", "()Ljava/lang/String;", "versionUpdateDetail", "<init>", "(JLjava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.aa, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaVersionData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long versionUpdateTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String versionUpdateDetail;

    public ZootopiaVersionData() {
        this(0L, null, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getVersionUpdateDetail() {
        return this.versionUpdateDetail;
    }

    /* renamed from: b, reason: from getter */
    public final long getVersionUpdateTime() {
        return this.versionUpdateTime;
    }

    public int hashCode() {
        int a16 = com.tencent.mobileqq.vas.banner.c.a(this.versionUpdateTime) * 31;
        String str = this.versionUpdateDetail;
        return a16 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ZootopiaVersionData(versionUpdateTime=" + this.versionUpdateTime + ", versionUpdateDetail=" + this.versionUpdateDetail + ")";
    }

    public ZootopiaVersionData(long j3, String str) {
        this.versionUpdateTime = j3;
        this.versionUpdateDetail = str;
    }

    public /* synthetic */ ZootopiaVersionData(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? null : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaVersionData)) {
            return false;
        }
        ZootopiaVersionData zootopiaVersionData = (ZootopiaVersionData) other;
        return this.versionUpdateTime == zootopiaVersionData.versionUpdateTime && Intrinsics.areEqual(this.versionUpdateDetail, zootopiaVersionData.versionUpdateDetail);
    }
}
