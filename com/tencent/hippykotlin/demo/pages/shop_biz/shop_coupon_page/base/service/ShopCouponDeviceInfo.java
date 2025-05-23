package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.service;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ShopCouponDeviceInfo implements ISSOModel {
    public static final Companion Companion = new Companion();
    public final String appVersion;
    public final String deviceBrandAndModel;
    public final String deviceId;
    public final ArrayList<ShopCouponEntry> ext;

    /* renamed from: ip, reason: collision with root package name */
    public final String f114302ip;
    public final String manufacturer;
    public final int network;

    /* renamed from: os, reason: collision with root package name */
    public final int f114303os;
    public final String qimei;
    public final String qimei36;
    public final String terminalId;
    public final String terminalType;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    public ShopCouponDeviceInfo() {
        this(null, 0, null, null, null, 0, null, null, null, null, null, null, 4095, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("app_version", this.appVersion);
        eVar.t("os", this.f114303os);
        eVar.v("device_id", this.deviceId);
        eVar.v(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, this.qimei);
        eVar.v("qimei36", this.qimei36);
        eVar.t("network", this.network);
        eVar.v("ip", this.f114302ip);
        eVar.v("terminal_id", this.terminalId);
        eVar.v(AudienceReportConst.TERMINAL_TYPE, this.terminalType);
        eVar.v("manufacturer", this.manufacturer);
        b a16 = o.a(eVar, "device_brand_and_model", this.deviceBrandAndModel);
        ArrayList<ShopCouponEntry> arrayList = this.ext;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                a16.t(((ShopCouponEntry) it.next()).encode());
            }
        }
        eVar.v("ext", a16);
        return eVar;
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.deviceBrandAndModel, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.manufacturer, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.terminalType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.terminalId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114302ip, QQAudioParams$$ExternalSyntheticOutline0.m(this.network, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei36, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.deviceId, QQAudioParams$$ExternalSyntheticOutline0.m(this.f114303os, this.appVersion.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        ArrayList<ShopCouponEntry> arrayList = this.ext;
        return m3 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        return "ShopCouponDeviceInfo(appVersion=" + this.appVersion + ", os=" + this.f114303os + ", deviceId=" + this.deviceId + ", qimei=" + this.qimei + ", qimei36=" + this.qimei36 + ", network=" + this.network + ", ip=" + this.f114302ip + ", terminalId=" + this.terminalId + ", terminalType=" + this.terminalType + ", manufacturer=" + this.manufacturer + ", deviceBrandAndModel=" + this.deviceBrandAndModel + ", ext=" + this.ext + ')';
    }

    public ShopCouponDeviceInfo(String str, int i3, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, String str9, ArrayList<ShopCouponEntry> arrayList) {
        this.appVersion = str;
        this.f114303os = i3;
        this.deviceId = str2;
        this.qimei = str3;
        this.qimei36 = str4;
        this.network = i16;
        this.f114302ip = str5;
        this.terminalId = str6;
        this.terminalType = str7;
        this.manufacturer = str8;
        this.deviceBrandAndModel = str9;
        this.ext = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopCouponDeviceInfo)) {
            return false;
        }
        ShopCouponDeviceInfo shopCouponDeviceInfo = (ShopCouponDeviceInfo) obj;
        return Intrinsics.areEqual(this.appVersion, shopCouponDeviceInfo.appVersion) && this.f114303os == shopCouponDeviceInfo.f114303os && Intrinsics.areEqual(this.deviceId, shopCouponDeviceInfo.deviceId) && Intrinsics.areEqual(this.qimei, shopCouponDeviceInfo.qimei) && Intrinsics.areEqual(this.qimei36, shopCouponDeviceInfo.qimei36) && this.network == shopCouponDeviceInfo.network && Intrinsics.areEqual(this.f114302ip, shopCouponDeviceInfo.f114302ip) && Intrinsics.areEqual(this.terminalId, shopCouponDeviceInfo.terminalId) && Intrinsics.areEqual(this.terminalType, shopCouponDeviceInfo.terminalType) && Intrinsics.areEqual(this.manufacturer, shopCouponDeviceInfo.manufacturer) && Intrinsics.areEqual(this.deviceBrandAndModel, shopCouponDeviceInfo.deviceBrandAndModel) && Intrinsics.areEqual(this.ext, shopCouponDeviceInfo.ext);
    }

    public /* synthetic */ ShopCouponDeviceInfo(String str, int i3, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "", "", "", 0, "", "", "", "", "", null);
    }
}
