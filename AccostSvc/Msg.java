package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Msg extends JceStruct {
    static int cache_eAccostType;
    static byte[] cache_strMsg;
    public int eAccostType;
    public int iMsgTime;
    public long iPluginID;
    public long lFromMID;
    public long lToMID;
    public short shMsgType;
    public byte[] strMsg;
    public long uMsgID;
    public long uRandID;

    public Msg() {
        this.shMsgType = (short) 0;
        this.uMsgID = 0L;
        this.lFromMID = 0L;
        this.lToMID = 0L;
        this.iMsgTime = 0;
        this.eAccostType = 0;
        this.strMsg = null;
        this.iPluginID = 0L;
        this.uRandID = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.shMsgType = jceInputStream.read(this.shMsgType, 0, true);
        this.uMsgID = jceInputStream.read(this.uMsgID, 1, true);
        this.lFromMID = jceInputStream.read(this.lFromMID, 2, true);
        this.lToMID = jceInputStream.read(this.lToMID, 3, true);
        this.iMsgTime = jceInputStream.read(this.iMsgTime, 4, true);
        this.eAccostType = jceInputStream.read(this.eAccostType, 5, true);
        if (cache_strMsg == null) {
            cache_strMsg = r0;
            byte[] bArr = {0};
        }
        this.strMsg = jceInputStream.read(cache_strMsg, 6, true);
        this.iPluginID = jceInputStream.read(this.iPluginID, 7, false);
        this.uRandID = jceInputStream.read(this.uRandID, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.shMsgType, 0);
        jceOutputStream.write(this.uMsgID, 1);
        jceOutputStream.write(this.lFromMID, 2);
        jceOutputStream.write(this.lToMID, 3);
        jceOutputStream.write(this.iMsgTime, 4);
        jceOutputStream.write(this.eAccostType, 5);
        jceOutputStream.write(this.strMsg, 6);
        jceOutputStream.write(this.iPluginID, 7);
        jceOutputStream.write(this.uRandID, 8);
    }

    public Msg(short s16, long j3, long j16, long j17, int i3, int i16, byte[] bArr, long j18, long j19) {
        this.shMsgType = s16;
        this.uMsgID = j3;
        this.lFromMID = j16;
        this.lToMID = j17;
        this.iMsgTime = i3;
        this.eAccostType = i16;
        this.strMsg = bArr;
        this.iPluginID = j18;
        this.uRandID = j19;
    }
}
