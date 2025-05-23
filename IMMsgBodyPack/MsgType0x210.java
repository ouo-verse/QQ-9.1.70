package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210 extends JceStruct {
    static MsgType0x210SubMsgType0x13 cache_stMsgInfo0x13;
    static MsgType0x210SubMsgType0x17 cache_stMsgInfo0x17;
    static MsgType0x210SubMsgType0x2 cache_stMsgInfo0x2;
    static MsgType0x210SubMsgType0x24 cache_stMsgInfo0x24;
    static MsgType0x210SubMsgType0xa cache_stMsgInfo0xa;
    static MsgType0x210SubMsgType0xe cache_stMsgInfo0xe;
    static byte[] cache_vProtobuf;
    public MsgType0x210SubMsgType0x13 stMsgInfo0x13;
    public MsgType0x210SubMsgType0x17 stMsgInfo0x17;
    public MsgType0x210SubMsgType0x2 stMsgInfo0x2;
    public MsgType0x210SubMsgType0x24 stMsgInfo0x24;
    public MsgType0x210SubMsgType0xa stMsgInfo0xa;
    public MsgType0x210SubMsgType0xe stMsgInfo0xe;
    public long uSubMsgType;
    public byte[] vProtobuf;

    public MsgType0x210() {
        this.uSubMsgType = 0L;
        this.stMsgInfo0x2 = null;
        this.stMsgInfo0xa = null;
        this.stMsgInfo0xe = null;
        this.stMsgInfo0x13 = null;
        this.stMsgInfo0x17 = null;
        this.stMsgInfo0x24 = null;
        this.vProtobuf = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uSubMsgType = jceInputStream.read(this.uSubMsgType, 0, true);
        if (cache_stMsgInfo0x2 == null) {
            cache_stMsgInfo0x2 = new MsgType0x210SubMsgType0x2();
        }
        this.stMsgInfo0x2 = (MsgType0x210SubMsgType0x2) jceInputStream.read((JceStruct) cache_stMsgInfo0x2, 1, false);
        if (cache_stMsgInfo0xa == null) {
            cache_stMsgInfo0xa = new MsgType0x210SubMsgType0xa();
        }
        this.stMsgInfo0xa = (MsgType0x210SubMsgType0xa) jceInputStream.read((JceStruct) cache_stMsgInfo0xa, 3, false);
        if (cache_stMsgInfo0xe == null) {
            cache_stMsgInfo0xe = new MsgType0x210SubMsgType0xe();
        }
        this.stMsgInfo0xe = (MsgType0x210SubMsgType0xe) jceInputStream.read((JceStruct) cache_stMsgInfo0xe, 4, false);
        if (cache_stMsgInfo0x13 == null) {
            cache_stMsgInfo0x13 = new MsgType0x210SubMsgType0x13();
        }
        this.stMsgInfo0x13 = (MsgType0x210SubMsgType0x13) jceInputStream.read((JceStruct) cache_stMsgInfo0x13, 5, false);
        if (cache_stMsgInfo0x17 == null) {
            cache_stMsgInfo0x17 = new MsgType0x210SubMsgType0x17();
        }
        this.stMsgInfo0x17 = (MsgType0x210SubMsgType0x17) jceInputStream.read((JceStruct) cache_stMsgInfo0x17, 6, false);
        if (cache_stMsgInfo0x24 == null) {
            cache_stMsgInfo0x24 = new MsgType0x210SubMsgType0x24();
        }
        this.stMsgInfo0x24 = (MsgType0x210SubMsgType0x24) jceInputStream.read((JceStruct) cache_stMsgInfo0x24, 9, false);
        if (cache_vProtobuf == null) {
            cache_vProtobuf = r0;
            byte[] bArr = {0};
        }
        this.vProtobuf = jceInputStream.read(cache_vProtobuf, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uSubMsgType, 0);
        MsgType0x210SubMsgType0x2 msgType0x210SubMsgType0x2 = this.stMsgInfo0x2;
        if (msgType0x210SubMsgType0x2 != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0x2, 1);
        }
        MsgType0x210SubMsgType0xa msgType0x210SubMsgType0xa = this.stMsgInfo0xa;
        if (msgType0x210SubMsgType0xa != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0xa, 3);
        }
        MsgType0x210SubMsgType0xe msgType0x210SubMsgType0xe = this.stMsgInfo0xe;
        if (msgType0x210SubMsgType0xe != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0xe, 4);
        }
        MsgType0x210SubMsgType0x13 msgType0x210SubMsgType0x13 = this.stMsgInfo0x13;
        if (msgType0x210SubMsgType0x13 != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0x13, 5);
        }
        MsgType0x210SubMsgType0x17 msgType0x210SubMsgType0x17 = this.stMsgInfo0x17;
        if (msgType0x210SubMsgType0x17 != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0x17, 6);
        }
        MsgType0x210SubMsgType0x24 msgType0x210SubMsgType0x24 = this.stMsgInfo0x24;
        if (msgType0x210SubMsgType0x24 != null) {
            jceOutputStream.write((JceStruct) msgType0x210SubMsgType0x24, 9);
        }
        byte[] bArr = this.vProtobuf;
        if (bArr != null) {
            jceOutputStream.write(bArr, 10);
        }
    }

    public MsgType0x210(long j3, MsgType0x210SubMsgType0x2 msgType0x210SubMsgType0x2, MsgType0x210SubMsgType0xa msgType0x210SubMsgType0xa, MsgType0x210SubMsgType0xe msgType0x210SubMsgType0xe, MsgType0x210SubMsgType0x13 msgType0x210SubMsgType0x13, MsgType0x210SubMsgType0x17 msgType0x210SubMsgType0x17, MsgType0x210SubMsgType0x24 msgType0x210SubMsgType0x24, byte[] bArr) {
        this.uSubMsgType = j3;
        this.stMsgInfo0x2 = msgType0x210SubMsgType0x2;
        this.stMsgInfo0xa = msgType0x210SubMsgType0xa;
        this.stMsgInfo0xe = msgType0x210SubMsgType0xe;
        this.stMsgInfo0x13 = msgType0x210SubMsgType0x13;
        this.stMsgInfo0x17 = msgType0x210SubMsgType0x17;
        this.stMsgInfo0x24 = msgType0x210SubMsgType0x24;
        this.vProtobuf = bArr;
    }
}
