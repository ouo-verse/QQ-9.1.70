package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes22.dex */
public final class AdcPoster extends JceStruct {
    static ArrayList<AdMarkLableInfo> cache_markLabelList = new ArrayList<>();
    public long duration;
    public String imageUrl;
    public ArrayList<AdMarkLableInfo> markLabelList;

    static {
        cache_markLabelList.add(new AdMarkLableInfo());
    }

    public AdcPoster() {
        this.imageUrl = "";
        this.markLabelList = null;
        this.duration = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.imageUrl = jceInputStream.readString(0, false);
        this.markLabelList = (ArrayList) jceInputStream.read((JceInputStream) cache_markLabelList, 1, false);
        this.duration = jceInputStream.read(this.duration, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.imageUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        ArrayList<AdMarkLableInfo> arrayList = this.markLabelList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.duration, 2);
    }

    public AdcPoster(String str, ArrayList<AdMarkLableInfo> arrayList, long j3) {
        this.imageUrl = str;
        this.markLabelList = arrayList;
        this.duration = j3;
    }
}
