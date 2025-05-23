package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideVideoVibrateInfo extends JceStruct {
    static ArrayList<AdVibratePointInfo> cache_vibrateInfos = new ArrayList<>();
    public ArrayList<AdVibratePointInfo> vibrateInfos;

    static {
        cache_vibrateInfos.add(new AdVibratePointInfo());
    }

    public AdInsideVideoVibrateInfo() {
        this.vibrateInfos = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vibrateInfos = (ArrayList) jceInputStream.read((JceInputStream) cache_vibrateInfos, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<AdVibratePointInfo> arrayList = this.vibrateInfos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public AdInsideVideoVibrateInfo(ArrayList<AdVibratePointInfo> arrayList) {
        this.vibrateInfos = arrayList;
    }
}
