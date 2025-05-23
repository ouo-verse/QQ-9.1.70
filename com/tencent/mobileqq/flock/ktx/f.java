package com.tencent.mobileqq.flock.ktx;

import cooperation.qzone.LbsDataV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y45.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0000j\u0002`\u0001\u001a\u0012\u0010\u0005\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0002j\u0002`\u0003*\n\u0010\u0007\"\u00020\u00062\u00020\u0006*\n\u0010\b\"\u00020\u00022\u00020\u0002*\n\u0010\n\"\u00020\t2\u00020\t*\n\u0010\u000b\"\u00020\u00002\u00020\u0000\u00a8\u0006\f"}, d2 = {"Ly45/l;", "Lcom/tencent/mobileqq/flock/ktx/RemotePoiInfo;", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "Lcom/tencent/mobileqq/flock/ktx/LocalPoiInfo;", "a", "b", "Lcooperation/qzone/LbsDataV2$GpsInfo;", "LocalGpsInfo", "LocalPoiInfo", "Ly45/g;", "RemoteGpsInfo", "RemotePoiInfo", "qq-flock-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {
    @NotNull
    public static final LbsDataV2.PoiInfo a(@NotNull l lVar) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(lVar, "<this>");
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        poiInfo.poiId = lVar.f449419a;
        poiInfo.poiName = lVar.f449420b;
        poiInfo.poiType = lVar.f449421c;
        poiInfo.poiTypeName = lVar.f449422d;
        poiInfo.address = lVar.f449423e;
        poiInfo.districtCode = lVar.f449424f;
        LbsDataV2.GpsInfo gpsInfo = new LbsDataV2.GpsInfo();
        y45.g gVar = lVar.f449425g;
        int i18 = 0;
        if (gVar != null) {
            i3 = (int) gVar.f449393a;
        } else {
            i3 = 0;
        }
        gpsInfo.lat = i3;
        if (gVar != null) {
            i16 = (int) gVar.f449394b;
        } else {
            i16 = 0;
        }
        gpsInfo.lon = i16;
        if (gVar != null) {
            i17 = (int) gVar.f449396d;
        } else {
            i17 = 0;
        }
        gpsInfo.alt = i17;
        if (gVar != null) {
            i18 = (int) gVar.f449395c;
        }
        gpsInfo.gpsType = i18;
        poiInfo.gpsInfo = gpsInfo;
        poiInfo.distance = lVar.f449426h;
        poiInfo.hotValue = lVar.f449427i;
        poiInfo.phoneNumber = lVar.f449428j;
        poiInfo.country = lVar.f449429k;
        poiInfo.province = lVar.f449430l;
        poiInfo.city = lVar.f449431m;
        poiInfo.poiOrderType = lVar.f449433o;
        poiInfo.poiDefaultName = lVar.f449434p;
        poiInfo.district = lVar.f449435q;
        poiInfo.dianPingId = lVar.f449436r;
        return poiInfo;
    }

    @NotNull
    public static final l b(@NotNull LbsDataV2.PoiInfo poiInfo) {
        long j3;
        long j16;
        long j17;
        Intrinsics.checkNotNullParameter(poiInfo, "<this>");
        l lVar = new l();
        String str = poiInfo.poiId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        lVar.f449419a = str;
        String str3 = poiInfo.poiName;
        if (str3 == null) {
            str3 = "";
        }
        lVar.f449420b = str3;
        lVar.f449421c = poiInfo.poiType;
        String str4 = poiInfo.poiTypeName;
        if (str4 == null) {
            str4 = "";
        }
        lVar.f449422d = str4;
        String str5 = poiInfo.address;
        if (str5 == null) {
            str5 = "";
        }
        lVar.f449423e = str5;
        lVar.f449424f = poiInfo.districtCode;
        y45.g gVar = new y45.g();
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        long j18 = 0;
        if (gpsInfo != null) {
            j3 = gpsInfo.lat;
        } else {
            j3 = 0;
        }
        gVar.f449393a = j3;
        if (gpsInfo != null) {
            j16 = gpsInfo.lon;
        } else {
            j16 = 0;
        }
        gVar.f449394b = j16;
        if (gpsInfo != null) {
            j17 = gpsInfo.alt;
        } else {
            j17 = 0;
        }
        gVar.f449396d = j17;
        if (gpsInfo != null) {
            j18 = gpsInfo.gpsType;
        }
        gVar.f449395c = j18;
        lVar.f449425g = gVar;
        lVar.f449426h = poiInfo.distance;
        lVar.f449427i = poiInfo.hotValue;
        String str6 = poiInfo.phoneNumber;
        if (str6 == null) {
            str6 = "";
        }
        lVar.f449428j = str6;
        String str7 = poiInfo.country;
        if (str7 == null) {
            str7 = "";
        }
        lVar.f449429k = str7;
        String str8 = poiInfo.province;
        if (str8 == null) {
            str8 = "";
        }
        lVar.f449430l = str8;
        String str9 = poiInfo.city;
        if (str9 == null) {
            str9 = "";
        }
        lVar.f449431m = str9;
        lVar.f449433o = poiInfo.poiOrderType;
        String str10 = poiInfo.poiDefaultName;
        if (str10 == null) {
            str10 = "";
        }
        lVar.f449434p = str10;
        String str11 = poiInfo.district;
        if (str11 == null) {
            str11 = "";
        }
        lVar.f449435q = str11;
        String str12 = poiInfo.dianPingId;
        if (str12 != null) {
            str2 = str12;
        }
        lVar.f449436r = str2;
        return lVar;
    }
}
