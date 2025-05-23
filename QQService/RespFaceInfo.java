package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespFaceInfo extends JceStruct {
    static RespHead cache_stHeader;
    static ArrayList<FaceInfo> cache_vFaceInfo;
    public int iFaceNum;
    public RespHead stHeader;
    public int uFaceTimeStamp;
    public ArrayList<FaceInfo> vFaceInfo;

    public RespFaceInfo() {
        this.stHeader = null;
        this.uFaceTimeStamp = 0;
        this.vFaceInfo = null;
        this.iFaceNum = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.uFaceTimeStamp = jceInputStream.read(this.uFaceTimeStamp, 1, true);
        if (cache_vFaceInfo == null) {
            cache_vFaceInfo = new ArrayList<>();
            cache_vFaceInfo.add(new FaceInfo());
        }
        this.vFaceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFaceInfo, 2, true);
        this.iFaceNum = jceInputStream.read(this.iFaceNum, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.uFaceTimeStamp, 1);
        jceOutputStream.write((Collection) this.vFaceInfo, 2);
        jceOutputStream.write(this.iFaceNum, 3);
    }

    public RespFaceInfo(RespHead respHead, int i3, ArrayList<FaceInfo> arrayList, int i16) {
        this.stHeader = respHead;
        this.uFaceTimeStamp = i3;
        this.vFaceInfo = arrayList;
        this.iFaceNum = i16;
    }
}
