package NS_COMM_UPLOAD_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CUploadUpstream extends JceStruct {
    static int cache_busiType;
    static byte[] cache_extra;
    static int cache_fileType;
    public int busiType;
    public byte[] extra;
    public int fileType;

    static {
        cache_extra = r0;
        byte[] bArr = {0};
    }

    public CUploadUpstream() {
        this.busiType = 0;
        this.fileType = 0;
        this.extra = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busiType = jceInputStream.read(this.busiType, 0, false);
        this.fileType = jceInputStream.read(this.fileType, 1, false);
        this.extra = jceInputStream.read(cache_extra, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.busiType, 0);
        jceOutputStream.write(this.fileType, 1);
        byte[] bArr = this.extra;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public CUploadUpstream(int i3, int i16, byte[] bArr) {
        this.busiType = i3;
        this.fileType = i16;
        this.extra = bArr;
    }
}
