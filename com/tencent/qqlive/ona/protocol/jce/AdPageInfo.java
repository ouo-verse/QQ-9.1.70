package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes22.dex */
public final class AdPageInfo extends JceStruct {
    static int cache_adPlayMode;
    static Map<String, String> cache_extraInfo;
    static AdInsideTraceInfo cache_traceInfo;
    public int adPlayMode;
    public String channelId;
    public Map<String, String> extraInfo;
    public String flowId;
    public String page;
    public String reportKey;
    public String reportParams;
    public int style;
    public AdInsideTraceInfo traceInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_extraInfo = hashMap;
        hashMap.put("", "");
        cache_traceInfo = new AdInsideTraceInfo();
    }

    public AdPageInfo() {
        this.adPlayMode = 0;
        this.style = 0;
        this.page = "";
        this.channelId = "";
        this.reportKey = "";
        this.reportParams = "";
        this.flowId = "";
        this.extraInfo = null;
        this.traceInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adPlayMode = jceInputStream.read(this.adPlayMode, 0, false);
        this.style = jceInputStream.read(this.style, 1, false);
        this.page = jceInputStream.readString(2, false);
        this.channelId = jceInputStream.readString(3, false);
        this.reportKey = jceInputStream.readString(4, false);
        this.reportParams = jceInputStream.readString(5, false);
        this.flowId = jceInputStream.readString(6, false);
        this.extraInfo = (Map) jceInputStream.read((JceInputStream) cache_extraInfo, 7, false);
        this.traceInfo = (AdInsideTraceInfo) jceInputStream.read((JceStruct) cache_traceInfo, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.adPlayMode, 0);
        jceOutputStream.write(this.style, 1);
        String str = this.page;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.channelId;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.reportKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.reportParams;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        String str5 = this.flowId;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        Map<String, String> map = this.extraInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 7);
        }
        AdInsideTraceInfo adInsideTraceInfo = this.traceInfo;
        if (adInsideTraceInfo != null) {
            jceOutputStream.write((JceStruct) adInsideTraceInfo, 8);
        }
    }

    public AdPageInfo(int i3, int i16, String str, String str2, String str3, String str4, String str5, Map<String, String> map, AdInsideTraceInfo adInsideTraceInfo) {
        this.adPlayMode = i3;
        this.style = i16;
        this.page = str;
        this.channelId = str2;
        this.reportKey = str3;
        this.reportParams = str4;
        this.flowId = str5;
        this.extraInfo = map;
        this.traceInfo = adInsideTraceInfo;
    }
}
