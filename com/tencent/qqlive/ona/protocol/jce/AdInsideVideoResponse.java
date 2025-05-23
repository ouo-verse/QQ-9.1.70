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
public final class AdInsideVideoResponse extends JceStruct {
    static AdResponseCommonInfo cache_commonInfo;
    static AdEpisodeVideoInfo cache_episodeVideoInfo;
    static Map<String, String> cache_extraDp3ReportMap;
    static AdInsideVideoExtraInfo cache_extraInfo;
    static Map<String, ArrayList<String>> cache_filterMap;
    static AdGetVInfoItem cache_getVInfoItem;
    static MidAdAdvanceInfo cache_midAdAdvanceInfo;
    static AdPrePlayTips cache_prePlayTips;
    static AdInsideReplaceOutsideInfo cache_replaceOutsideInfo;
    static InsideVideoSkipAdInfo cache_skipAdInfo;
    static Map<String, String> cache_transparentData;
    static ArrayList<AdTempletItem> cache_videoAdItemList = new ArrayList<>();
    public String adCookie;
    public AdResponseCommonInfo commonInfo;
    public int emptyAdReason;
    public AdEpisodeVideoInfo episodeVideoInfo;
    public int errCode;
    public String errMsg;
    public Map<String, String> extraDp3ReportMap;
    public AdInsideVideoExtraInfo extraInfo;
    public Map<String, ArrayList<String>> filterMap;
    public AdGetVInfoItem getVInfoItem;
    public MidAdAdvanceInfo midAdAdvanceInfo;
    public long nextRequestInterval;
    public AdPrePlayTips prePlayTips;
    public AdInsideReplaceOutsideInfo replaceOutsideInfo;
    public InsideVideoSkipAdInfo skipAdInfo;
    public boolean stopRequestDynamicAd;
    public Map<String, String> transparentData;
    public ArrayList<AdTempletItem> videoAdItemList;

    static {
        cache_videoAdItemList.add(new AdTempletItem());
        cache_filterMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("");
        cache_filterMap.put("", arrayList);
        cache_getVInfoItem = new AdGetVInfoItem();
        HashMap hashMap = new HashMap();
        cache_extraDp3ReportMap = hashMap;
        hashMap.put("", "");
        cache_extraInfo = new AdInsideVideoExtraInfo();
        cache_replaceOutsideInfo = new AdInsideReplaceOutsideInfo();
        cache_commonInfo = new AdResponseCommonInfo();
        HashMap hashMap2 = new HashMap();
        cache_transparentData = hashMap2;
        hashMap2.put("", "");
        cache_midAdAdvanceInfo = new MidAdAdvanceInfo();
        cache_skipAdInfo = new InsideVideoSkipAdInfo();
        cache_prePlayTips = new AdPrePlayTips();
        cache_episodeVideoInfo = new AdEpisodeVideoInfo();
    }

