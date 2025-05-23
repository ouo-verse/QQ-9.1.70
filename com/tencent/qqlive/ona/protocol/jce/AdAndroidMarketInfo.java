package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdAndroidMarketInfo extends JceStruct {
    static ArrayList<String> cache_marketPackageName;
    public boolean enableMarketDownload;
    public String marketDeepLink;
    public ArrayList<String> marketPackageName;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_marketPackageName = arrayList;
        arrayList.add("");
    }

    public AdAndroidMarketInfo() {
        this.enableMarketDownload = false;
        this.marketDeepLink = "";
        this.marketPackageName = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enableMarketDownload = jceInputStream.read(this.enableMarketDownload, 0, false);
        this.marketDeepLink = jceInputStream.readString(1, false);
        this.marketPackageName = (ArrayList) jceInputStream.read((JceInputStream) cache_marketPackageName, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enableMarketDownload, 0);
        String str = this.marketDeepLink;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<String> arrayList = this.marketPackageName;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public AdAndroidMarketInfo(boolean z16, String str, ArrayList<String> arrayList) {
        this.enableMarketDownload = z16;
        this.marketDeepLink = str;
        this.marketPackageName = arrayList;
    }
}
