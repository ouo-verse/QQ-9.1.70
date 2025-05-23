package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SvcRequestGetGroupMsg extends JceStruct {
    public byte c30Min;
    public byte cGetGroupNick;
    public byte cGetPttUrl;
    public byte cGroupMsgRoam;
    public byte cMsgStoreType;
    public byte cRecivePic;
    public byte cSubCmd;
    public byte cVerifyType;
    public long lBeginSeq;
    public long lEndSeq;
    public long lGroupCode;
    public long lUin;

    public SvcRequestGetGroupMsg() {
        this.lUin = 0L;
        this.lGroupCode = 0L;
        this.lBeginSeq = 0L;
        this.lEndSeq = 0L;
        this.c30Min = (byte) 0;
        this.cRecivePic = (byte) 0;
        this.cMsgStoreType = (byte) 0;
        this.cVerifyType = (byte) 0;
        this.cSubCmd = (byte) 0;
        this.cGetGroupNick = (byte) 0;
        this.cGroupMsgRoam = (byte) 0;
        this.cGetPttUrl = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, true);
        this.lGroupCode = jceInputStream.read(this.lGroupCode, 1, true);
        this.lBeginSeq = jceInputStream.read(this.lBeginSeq, 2, true);
        this.lEndSeq = jceInputStream.read(this.lEndSeq, 3, true);
        this.c30Min = jceInputStream.read(this.c30Min, 4, true);
        this.cRecivePic = jceInputStream.read(this.cRecivePic, 5, true);
        this.cMsgStoreType = jceInputStream.read(this.cMsgStoreType, 6, false);
        this.cVerifyType = jceInputStream.read(this.cVerifyType, 7, false);
        this.cSubCmd = jceInputStream.read(this.cSubCmd, 8, false);
        this.cGetGroupNick = jceInputStream.read(this.cGetGroupNick, 9, false);
        this.cGroupMsgRoam = jceInputStream.read(this.cGroupMsgRoam, 10, false);
        this.cGetPttUrl = jceInputStream.read(this.cGetPttUrl, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        jceOutputStream.write(this.lGroupCode, 1);
        jceOutputStream.write(this.lBeginSeq, 2);
        jceOutputStream.write(this.lEndSeq, 3);
        jceOutputStream.write(this.c30Min, 4);
        jceOutputStream.write(this.cRecivePic, 5);
        jceOutputStream.write(this.cMsgStoreType, 6);
        jceOutputStream.write(this.cVerifyType, 7);
        jceOutputStream.write(this.cSubCmd, 8);
        jceOutputStream.write(this.cGetGroupNick, 9);
        jceOutputStream.write(this.cGroupMsgRoam, 10);
        jceOutputStream.write(this.cGetPttUrl, 11);
    }

    public SvcRequestGetGroupMsg(long j3, long j16, long j17, long j18, byte b16, byte b17, byte b18, byte b19, byte b26, byte b27, byte b28, byte b29) {
        this.lUin = j3;
        this.lGroupCode = j16;
        this.lBeginSeq = j17;
        this.lEndSeq = j18;
        this.c30Min = b16;
        this.cRecivePic = b17;
        this.cMsgStoreType = b18;
        this.cVerifyType = b19;
        this.cSubCmd = b26;
        this.cGetGroupNick = b27;
        this.cGroupMsgRoam = b28;
        this.cGetPttUrl = b29;
    }
}
