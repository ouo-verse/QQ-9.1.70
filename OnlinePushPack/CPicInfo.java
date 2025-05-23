package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CPicInfo extends JceStruct {
    static byte[] cache_vHost;
    static byte[] cache_vPath;
    public byte[] vHost;
    public byte[] vPath;

    public CPicInfo() {
        this.vPath = null;
        this.vHost = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vPath == null) {
            cache_vPath = r0;
            byte[] bArr = {0};
        }
        this.vPath = jceInputStream.read(cache_vPath, 0, true);
        if (cache_vHost == null) {
            cache_vHost = r0;
            byte[] bArr2 = {0};
        }
        this.vHost = jceInputStream.read(cache_vHost, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vPath, 0);
        byte[] bArr = this.vHost;
        if (bArr != null) {
            jceOutputStream.write(bArr, 1);
        }
    }

    public CPicInfo(byte[] bArr, byte[] bArr2) {
        this.vPath = bArr;
        this.vHost = bArr2;
    }
}
