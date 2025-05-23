package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class MovGroupMemResp extends JceStruct {
    public String ErrorString;
    public byte reqtype;
    public byte result;
    public long uin;

    public MovGroupMemResp() {
        this.uin = 0L;
        this.reqtype = (byte) 0;
        this.result = (byte) 0;
        this.ErrorString = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.reqtype = jceInputStream.read(this.reqtype, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
        this.ErrorString = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.reqtype, 1);
        jceOutputStream.write(this.result, 2);
        jceOutputStream.write(this.ErrorString, 3);
    }

    public MovGroupMemResp(long j3, byte b16, byte b17, String str) {
        this.uin = j3;
        this.reqtype = b16;
        this.result = b17;
        this.ErrorString = str;
    }
}
