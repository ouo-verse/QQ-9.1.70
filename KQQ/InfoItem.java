package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class InfoItem extends JceStruct {
    static byte[] cache_vecValue;
    public byte cOperType;
    public byte cResult;
    public long qwServiceId;
    public long qwTimeStamp;
    public byte[] vecValue;

    public InfoItem() {
        this.cOperType = (byte) 0;
        this.qwServiceId = 0L;
        this.qwTimeStamp = 0L;
        this.vecValue = null;
        this.cResult = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cOperType = jceInputStream.read(this.cOperType, 0, true);
        this.qwServiceId = jceInputStream.read(this.qwServiceId, 1, true);
        this.qwTimeStamp = jceInputStream.read(this.qwTimeStamp, 2, true);
        if (cache_vecValue == null) {
            cache_vecValue = r0;
            byte[] bArr = {0};
        }
        this.vecValue = jceInputStream.read(cache_vecValue, 3, false);
        this.cResult = jceInputStream.read(this.cResult, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cOperType, 0);
        jceOutputStream.write(this.qwServiceId, 1);
        jceOutputStream.write(this.qwTimeStamp, 2);
        byte[] bArr = this.vecValue;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.cResult, 4);
    }

    public InfoItem(byte b16, long j3, long j16, byte[] bArr, byte b17) {
        this.cOperType = b16;
        this.qwServiceId = j3;
        this.qwTimeStamp = j16;
        this.vecValue = bArr;
        this.cResult = b17;
    }
}
