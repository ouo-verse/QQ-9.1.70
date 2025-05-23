package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqMakeFriendsCard extends JceStruct {
    static ReqHead cache_stHeader;
    public byte bReqType;
    public ReqHead stHeader;
    public int uFaceTimeStamp;

    public ReqMakeFriendsCard() {
        this.stHeader = null;
        this.bReqType = (byte) 0;
        this.uFaceTimeStamp = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.bReqType = jceInputStream.read(this.bReqType, 1, true);
        this.uFaceTimeStamp = jceInputStream.read(this.uFaceTimeStamp, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.bReqType, 1);
        jceOutputStream.write(this.uFaceTimeStamp, 2);
    }

    public ReqMakeFriendsCard(ReqHead reqHead, byte b16, int i3) {
        this.stHeader = reqHead;
        this.bReqType = b16;
        this.uFaceTimeStamp = i3;
    }
}
