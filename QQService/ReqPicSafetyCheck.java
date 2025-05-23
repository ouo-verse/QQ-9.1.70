package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class ReqPicSafetyCheck extends JceStruct {
    static ReqHead cache_stHeader;
    public int iScene;
    public long lToUIN;
    public ReqHead stHeader;

    public ReqPicSafetyCheck() {
        this.stHeader = null;
        this.lToUIN = 0L;
        this.iScene = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lToUIN = jceInputStream.read(this.lToUIN, 1, true);
        this.iScene = jceInputStream.read(this.iScene, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lToUIN, 1);
        jceOutputStream.write(this.iScene, 2);
    }

    public ReqPicSafetyCheck(ReqHead reqHead, long j3, int i3) {
        this.stHeader = reqHead;
        this.lToUIN = j3;
        this.iScene = i3;
    }
}
