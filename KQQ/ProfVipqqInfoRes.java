package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfVipqqInfoRes extends JceStruct {
    public short wLevel;

    public ProfVipqqInfoRes() {
        this.wLevel = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.wLevel = jceInputStream.read(this.wLevel, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wLevel, 1);
    }

    public ProfVipqqInfoRes(short s16) {
        this.wLevel = s16;
    }
}
