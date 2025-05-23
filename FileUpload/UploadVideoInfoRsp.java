package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadVideoInfoRsp extends JceStruct {
    static byte[] cache_vBusiNessData;
    public int iBusiNessType;
    public String sVid;
    public byte[] vBusiNessData;

    static {
        cache_vBusiNessData = r0;
        byte[] bArr = {0};
    }

    public UploadVideoInfoRsp() {
        this.sVid = "";
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sVid = jceInputStream.readString(0, false);
        this.iBusiNessType = jceInputStream.read(this.iBusiNessType, 1, false);
        this.vBusiNessData = jceInputStream.read(cache_vBusiNessData, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sVid;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.iBusiNessType, 1);
        byte[] bArr = this.vBusiNessData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 2);
        }
    }

    public UploadVideoInfoRsp(String str, int i3, byte[] bArr) {
        this.sVid = str;
        this.iBusiNessType = i3;
        this.vBusiNessData = bArr;
    }
}