    public AdInsideVideoResponse() {
        this.errCode = 0;
        this.errMsg = "";
        this.videoAdItemList = null;
        this.adCookie = "";
        this.filterMap = null;
        this.getVInfoItem = null;
        this.extraDp3ReportMap = null;
        this.emptyAdReason = 0;
        this.extraInfo = null;
        this.replaceOutsideInfo = null;
        this.commonInfo = null;
        this.nextRequestInterval = 0L;
        this.stopRequestDynamicAd = false;
        this.transparentData = null;
        this.midAdAdvanceInfo = null;
        this.skipAdInfo = null;
        this.prePlayTips = null;
        this.episodeVideoInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errCode = jceInputStream.read(this.errCode, 0, true);
        this.errMsg = jceInputStream.readString(1, false);
        this.videoAdItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_videoAdItemList, 2, false);
        this.adCookie = jceInputStream.readString(3, false);
        this.filterMap = (Map) jceInputStream.read((JceInputStream) cache_filterMap, 4, false);
        this.getVInfoItem = (AdGetVInfoItem) jceInputStream.read((JceStruct) cache_getVInfoItem, 5, false);
        this.extraDp3ReportMap = (Map) jceInputStream.read((JceInputStream) cache_extraDp3ReportMap, 6, false);
        this.emptyAdReason = jceInputStream.read(this.emptyAdReason, 7, false);
        this.extraInfo = (AdInsideVideoExtraInfo) jceInputStream.read((JceStruct) cache_extraInfo, 8, false);
        this.replaceOutsideInfo = (AdInsideReplaceOutsideInfo) jceInputStream.read((JceStruct) cache_replaceOutsideInfo, 9, false);
        this.commonInfo = (AdResponseCommonInfo) jceInputStream.read((JceStruct) cache_commonInfo, 10, false);
        this.nextRequestInterval = jceInputStream.read(this.nextRequestInterval, 11, false);
        this.stopRequestDynamicAd = jceInputStream.read(this.stopRequestDynamicAd, 12, false);
        this.transparentData = (Map) jceInputStream.read((JceInputStream) cache_transparentData, 13, false);
        this.midAdAdvanceInfo = (MidAdAdvanceInfo) jceInputStream.read((JceStruct) cache_midAdAdvanceInfo, 14, false);
        this.skipAdInfo = (InsideVideoSkipAdInfo) jceInputStream.read((JceStruct) cache_skipAdInfo, 15, false);
        this.prePlayTips = (AdPrePlayTips) jceInputStream.read((JceStruct) cache_prePlayTips, 16, false);
        this.episodeVideoInfo = (AdEpisodeVideoInfo) jceInputStream.read((JceStruct) cache_episodeVideoInfo, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.errCode, 0);
        String str = this.errMsg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<AdTempletItem> arrayList = this.videoAdItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.adCookie;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<String, ArrayList<String>> map = this.filterMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        AdGetVInfoItem adGetVInfoItem = this.getVInfoItem;
        if (adGetVInfoItem != null) {
            jceOutputStream.write((JceStruct) adGetVInfoItem, 5);
        }
        Map<String, String> map2 = this.extraDp3ReportMap;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 6);
        }
        jceOutputStream.write(this.emptyAdReason, 7);
        AdInsideVideoExtraInfo adInsideVideoExtraInfo = this.extraInfo;
        if (adInsideVideoExtraInfo != null) {
            jceOutputStream.write((JceStruct) adInsideVideoExtraInfo, 8);
        }
        AdInsideReplaceOutsideInfo adInsideReplaceOutsideInfo = this.replaceOutsideInfo;
        if (adInsideReplaceOutsideInfo != null) {
            jceOutputStream.write((JceStruct) adInsideReplaceOutsideInfo, 9);
        }
        AdResponseCommonInfo adResponseCommonInfo = this.commonInfo;
        if (adResponseCommonInfo != null) {
            jceOutputStream.write((JceStruct) adResponseCommonInfo, 10);
        }
        jceOutputStream.write(this.nextRequestInterval, 11);
        jceOutputStream.write(this.stopRequestDynamicAd, 12);
        Map<String, String> map3 = this.transparentData;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 13);
        }
        MidAdAdvanceInfo midAdAdvanceInfo = this.midAdAdvanceInfo;
        if (midAdAdvanceInfo != null) {
            jceOutputStream.write((JceStruct) midAdAdvanceInfo, 14);
        }
        InsideVideoSkipAdInfo insideVideoSkipAdInfo = this.skipAdInfo;
        if (insideVideoSkipAdInfo != null) {
            jceOutputStream.write((JceStruct) insideVideoSkipAdInfo, 15);
        }
        AdPrePlayTips adPrePlayTips = this.prePlayTips;
        if (adPrePlayTips != null) {
            jceOutputStream.write((JceStruct) adPrePlayTips, 16);
        }
        AdEpisodeVideoInfo adEpisodeVideoInfo = this.episodeVideoInfo;
        if (adEpisodeVideoInfo != null) {
            jceOutputStream.write((JceStruct) adEpisodeVideoInfo, 17);
        }
    }

    public AdInsideVideoResponse(int i3, String str, ArrayList<AdTempletItem> arrayList, String str2, Map<String, ArrayList<String>> map, AdGetVInfoItem adGetVInfoItem, Map<String, String> map2, int i16, AdInsideVideoExtraInfo adInsideVideoExtraInfo, AdInsideReplaceOutsideInfo adInsideReplaceOutsideInfo, AdResponseCommonInfo adResponseCommonInfo, long j3, boolean z16, Map<String, String> map3, MidAdAdvanceInfo midAdAdvanceInfo, InsideVideoSkipAdInfo insideVideoSkipAdInfo, AdPrePlayTips adPrePlayTips, AdEpisodeVideoInfo adEpisodeVideoInfo) {
        this.errCode = i3;
        this.errMsg = str;
        this.videoAdItemList = arrayList;
        this.adCookie = str2;
        this.filterMap = map;
        this.getVInfoItem = adGetVInfoItem;
        this.extraDp3ReportMap = map2;
        this.emptyAdReason = i16;
        this.extraInfo = adInsideVideoExtraInfo;
        this.replaceOutsideInfo = adInsideReplaceOutsideInfo;
        this.commonInfo = adResponseCommonInfo;
        this.nextRequestInterval = j3;
        this.stopRequestDynamicAd = z16;
        this.transparentData = map3;
        this.midAdAdvanceInfo = midAdAdvanceInfo;
        this.skipAdInfo = insideVideoSkipAdInfo;
        this.prePlayTips = adPrePlayTips;
        this.episodeVideoInfo = adEpisodeVideoInfo;
    }
}
