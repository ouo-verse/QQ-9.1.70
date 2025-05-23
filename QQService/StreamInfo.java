package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class StreamInfo extends JceStruct {
    static int cache_type;
    static byte[] cache_vPbData;
    public String fileKey;
    public int iMsgId;
    public int iSendTime;
    public long lFromUIN;
    public long lToUIN;
    public int msgSeq;
    public long msgTime;
    public long netType;
    public short oprType;
    public long pttFormat;
    public long pttTime;
    public byte pttTransFlag;
    public long random;
    public short shFlowLayer;
    public short shPackNum;
    public long subBubbleId;
    public int type;
    public byte[] vPbData;

    static {
        cache_vPbData = r0;
        byte[] bArr = {0};
    }

    public StreamInfo() {
        this.lFromUIN = 0L;
        this.lToUIN = 0L;
        this.iMsgId = 0;
        this.type = 0;
        this.iSendTime = 0;
        this.shPackNum = (short) 0;
        this.shFlowLayer = (short) 0;
        this.oprType = (short) 0;
        this.pttTransFlag = (byte) 0;
        this.fileKey = "";
        this.msgTime = 0L;
        this.msgSeq = 0;
        this.random = 0L;
        this.pttTime = 0L;
        this.pttFormat = 0L;
        this.netType = 255L;
        this.subBubbleId = 0L;
        this.vPbData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromUIN = jceInputStream.read(this.lFromUIN, 0, true);
        this.lToUIN = jceInputStream.read(this.lToUIN, 1, true);
        this.iMsgId = jceInputStream.read(this.iMsgId, 2, true);
        this.type = jceInputStream.read(this.type, 3, true);
        this.iSendTime = jceInputStream.read(this.iSendTime, 4, true);
        this.shPackNum = jceInputStream.read(this.shPackNum, 5, true);
        this.shFlowLayer = jceInputStream.read(this.shFlowLayer, 6, true);
        this.oprType = jceInputStream.read(this.oprType, 7, false);
        this.pttTransFlag = jceInputStream.read(this.pttTransFlag, 8, false);
        this.fileKey = jceInputStream.readString(9, false);
        this.msgTime = jceInputStream.read(this.msgTime, 10, false);
        this.msgSeq = jceInputStream.read(this.msgSeq, 11, false);
        this.random = jceInputStream.read(this.random, 12, false);
        this.pttTime = jceInputStream.read(this.pttTime, 13, false);
        this.pttFormat = jceInputStream.read(this.pttFormat, 14, false);
        this.netType = jceInputStream.read(this.netType, 15, false);
        this.subBubbleId = jceInputStream.read(this.subBubbleId, 16, false);
        this.vPbData = jceInputStream.read(cache_vPbData, 17, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromUIN, 0);
        jceOutputStream.write(this.lToUIN, 1);
        jceOutputStream.write(this.iMsgId, 2);
        jceOutputStream.write(this.type, 3);
        jceOutputStream.write(this.iSendTime, 4);
        jceOutputStream.write(this.shPackNum, 5);
        jceOutputStream.write(this.shFlowLayer, 6);
        jceOutputStream.write(this.oprType, 7);
        jceOutputStream.write(this.pttTransFlag, 8);
        String str = this.fileKey;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.msgTime, 10);
        jceOutputStream.write(this.msgSeq, 11);
        jceOutputStream.write(this.random, 12);
        jceOutputStream.write(this.pttTime, 13);
        jceOutputStream.write(this.pttFormat, 14);
        jceOutputStream.write(this.netType, 15);
        jceOutputStream.write(this.subBubbleId, 16);
        byte[] bArr = this.vPbData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 17);
        }
    }

    public StreamInfo(long j3, long j16, int i3, int i16, int i17, short s16, short s17, short s18, byte b16, String str, long j17, int i18, long j18, long j19, long j26, long j27, long j28, byte[] bArr) {
        this.lFromUIN = j3;
        this.lToUIN = j16;
        this.iMsgId = i3;
        this.type = i16;
        this.iSendTime = i17;
        this.shPackNum = s16;
        this.shFlowLayer = s17;
        this.oprType = s18;
        this.pttTransFlag = b16;
        this.fileKey = str;
        this.msgTime = j17;
        this.msgSeq = i18;
        this.random = j18;
        this.pttTime = j19;
        this.pttFormat = j26;
        this.netType = j27;
        this.subBubbleId = j28;
        this.vPbData = bArr;
    }
}
