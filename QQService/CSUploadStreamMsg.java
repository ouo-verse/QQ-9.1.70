package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CSUploadStreamMsg extends JceStruct {
    static StreamData cache_stStreamData;
    static StreamInfo cache_stStreamInfo;
    public int iSeq;
    public int shMsgSeq;
    public short shVersion;
    public StreamData stStreamData;
    public StreamInfo stStreamInfo;

    public CSUploadStreamMsg() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.stStreamInfo = null;
        this.stStreamData = null;
        this.shMsgSeq = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shVersion = jceInputStream.read(this.shVersion, 0, true);
        this.iSeq = jceInputStream.read(this.iSeq, 1, true);
        if (cache_stStreamInfo == null) {
            cache_stStreamInfo = new StreamInfo();
        }
        this.stStreamInfo = (StreamInfo) jceInputStream.read((JceStruct) cache_stStreamInfo, 2, true);
        if (cache_stStreamData == null) {
            cache_stStreamData = new StreamData();
        }
        this.stStreamData = (StreamData) jceInputStream.read((JceStruct) cache_stStreamData, 3, true);
        this.shMsgSeq = jceInputStream.read(this.shMsgSeq, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write((JceStruct) this.stStreamInfo, 2);
        jceOutputStream.write((JceStruct) this.stStreamData, 3);
        jceOutputStream.write(this.shMsgSeq, 4);
    }

    public CSUploadStreamMsg(short s16, int i3, StreamInfo streamInfo, StreamData streamData, int i16) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.stStreamInfo = streamInfo;
        this.stStreamData = streamData;
        this.shMsgSeq = i16;
    }
}
