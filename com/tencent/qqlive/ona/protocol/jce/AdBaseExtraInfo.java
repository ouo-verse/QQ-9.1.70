package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdBaseExtraInfo extends JceStruct {
    static AdExtraSystemInfo cache_adExtraSystemInfo;
    static ArrayList<String> cache_expIds;
    public AdExtraSystemInfo adExtraSystemInfo;
    public String deviceInitTime;
    public ArrayList<String> expIds;
    public String interestAdTags;
    public String mntId;
    public boolean shouldSkipCustomAdWithoutLogin;
    public boolean supportHapApp;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_expIds = arrayList;
        arrayList.add("");
        cache_adExtraSystemInfo = new AdExtraSystemInfo();
    }

    public AdBaseExtraInfo() {
        this.shouldSkipCustomAdWithoutLogin = false;
        this.expIds = null;
        this.supportHapApp = false;
        this.adExtraSystemInfo = null;
        this.interestAdTags = "";
        this.mntId = "";
        this.deviceInitTime = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shouldSkipCustomAdWithoutLogin = jceInputStream.read(this.shouldSkipCustomAdWithoutLogin, 0, false);
        this.expIds = (ArrayList) jceInputStream.read((JceInputStream) cache_expIds, 1, false);
        this.supportHapApp = jceInputStream.read(this.supportHapApp, 2, false);
        this.adExtraSystemInfo = (AdExtraSystemInfo) jceInputStream.read((JceStruct) cache_adExtraSystemInfo, 3, false);
        this.interestAdTags = jceInputStream.readString(4, false);
        this.mntId = jceInputStream.readString(5, false);
        this.deviceInitTime = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shouldSkipCustomAdWithoutLogin, 0);
        ArrayList<String> arrayList = this.expIds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.supportHapApp, 2);
        AdExtraSystemInfo adExtraSystemInfo = this.adExtraSystemInfo;
        if (adExtraSystemInfo != null) {
            jceOutputStream.write((JceStruct) adExtraSystemInfo, 3);
        }
        String str = this.interestAdTags;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        String str2 = this.mntId;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.deviceInitTime;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }

    public AdBaseExtraInfo(boolean z16, ArrayList<String> arrayList, boolean z17, AdExtraSystemInfo adExtraSystemInfo, String str, String str2, String str3) {
        this.shouldSkipCustomAdWithoutLogin = z16;
        this.expIds = arrayList;
        this.supportHapApp = z17;
        this.adExtraSystemInfo = adExtraSystemInfo;
        this.interestAdTags = str;
        this.mntId = str2;
        this.deviceInitTime = str3;
    }
}
