package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StreamData extends JceStruct {
    static byte[] cache_vData;
    public short shPackSeq;
    public byte[] vData;

    public StreamData() {
        this.shPackSeq = (short) 0;
        this.vData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shPackSeq = jceInputStream.read(this.shPackSeq, 1, true);
        if (cache_vData == null) {
            cache_vData = r0;
            byte[] bArr = {0};
        }
        this.vData = jceInputStream.read(cache_vData, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shPackSeq, 1);
        jceOutputStream.write(this.vData, 2);
    }

    public StreamData(short s16, byte[] bArr) {
        this.shPackSeq = s16;
        this.vData = bArr;
    }
}
