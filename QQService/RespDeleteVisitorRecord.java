package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespDeleteVisitorRecord extends JceStruct {
    static RespHead cache_stHeader = new RespHead();
    public RespHead stHeader;

    public RespDeleteVisitorRecord() {
        this.stHeader = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
    }

    public RespDeleteVisitorRecord(RespHead respHead) {
        this.stHeader = respHead;
    }
}
