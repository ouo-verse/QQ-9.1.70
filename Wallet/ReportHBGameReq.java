package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReportHBGameReq extends JceStruct implements Cloneable {
    public String sHBId = "";
    public long lUin = 0;
    public String sPoint = "";
    public int iAmount = 0;
    public boolean bSucc = false;
    public boolean bStart = false;
    public int iGameId = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sHBId = jceInputStream.readString(0, false);
        this.lUin = jceInputStream.read(this.lUin, 1, false);
        this.sPoint = jceInputStream.readString(2, false);
        this.iAmount = jceInputStream.read(this.iAmount, 3, false);
        this.bSucc = jceInputStream.read(this.bSucc, 4, false);
        this.bStart = jceInputStream.read(this.bStart, 5, false);
        this.iGameId = jceInputStream.read(this.iGameId, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sHBId, 0);
        jceOutputStream.write(this.lUin, 1);
        jceOutputStream.write(this.sPoint, 2);
        jceOutputStream.write(this.iAmount, 3);
        jceOutputStream.write(this.bSucc, 4);
        jceOutputStream.write(this.bStart, 5);
        jceOutputStream.write(this.iGameId, 6);
    }
}
