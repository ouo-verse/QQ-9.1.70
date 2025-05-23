package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FaceInfo extends JceStruct {
    static byte[] cache_vFaceID;
    public int uAddTimeStamp;
    public byte[] vFaceID;

    public FaceInfo() {
        this.vFaceID = null;
        this.uAddTimeStamp = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vFaceID == null) {
            cache_vFaceID = r0;
            byte[] bArr = {0};
        }
        this.vFaceID = jceInputStream.read(cache_vFaceID, 0, true);
        this.uAddTimeStamp = jceInputStream.read(this.uAddTimeStamp, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vFaceID, 0);
        jceOutputStream.write(this.uAddTimeStamp, 1);
    }

    public FaceInfo(byte[] bArr, int i3) {
        this.vFaceID = bArr;
        this.uAddTimeStamp = i3;
    }
}
