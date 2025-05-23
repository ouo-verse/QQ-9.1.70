package com.tencent.state.service;

import android.util.Size;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.state.map.MapItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0012J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\tH\u00c6\u0003J\t\u0010%\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\t\u0010(\u001a\u00020\u0006H\u00c6\u0003J\t\u0010)\u001a\u00020\u0011H\u00c6\u0003Jm\u0010*\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00c6\u0001J\u0013\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\u0006H\u00d6\u0001J\t\u0010.\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/service/SquarePageInfo;", "", "squareItemList", "", "Lcom/tencent/state/map/MapItem;", "currentPage", "", "totalPage", "mapSize", "Landroid/util/Size;", "mapId", "specialToast", "", "backgroundInfo", "Lcom/tencent/state/service/SquarePageBackgroundInfo;", "tipType", QAdRewardDefine$VideoParams.ISCACHE, "", "(Ljava/util/List;IILandroid/util/Size;ILjava/lang/String;Lcom/tencent/state/service/SquarePageBackgroundInfo;IZ)V", "getBackgroundInfo", "()Lcom/tencent/state/service/SquarePageBackgroundInfo;", "getCurrentPage", "()I", "()Z", "getMapId", "getMapSize", "()Landroid/util/Size;", "getSpecialToast", "()Ljava/lang/String;", "getSquareItemList", "()Ljava/util/List;", "getTipType", "getTotalPage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquarePageInfo {
    private final SquarePageBackgroundInfo backgroundInfo;
    private final int currentPage;
    private final boolean isCache;
    private final int mapId;
    private final Size mapSize;
    private final String specialToast;
    private final List<MapItem> squareItemList;
    private final int tipType;
    private final int totalPage;

    /* JADX WARN: Multi-variable type inference failed */
    public SquarePageInfo(List<? extends MapItem> squareItemList, int i3, int i16, Size mapSize, int i17, String str, SquarePageBackgroundInfo squarePageBackgroundInfo, int i18, boolean z16) {
        Intrinsics.checkNotNullParameter(squareItemList, "squareItemList");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        this.squareItemList = squareItemList;
        this.currentPage = i3;
        this.totalPage = i16;
        this.mapSize = mapSize;
        this.mapId = i17;
        this.specialToast = str;
        this.backgroundInfo = squarePageBackgroundInfo;
        this.tipType = i18;
        this.isCache = z16;
    }

    public final List<MapItem> component1() {
        return this.squareItemList;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalPage() {
        return this.totalPage;
    }

    /* renamed from: component4, reason: from getter */
    public final Size getMapSize() {
        return this.mapSize;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMapId() {
        return this.mapId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSpecialToast() {
        return this.specialToast;
    }

    /* renamed from: component7, reason: from getter */
    public final SquarePageBackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final int getTipType() {
        return this.tipType;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    public final SquarePageInfo copy(List<? extends MapItem> squareItemList, int currentPage, int totalPage, Size mapSize, int mapId, String specialToast, SquarePageBackgroundInfo backgroundInfo, int tipType, boolean isCache) {
        Intrinsics.checkNotNullParameter(squareItemList, "squareItemList");
        Intrinsics.checkNotNullParameter(mapSize, "mapSize");
        return new SquarePageInfo(squareItemList, currentPage, totalPage, mapSize, mapId, specialToast, backgroundInfo, tipType, isCache);
    }

    public final SquarePageBackgroundInfo getBackgroundInfo() {
        return this.backgroundInfo;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final int getMapId() {
        return this.mapId;
    }

    public final Size getMapSize() {
        return this.mapSize;
    }

    public final String getSpecialToast() {
        return this.specialToast;
    }

    public final List<MapItem> getSquareItemList() {
        return this.squareItemList;
    }

    public final int getTipType() {
        return this.tipType;
    }

    public final int getTotalPage() {
        return this.totalPage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<MapItem> list = this.squareItemList;
        int hashCode = (((((list != null ? list.hashCode() : 0) * 31) + this.currentPage) * 31) + this.totalPage) * 31;
        Size size = this.mapSize;
        int hashCode2 = (((hashCode + (size != null ? size.hashCode() : 0)) * 31) + this.mapId) * 31;
        String str = this.specialToast;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        SquarePageBackgroundInfo squarePageBackgroundInfo = this.backgroundInfo;
        int hashCode4 = (((hashCode3 + (squarePageBackgroundInfo != null ? squarePageBackgroundInfo.hashCode() : 0)) * 31) + this.tipType) * 31;
        boolean z16 = this.isCache;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public final boolean isCache() {
        return this.isCache;
    }

    public String toString() {
        return "SquarePageInfo(squareItemList=" + this.squareItemList + ", currentPage=" + this.currentPage + ", totalPage=" + this.totalPage + ", mapSize=" + this.mapSize + ", mapId=" + this.mapId + ", specialToast=" + this.specialToast + ", backgroundInfo=" + this.backgroundInfo + ", tipType=" + this.tipType + ", isCache=" + this.isCache + ")";
    }

    public /* synthetic */ SquarePageInfo(List list, int i3, int i16, Size size, int i17, String str, SquarePageBackgroundInfo squarePageBackgroundInfo, int i18, boolean z16, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i3, i16, size, i17, (i19 & 32) != 0 ? null : str, (i19 & 64) != 0 ? null : squarePageBackgroundInfo, i18, (i19 & 256) != 0 ? false : z16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquarePageInfo)) {
            return false;
        }
        SquarePageInfo squarePageInfo = (SquarePageInfo) other;
        return Intrinsics.areEqual(this.squareItemList, squarePageInfo.squareItemList) && this.currentPage == squarePageInfo.currentPage && this.totalPage == squarePageInfo.totalPage && Intrinsics.areEqual(this.mapSize, squarePageInfo.mapSize) && this.mapId == squarePageInfo.mapId && Intrinsics.areEqual(this.specialToast, squarePageInfo.specialToast) && Intrinsics.areEqual(this.backgroundInfo, squarePageInfo.backgroundInfo) && this.tipType == squarePageInfo.tipType && this.isCache == squarePageInfo.isCache;
    }
}
