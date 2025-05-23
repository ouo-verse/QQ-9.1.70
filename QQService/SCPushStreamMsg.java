package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SCPushStreamMsg extends JceStruct {
    static StreamData cache_stStreamData;
    static StreamInfo cache_stStreamInfo;
    public long bubbleID;
    public long diyAddonId;
    public int iSeq;
    public long lKey;
    public short shVersion;
    public StreamData stStreamData;
    public StreamInfo stStreamInfo;
    public long subBubbleId;
    public long uPcQQStatus;

    public SCPushStreamMsg() {
        this.shVersion = (short) 0;
        this.iSeq = 0;
        this.stStreamInfo = null;
        this.stStreamData = null;
        this.lKey = 0L;
        this.bubbleID = 0L;
        this.uPcQQStatus = 0L;
        this.subBubbleId = 0L;
        this.diyAddonId = 0L;
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
        this.lKey = jceInputStream.read(this.lKey, 4, true);
        this.bubbleID = jceInputStream.read(this.bubbleID, 5, false);
        this.uPcQQStatus = jceInputStream.read(this.uPcQQStatus, 6, false);
        this.subBubbleId = jceInputStream.read(this.subBubbleId, 7, false);
        this.diyAddonId = jceInputStream.read(this.diyAddonId, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shVersion, 0);
        jceOutputStream.write(this.iSeq, 1);
        jceOutputStream.write((JceStruct) this.stStreamInfo, 2);
        jceOutputStream.write((JceStruct) this.stStreamData, 3);
        jceOutputStream.write(this.lKey, 4);
        jceOutputStream.write(this.bubbleID, 5);
        jceOutputStream.write(this.uPcQQStatus, 6);
        jceOutputStream.write(this.subBubbleId, 7);
        jceOutputStream.write(this.diyAddonId, 8);
    }

    public SCPushStreamMsg(short s16, int i3, StreamInfo streamInfo, StreamData streamData, long j3, long j16, long j17, long j18, long j19) {
        this.shVersion = s16;
        this.iSeq = i3;
        this.stStreamInfo = streamInfo;
        this.stStreamData = streamData;
        this.lKey = j3;
        this.bubbleID = j16;
        this.uPcQQStatus = j17;
        this.subBubbleId = j18;
        this.diyAddonId = j19;
    }
}
