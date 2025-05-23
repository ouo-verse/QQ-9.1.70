package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SvcRequestPullGroupMsg extends JceStruct {
    public byte cGetGroupNick;
    public byte cGetPttUrl;
    public byte cGroupMsgRoam;
    public byte cMsgStoreType;
    public byte cVerifyType;
    public long lBeginSeq;
    public long lEndSeq;
    public long lGroupCode;

    public SvcRequestPullGroupMsg() {
        this.cVerifyType = (byte) 0;
        this.lGroupCode = 0L;
        this.lBeginSeq = 0L;
        this.lEndSeq = 0L;
        this.cGetGroupNick = (byte) 0;
        this.cGroupMsgRoam = (byte) 0;
        this.cMsgStoreType = (byte) 0;
        this.cGetPttUrl = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 0, true);
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 1, true);
        this.lBeginSeq = jceInputStream.read(this.lBeginSeq, 2, true);
        this.lEndSeq = jceInputStream.read(this.lEndSeq, 3, true);
        this.cGetGroupNick = jceInputStream.read(this.cGetGroupNick, 4, false);
        this.cGroupMsgRoam = jceInputStream.read(this.cGroupMsgRoam, 5, false);
        this.cMsgStoreType = jceInputStream.read(this.cMsgStoreType, 6, false);
        this.cGetPttUrl = jceInputStream.read(this.cGetPttUrl, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cVerifyType, 0);
        jceOutputStream.write(this.lGroupCode, 1);
        jceOutputStream.write(this.lBeginSeq, 2);
        jceOutputStream.write(this.lEndSeq, 3);
        jceOutputStream.write(this.cGetGroupNick, 4);
        jceOutputStream.write(this.cGroupMsgRoam, 5);
        jceOutputStream.write(this.cMsgStoreType, 6);
        jceOutputStream.write(this.cGetPttUrl, 7);
    }

    public SvcRequestPullGroupMsg(byte b16, long j3, long j16, long j17, byte b17, byte b18, byte b19, byte b26) {
        this.cVerifyType = b16;
        this.lGroupCode = j3;
        this.lBeginSeq = j16;
        this.lEndSeq = j17;
        this.cGetGroupNick = b17;
        this.cGroupMsgRoam = b18;
        this.cMsgStoreType = b19;
        this.cGetPttUrl = b26;
    }
}
