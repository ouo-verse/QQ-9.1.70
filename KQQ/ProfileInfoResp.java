package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfileInfoResp extends JceStruct {
    static byte[] cache_vecValue;
    public byte cOper;
    public byte cType;
    public long dwTimeStamp;
    public String strKey;
    public byte[] vecValue;

    public ProfileInfoResp() {
        this.cOper = (byte) 0;
        this.cType = (byte) 0;
        this.strKey = "";
        this.dwTimeStamp = 0L;
        this.vecValue = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cOper = jceInputStream.read(this.cOper, 0, true);
        this.cType = jceInputStream.read(this.cType, 1, true);
        this.strKey = jceInputStream.readString(2, true);
        this.dwTimeStamp = jceInputStream.read(this.dwTimeStamp, 3, true);
        if (cache_vecValue == null) {
            cache_vecValue = r0;
            byte[] bArr = {0};
        }
        this.vecValue = jceInputStream.read(cache_vecValue, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cOper, 0);
        jceOutputStream.write(this.cType, 1);
        jceOutputStream.write(this.strKey, 2);
        jceOutputStream.write(this.dwTimeStamp, 3);
        jceOutputStream.write(this.vecValue, 4);
    }

    public ProfileInfoResp(byte b16, byte b17, String str, long j3, byte[] bArr) {
        this.cOper = b16;
        this.cType = b17;
        this.strKey = str;
        this.dwTimeStamp = j3;
        this.vecValue = bArr;
    }
}
