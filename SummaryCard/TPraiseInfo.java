package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class TPraiseInfo extends JceStruct {
    public int iIsPayed;
    public long uCustomId;

    public TPraiseInfo() {
        this.uCustomId = 0L;
        this.iIsPayed = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uCustomId = jceInputStream.read(this.uCustomId, 0, false);
        this.iIsPayed = jceInputStream.read(this.iIsPayed, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uCustomId, 0);
        jceOutputStream.write(this.iIsPayed, 1);
    }

    public TPraiseInfo(long j3, int i3) {
        this.uCustomId = j3;
        this.iIsPayed = i3;
    }
}
