package com.qzone.reborn.albumx.common.bean;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import cooperation.qzone.LbsDataV2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;", "Ljava/io/Serializable;", "", "component1", "component2", QCircleSchemeAttr.Polymerize.LAT, "lon", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getLat", "()I", "setLat", "(I)V", "getLon", "setLon", "<init>", "(II)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class CommonAlbumUploadGpsInfo implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -7960381954960336775L;
    private int lat;
    private int lon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo$a;", "", "Lcooperation/qzone/LbsDataV2$GpsInfo;", "gpsInfo", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadGpsInfo;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.albumx.common.bean.CommonAlbumUploadGpsInfo$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final CommonAlbumUploadGpsInfo a(LbsDataV2.GpsInfo gpsInfo) {
            if (gpsInfo == null) {
                return null;
            }
            return new CommonAlbumUploadGpsInfo(gpsInfo.lat, gpsInfo.lon);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CommonAlbumUploadGpsInfo() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: component1, reason: from getter */
    public final int getLat() {
        return this.lat;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLon() {
        return this.lon;
    }

    public final CommonAlbumUploadGpsInfo copy(int lat, int lon) {
        return new CommonAlbumUploadGpsInfo(lat, lon);
    }

    public final int getLat() {
        return this.lat;
    }

    public final int getLon() {
        return this.lon;
    }

    public int hashCode() {
        return (this.lat * 31) + this.lon;
    }

    public final void setLat(int i3) {
        this.lat = i3;
    }

    public final void setLon(int i3) {
        this.lon = i3;
    }

    public String toString() {
        return "CommonAlbumUploadGpsInfo(lat=" + this.lat + ", lon=" + this.lon + ")";
    }

    public CommonAlbumUploadGpsInfo(int i3, int i16) {
        this.lat = i3;
        this.lon = i16;
    }

    public /* synthetic */ CommonAlbumUploadGpsInfo(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? -1 : i16);
    }

    public static /* synthetic */ CommonAlbumUploadGpsInfo copy$default(CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = commonAlbumUploadGpsInfo.lat;
        }
        if ((i17 & 2) != 0) {
            i16 = commonAlbumUploadGpsInfo.lon;
        }
        return commonAlbumUploadGpsInfo.copy(i3, i16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonAlbumUploadGpsInfo)) {
            return false;
        }
        CommonAlbumUploadGpsInfo commonAlbumUploadGpsInfo = (CommonAlbumUploadGpsInfo) other;
        return this.lat == commonAlbumUploadGpsInfo.lat && this.lon == commonAlbumUploadGpsInfo.lon;
    }
}
