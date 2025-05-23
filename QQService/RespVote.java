package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespVote extends JceStruct {
    static RespHead cache_stHeader;
    public long lMID;
    public RespHead stHeader;

    public RespVote() {
        this.stHeader = null;
        this.lMID = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lMID = jceInputStream.read(this.lMID, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lMID, 1);
    }

    public RespVote(RespHead respHead, long j3) {
        this.stHeader = respHead;
        this.lMID = j3;
    }
}
