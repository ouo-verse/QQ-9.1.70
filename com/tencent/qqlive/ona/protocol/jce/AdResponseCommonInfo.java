package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdResponseCommonInfo extends JceStruct {
    static ArrayList<AdAppInstallInfo> cache_installInfoList = new ArrayList<>();
    public ArrayList<AdAppInstallInfo> installInfoList;
    public String ipServerUrl;

    static {
        cache_installInfoList.add(new AdAppInstallInfo());
    }

    public AdResponseCommonInfo() {
        this.ipServerUrl = "";
        this.installInfoList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ipServerUrl = jceInputStream.readString(0, false);
        this.installInfoList = (ArrayList) jceInputStream.read((JceInputStream) cache_installInfoList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.ipServerUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<AdAppInstallInfo> arrayList = this.installInfoList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public AdResponseCommonInfo(String str, ArrayList<AdAppInstallInfo> arrayList) {
        this.ipServerUrl = str;
        this.installInfoList = arrayList;
    }
}
