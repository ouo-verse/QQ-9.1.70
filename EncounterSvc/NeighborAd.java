package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NeighborAd extends JceStruct {
    public String ad_item;
    public int ad_postion;
    public int ad_source;

    public NeighborAd() {
        this.ad_item = "";
        this.ad_postion = 0;
        this.ad_source = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ad_item = jceInputStream.readString(0, true);
        this.ad_postion = jceInputStream.read(this.ad_postion, 1, true);
        this.ad_source = jceInputStream.read(this.ad_source, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ad_item, 0);
        jceOutputStream.write(this.ad_postion, 1);
        jceOutputStream.write(this.ad_source, 2);
    }

    public NeighborAd(String str, int i3, int i16) {
        this.ad_item = str;
        this.ad_postion = i3;
        this.ad_source = i16;
    }
}
