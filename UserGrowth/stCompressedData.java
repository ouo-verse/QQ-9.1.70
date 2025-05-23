package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stCompressedData extends JceStruct {
    static byte[] cache_compressed;
    public byte[] compressed;

    static {
        cache_compressed = r0;
        byte[] bArr = {0};
    }

    public stCompressedData() {
        this.compressed = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.compressed = jceInputStream.read(cache_compressed, 100, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.compressed;
        if (bArr != null) {
            jceOutputStream.write(bArr, 100);
        }
    }

    public stCompressedData(byte[] bArr) {
        this.compressed = bArr;
    }
}
