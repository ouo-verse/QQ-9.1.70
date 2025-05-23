package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class CSRespPushStreamMsg extends JceStruct {
    static StreamInfo cache_stStreamInfo;
    public int iSeq;
    public long lKey;
    public short shResetSeq;
    public short shVersion;
    public StreamInfo stStreamInfo;

    public CSRespPushStreamMsg() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.stStreamInfo = null;
        this.shResetSeq = (short) 0;
        this.lKey = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        if (cache_stStreamInfo == null) {
            cache_stStreamInfo = new StreamInfo();
        }
        this.stStreamInfo = (StreamInfo) jceInputStream.read((JceStruct) cache_stStreamInfo, 2, true);
        this.shResetSeq = jceInputStream.read(this.shResetSeq, 3, true);
        this.lKey = jceInputStream.read(this.lKey, 4, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write((JceStruct) this.stStreamInfo, 2);
        jceOutputStream.write(this.shResetSeq, 3);
        jceOutputStream.write(this.lKey, 4);
    }

    public CSRespPushStreamMsg(short s16, int i3, StreamInfo streamInfo, short s17, long j3) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.stStreamInfo = streamInfo;
        this.shResetSeq = s17;
        this.lKey = j3;
    }
}
