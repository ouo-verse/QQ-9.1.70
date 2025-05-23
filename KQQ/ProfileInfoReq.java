package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ProfileInfoReq extends JceStruct {
    static byte[] cache_vecValue;
    public byte cType;
    public long dwTimeStamp;
    public String strKey;
    public byte[] vecValue;

    public ProfileInfoReq() {
        this.cType = (byte) 0;
        this.strKey = "";
        this.dwTimeStamp = 0L;
        this.vecValue = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cType = jceInputStream.read(this.cType, 0, true);
        this.strKey = jceInputStream.readString(1, true);
        this.dwTimeStamp = jceInputStream.read(this.dwTimeStamp, 2, true);
        if (cache_vecValue == null) {
            cache_vecValue = r0;
            byte[] bArr = {0};
        }
        this.vecValue = jceInputStream.read(cache_vecValue, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cType, 0);
        jceOutputStream.write(this.strKey, 1);
        jceOutputStream.write(this.dwTimeStamp, 2);
        jceOutputStream.write(this.vecValue, 3);
    }

    public ProfileInfoReq(byte b16, String str, long j3, byte[] bArr) {
        this.cType = b16;
        this.strKey = str;
        this.dwTimeStamp = j3;
        this.vecValue = bArr;
    }
}
