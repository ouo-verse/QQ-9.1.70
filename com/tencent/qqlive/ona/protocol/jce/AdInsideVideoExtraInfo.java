package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideVideoExtraInfo extends JceStruct {
    static ArrayList<AdInsideOfflineIndexItem> cache_offlineIndexItemList = new ArrayList<>();
    public String adReportReason;
    public ArrayList<AdInsideOfflineIndexItem> offlineIndexItemList;

    static {
        cache_offlineIndexItemList.add(new AdInsideOfflineIndexItem());
    }

    public AdInsideVideoExtraInfo() {
        this.offlineIndexItemList = null;
        this.adReportReason = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.offlineIndexItemList = (ArrayList) jceInputStream.read((JceInputStream) cache_offlineIndexItemList, 0, false);
        this.adReportReason = jceInputStream.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AdInsideOfflineIndexItem> arrayList = this.offlineIndexItemList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.adReportReason;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public AdInsideVideoExtraInfo(ArrayList<AdInsideOfflineIndexItem> arrayList, String str) {
        this.offlineIndexItemList = arrayList;
        this.adReportReason = str;
    }
}
