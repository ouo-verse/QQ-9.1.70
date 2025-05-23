package com.tencent.mobileqq.zplan.resource.api.data;

import hv4.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0019\u001a\u0004\b\u0013\u0010\u001aR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001d\u001a\u0004\b\n\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/resource/api/data/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/zplan/resource/api/data/ZPlanResourceType;", "a", "Lcom/tencent/mobileqq/zplan/resource/api/data/ZPlanResourceType;", "b", "()Lcom/tencent/mobileqq/zplan/resource/api/data/ZPlanResourceType;", "downloadType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "uniqueTaskId", "c", "Z", "e", "()Z", "isStrongDepend", "Lcom/tencent/mobileqq/zplan/resource/api/data/a;", "Lcom/tencent/mobileqq/zplan/resource/api/data/a;", "()Lcom/tencent/mobileqq/zplan/resource/api/data/a;", "resHubIdInfo", "Lhv4/s;", "Lhv4/s;", "()Lhv4/s;", "directUrlResource", "<init>", "(Lcom/tencent/mobileqq/zplan/resource/api/data/ZPlanResourceType;Ljava/lang/String;ZLcom/tencent/mobileqq/zplan/resource/api/data/a;Lhv4/s;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.resource.api.data.c, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanResourceDownloadTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanResourceType downloadType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String uniqueTaskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isStrongDepend;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZPlanResHubIdInfo resHubIdInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final s directUrlResource;

    public ZPlanResourceDownloadTask(ZPlanResourceType downloadType, String uniqueTaskId, boolean z16, ZPlanResHubIdInfo zPlanResHubIdInfo, s sVar) {
        Intrinsics.checkNotNullParameter(downloadType, "downloadType");
        Intrinsics.checkNotNullParameter(uniqueTaskId, "uniqueTaskId");
        this.downloadType = downloadType;
        this.uniqueTaskId = uniqueTaskId;
        this.isStrongDepend = z16;
        this.resHubIdInfo = zPlanResHubIdInfo;
        this.directUrlResource = sVar;
    }

    /* renamed from: a, reason: from getter */
    public final s getDirectUrlResource() {
        return this.directUrlResource;
    }

    /* renamed from: b, reason: from getter */
    public final ZPlanResourceType getDownloadType() {
        return this.downloadType;
    }

    /* renamed from: c, reason: from getter */
    public final ZPlanResHubIdInfo getResHubIdInfo() {
        return this.resHubIdInfo;
    }

    /* renamed from: d, reason: from getter */
    public final String getUniqueTaskId() {
        return this.uniqueTaskId;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsStrongDepend() {
        return this.isStrongDepend;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.downloadType.hashCode() * 31) + this.uniqueTaskId.hashCode()) * 31;
        boolean z16 = this.isStrongDepend;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        ZPlanResHubIdInfo zPlanResHubIdInfo = this.resHubIdInfo;
        int hashCode2 = (i16 + (zPlanResHubIdInfo == null ? 0 : zPlanResHubIdInfo.hashCode())) * 31;
        s sVar = this.directUrlResource;
        return hashCode2 + (sVar != null ? sVar.hashCode() : 0);
    }

    public String toString() {
        return "ZPlanResourceDownloadTask(downloadType=" + this.downloadType + ", uniqueTaskId=" + this.uniqueTaskId + ", isStrongDepend=" + this.isStrongDepend + ", resHubIdInfo=" + this.resHubIdInfo + ", directUrlResource=" + this.directUrlResource + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanResourceDownloadTask)) {
            return false;
        }
        ZPlanResourceDownloadTask zPlanResourceDownloadTask = (ZPlanResourceDownloadTask) other;
        return this.downloadType == zPlanResourceDownloadTask.downloadType && Intrinsics.areEqual(this.uniqueTaskId, zPlanResourceDownloadTask.uniqueTaskId) && this.isStrongDepend == zPlanResourceDownloadTask.isStrongDepend && Intrinsics.areEqual(this.resHubIdInfo, zPlanResourceDownloadTask.resHubIdInfo) && Intrinsics.areEqual(this.directUrlResource, zPlanResourceDownloadTask.directUrlResource);
    }
}
