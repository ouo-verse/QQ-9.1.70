package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BlackSimpleInfo extends JceStruct {
    public byte cAge;
    public byte cSex;
    public long lBlackID;
    public String strNick;
    public short wFace;

    public BlackSimpleInfo() {
        this.lBlackID = 0L;
        this.wFace = (short) 0;
        this.cSex = (byte) 0;
        this.cAge = (byte) 0;
        this.strNick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lBlackID = jceInputStream.read(this.lBlackID, 0, true);
        this.wFace = jceInputStream.read(this.wFace, 1, true);
        this.cSex = jceInputStream.read(this.cSex, 2, true);
        this.cAge = jceInputStream.read(this.cAge, 3, true);
        this.strNick = jceInputStream.readString(4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lBlackID, 0);
        jceOutputStream.write(this.wFace, 1);
        jceOutputStream.write(this.cSex, 2);
        jceOutputStream.write(this.cAge, 3);
        jceOutputStream.write(this.strNick, 4);
    }

    public BlackSimpleInfo(long j3, short s16, byte b16, byte b17, String str) {
        this.lBlackID = j3;
        this.wFace = s16;
        this.cSex = b16;
        this.cAge = b17;
        this.strNick = str;
    }
}
