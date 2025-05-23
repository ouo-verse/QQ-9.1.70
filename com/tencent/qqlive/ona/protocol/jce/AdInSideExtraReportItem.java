package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInSideExtraReportItem extends JceStruct {
    static Map<String, String> cache_operationReportMap;
    public String adid;
    public boolean needFunnelReport;
    public boolean needOperationReport;
    public boolean needRetryReport;
    public boolean needWisdomReport;
    public Map<String, String> operationReportMap;
    public String soid;

    static {
        HashMap hashMap = new HashMap();
        cache_operationReportMap = hashMap;
        hashMap.put("", "");
    }

    public AdInSideExtraReportItem() {
        this.soid = "";
        this.adid = "";
        this.needOperationReport = false;
        this.needWisdomReport = false;
        this.needRetryReport = false;
        this.operationReportMap = null;
        this.needFunnelReport = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.soid = jceInputStream.readString(0, false);
        this.adid = jceInputStream.readString(1, false);
        this.needOperationReport = jceInputStream.read(this.needOperationReport, 2, false);
        this.needWisdomReport = jceInputStream.read(this.needWisdomReport, 3, false);
        this.needRetryReport = jceInputStream.read(this.needRetryReport, 4, false);
        this.operationReportMap = (Map) jceInputStream.read((JceInputStream) cache_operationReportMap, 5, false);
        this.needFunnelReport = jceInputStream.read(this.needFunnelReport, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.soid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.adid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.needOperationReport, 2);
        jceOutputStream.write(this.needWisdomReport, 3);
        jceOutputStream.write(this.needRetryReport, 4);
        Map<String, String> map = this.operationReportMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.needFunnelReport, 6);
    }

    public AdInSideExtraReportItem(String str, String str2, boolean z16, boolean z17, boolean z18, Map<String, String> map, boolean z19) {
        this.soid = str;
        this.adid = str2;
        this.needOperationReport = z16;
        this.needWisdomReport = z17;
        this.needRetryReport = z18;
        this.operationReportMap = map;
        this.needFunnelReport = z19;
    }
}
