package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SignatureRes extends JceStruct {
    public long dwSeq;
    public String strLongNick;
    public long uin;

    public SignatureRes() {
        this.uin = 0L;
        this.dwSeq = 0L;
        this.strLongNick = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.dwSeq = jceInputStream.read(this.dwSeq, 1, true);
        this.strLongNick = jceInputStream.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.dwSeq, 1);
        jceOutputStream.write(this.strLongNick, 2);
    }

    public SignatureRes(long j3, long j16, String str) {
        this.uin = j3;
        this.dwSeq = j16;
        this.strLongNick = str;
    }
}
