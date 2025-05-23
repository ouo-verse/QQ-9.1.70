package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdSdkRequestInfo extends JceStruct {
    static AdSceneDesc cache_adSceneDesc;
    static ArrayList<String> cache_deduplicationOids;
    public AdSceneDesc adSceneDesc;
    public String appversion;
    public ArrayList<String> deduplicationOids;
    public String requestCookie;
    public String requestid;
    public String sdkversion;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_deduplicationOids = arrayList;
        arrayList.add("");
        cache_adSceneDesc = new AdSceneDesc();
    }

    public AdSdkRequestInfo() {
        this.sdkversion = "";
        this.requestid = "";
        this.appversion = "";
        this.deduplicationOids = null;
        this.requestCookie = "";
        this.adSceneDesc = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sdkversion = jceInputStream.readString(0, false);
        this.requestid = jceInputStream.readString(1, false);
        this.appversion = jceInputStream.readString(2, false);
        this.deduplicationOids = (ArrayList) jceInputStream.read((JceInputStream) cache_deduplicationOids, 3, false);
        this.requestCookie = jceInputStream.readString(4, false);
        this.adSceneDesc = (AdSceneDesc) jceInputStream.read((JceStruct) cache_adSceneDesc, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sdkversion;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.requestid;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.appversion;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<String> arrayList = this.deduplicationOids;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        String str4 = this.requestCookie;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        AdSceneDesc adSceneDesc = this.adSceneDesc;
        if (adSceneDesc != null) {
            jceOutputStream.write((JceStruct) adSceneDesc, 5);
        }
    }

    public AdSdkRequestInfo(String str, String str2, String str3, ArrayList<String> arrayList, String str4, AdSceneDesc adSceneDesc) {
        this.sdkversion = str;
        this.requestid = str2;
        this.appversion = str3;
        this.deduplicationOids = arrayList;
        this.requestCookie = str4;
        this.adSceneDesc = adSceneDesc;
    }
}
