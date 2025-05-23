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
public final class AdInsideVideoRequestExtraInfo extends JceStruct {
    static Map<String, String> cache_extraVrReportMap;
    static ArrayList<AdInsideContextInfo> cache_refreshRelatedAdList = new ArrayList<>();
    static Map<String, String> cache_transparentData;
    public String anchorRequestId;
    public int currentIndex;
    public int dynamicMidAdRequestNum;
    public Map<String, String> extraVrReportMap;
    public boolean hasPRInfo;
    public boolean isMidAdAdvanceRequest;
    public String pageParamsJson;
    public ArrayList<AdInsideContextInfo> refreshRelatedAdList;
    public Map<String, String> transparentData;

    static {
        cache_refreshRelatedAdList.add(new AdInsideContextInfo());
        HashMap hashMap = new HashMap();
        cache_transparentData = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_extraVrReportMap = hashMap2;
        hashMap2.put("", "");
    }

    public AdInsideVideoRequestExtraInfo() {
        this.hasPRInfo = true;
        this.refreshRelatedAdList = null;
        this.currentIndex = 0;
        this.dynamicMidAdRequestNum = 0;
        this.anchorRequestId = "";
        this.transparentData = null;
        this.pageParamsJson = "";
        this.isMidAdAdvanceRequest = false;
        this.extraVrReportMap = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasPRInfo = jceInputStream.read(this.hasPRInfo, 0, false);
        this.refreshRelatedAdList = (ArrayList) jceInputStream.read((JceInputStream) cache_refreshRelatedAdList, 1, false);
        this.currentIndex = jceInputStream.read(this.currentIndex, 2, false);
        this.dynamicMidAdRequestNum = jceInputStream.read(this.dynamicMidAdRequestNum, 3, false);
        this.anchorRequestId = jceInputStream.readString(4, false);
        this.transparentData = (Map) jceInputStream.read((JceInputStream) cache_transparentData, 5, false);
        this.pageParamsJson = jceInputStream.readString(6, false);
        this.isMidAdAdvanceRequest = jceInputStream.read(this.isMidAdAdvanceRequest, 7, false);
        this.extraVrReportMap = (Map) jceInputStream.read((JceInputStream) cache_extraVrReportMap, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasPRInfo, 0);
        ArrayList<AdInsideContextInfo> arrayList = this.refreshRelatedAdList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.currentIndex, 2);
        jceOutputStream.write(this.dynamicMidAdRequestNum, 3);
        String str = this.anchorRequestId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        Map<String, String> map = this.transparentData;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        String str2 = this.pageParamsJson;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.isMidAdAdvanceRequest, 7);
        Map<String, String> map2 = this.extraVrReportMap;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
    }

    public AdInsideVideoRequestExtraInfo(boolean z16, ArrayList<AdInsideContextInfo> arrayList, int i3, int i16, String str, Map<String, String> map, String str2, boolean z17, Map<String, String> map2) {
        this.hasPRInfo = z16;
        this.refreshRelatedAdList = arrayList;
        this.currentIndex = i3;
        this.dynamicMidAdRequestNum = i16;
        this.anchorRequestId = str;
        this.transparentData = map;
        this.pageParamsJson = str2;
        this.isMidAdAdvanceRequest = z17;
        this.extraVrReportMap = map2;
    }
}
