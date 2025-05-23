package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class QzmallProfileDecoGetRsp extends JceStruct {
    static byte[] cache_vecBuff;
    public byte[] vecBuff;

    static {
        cache_vecBuff = r0;
        byte[] bArr = {0};
    }

    public QzmallProfileDecoGetRsp() {
        this.vecBuff = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vecBuff = jceInputStream.read(cache_vecBuff, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vecBuff;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public QzmallProfileDecoGetRsp(byte[] bArr) {
        this.vecBuff = bArr;
    }
}
