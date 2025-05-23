package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespDelFace extends JceStruct {
    static RespHead cache_stHeader;
    public int iFaceNum;
    public RespHead stHeader;
    public int uFaceTimeStamp;

    public RespDelFace() {
        this.stHeader = null;
        this.uFaceTimeStamp = 0;
        this.iFaceNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.uFaceTimeStamp = jceInputStream.read(this.uFaceTimeStamp, 1, true);
        this.iFaceNum = jceInputStream.read(this.iFaceNum, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.uFaceTimeStamp, 1);
        jceOutputStream.write(this.iFaceNum, 2);
    }

    public RespDelFace(RespHead respHead, int i3, int i16) {
        this.stHeader = respHead;
        this.uFaceTimeStamp = i3;
        this.iFaceNum = i16;
    }
}
