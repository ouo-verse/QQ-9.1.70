package com.tencent.sqshow.zootopia.data;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ab;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/z;", "a", "Lcom/tencent/sqshow/zootopia/data/z;", "b", "()Lcom/tencent/sqshow/zootopia/data/z;", "userData", "", "J", "()J", PhotoCategorySinglePicInfo.UPLOAD_TIME, "", "Lcom/tencent/sqshow/zootopia/data/aa;", "c", "Ljava/util/List;", "()Ljava/util/List;", "versionList", "<init>", "(Lcom/tencent/sqshow/zootopia/data/z;JLjava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.zootopia.data.ab, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaVersionUpdateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaUserData userData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uploadTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZootopiaVersionData> versionList;

    public ZootopiaVersionUpdateInfo(ZootopiaUserData userData, long j3, List<ZootopiaVersionData> versionList) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(versionList, "versionList");
        this.userData = userData;
        this.uploadTime = j3;
        this.versionList = versionList;
    }

    /* renamed from: a, reason: from getter */
    public final long getUploadTime() {
        return this.uploadTime;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaUserData getUserData() {
        return this.userData;
    }

    public final List<ZootopiaVersionData> c() {
        return this.versionList;
    }

    public int hashCode() {
        return (((this.userData.hashCode() * 31) + com.tencent.mobileqq.vas.banner.c.a(this.uploadTime)) * 31) + this.versionList.hashCode();
    }

    public String toString() {
        return "ZootopiaVersionUpdateInfo(userData=" + this.userData + ", uploadTime=" + this.uploadTime + ", versionList=" + this.versionList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaVersionUpdateInfo)) {
            return false;
        }
        ZootopiaVersionUpdateInfo zootopiaVersionUpdateInfo = (ZootopiaVersionUpdateInfo) other;
        return Intrinsics.areEqual(this.userData, zootopiaVersionUpdateInfo.userData) && this.uploadTime == zootopiaVersionUpdateInfo.uploadTime && Intrinsics.areEqual(this.versionList, zootopiaVersionUpdateInfo.versionList);
    }
}
