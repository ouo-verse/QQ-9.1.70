package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqCommonCard extends JceStruct {
    static ReqHead cache_stHeader;
    public ReqHead stHeader;
    public int uFaceTimeStamp;

    public ReqCommonCard() {
        this.stHeader = null;
        this.uFaceTimeStamp = -1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.uFaceTimeStamp = jceInputStream.read(this.uFaceTimeStamp, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.uFaceTimeStamp, 1);
    }

    public ReqCommonCard(ReqHead reqHead, int i3) {
        this.stHeader = reqHead;
        this.uFaceTimeStamp = i3;
    }
}
