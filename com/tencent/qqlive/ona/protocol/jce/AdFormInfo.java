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
public final class AdFormInfo extends JceStruct {
    static ArrayList<AdFormInputFieldInfo> cache_inputFieldArray;
    static Map<String, String> cache_reportMap;
    public int bannerShowTime;
    public String buttonSubmittedTitle;
    public String buttonTitle;
    public int formType;
    public ArrayList<AdFormInputFieldInfo> inputFieldArray;
    public boolean isValid;
    public Map<String, String> reportMap;
    public String reportUrl;
    public String secretKey;
    public String title;

    static {
        HashMap hashMap = new HashMap();
        cache_reportMap = hashMap;
        hashMap.put("", "");
        cache_inputFieldArray = new ArrayList<>();
        cache_inputFieldArray.add(new AdFormInputFieldInfo());
    }

    public AdFormInfo() {
        this.isValid = false;
        this.formType = 0;
        this.title = "";
        this.reportUrl = "";
        this.reportMap = null;
        this.inputFieldArray = null;
        this.buttonTitle = "";
        this.buttonSubmittedTitle = "";
        this.secretKey = "";
        this.bannerShowTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isValid = jceInputStream.read(this.isValid, 0, false);
        this.formType = jceInputStream.read(this.formType, 1, false);
        this.title = jceInputStream.readString(2, false);
        this.reportUrl = jceInputStream.readString(3, false);
        this.reportMap = (Map) jceInputStream.read((JceInputStream) cache_reportMap, 4, false);
        this.inputFieldArray = (ArrayList) jceInputStream.read((JceInputStream) cache_inputFieldArray, 5, false);
        this.buttonTitle = jceInputStream.readString(6, false);
        this.buttonSubmittedTitle = jceInputStream.readString(7, false);
        this.secretKey = jceInputStream.readString(8, false);
        this.bannerShowTime = jceInputStream.read(this.bannerShowTime, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isValid, 0);
        jceOutputStream.write(this.formType, 1);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.reportUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        Map<String, String> map = this.reportMap;
        if (map != null) {
            jceOutputStream.write((Map) map, 4);
        }
        ArrayList<AdFormInputFieldInfo> arrayList = this.inputFieldArray;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        String str3 = this.buttonTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
        String str4 = this.buttonSubmittedTitle;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.secretKey;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.bannerShowTime, 9);
    }

    public AdFormInfo(boolean z16, int i3, String str, String str2, Map<String, String> map, ArrayList<AdFormInputFieldInfo> arrayList, String str3, String str4, String str5, int i16) {
        this.isValid = z16;
        this.formType = i3;
        this.title = str;
        this.reportUrl = str2;
        this.reportMap = map;
        this.inputFieldArray = arrayList;
        this.buttonTitle = str3;
        this.buttonSubmittedTitle = str4;
        this.secretKey = str5;
        this.bannerShowTime = i16;
    }
}
