package PUSH_COMM_STRUCT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class BinaryPushInfo extends JceStruct {
    static byte[] cache_pushBuffer;
    public long compressType;
    public byte[] pushBuffer;
    public long pushType;

    static {
        cache_pushBuffer = r0;
        byte[] bArr = {0};
    }

    public BinaryPushInfo() {
        this.pushType = 0L;
        this.compressType = 0L;
        this.pushBuffer = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.pushType = jceInputStream.read(this.pushType, 0, false);
        this.compressType = jceInputStream.read(this.compressType, 1, false);
        this.pushBuffer = jceInputStream.read(cache_pushBuffer, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.pushType, 0);
        jceOutputStream.write(this.compressType, 1);
        byte[] bArr = this.pushBuffer;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public BinaryPushInfo(long j3, long j16, byte[] bArr) {
        this.pushType = j3;
        this.compressType = j16;
        this.pushBuffer = bArr;
    }
}
