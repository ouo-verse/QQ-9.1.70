package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class DeviceInfo {
    public final String availableMemory;
    public final int cpuNum;
    public final String cpuType;
    public final String fingerprint;
    public final String idfa;
    public final String imsi;
    public final String incremental;
    public final int isGrayOrAppstore;
    public final String macAddress;
    public final String model;
    public final String msfIdentifier;
    public final String msfImei;
    public final String qimei;
    public final String qimei36;
    public final String systemName;
    public final String systemVersion;
    public final String totalMemory;

    public final int hashCode() {
        return this.idfa.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.msfIdentifier, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.msfImei, QQAudioParams$$ExternalSyntheticOutline0.m(this.isGrayOrAppstore, QQAudioParams$$ExternalSyntheticOutline0.m(this.cpuNum, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.cpuType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.availableMemory, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.totalMemory, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei36, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.qimei, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.imsi, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.macAddress, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.incremental, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.fingerprint, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.model, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.systemVersion, this.systemName.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "DeviceInfo(systemName=" + this.systemName + ", systemVersion=" + this.systemVersion + ", model=" + this.model + ", fingerprint=" + this.fingerprint + ", incremental=" + this.incremental + ", macAddress=" + this.macAddress + ", imsi=" + this.imsi + ", qimei=" + this.qimei + ", qimei36=" + this.qimei36 + ", totalMemory=" + this.totalMemory + ", availableMemory=" + this.availableMemory + ", cpuType=" + this.cpuType + ", cpuNum=" + this.cpuNum + ", isGrayOrAppstore=" + this.isGrayOrAppstore + ", msfImei=" + this.msfImei + ", msfIdentifier=" + this.msfIdentifier + ", idfa=" + this.idfa + ')';
    }

    public DeviceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i3, int i16, String str13, String str14, String str15) {
        this.systemName = str;
        this.systemVersion = str2;
        this.model = str3;
        this.fingerprint = str4;
        this.incremental = str5;
        this.macAddress = str6;
        this.imsi = str7;
        this.qimei = str8;
        this.qimei36 = str9;
        this.totalMemory = str10;
        this.availableMemory = str11;
        this.cpuType = str12;
        this.cpuNum = i3;
        this.isGrayOrAppstore = i16;
        this.msfImei = str13;
        this.msfIdentifier = str14;
        this.idfa = str15;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        return Intrinsics.areEqual(this.systemName, deviceInfo.systemName) && Intrinsics.areEqual(this.systemVersion, deviceInfo.systemVersion) && Intrinsics.areEqual(this.model, deviceInfo.model) && Intrinsics.areEqual(this.fingerprint, deviceInfo.fingerprint) && Intrinsics.areEqual(this.incremental, deviceInfo.incremental) && Intrinsics.areEqual(this.macAddress, deviceInfo.macAddress) && Intrinsics.areEqual(this.imsi, deviceInfo.imsi) && Intrinsics.areEqual(this.qimei, deviceInfo.qimei) && Intrinsics.areEqual(this.qimei36, deviceInfo.qimei36) && Intrinsics.areEqual(this.totalMemory, deviceInfo.totalMemory) && Intrinsics.areEqual(this.availableMemory, deviceInfo.availableMemory) && Intrinsics.areEqual(this.cpuType, deviceInfo.cpuType) && this.cpuNum == deviceInfo.cpuNum && this.isGrayOrAppstore == deviceInfo.isGrayOrAppstore && Intrinsics.areEqual(this.msfImei, deviceInfo.msfImei) && Intrinsics.areEqual(this.msfIdentifier, deviceInfo.msfIdentifier) && Intrinsics.areEqual(this.idfa, deviceInfo.idfa);
    }
}
