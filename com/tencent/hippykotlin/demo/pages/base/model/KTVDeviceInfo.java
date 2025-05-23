package com.tencent.hippykotlin.demo.pages.base.model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class KTVDeviceInfo {
    public final String appVersion;
    public final String deviceBrandAndModel;
    public final String deviceId;
    public final ArrayList<KTVEntry> ext;

    /* renamed from: ip, reason: collision with root package name */
    public final String f114180ip;
    public final String manufacturer;
    public final int network;

    /* renamed from: os, reason: collision with root package name */
    public final int f114181os;
    public final String qimei;
    public final String qimei36;
    public final String terminalId;
    public final String terminalType;

    public KTVDeviceInfo() {
        this(null, 0, null, null, null, 0, null, null, null, null, null, null, 4095, null);
    }

    public final int hashCode() {
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.deviceBrandAndModel, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.manufacturer, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.terminalType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.terminalId, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.f114180ip, QQAudioParams$$ExternalSyntheticOutline0.m(this.network, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei36, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.deviceId, QQAudioParams$$ExternalSyntheticOutline0.m(this.f114181os, this.appVersion.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        ArrayList<KTVEntry> arrayList = this.ext;
        return m3 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final String toString() {
        return "KTVDeviceInfo(appVersion=" + this.appVersion + ", os=" + this.f114181os + ", deviceId=" + this.deviceId + ", qimei=" + this.qimei + ", qimei36=" + this.qimei36 + ", network=" + this.network + ", ip=" + this.f114180ip + ", terminalId=" + this.terminalId + ", terminalType=" + this.terminalType + ", manufacturer=" + this.manufacturer + ", deviceBrandAndModel=" + this.deviceBrandAndModel + ", ext=" + this.ext + ')';
    }

    public KTVDeviceInfo(String str, int i3, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, String str9, ArrayList<KTVEntry> arrayList) {
        this.appVersion = str;
        this.f114181os = i3;
        this.deviceId = str2;
        this.qimei = str3;
        this.qimei36 = str4;
        this.network = i16;
        this.f114180ip = str5;
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
        if (!(obj instanceof KTVDeviceInfo)) {
            return false;
        }
        KTVDeviceInfo kTVDeviceInfo = (KTVDeviceInfo) obj;
        return Intrinsics.areEqual(this.appVersion, kTVDeviceInfo.appVersion) && this.f114181os == kTVDeviceInfo.f114181os && Intrinsics.areEqual(this.deviceId, kTVDeviceInfo.deviceId) && Intrinsics.areEqual(this.qimei, kTVDeviceInfo.qimei) && Intrinsics.areEqual(this.qimei36, kTVDeviceInfo.qimei36) && this.network == kTVDeviceInfo.network && Intrinsics.areEqual(this.f114180ip, kTVDeviceInfo.f114180ip) && Intrinsics.areEqual(this.terminalId, kTVDeviceInfo.terminalId) && Intrinsics.areEqual(this.terminalType, kTVDeviceInfo.terminalType) && Intrinsics.areEqual(this.manufacturer, kTVDeviceInfo.manufacturer) && Intrinsics.areEqual(this.deviceBrandAndModel, kTVDeviceInfo.deviceBrandAndModel) && Intrinsics.areEqual(this.ext, kTVDeviceInfo.ext);
    }

    public /* synthetic */ KTVDeviceInfo(String str, int i3, String str2, String str3, String str4, int i16, String str5, String str6, String str7, String str8, String str9, ArrayList arrayList, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0, "", "", "", 0, "", "", "", "", "", null);
    }
}
