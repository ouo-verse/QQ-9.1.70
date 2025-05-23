package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GrpMsg extends JceStruct {
    static byte[] cache_strMsg;
    public long GrpMsgID;
    public int iMsgTime;
    public long lFromMID;
    public long lGrpId;
    public short shMsgType;
    public byte[] strMsg;

    public GrpMsg() {
        this.shMsgType = (short) 0;
        this.GrpMsgID = 0L;
        this.lFromMID = 0L;
        this.lGrpId = 0L;
        this.iMsgTime = 0;
        this.strMsg = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shMsgType = jceInputStream.read(this.shMsgType, 0, true);
        this.GrpMsgID = jceInputStream.read(this.GrpMsgID, 1, true);
        this.lFromMID = jceInputStream.read(this.lFromMID, 2, true);
        this.lGrpId = jceInputStream.read(this.lGrpId, 3, true);
        this.iMsgTime = jceInputStream.read(this.iMsgTime, 4, true);
        if (cache_strMsg == null) {
            cache_strMsg = r0;
            byte[] bArr = {0};
        }
        this.strMsg = jceInputStream.read(cache_strMsg, 5, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shMsgType, 0);
        jceOutputStream.write(this.GrpMsgID, 1);
        jceOutputStream.write(this.lFromMID, 2);
        jceOutputStream.write(this.lGrpId, 3);
        jceOutputStream.write(this.iMsgTime, 4);
        jceOutputStream.write(this.strMsg, 5);
    }

    public GrpMsg(short s16, long j3, long j16, long j17, int i3, byte[] bArr) {
        this.shMsgType = s16;
        this.GrpMsgID = j3;
        this.lFromMID = j16;
        this.lGrpId = j17;
        this.iMsgTime = i3;
        this.strMsg = bArr;
    }
}
