package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class SetGroupResp extends JceStruct {
    static byte[] cache_vecBody;
    public String ErrorString;
    public byte reqtype;
    public byte result;
    public byte[] vecBody;

    public SetGroupResp() {
        this.reqtype = (byte) 0;
        this.result = (byte) 0;
        this.vecBody = null;
        this.ErrorString = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reqtype = jceInputStream.read(this.reqtype, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        if (cache_vecBody == null) {
            cache_vecBody = r0;
            byte[] bArr = {0};
        }
        this.vecBody = jceInputStream.read(cache_vecBody, 2, true);
        this.ErrorString = jceInputStream.readString(3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reqtype, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write(this.vecBody, 2);
        jceOutputStream.write(this.ErrorString, 3);
    }

    public SetGroupResp(byte b16, byte b17, byte[] bArr, String str) {
        this.reqtype = b16;
        this.result = b17;
        this.vecBody = bArr;
        this.ErrorString = str;
    }
}
