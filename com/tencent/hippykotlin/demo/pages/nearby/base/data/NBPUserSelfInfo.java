package com.tencent.hippykotlin.demo.pages.nearby.base.data;

import c45.i;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import d45.a;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import q25.g;

/* loaded from: classes31.dex */
public final class NBPUserSelfInfo {
    public static final Companion Companion = new Companion();
    public String avatarDressBorderUrl;
    public String avatarUrl;
    public int gender;
    public boolean isNewUser;
    public NBPLatLng latLng;
    public boolean likesOnlySelf;
    public String locationAddress;
    public String locationCity;
    public String locationCountry;
    public String locationDistrict;
    public String locationName;
    public String locationProvince;
    public String nickName;
    public g statusInfo;
    public long tid;

    public NBPUserSelfInfo() {
        this(0L, null, null, 0, null, null, null, null, null, null, null, null, null, false, false, 32767, null);
    }

    public final String getAvatarDressBorderUrl() {
        return this.avatarDressBorderUrl;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getLocationAddress() {
        return this.locationAddress;
    }

    public final String getLocationCity() {
        return this.locationCity;
    }

    public final String getLocationCountry() {
        return this.locationCountry;
    }

    public final String getLocationDistrict() {
        return this.locationDistrict;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public final String getLocationProvince() {
        return this.locationProvince;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final long getTid() {
        return this.tid;
    }

    public final String toJson() {
        String decodeToString;
        e eVar = new e();
        eVar.u("tid", this.tid);
        eVar.v(PhotoCategorySummaryInfo.AVATAR_URL, this.avatarUrl);
        e eVar2 = new e();
        eVar2.s("lat02", this.latLng.latitude);
        eVar2.s("lon02", this.latLng.longitude);
        Unit unit = Unit.INSTANCE;
        eVar.v("latLng", eVar2);
        eVar.t("gender", this.gender);
        eVar.v("nickName", this.nickName);
        g gVar = this.statusInfo;
        if (gVar != null) {
            decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(i.d(gVar)));
            eVar.v("statusInfo", decodeToString);
        }
        eVar.v("locationAddress", this.locationAddress);
        eVar.v("locationName", this.locationName);
        eVar.v("locationCountry", this.locationCountry);
        eVar.v("locationProvince", this.locationProvince);
        eVar.v("locationCity", this.locationCity);
        eVar.v("locationDistrict", this.locationDistrict);
        eVar.v("avatarDressBorderUrl", this.avatarDressBorderUrl);
        return eVar.toString();
    }

    public final boolean updateAvatar(String str) {
        if (!Intrinsics.areEqual(this.avatarUrl, str)) {
            if (str.length() > 0) {
                this.avatarUrl = str;
                return true;
            }
        }
        return false;
    }

    public final boolean updateAvatarDressBorderUrl(String str) {
        if (Intrinsics.areEqual(this.avatarDressBorderUrl, str)) {
            return false;
        }
        this.avatarDressBorderUrl = str;
        return true;
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final NBPUserSelfInfo fromJson(e eVar) {
            byte[] a16;
            NBPUserSelfInfo nBPUserSelfInfo = new NBPUserSelfInfo(0L, null, null, 0, null, null, null, null, null, null, null, null, null, false, false, 32767, null);
            nBPUserSelfInfo.tid = eVar.n("tid");
            nBPUserSelfInfo.avatarUrl = eVar.p(PhotoCategorySummaryInfo.AVATAR_URL);
            NBPLatLng nBPLatLng = new NBPLatLng(0.0d, 0.0d, 3, null);
            e m3 = eVar.m("latLng");
            if (m3 == null) {
                m3 = new e();
            }
            nBPLatLng.latitude = m3.h("lat02");
            nBPLatLng.longitude = m3.h("lon02");
            nBPUserSelfInfo.latLng = nBPLatLng;
            nBPUserSelfInfo.gender = eVar.j("gender");
            nBPUserSelfInfo.nickName = eVar.p("nickName");
            String p16 = eVar.p("statusInfo");
            if ((p16.length() > 0) && (a16 = a.a(p16)) != null) {
                nBPUserSelfInfo.statusInfo = (g) i.b(new g(0, 0, null, null, null, null, null, null, null, null, 1023, null), a16);
            }
            nBPUserSelfInfo.locationAddress = eVar.p("locationAddress");
            nBPUserSelfInfo.locationName = eVar.p("locationName");
            nBPUserSelfInfo.locationCountry = eVar.p("locationCountry");
            nBPUserSelfInfo.locationProvince = eVar.p("locationProvince");
            nBPUserSelfInfo.locationCity = eVar.p("locationCity");
            nBPUserSelfInfo.locationDistrict = eVar.p("locationDistrict");
            nBPUserSelfInfo.avatarDressBorderUrl = eVar.p("avatarDressBorderUrl");
            return nBPUserSelfInfo;
        }
    }

    public NBPUserSelfInfo(long j3, String str, NBPLatLng nBPLatLng, int i3, String str2, g gVar, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z16, boolean z17) {
        this.tid = j3;
        this.avatarUrl = str;
        this.latLng = nBPLatLng;
        this.gender = i3;
        this.nickName = str2;
        this.statusInfo = gVar;
        this.locationAddress = str3;
        this.locationName = str4;
        this.locationCountry = str5;
        this.locationProvince = str6;
        this.locationCity = str7;
        this.locationDistrict = str8;
        this.avatarDressBorderUrl = str9;
        this.isNewUser = z16;
        this.likesOnlySelf = z17;
    }

    public /* synthetic */ NBPUserSelfInfo(long j3, String str, NBPLatLng nBPLatLng, int i3, String str2, g gVar, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", NBPLatLngExtKt.DEFAULT_INIT_POS, 0, "", null, "", "", "", "", "", "", "", false, false);
    }
}
