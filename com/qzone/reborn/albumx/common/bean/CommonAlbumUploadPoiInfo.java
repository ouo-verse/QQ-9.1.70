package com.qzone.reborn.albumx.common.bean;

import FileUpload.stPoi;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellLBS;
import com.tencent.qqnt.kernel.nativeinterface.StGPS;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import cooperation.qzone.LbsDataV2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 ;2\u00020\u0001:\u0001<BY\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b9\u0010:J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J[\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010 \u001a\u0004\b.\u0010\"\"\u0004\b/\u0010$R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R$\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "Ljava/io/Serializable;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellLBS;", "toStFeedCellLBS", "LFileUpload/stPoi;", "toStPoi", "", "component1", "component2", "", "component3", "component4", "component5", "component6", "component7", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;", "component8", "poiId", "poiName", "poiType", "poiTypeName", "poiDefaultName", "address", "showPoi", "gpsInfo", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getPoiId", "()Ljava/lang/String;", "setPoiId", "(Ljava/lang/String;)V", "getPoiName", "setPoiName", "I", "getPoiType", "()I", "setPoiType", "(I)V", "getPoiTypeName", "setPoiTypeName", "getPoiDefaultName", "setPoiDefaultName", "getAddress", "setAddress", "getShowPoi", "setShowPoi", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;", "getGpsInfo", "()Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;", "setGpsInfo", "(Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadPoiInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -8318431495802752008L;
    private String address;
    private CommonAlbumUploadGpsInfo gpsInfo;
    private String poiDefaultName;
    private String poiId;
    private String poiName;
    private int poiType;
    private String poiTypeName;
    private int showPoi;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo$a;", "", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "poiInfo", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadPoiInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumUploadPoiInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final CommonAlbumUploadPoiInfo a(LbsDataV2.PoiInfo poiInfo) {
            if (poiInfo == null) {
                return null;
            }
            String str = poiInfo.poiId;
            String str2 = str == null ? "" : str;
            String str3 = poiInfo.poiName;
            String str4 = str3 == null ? "" : str3;
            int i3 = poiInfo.poiType;
            String str5 = poiInfo.poiTypeName;
            String str6 = str5 == null ? "" : str5;
            String str7 = poiInfo.poiDefaultName;
            String str8 = str7 == null ? "" : str7;
            String str9 = poiInfo.address;
            return new CommonAlbumUploadPoiInfo(str2, str4, i3, str6, str8, str9 == null ? "" : str9, poiInfo.show_poi, CommonAlbumUploadGpsInfo.INSTANCE.a(poiInfo.gpsInfo));
        }
    }

    public CommonAlbumUploadPoiInfo() {
        this(null, null, 0, null, null, null, 0, null, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPoiName() {
        return this.poiName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPoiType() {
        return this.poiType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPoiTypeName() {
        return this.poiTypeName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPoiDefaultName() {
        return this.poiDefaultName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component7, reason: from getter */
    public final int getShowPoi() {
        return this.showPoi;
    }

    /* renamed from: component8, reason: from getter */
    public final CommonAlbumUploadGpsInfo getGpsInfo() {
        return this.gpsInfo;
    }

    public final CommonAlbumUploadPoiInfo copy(String poiId, String poiName, int poiType, String poiTypeName, String poiDefaultName, String address, int showPoi, CommonAlbumUploadGpsInfo gpsInfo) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(address, "address");
        return new CommonAlbumUploadPoiInfo(poiId, poiName, poiType, poiTypeName, poiDefaultName, address, showPoi, gpsInfo);
    }

    public final String getAddress() {
        return this.address;
    }

    public final CommonAlbumUploadGpsInfo getGpsInfo() {
        return this.gpsInfo;
    }

    public final String getPoiDefaultName() {
        return this.poiDefaultName;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final int getPoiType() {
        return this.poiType;
    }

    public final String getPoiTypeName() {
        return this.poiTypeName;
    }

    public final int getShowPoi() {
        return this.showPoi;
    }

    public int hashCode() {
        int hashCode = ((((((((((((this.poiId.hashCode() * 31) + this.poiName.hashCode()) * 31) + this.poiType) * 31) + this.poiTypeName.hashCode()) * 31) + this.poiDefaultName.hashCode()) * 31) + this.address.hashCode()) * 31) + this.showPoi) * 31;
        CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo = this.gpsInfo;
        return hashCode + (commonAlbumUploadGpsInfo == null ? 0 : commonAlbumUploadGpsInfo.hashCode());
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final void setGpsInfo(CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo) {
        this.gpsInfo = commonAlbumUploadGpsInfo;
    }

    public final void setPoiDefaultName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiDefaultName = str;
    }

    public final void setPoiId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiId = str;
    }

    public final void setPoiName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiName = str;
    }

    public final void setPoiType(int i3) {
        this.poiType = i3;
    }

    public final void setPoiTypeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiTypeName = str;
    }

    public final void setShowPoi(int i3) {
        this.showPoi = i3;
    }

    public final StFeedCellLBS toStFeedCellLBS() {
        String str;
        StFeedCellLBS stFeedCellLBS = new StFeedCellLBS();
        if (this.poiDefaultName.length() > 0) {
            str = this.poiDefaultName;
        } else {
            if (this.poiName.length() > 0) {
                str = this.poiName;
            } else {
                str = this.address;
            }
        }
        StGPS stGPS = new StGPS();
        if (this.gpsInfo != null) {
            stGPS = new StGPS(r3.getLat(), r3.getLon(), 0L, 0L);
        }
        StLBS stLBS = new StLBS();
        stLBS.gps = stGPS;
        stLBS.location = str;
        stFeedCellLBS.lbs = stLBS;
        return stFeedCellLBS;
    }

    public final stPoi toStPoi() {
        stPoi stpoi = new stPoi();
        if (this.gpsInfo != null) {
            stpoi.poi_x = String.valueOf(r1.getLon() / 1000000.0d);
            stpoi.poi_y = String.valueOf(r1.getLat() / 1000000.0d);
        }
        stpoi.poi_name = this.poiName;
        stpoi.poi_address = this.address;
        stpoi.poi_id = this.poiId;
        stpoi.show_poi = this.showPoi;
        return stpoi;
    }

    public String toString() {
        return "CommonAlbumUploadPoiInfo(poiId=" + this.poiId + ", poiName=" + this.poiName + ", poiType=" + this.poiType + ", poiTypeName=" + this.poiTypeName + ", poiDefaultName=" + this.poiDefaultName + ", address=" + this.address + ", showPoi=" + this.showPoi + ", gpsInfo=" + this.gpsInfo + ")";
    }

    public CommonAlbumUploadPoiInfo(String poiId, String poiName, int i3, String poiTypeName, String poiDefaultName, String address, int i16, CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo) {
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiName, "poiName");
        Intrinsics.checkNotNullParameter(poiTypeName, "poiTypeName");
        Intrinsics.checkNotNullParameter(poiDefaultName, "poiDefaultName");
        Intrinsics.checkNotNullParameter(address, "address");
        this.poiId = poiId;
        this.poiName = poiName;
        this.poiType = i3;
        this.poiTypeName = poiTypeName;
        this.poiDefaultName = poiDefaultName;
        this.address = address;
        this.showPoi = i16;
        this.gpsInfo = commonAlbumUploadGpsInfo;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonAlbumUploadPoiInfo)) {
            return false;
        }
        CommonAlbumUploadPoiInfo commonAlbumUploadPoiInfo = (CommonAlbumUploadPoiInfo) other;
        return Intrinsics.areEqual(this.poiId, commonAlbumUploadPoiInfo.poiId) && Intrinsics.areEqual(this.poiName, commonAlbumUploadPoiInfo.poiName) && this.poiType == commonAlbumUploadPoiInfo.poiType && Intrinsics.areEqual(this.poiTypeName, commonAlbumUploadPoiInfo.poiTypeName) && Intrinsics.areEqual(this.poiDefaultName, commonAlbumUploadPoiInfo.poiDefaultName) && Intrinsics.areEqual(this.address, commonAlbumUploadPoiInfo.address) && this.showPoi == commonAlbumUploadPoiInfo.showPoi && Intrinsics.areEqual(this.gpsInfo, commonAlbumUploadPoiInfo.gpsInfo);
    }

    public /* synthetic */ CommonAlbumUploadPoiInfo(String str, String str2, int i3, String str3, String str4, String str5, int i16, CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? -1 : i3, (i17 & 8) != 0 ? "" : str3, (i17 & 16) != 0 ? "" : str4, (i17 & 32) == 0 ? str5 : "", (i17 & 64) == 0 ? i16 : -1, (i17 & 128) != 0 ? null : commonAlbumUploadGpsInfo);
    }
}
