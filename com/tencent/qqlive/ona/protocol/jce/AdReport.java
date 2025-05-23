package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdReport extends JceStruct {
    static ArrayList<String> cache_apiReportUrl;
    static ArrayList<String> cache_sdkReportUrl;
    public ArrayList<String> apiReportUrl;
    public String headerInfo;
    public String reportKey;
    public String reportParam;
    public int reportTime;
    public ArrayList<String> sdkReportUrl;
    public String url;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_apiReportUrl = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_sdkReportUrl = arrayList2;
        arrayList2.add("");
    }

    public AdReport() {
        this.reportKey = "";
        this.reportParam = "";
        this.url = "";
        this.apiReportUrl = null;
        this.sdkReportUrl = null;
        this.reportTime = 0;
        this.headerInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reportKey = jceInputStream.readString(0, false);
        this.reportParam = jceInputStream.readString(1, false);
        this.url = jceInputStream.readString(2, false);
        this.apiReportUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_apiReportUrl, 3, false);
        this.sdkReportUrl = (ArrayList) jceInputStream.read((JceInputStream) cache_sdkReportUrl, 4, false);
        this.reportTime = jceInputStream.read(this.reportTime, 5, false);
        this.headerInfo = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.reportKey;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.reportParam;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.url;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<String> arrayList = this.apiReportUrl;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<String> arrayList2 = this.sdkReportUrl;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        jceOutputStream.write(this.reportTime, 5);
        String str4 = this.headerInfo;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public AdReport(String str, String str2, String str3, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i3, String str4) {
        this.reportKey = str;
        this.reportParam = str2;
        this.url = str3;
        this.apiReportUrl = arrayList;
        this.sdkReportUrl = arrayList2;
        this.reportTime = i3;
        this.headerInfo = str4;
    }
}
