package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class BatchRequest extends JceStruct {
    static byte[] cache_buffer;
    static int cache_type;
    public byte[] buffer;
    public int seq;
    public int type;

    public BatchRequest() {
        this.type = 0;
        this.seq = 0;
        this.buffer = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.seq = jceInputStream.read(this.seq, 1, false);
        if (cache_buffer == null) {
            cache_buffer = r0;
            byte[] bArr = {0};
        }
        this.buffer = jceInputStream.read(cache_buffer, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.seq, 1);
        byte[] bArr = this.buffer;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public BatchRequest(int i3, int i16, byte[] bArr) {
        this.type = i3;
        this.seq = i16;
        this.buffer = bArr;
    }
}
