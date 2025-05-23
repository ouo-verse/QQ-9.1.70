package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdOfflineInfo extends JceStruct {
    static int cache_offlineVideoType;
    static ArrayList<String> cache_vidList;
    public int offlineVideoType;
    public ArrayList<String> vidList;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vidList = arrayList;
        arrayList.add("");
    }

    public AdOfflineInfo() {
        this.offlineVideoType = 0;
        this.vidList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.offlineVideoType = jceInputStream.read(this.offlineVideoType, 0, false);
        this.vidList = (ArrayList) jceInputStream.read((JceInputStream) cache_vidList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.offlineVideoType, 0);
        ArrayList<String> arrayList = this.vidList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public AdOfflineInfo(int i3, ArrayList<String> arrayList) {
        this.offlineVideoType = i3;
        this.vidList = arrayList;
    }
}
