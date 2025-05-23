package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdOrderItem extends JceStruct {
    static Map<String, String> cache_adExperiment;
    static int cache_adType;
    static AdInsideRewardInfo cache_rewardInfo;
    static SKAdNetworkInfo cache_skAdNetworkInfo;
    static Map<Integer, AdVRReportItem> cache_vrReportMap;
    public AdAction adAction;
    public Map<String, String> adExperiment;
    public int adType;
    public double ecpm;
    public AdInSideVideoExposureItem exposureItem;
    public String orderId;
    public AdPositionItem positionItem;
    public AdInsideRewardInfo rewardInfo;
    public SKAdNetworkInfo skAdNetworkInfo;
    public Map<Integer, AdVRReportItem> vrReportMap;
    static AdInSideVideoExposureItem cache_exposureItem = new AdInSideVideoExposureItem();
    static AdAction cache_adAction = new AdAction();
    static AdPositionItem cache_positionItem = new AdPositionItem();

    static {
        HashMap hashMap = new HashMap();
        cache_adExperiment = hashMap;
        hashMap.put("", "");
        cache_vrReportMap = new HashMap();
        cache_vrReportMap.put(0, new AdVRReportItem());
        cache_skAdNetworkInfo = new SKAdNetworkInfo();
        cache_rewardInfo = new AdInsideRewardInfo();
    }

    public AdOrderItem() {
        this.orderId = "";
        this.adType = 0;
        this.exposureItem = null;
        this.adAction = null;
        this.positionItem = null;
        this.adExperiment = null;
        this.vrReportMap = null;
        this.skAdNetworkInfo = null;
        this.rewardInfo = null;
        this.ecpm = 0.0d;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.orderId = jceInputStream.readString(0, true);
        this.adType = jceInputStream.read(this.adType, 1, false);
        this.exposureItem = (AdInSideVideoExposureItem) jceInputStream.read((JceStruct) cache_exposureItem, 2, false);
        this.adAction = (AdAction) jceInputStream.read((JceStruct) cache_adAction, 3, false);
        this.positionItem = (AdPositionItem) jceInputStream.read((JceStruct) cache_positionItem, 4, false);
        this.adExperiment = (Map) jceInputStream.read((JceInputStream) cache_adExperiment, 5, false);
        this.vrReportMap = (Map) jceInputStream.read((JceInputStream) cache_vrReportMap, 6, false);
        this.skAdNetworkInfo = (SKAdNetworkInfo) jceInputStream.read((JceStruct) cache_skAdNetworkInfo, 7, false);
        this.rewardInfo = (AdInsideRewardInfo) jceInputStream.read((JceStruct) cache_rewardInfo, 8, false);
        this.ecpm = jceInputStream.read(this.ecpm, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.orderId, 0);
        jceOutputStream.write(this.adType, 1);
        AdInSideVideoExposureItem adInSideVideoExposureItem = this.exposureItem;
        if (adInSideVideoExposureItem != null) {
            jceOutputStream.write((JceStruct) adInSideVideoExposureItem, 2);
        }
        AdAction adAction = this.adAction;
        if (adAction != null) {
            jceOutputStream.write((JceStruct) adAction, 3);
        }
        AdPositionItem adPositionItem = this.positionItem;
        if (adPositionItem != null) {
            jceOutputStream.write((JceStruct) adPositionItem, 4);
        }
        Map<String, String> map = this.adExperiment;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        Map<Integer, AdVRReportItem> map2 = this.vrReportMap;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 6);
        }
        SKAdNetworkInfo sKAdNetworkInfo = this.skAdNetworkInfo;
        if (sKAdNetworkInfo != null) {
            jceOutputStream.write((JceStruct) sKAdNetworkInfo, 7);
        }
        AdInsideRewardInfo adInsideRewardInfo = this.rewardInfo;
        if (adInsideRewardInfo != null) {
            jceOutputStream.write((JceStruct) adInsideRewardInfo, 8);
        }
        jceOutputStream.write(this.ecpm, 9);
    }

    public AdOrderItem(String str, int i3, AdInSideVideoExposureItem adInSideVideoExposureItem, AdAction adAction, AdPositionItem adPositionItem, Map<String, String> map, Map<Integer, AdVRReportItem> map2, SKAdNetworkInfo sKAdNetworkInfo, AdInsideRewardInfo adInsideRewardInfo, double d16) {
        this.orderId = str;
        this.adType = i3;
        this.exposureItem = adInSideVideoExposureItem;
        this.adAction = adAction;
        this.positionItem = adPositionItem;
        this.adExperiment = map;
        this.vrReportMap = map2;
        this.skAdNetworkInfo = sKAdNetworkInfo;
        this.rewardInfo = adInsideRewardInfo;
        this.ecpm = d16;
    }
}
