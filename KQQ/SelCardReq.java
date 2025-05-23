package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SelCardReq extends JceStruct {
    public long m_LastOthMsg;
    public long m_LastPic;

    public SelCardReq() {
        this.m_LastPic = 0L;
        this.m_LastOthMsg = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.m_LastPic = jceInputStream.read(this.m_LastPic, 0, true);
        this.m_LastOthMsg = jceInputStream.read(this.m_LastOthMsg, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.m_LastPic, 0);
        jceOutputStream.write(this.m_LastOthMsg, 1);
    }

    public SelCardReq(long j3, long j16) {
        this.m_LastPic = j3;
        this.m_LastOthMsg = j16;
    }
}
