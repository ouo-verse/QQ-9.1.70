package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqUpdateQQFace extends JceStruct {
    static FaceInfo cache_stFaceInfo;
    static ReqHead cache_stHeader;
    public int bPicType;
    public FaceInfo stFaceInfo;
    public ReqHead stHeader;

    public ReqUpdateQQFace() {
        this.stHeader = null;
        this.stFaceInfo = null;
        this.bPicType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stFaceInfo == null) {
            cache_stFaceInfo = new FaceInfo();
        }
        this.stFaceInfo = (FaceInfo) jceInputStream.read((JceStruct) cache_stFaceInfo, 1, true);
        this.bPicType = jceInputStream.read(this.bPicType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stFaceInfo, 1);
        jceOutputStream.write(this.bPicType, 2);
    }

    public ReqUpdateQQFace(ReqHead reqHead, FaceInfo faceInfo, int i3) {
        this.stHeader = reqHead;
        this.stFaceInfo = faceInfo;
        this.bPicType = i3;
    }
}
