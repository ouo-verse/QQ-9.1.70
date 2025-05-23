package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Visitor extends JceStruct {
    static FaceInfo cache_stFace;
    static byte[] cache_vecNick;
    public int iFaceID;
    public long lUIN;
    public FaceInfo stFace;
    public String strNick;
    public byte[] vecNick;

    public Visitor() {
        this.lUIN = 0L;
        this.stFace = null;
        this.iFaceID = 0;
        this.strNick = "";
        this.vecNick = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUIN = jceInputStream.read(this.lUIN, 0, true);
        if (cache_stFace == null) {
            cache_stFace = new FaceInfo();
        }
        this.stFace = (FaceInfo) jceInputStream.read((JceStruct) cache_stFace, 1, true);
        this.iFaceID = jceInputStream.read(this.iFaceID, 2, false);
        this.strNick = jceInputStream.readString(3, false);
        if (cache_vecNick == null) {
            cache_vecNick = r0;
            byte[] bArr = {0};
        }
        this.vecNick = jceInputStream.read(cache_vecNick, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUIN, 0);
        jceOutputStream.write((JceStruct) this.stFace, 1);
        jceOutputStream.write(this.iFaceID, 2);
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        byte[] bArr = this.vecNick;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
    }

    public Visitor(long j3, FaceInfo faceInfo, int i3, String str, byte[] bArr) {
        this.lUIN = j3;
        this.stFace = faceInfo;
        this.iFaceID = i3;
        this.strNick = str;
        this.vecNick = bArr;
    }
}
