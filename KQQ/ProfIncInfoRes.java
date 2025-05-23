package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfIncInfoRes extends JceStruct {
    public int uOnlineTime;
    public int uRemainTime;
    public short wLevel;

    public ProfIncInfoRes() {
        this.wLevel = (short) 0;
        this.uOnlineTime = 0;
        this.uRemainTime = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wLevel = jceInputStream.read(this.wLevel, 1, true);
        this.uOnlineTime = jceInputStream.read(this.uOnlineTime, 2, true);
        this.uRemainTime = jceInputStream.read(this.uRemainTime, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wLevel, 1);
        jceOutputStream.write(this.uOnlineTime, 2);
        jceOutputStream.write(this.uRemainTime, 3);
    }

    public ProfIncInfoRes(short s16, int i3, int i16) {
        this.wLevel = s16;
        this.uOnlineTime = i3;
        this.uRemainTime = i16;
    }
}
