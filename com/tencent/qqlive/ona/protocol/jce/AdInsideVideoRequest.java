package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideVideoRequest extends JceStruct {
    static AdCreativeProfileInfo cache_adCreativeProfileInfo;
    static AdInsideVideoRequestExtraInfo cache_extraInfo;
    static int cache_screenMode;
    static ArrayList<String> cache_watchedVidList;
    public AdCreativeProfileInfo adCreativeProfileInfo;
    public AdOfflineInfo adOfflineInfo;
    public AdPageInfo adPageInfo;
    public AdSdkRequestInfo adSdkRequestInfo;
    public AdVideoInfo adVideoInfo;
    public AdVideoPlatformInfo adVideoPlatformInfo;
    public int adVipState;
    public AdInsideVideoRequestExtraInfo extraInfo;
    public Map<String, ArrayList<String>> filterMap;
    public AdFreeFlowItem freeFlowItem;
    public boolean isFirstOrderShowDay;
    public int requestAdType;
    public int screenMode;
    public ArrayList<String> watchedVidList;
    static AdVideoInfo cache_adVideoInfo = new AdVideoInfo();
    static int cache_adVipState = 0;
    static AdPageInfo cache_adPageInfo = new AdPageInfo();
    static AdOfflineInfo cache_adOfflineInfo = new AdOfflineInfo();
    static AdVideoPlatformInfo cache_adVideoPlatformInfo = new AdVideoPlatformInfo();
    static AdSdkRequestInfo cache_adSdkRequestInfo = new AdSdkRequestInfo();
    static AdFreeFlowItem cache_freeFlowItem = new AdFreeFlowItem();
    static Map<String, ArrayList<String>> cache_filterMap = new HashMap();

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_filterMap.put("", arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_watchedVidList = arrayList2;
        arrayList2.add("");
        cache_adCreativeProfileInfo = new AdCreativeProfileInfo();
        cache_screenMode = 0;
        cache_extraInfo = new AdInsideVideoRequestExtraInfo();
    }

    public AdInsideVideoRequest() {
        this.requestAdType = 0;
        this.adVideoInfo = null;
        this.adVipState = 0;
        this.adPageInfo = null;
        this.adOfflineInfo = null;
        this.adVideoPlatformInfo = null;
        this.adSdkRequestInfo = null;
        this.freeFlowItem = null;
        this.filterMap = null;
        this.watchedVidList = null;
        this.adCreativeProfileInfo = null;
        this.screenMode = 0;
        this.isFirstOrderShowDay = false;
        this.extraInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.requestAdType = jceInputStream.read(this.requestAdType, 0, false);
        this.adVideoInfo = (AdVideoInfo) jceInputStream.read((JceStruct) cache_adVideoInfo, 1, false);
        this.adVipState = jceInputStream.read(this.adVipState, 2, false);
        this.adPageInfo = (AdPageInfo) jceInputStream.read((JceStruct) cache_adPageInfo, 3, false);
        this.adOfflineInfo = (AdOfflineInfo) jceInputStream.read((JceStruct) cache_adOfflineInfo, 4, false);
        this.adVideoPlatformInfo = (AdVideoPlatformInfo) jceInputStream.read((JceStruct) cache_adVideoPlatformInfo, 5, false);
        this.adSdkRequestInfo = (AdSdkRequestInfo) jceInputStream.read((JceStruct) cache_adSdkRequestInfo, 6, false);
        this.freeFlowItem = (AdFreeFlowItem) jceInputStream.read((JceStruct) cache_freeFlowItem, 7, false);
        this.filterMap = (Map) jceInputStream.read((JceInputStream) cache_filterMap, 8, false);
        this.watchedVidList = (ArrayList) jceInputStream.read((JceInputStream) cache_watchedVidList, 9, false);
        this.adCreativeProfileInfo = (AdCreativeProfileInfo) jceInputStream.read((JceStruct) cache_adCreativeProfileInfo, 10, false);
        this.screenMode = jceInputStream.read(this.screenMode, 11, false);
        this.isFirstOrderShowDay = jceInputStream.read(this.isFirstOrderShowDay, 12, false);
        this.extraInfo = (AdInsideVideoRequestExtraInfo) jceInputStream.read((JceStruct) cache_extraInfo, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.requestAdType, 0);
        AdVideoInfo adVideoInfo = this.adVideoInfo;
        if (adVideoInfo != null) {
            jceOutputStream.write((JceStruct) adVideoInfo, 1);
        }
        jceOutputStream.write(this.adVipState, 2);
        AdPageInfo adPageInfo = this.adPageInfo;
        if (adPageInfo != null) {
            jceOutputStream.write((JceStruct) adPageInfo, 3);
        }
        AdOfflineInfo adOfflineInfo = this.adOfflineInfo;
        if (adOfflineInfo != null) {
            jceOutputStream.write((JceStruct) adOfflineInfo, 4);
        }
        AdVideoPlatformInfo adVideoPlatformInfo = this.adVideoPlatformInfo;
        if (adVideoPlatformInfo != null) {
            jceOutputStream.write((JceStruct) adVideoPlatformInfo, 5);
        }
        AdSdkRequestInfo adSdkRequestInfo = this.adSdkRequestInfo;
        if (adSdkRequestInfo != null) {
            jceOutputStream.write((JceStruct) adSdkRequestInfo, 6);
        }
        AdFreeFlowItem adFreeFlowItem = this.freeFlowItem;
        if (adFreeFlowItem != null) {
            jceOutputStream.write((JceStruct) adFreeFlowItem, 7);
        }
        Map<String, ArrayList<String>> map = this.filterMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        ArrayList<String> arrayList = this.watchedVidList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        AdCreativeProfileInfo adCreativeProfileInfo = this.adCreativeProfileInfo;
        if (adCreativeProfileInfo != null) {
            jceOutputStream.write((JceStruct) adCreativeProfileInfo, 10);
        }
        jceOutputStream.write(this.screenMode, 11);
        jceOutputStream.write(this.isFirstOrderShowDay, 12);
        AdInsideVideoRequestExtraInfo adInsideVideoRequestExtraInfo = this.extraInfo;
        if (adInsideVideoRequestExtraInfo != null) {
            jceOutputStream.write((JceStruct) adInsideVideoRequestExtraInfo, 13);
        }
    }

    public AdInsideVideoRequest(int i3, AdVideoInfo adVideoInfo, int i16, AdPageInfo adPageInfo, AdOfflineInfo adOfflineInfo, AdVideoPlatformInfo adVideoPlatformInfo, AdSdkRequestInfo adSdkRequestInfo, AdFreeFlowItem adFreeFlowItem, Map<String, ArrayList<String>> map, ArrayList<String> arrayList, AdCreativeProfileInfo adCreativeProfileInfo, int i17, boolean z16, AdInsideVideoRequestExtraInfo adInsideVideoRequestExtraInfo) {
        this.requestAdType = i3;
        this.adVideoInfo = adVideoInfo;
        this.adVipState = i16;
        this.adPageInfo = adPageInfo;
        this.adOfflineInfo = adOfflineInfo;
        this.adVideoPlatformInfo = adVideoPlatformInfo;
        this.adSdkRequestInfo = adSdkRequestInfo;
        this.freeFlowItem = adFreeFlowItem;
        this.filterMap = map;
        this.watchedVidList = arrayList;
        this.adCreativeProfileInfo = adCreativeProfileInfo;
        this.screenMode = i17;
        this.isFirstOrderShowDay = z16;
        this.extraInfo = adInsideVideoRequestExtraInfo;
    }
}
