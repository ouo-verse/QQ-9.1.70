package com.tencent.sqshow.zootopia.data;

import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001J\t\u0010*\u001a\u00020+H\u00d6\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0004R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0004\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;", "Ljava/io/Serializable;", IZootopiaShareArkService.ARK_MAP_ID, "", "(I)V", "cloudGameInfo", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "getCloudGameInfo", "()Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "setCloudGameInfo", "(Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;)V", "diffPatchInfo", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "getDiffPatchInfo", "()Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "setDiffPatchInfo", "(Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;)V", "getMapID", "()I", "setMapID", "mapStatus", "getMapStatus", "setMapStatus", "mapVerTip", "getMapVerTip", "setMapVerTip", "modVersionSimpleData", "Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "getModVersionSimpleData", "()Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;", "setModVersionSimpleData", "(Lcom/tencent/mobileqq/z1/download/data/ZPlanModVersionSimpleData;)V", "qqVerTip", "getQqVerTip", "setQqVerTip", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaSimpleVerInfo implements Serializable {
    private ZPlanCloudGameInfo cloudGameInfo;
    private ZPlanMapDiffPatchInfo diffPatchInfo;
    private int mapID;
    private int mapStatus;
    private int mapVerTip;
    private ZPlanModVersionSimpleData modVersionSimpleData;
    private int qqVerTip;

    public ZootopiaSimpleVerInfo() {
        this(0, 1, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMapID() {
        return this.mapID;
    }

    public final ZootopiaSimpleVerInfo copy(int mapID) {
        return new ZootopiaSimpleVerInfo(mapID);
    }

    public final ZPlanCloudGameInfo getCloudGameInfo() {
        return this.cloudGameInfo;
    }

    public final ZPlanMapDiffPatchInfo getDiffPatchInfo() {
        return this.diffPatchInfo;
    }

    public final int getMapID() {
        return this.mapID;
    }

    public final int getMapStatus() {
        return this.mapStatus;
    }

    public final int getMapVerTip() {
        return this.mapVerTip;
    }

    public final ZPlanModVersionSimpleData getModVersionSimpleData() {
        return this.modVersionSimpleData;
    }

    public final int getQqVerTip() {
        return this.qqVerTip;
    }

    public int hashCode() {
        return this.mapID;
    }

    public final void setCloudGameInfo(ZPlanCloudGameInfo zPlanCloudGameInfo) {
        this.cloudGameInfo = zPlanCloudGameInfo;
    }

    public final void setDiffPatchInfo(ZPlanMapDiffPatchInfo zPlanMapDiffPatchInfo) {
        this.diffPatchInfo = zPlanMapDiffPatchInfo;
    }

    public final void setMapID(int i3) {
        this.mapID = i3;
    }

    public final void setMapStatus(int i3) {
        this.mapStatus = i3;
    }

    public final void setMapVerTip(int i3) {
        this.mapVerTip = i3;
    }

    public final void setModVersionSimpleData(ZPlanModVersionSimpleData zPlanModVersionSimpleData) {
        Intrinsics.checkNotNullParameter(zPlanModVersionSimpleData, "<set-?>");
        this.modVersionSimpleData = zPlanModVersionSimpleData;
    }

    public final void setQqVerTip(int i3) {
        this.qqVerTip = i3;
    }

    public String toString() {
        return "ZootopiaSimpleVerInfo(mapID=" + this.mapID + ")";
    }

    public ZootopiaSimpleVerInfo(int i3) {
        this.mapID = i3;
        this.modVersionSimpleData = new ZPlanModVersionSimpleData(this.mapID);
    }

    public /* synthetic */ ZootopiaSimpleVerInfo(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }

    public static /* synthetic */ ZootopiaSimpleVerInfo copy$default(ZootopiaSimpleVerInfo zootopiaSimpleVerInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = zootopiaSimpleVerInfo.mapID;
        }
        return zootopiaSimpleVerInfo.copy(i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZootopiaSimpleVerInfo) && this.mapID == ((ZootopiaSimpleVerInfo) other).mapID;
    }
}
