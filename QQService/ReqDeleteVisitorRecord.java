package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqDeleteVisitorRecord extends JceStruct {
    public int cRecordType;
    public long lTargetUin;
    public ReqHead stHeader;
    static ReqHead cache_stHeader = new ReqHead();
    static int cache_cRecordType = 0;

    public ReqDeleteVisitorRecord() {
        this.stHeader = null;
        this.lTargetUin = 0L;
        this.cRecordType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.lTargetUin = jceInputStream.read(this.lTargetUin, 1, false);
        this.cRecordType = jceInputStream.read(this.cRecordType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.lTargetUin, 1);
        jceOutputStream.write(this.cRecordType, 2);
    }

    public ReqDeleteVisitorRecord(ReqHead reqHead, long j3, int i3) {
        this.stHeader = reqHead;
        this.lTargetUin = j3;
        this.cRecordType = i3;
    }
}
