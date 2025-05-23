package NS_MOBILE_NEWEST_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzoneData extends JceStruct {
    static byte[] cache_vcByte;
    public int iType;
    public byte[] vcByte;

    static {
        cache_vcByte = r0;
        byte[] bArr = {0};
    }

    public QzoneData() {
        this.iType = 0;
        this.vcByte = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iType = jceInputStream.read(this.iType, 0, false);
        this.vcByte = jceInputStream.read(cache_vcByte, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iType, 0);
        byte[] bArr = this.vcByte;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public QzoneData(int i3, byte[] bArr) {
        this.iType = i3;
        this.vcByte = bArr;
    }
}
