package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SCRespUploadStreamMsg extends JceStruct {
    static StreamInfo cache_stStreamInfo;
    public int iSeq;
    public int result;
    public int shMsgSeq;
    public short shResetSeq;
    public short shVersion;
    public StreamInfo stStreamInfo;
    public long uDateTime;

    public SCRespUploadStreamMsg() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.stStreamInfo = null;
        this.shResetSeq = (short) 0;
        this.shMsgSeq = 0;
        this.uDateTime = 0L;
        this.result = 0;
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
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 4, false);
        this.uDateTime = jceInputStream.read(this.uDateTime, 5, false);
        this.result = jceInputStream.read(this.result, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write((JceStruct) this.stStreamInfo, 2);
        jceOutputStream.write(this.shResetSeq, 3);
        jceOutputStream.write(this.shMsgSeq, 4);
        jceOutputStream.write(this.uDateTime, 5);
        jceOutputStream.write(this.result, 6);
    }

    public SCRespUploadStreamMsg(short s16, int i3, StreamInfo streamInfo, short s17, int i16, long j3, int i17) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.stStreamInfo = streamInfo;
        this.shResetSeq = s17;
        this.shMsgSeq = i16;
        this.uDateTime = j3;
        this.result = i17;
    }
}
