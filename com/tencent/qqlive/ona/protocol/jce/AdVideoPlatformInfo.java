package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public final class AdVideoPlatformInfo extends JceStruct {
    static AdBaseExtraInfo cache_adBaseExtraInfo;
    static Map<String, String> cache_adxEncryDataMap;
    static ArrayList<AdDeviceInfo> cache_deviceInfos;
    static Map<String, String> cache_vrPublicParams;
    static WechatVersionInfo cache_wechatVersionInfo;
    public AdBaseExtraInfo adBaseExtraInfo;
    public String adxEncryData;
    public Map<String, String> adxEncryDataMap;
    public String bluetooth_mac;
    public String boottime;
    public String bssid;
    public String chid;
    public String country;
    public String device;
    public ArrayList<AdDeviceInfo> deviceInfos;
    public String deviceName;
    public String disk;
    public String encrypt_cached_idfa;
    public String harmony_os_version;
    public int harmony_pure_mode;
    public String hwmachine;
    public String hwmodel;
    public String idfv;
    public String language;
    public String memory;
    public String networkOperatorCode;
    public int newNetType;
    public String openudid;
    public String osUpgradeTime;
    public int os_type;
    public String os_version;

    /* renamed from: pf, reason: collision with root package name */
    public String f345338pf;
    public String platform;
    public String sdtfrom;
    public String subscriber_id;
    public String systemVersion;
    public String taidTicket;
    public String timeZone;
    public String userAgent;
    public String uuid;
    public Map<String, String> vrPublicParams;
    public WechatVersionInfo wechatVersionInfo;
    public String wifiName;
    public int wxVersionCode;

    static {
        HashMap hashMap = new HashMap();
        cache_adxEncryDataMap = hashMap;
        hashMap.put("", "");
        cache_deviceInfos = new ArrayList<>();
        cache_deviceInfos.add(new AdDeviceInfo());
        cache_wechatVersionInfo = new WechatVersionInfo();
        HashMap hashMap2 = new HashMap();
        cache_vrPublicParams = hashMap2;
        hashMap2.put("", "");
        cache_adBaseExtraInfo = new AdBaseExtraInfo();
    }

    public AdVideoPlatformInfo() {
        this.adxEncryData = "";
        this.f345338pf = "";
        this.chid = "";
        this.sdtfrom = "";
        this.platform = "";
        this.device = "";
        this.newNetType = 0;
        this.openudid = "";
        this.wxVersionCode = 0;
        this.adxEncryDataMap = null;
        this.deviceInfos = null;
        this.bluetooth_mac = "";
        this.subscriber_id = "";
        this.uuid = "";
        this.bssid = "";
        this.os_version = "";
        this.boottime = "";
        this.country = "";
        this.language = "";
        this.deviceName = "";
        this.networkOperatorCode = "";
        this.memory = "";
        this.disk = "";
        this.osUpgradeTime = "";
        this.timeZone = "";
        this.hwmodel = "";
        this.hwmachine = "";
        this.idfv = "";
        this.userAgent = "";
        this.wechatVersionInfo = null;
        this.encrypt_cached_idfa = "";
        this.vrPublicParams = null;
        this.harmony_os_version = "";
        this.harmony_pure_mode = 0;
        this.os_type = 0;
        this.wifiName = "";
        this.taidTicket = "";
        this.adBaseExtraInfo = null;
        this.systemVersion = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adxEncryData = jceInputStream.readString(0, false);
        this.f345338pf = jceInputStream.readString(1, false);
        this.chid = jceInputStream.readString(2, false);
        this.sdtfrom = jceInputStream.readString(3, false);
        this.platform = jceInputStream.readString(4, false);
        this.device = jceInputStream.readString(5, false);
        this.newNetType = jceInputStream.read(this.newNetType, 6, false);
        this.openudid = jceInputStream.readString(7, false);
        this.wxVersionCode = jceInputStream.read(this.wxVersionCode, 8, false);
        this.adxEncryDataMap = (Map) jceInputStream.read((JceInputStream) cache_adxEncryDataMap, 9, false);
        this.deviceInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_deviceInfos, 10, false);
        this.bluetooth_mac = jceInputStream.readString(11, false);
        this.subscriber_id = jceInputStream.readString(12, false);
        this.uuid = jceInputStream.readString(13, false);
        this.bssid = jceInputStream.readString(14, false);
        this.os_version = jceInputStream.readString(15, false);
        this.boottime = jceInputStream.readString(16, false);
        this.country = jceInputStream.readString(17, false);
        this.language = jceInputStream.readString(18, false);
        this.deviceName = jceInputStream.readString(19, false);
        this.networkOperatorCode = jceInputStream.readString(20, false);
        this.memory = jceInputStream.readString(21, false);
        this.disk = jceInputStream.readString(22, false);
        this.osUpgradeTime = jceInputStream.readString(23, false);
        this.timeZone = jceInputStream.readString(24, false);
        this.hwmodel = jceInputStream.readString(25, false);
        this.hwmachine = jceInputStream.readString(26, false);
        this.idfv = jceInputStream.readString(27, false);
        this.userAgent = jceInputStream.readString(28, false);
        this.wechatVersionInfo = (WechatVersionInfo) jceInputStream.read((JceStruct) cache_wechatVersionInfo, 29, false);
        this.encrypt_cached_idfa = jceInputStream.readString(30, false);
        this.vrPublicParams = (Map) jceInputStream.read((JceInputStream) cache_vrPublicParams, 31, false);
        this.harmony_os_version = jceInputStream.readString(32, false);
        this.harmony_pure_mode = jceInputStream.read(this.harmony_pure_mode, 33, false);
        this.os_type = jceInputStream.read(this.os_type, 34, false);
        this.wifiName = jceInputStream.readString(35, false);
        this.taidTicket = jceInputStream.readString(36, false);
        this.adBaseExtraInfo = (AdBaseExtraInfo) jceInputStream.read((JceStruct) cache_adBaseExtraInfo, 37, false);
        this.systemVersion = jceInputStream.readString(38, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.adxEncryData;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.f345338pf;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.chid;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.sdtfrom;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.platform;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        String str6 = this.device;
        if (str6 != null) {
            jceOutputStream.write(str6, 5);
        }
        jceOutputStream.write(this.newNetType, 6);
        String str7 = this.openudid;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        jceOutputStream.write(this.wxVersionCode, 8);
        Map<String, String> map = this.adxEncryDataMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 9);
        }
        ArrayList<AdDeviceInfo> arrayList = this.deviceInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        String str8 = this.bluetooth_mac;
        if (str8 != null) {
            jceOutputStream.write(str8, 11);
        }
        String str9 = this.subscriber_id;
        if (str9 != null) {
            jceOutputStream.write(str9, 12);
        }
        String str10 = this.uuid;
        if (str10 != null) {
            jceOutputStream.write(str10, 13);
        }
        String str11 = this.bssid;
        if (str11 != null) {
            jceOutputStream.write(str11, 14);
        }
        String str12 = this.os_version;
        if (str12 != null) {
            jceOutputStream.write(str12, 15);
        }
        String str13 = this.boottime;
        if (str13 != null) {
            jceOutputStream.write(str13, 16);
        }
        String str14 = this.country;
        if (str14 != null) {
            jceOutputStream.write(str14, 17);
        }
        String str15 = this.language;
        if (str15 != null) {
            jceOutputStream.write(str15, 18);
        }
        String str16 = this.deviceName;
        if (str16 != null) {
            jceOutputStream.write(str16, 19);
        }
        String str17 = this.networkOperatorCode;
        if (str17 != null) {
            jceOutputStream.write(str17, 20);
        }
        String str18 = this.memory;
        if (str18 != null) {
            jceOutputStream.write(str18, 21);
        }
        String str19 = this.disk;
        if (str19 != null) {
            jceOutputStream.write(str19, 22);
        }
        String str20 = this.osUpgradeTime;
        if (str20 != null) {
            jceOutputStream.write(str20, 23);
        }
        String str21 = this.timeZone;
        if (str21 != null) {
            jceOutputStream.write(str21, 24);
        }
        String str22 = this.hwmodel;
        if (str22 != null) {
            jceOutputStream.write(str22, 25);
        }
        String str23 = this.hwmachine;
        if (str23 != null) {
            jceOutputStream.write(str23, 26);
        }
        String str24 = this.idfv;
        if (str24 != null) {
            jceOutputStream.write(str24, 27);
        }
        String str25 = this.userAgent;
        if (str25 != null) {
            jceOutputStream.write(str25, 28);
        }
        WechatVersionInfo wechatVersionInfo = this.wechatVersionInfo;
        if (wechatVersionInfo != null) {
            jceOutputStream.write((JceStruct) wechatVersionInfo, 29);
        }
        String str26 = this.encrypt_cached_idfa;
        if (str26 != null) {
            jceOutputStream.write(str26, 30);
        }
        Map<String, String> map2 = this.vrPublicParams;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 31);
        }
        String str27 = this.harmony_os_version;
        if (str27 != null) {
            jceOutputStream.write(str27, 32);
        }
        jceOutputStream.write(this.harmony_pure_mode, 33);
        jceOutputStream.write(this.os_type, 34);
        String str28 = this.wifiName;
        if (str28 != null) {
            jceOutputStream.write(str28, 35);
        }
        String str29 = this.taidTicket;
        if (str29 != null) {
            jceOutputStream.write(str29, 36);
        }
        AdBaseExtraInfo adBaseExtraInfo = this.adBaseExtraInfo;
        if (adBaseExtraInfo != null) {
            jceOutputStream.write((JceStruct) adBaseExtraInfo, 37);
        }
        String str30 = this.systemVersion;
        if (str30 != null) {
            jceOutputStream.write(str30, 38);
        }
    }

    public AdVideoPlatformInfo(String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, int i16, Map<String, String> map, ArrayList<AdDeviceInfo> arrayList, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, WechatVersionInfo wechatVersionInfo, String str26, Map<String, String> map2, String str27, int i17, int i18, String str28, String str29, AdBaseExtraInfo adBaseExtraInfo, String str30) {
        this.adxEncryData = str;
        this.f345338pf = str2;
        this.chid = str3;
        this.sdtfrom = str4;
        this.platform = str5;
        this.device = str6;
        this.newNetType = i3;
        this.openudid = str7;
        this.wxVersionCode = i16;
        this.adxEncryDataMap = map;
        this.deviceInfos = arrayList;
        this.bluetooth_mac = str8;
        this.subscriber_id = str9;
        this.uuid = str10;
        this.bssid = str11;
        this.os_version = str12;
        this.boottime = str13;
        this.country = str14;
        this.language = str15;
        this.deviceName = str16;
        this.networkOperatorCode = str17;
        this.memory = str18;
        this.disk = str19;
        this.osUpgradeTime = str20;
        this.timeZone = str21;
        this.hwmodel = str22;
        this.hwmachine = str23;
        this.idfv = str24;
        this.userAgent = str25;
        this.wechatVersionInfo = wechatVersionInfo;
        this.encrypt_cached_idfa = str26;
        this.vrPublicParams = map2;
        this.harmony_os_version = str27;
        this.harmony_pure_mode = i17;
        this.os_type = i18;
        this.wifiName = str28;
        this.taidTicket = str29;
        this.adBaseExtraInfo = adBaseExtraInfo;
        this.systemVersion = str30;
    }
}
