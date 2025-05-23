package com.tencent.mobileqq.zootopia.download.ui.downloading;

import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloading/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "", "b", "Ljava/lang/Float;", "d", "()Ljava/lang/Float;", "progress", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "e", "realTimeSpeed", "averageSpeed", "<init>", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zootopia.download.ui.downloading.a, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class DownloadingPayloadData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final Float progress;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer downloadStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer realTimeSpeed;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final Integer averageSpeed;

    public DownloadingPayloadData(String id5, Float f16, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.id = id5;
        this.progress = f16;
        this.downloadStatus = num;
        this.realTimeSpeed = num2;
        this.averageSpeed = num3;
    }

    /* renamed from: a, reason: from getter */
    public final Integer getAverageSpeed() {
        return this.averageSpeed;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getDownloadStatus() {
        return this.downloadStatus;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final Float getProgress() {
        return this.progress;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getRealTimeSpeed() {
        return this.realTimeSpeed;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        Float f16 = this.progress;
        int hashCode2 = (hashCode + (f16 == null ? 0 : f16.hashCode())) * 31;
        Integer num = this.downloadStatus;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.realTimeSpeed;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.averageSpeed;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "DownloadingPayloadData(id=" + this.id + ", progress=" + this.progress + ", downloadStatus=" + this.downloadStatus + ", realTimeSpeed=" + this.realTimeSpeed + ", averageSpeed=" + this.averageSpeed + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadingPayloadData)) {
            return false;
        }
        DownloadingPayloadData downloadingPayloadData = (DownloadingPayloadData) other;
        return Intrinsics.areEqual(this.id, downloadingPayloadData.id) && Intrinsics.areEqual((Object) this.progress, (Object) downloadingPayloadData.progress) && Intrinsics.areEqual(this.downloadStatus, downloadingPayloadData.downloadStatus) && Intrinsics.areEqual(this.realTimeSpeed, downloadingPayloadData.realTimeSpeed) && Intrinsics.areEqual(this.averageSpeed, downloadingPayloadData.averageSpeed);
    }
}
