package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideContextInfo extends JceStruct {
    static ArrayList<Integer> cache_showedAdList = new ArrayList<>();
    public int index;
    public ArrayList<Integer> showedAdList;
    public String vid;

    static {
        cache_showedAdList.add(0);
    }

    public AdInsideContextInfo() {
        this.vid = "";
        this.index = 0;
        this.showedAdList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vid = jceInputStream.readString(0, false);
        this.index = jceInputStream.read(this.index, 1, false);
        this.showedAdList = (ArrayList) jceInputStream.read((JceInputStream) cache_showedAdList, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.vid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.index, 1);
        ArrayList<Integer> arrayList = this.showedAdList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public AdInsideContextInfo(String str, int i3, ArrayList<Integer> arrayList) {
        this.vid = str;
        this.index = i3;
        this.showedAdList = arrayList;
    }
}
