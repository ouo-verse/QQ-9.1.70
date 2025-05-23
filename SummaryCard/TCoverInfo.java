package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TCoverInfo extends JceStruct {
    static byte[] cache_vTagInfo;
    public byte[] vTagInfo;

    static {
        cache_vTagInfo = r0;
        byte[] bArr = {0};
    }

    public TCoverInfo() {
        this.vTagInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vTagInfo = jceInputStream.read(cache_vTagInfo, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.vTagInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
    }

    public TCoverInfo(byte[] bArr) {
        this.vTagInfo = bArr;
    }
}
