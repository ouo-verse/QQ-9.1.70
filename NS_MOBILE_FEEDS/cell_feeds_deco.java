package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_feeds_deco extends JceStruct {
    static byte[] cache_decoration;
    public byte[] decoration;

    static {
        cache_decoration = r0;
        byte[] bArr = {0};
    }

    public cell_feeds_deco() {
        this.decoration = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.decoration = jceInputStream.read(cache_decoration, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.decoration;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public cell_feeds_deco(byte[] bArr) {
        this.decoration = bArr;
    }
}
