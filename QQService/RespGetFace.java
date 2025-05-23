package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetFace extends JceStruct {
    static RespHead cache_stHeader;
    static UserCntlData cache_stUserData;
    static ArrayList<FaceInfo> cache_vFaceInfo;
    public RespHead stHeader;
    public UserCntlData stUserData;
    public ArrayList<FaceInfo> vFaceInfo;

    public RespGetFace() {
        this.stHeader = null;
        this.stUserData = null;
        this.vFaceInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stUserData == null) {
            cache_stUserData = new UserCntlData();
        }
        this.stUserData = (UserCntlData) jceInputStream.read((JceStruct) cache_stUserData, 1, true);
        if (cache_vFaceInfo == null) {
            cache_vFaceInfo = new ArrayList<>();
            cache_vFaceInfo.add(new FaceInfo());
        }
        this.vFaceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFaceInfo, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stUserData, 1);
        jceOutputStream.write((Collection) this.vFaceInfo, 2);
    }

    public RespGetFace(RespHead respHead, UserCntlData userCntlData, ArrayList<FaceInfo> arrayList) {
        this.stHeader = respHead;
        this.stUserData = userCntlData;
        this.vFaceInfo = arrayList;
    }
}
