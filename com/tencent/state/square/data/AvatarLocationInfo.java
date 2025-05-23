package com.tencent.state.square.data;

import com.tencent.mobileqq.zootopia.webview.f;
import com.tencent.weiyun.poi.PoiDbManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020\u0006H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/data/AvatarLocationInfo;", "Ljava/io/Serializable;", "longitude", "", "latitude", PoiDbManager.TBL_POI, "", "poiId", "poiAddress", "(DDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLatitude", "()D", "setLatitude", "(D)V", "getLongitude", "setLongitude", "getPoi", "()Ljava/lang/String;", "setPoi", "(Ljava/lang/String;)V", "getPoiAddress", "setPoiAddress", "getPoiId", "setPoiId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class AvatarLocationInfo implements Serializable {
    private double latitude;
    private double longitude;
    private String poi;
    private String poiAddress;
    private String poiId;

    public AvatarLocationInfo() {
        this(0.0d, 0.0d, null, null, null, 31, null);
    }

    /* renamed from: component1, reason: from getter */
    public final double getLongitude() {
        return this.longitude;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLatitude() {
        return this.latitude;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPoi() {
        return this.poi;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPoiId() {
        return this.poiId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPoiAddress() {
        return this.poiAddress;
    }

    public final AvatarLocationInfo copy(double longitude, double latitude, String poi, String poiId, String poiAddress) {
        Intrinsics.checkNotNullParameter(poi, "poi");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiAddress, "poiAddress");
        return new AvatarLocationInfo(longitude, latitude, poi, poiId, poiAddress);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final String getPoi() {
        return this.poi;
    }

    public final String getPoiAddress() {
        return this.poiAddress;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public int hashCode() {
        int a16 = ((f.a(this.longitude) * 31) + f.a(this.latitude)) * 31;
        String str = this.poi;
        int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.poiId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.poiAddress;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setLatitude(double d16) {
        this.latitude = d16;
    }

    public final void setLongitude(double d16) {
        this.longitude = d16;
    }

    public final void setPoi(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poi = str;
    }

    public final void setPoiAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiAddress = str;
    }

    public final void setPoiId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.poiId = str;
    }

    public String toString() {
        return "AvatarLocationInfo(longitude=" + this.longitude + ", latitude=" + this.latitude + ", poi=" + this.poi + ", poiId=" + this.poiId + ", poiAddress=" + this.poiAddress + ")";
    }

    public AvatarLocationInfo(double d16, double d17, String poi, String poiId, String poiAddress) {
        Intrinsics.checkNotNullParameter(poi, "poi");
        Intrinsics.checkNotNullParameter(poiId, "poiId");
        Intrinsics.checkNotNullParameter(poiAddress, "poiAddress");
        this.longitude = d16;
        this.latitude = d17;
        this.poi = poi;
        this.poiId = poiId;
        this.poiAddress = poiAddress;
    }

    public /* synthetic */ AvatarLocationInfo(double d16, double d17, String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0.0d : d16, (i3 & 2) == 0 ? d17 : 0.0d, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? "" : str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvatarLocationInfo)) {
            return false;
        }
        AvatarLocationInfo avatarLocationInfo = (AvatarLocationInfo) other;
        return Double.compare(this.longitude, avatarLocationInfo.longitude) == 0 && Double.compare(this.latitude, avatarLocationInfo.latitude) == 0 && Intrinsics.areEqual(this.poi, avatarLocationInfo.poi) && Intrinsics.areEqual(this.poiId, avatarLocationInfo.poiId) && Intrinsics.areEqual(this.poiAddress, avatarLocationInfo.poiAddress);
    }
}
