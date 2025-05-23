package com.tencent.sqshow.zootopia.mapstatus;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0005\f\u0003B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/b;", "", "Lcom/tencent/sqshow/zootopia/mapstatus/b$c;", "c", "Lcom/tencent/sqshow/zootopia/mapstatus/b$a;", "a", "Lcom/tencent/sqshow/zootopia/mapstatus/b$b;", "d", "Lcom/tencent/sqshow/zootopia/mapstatus/c;", "Lcom/tencent/sqshow/zootopia/mapstatus/c;", "mapStatusInfo", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "mapId", "<init>", "(Lcom/tencent/sqshow/zootopia/mapstatus/c;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c mapStatusInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String mapId;

    public b(c mapStatusInfo) {
        Intrinsics.checkNotNullParameter(mapStatusInfo, "mapStatusInfo");
        this.mapStatusInfo = mapStatusInfo;
        this.mapId = mapStatusInfo.getMapId();
    }

    public final MapDownloadStatusResult a() {
        return new MapDownloadStatusResult(this.mapStatusInfo.getDownloadStatus(), this.mapStatusInfo.getProgress(), this.mapStatusInfo.getDownloadVersion(), this.mapStatusInfo.getRealTimeSpeed(), this.mapStatusInfo.getAverageSpeed());
    }

    /* renamed from: b, reason: from getter */
    public final String getMapId() {
        return this.mapId;
    }

    public final MapStatusResult c() {
        d dVar = d.f370777a;
        MapStatus b16 = dVar.b(this.mapStatusInfo.getMapStatus(), Integer.valueOf(this.mapStatusInfo.getDownloadStatus()));
        if (b16 == null && (b16 = dVar.c(this.mapStatusInfo.getQqVerStatus())) == null && (b16 = dVar.a(this.mapStatusInfo.getMapVerStatus(), this.mapStatusInfo.getDownloadVersion(), this.mapStatusInfo.getModVersionSimpleData().getNowMapVer())) == null) {
            b16 = dVar.d(Integer.valueOf(this.mapStatusInfo.getDownloadStatus()), this.mapStatusInfo.getDownloadErrorCode());
        }
        Float f16 = dVar.f(b16, Float.valueOf(this.mapStatusInfo.getProgress()));
        return new MapStatusResult(b16, f16 != null ? f16.floatValue() : 0.0f);
    }

    public final MapServerStatusResult d() {
        return new MapServerStatusResult(this.mapStatusInfo.getModVersionSimpleData(), this.mapStatusInfo.getMapStatus(), this.mapStatusInfo.getQqVerStatus(), this.mapStatusInfo.getMapVerStatus(), this.mapStatusInfo.getDiffPatchInfo());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", UserInfo.SEX_FEMALE, HippyQQPagView.FunctionName.GET_PROGRESS, "()F", "progress", "c", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "version", "d", "realTimeSpeed", "e", "averageSpeed", "<init>", "(IFLjava/lang/String;II)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.mapstatus.b$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class MapDownloadStatusResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int downloadStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float progress;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final String version;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int realTimeSpeed;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int averageSpeed;

        public MapDownloadStatusResult(int i3, float f16, String str, int i16, int i17) {
            this.downloadStatus = i3;
            this.progress = f16;
            this.version = str;
            this.realTimeSpeed = i16;
            this.averageSpeed = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getAverageSpeed() {
            return this.averageSpeed;
        }

        /* renamed from: b, reason: from getter */
        public final int getDownloadStatus() {
            return this.downloadStatus;
        }

        /* renamed from: c, reason: from getter */
        public final int getRealTimeSpeed() {
            return this.realTimeSpeed;
        }

        public int hashCode() {
            int floatToIntBits = ((this.downloadStatus * 31) + Float.floatToIntBits(this.progress)) * 31;
            String str = this.version;
            return ((((floatToIntBits + (str == null ? 0 : str.hashCode())) * 31) + this.realTimeSpeed) * 31) + this.averageSpeed;
        }

        public String toString() {
            return "MapDownloadStatusResult(downloadStatus=" + this.downloadStatus + ", progress=" + this.progress + ", version=" + this.version + ", realTimeSpeed=" + this.realTimeSpeed + ", averageSpeed=" + this.averageSpeed + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapDownloadStatusResult)) {
                return false;
            }
            MapDownloadStatusResult mapDownloadStatusResult = (MapDownloadStatusResult) other;
            return this.downloadStatus == mapDownloadStatusResult.downloadStatus && Float.compare(this.progress, mapDownloadStatusResult.progress) == 0 && Intrinsics.areEqual(this.version, mapDownloadStatusResult.version) && this.realTimeSpeed == mapDownloadStatusResult.realTimeSpeed && this.averageSpeed == mapDownloadStatusResult.averageSpeed;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "a", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "d", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "modVersionSimpleData", "b", "I", "()I", "mapStatus", "c", "e", "qqVerStatus", "mapVerStatus", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "diffPatchInfo", "<init>", "(Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;IIILcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.mapstatus.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class MapServerStatusResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final ZPlanModVersionSimpleData modVersionSimpleData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int mapStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int qqVerStatus;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int mapVerStatus;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final ZPlanMapDiffPatchInfo diffPatchInfo;

        public MapServerStatusResult(ZPlanModVersionSimpleData modVersionSimpleData, int i3, int i16, int i17, ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo) {
            Intrinsics.checkNotNullParameter(modVersionSimpleData, "modVersionSimpleData");
            this.modVersionSimpleData = modVersionSimpleData;
            this.mapStatus = i3;
            this.qqVerStatus = i16;
            this.mapVerStatus = i17;
            this.diffPatchInfo = zPlanMapDiffPatchInfo;
        }

        /* renamed from: a, reason: from getter */
        public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
            return this.diffPatchInfo;
        }

        /* renamed from: b, reason: from getter */
        public final int getMapStatus() {
            return this.mapStatus;
        }

        /* renamed from: c, reason: from getter */
        public final int getMapVerStatus() {
            return this.mapVerStatus;
        }

        /* renamed from: d, reason: from getter */
        public final ZPlanModVersionSimpleData getModVersionSimpleData() {
            return this.modVersionSimpleData;
        }

        /* renamed from: e, reason: from getter */
        public final int getQqVerStatus() {
            return this.qqVerStatus;
        }

        public int hashCode() {
            int hashCode = ((((((this.modVersionSimpleData.hashCode() * 31) + this.mapStatus) * 31) + this.qqVerStatus) * 31) + this.mapVerStatus) * 31;
            ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo = this.diffPatchInfo;
            return hashCode + (zPlanMapDiffPatchInfo == null ? 0 : zPlanMapDiffPatchInfo.hashCode());
        }

        public String toString() {
            return "MapServerStatusResult(modVersionSimpleData=" + this.modVersionSimpleData + ", mapStatus=" + this.mapStatus + ", qqVerStatus=" + this.qqVerStatus + ", mapVerStatus=" + this.mapVerStatus + ", diffPatchInfo=" + this.diffPatchInfo + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapServerStatusResult)) {
                return false;
            }
            MapServerStatusResult mapServerStatusResult = (MapServerStatusResult) other;
            return Intrinsics.areEqual(this.modVersionSimpleData, mapServerStatusResult.modVersionSimpleData) && this.mapStatus == mapServerStatusResult.mapStatus && this.qqVerStatus == mapServerStatusResult.qqVerStatus && this.mapVerStatus == mapServerStatusResult.mapVerStatus && Intrinsics.areEqual(this.diffPatchInfo, mapServerStatusResult.diffPatchInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/mapstatus/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "a", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "()Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "", "b", UserInfo.SEX_FEMALE, "()F", "progress", "<init>", "(Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;F)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.mapstatus.b$c, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class MapStatusResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final MapStatus mapStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float progress;

        public MapStatusResult(MapStatus mapStatus, float f16) {
            Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
            this.mapStatus = mapStatus;
            this.progress = f16;
        }

        /* renamed from: a, reason: from getter */
        public final MapStatus getMapStatus() {
            return this.mapStatus;
        }

        /* renamed from: b, reason: from getter */
        public final float getProgress() {
            return this.progress;
        }

        public int hashCode() {
            return (this.mapStatus.hashCode() * 31) + Float.floatToIntBits(this.progress);
        }

        public String toString() {
            return "MapStatusResult(mapStatus=" + this.mapStatus + ", progress=" + this.progress + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MapStatusResult)) {
                return false;
            }
            MapStatusResult mapStatusResult = (MapStatusResult) other;
            return this.mapStatus == mapStatusResult.mapStatus && Float.compare(this.progress, mapStatusResult.progress) == 0;
        }
    }
}
