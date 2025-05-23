package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0xa extends JceStruct {
    static byte[] cache_strFileName;
    static byte[] cache_strOriginfile_md5;
    static byte[] cache_vMd5;
    static byte[] cache_vTokenKey;
    static byte[] cache_vUrlNotify;
    public long lSessionId;
    public byte[] strFileName;
    public byte[] strOriginfile_md5;
    public long uDstAppId;
    public long uDstInstId;
    public long uDstUin;
    public long uFileLen;
    public long uOriginfiletype;
    public long uSeq;
    public long uServerIp;
    public long uServerPort;
    public long uSrcAppId;
    public long uSrcInstId;
    public long uType;
    public byte[] vMd5;
    public byte[] vTokenKey;
    public byte[] vUrlNotify;

    public MsgType0x210SubMsgType0xa() {
        this.uSrcAppId = 0L;
        this.uSrcInstId = 0L;
        this.uDstAppId = 0L;
        this.uDstInstId = 0L;
        this.uDstUin = 0L;
        this.uType = 0L;
        this.uServerIp = 0L;
        this.uServerPort = 0L;
        this.vUrlNotify = null;
        this.vTokenKey = null;
        this.uFileLen = 0L;
        this.strFileName = null;
        this.vMd5 = null;
        this.lSessionId = 0L;
        this.strOriginfile_md5 = null;
        this.uOriginfiletype = 0L;
        this.uSeq = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uSrcAppId = jceInputStream.read(this.uSrcAppId, 0, false);
        this.uSrcInstId = jceInputStream.read(this.uSrcInstId, 1, false);
        this.uDstAppId = jceInputStream.read(this.uDstAppId, 2, false);
        this.uDstInstId = jceInputStream.read(this.uDstInstId, 3, false);
        this.uDstUin = jceInputStream.read(this.uDstUin, 4, false);
        this.uType = jceInputStream.read(this.uType, 5, false);
        this.uServerIp = jceInputStream.read(this.uServerIp, 6, false);
        this.uServerPort = jceInputStream.read(this.uServerPort, 7, false);
        if (cache_vUrlNotify == null) {
            cache_vUrlNotify = r0;
            byte[] bArr = {0};
        }
        this.vUrlNotify = jceInputStream.read(cache_vUrlNotify, 8, false);
        if (cache_vTokenKey == null) {
            cache_vTokenKey = r0;
            byte[] bArr2 = {0};
        }
        this.vTokenKey = jceInputStream.read(cache_vTokenKey, 9, false);
        this.uFileLen = jceInputStream.read(this.uFileLen, 10, false);
        if (cache_strFileName == null) {
            cache_strFileName = r0;
            byte[] bArr3 = {0};
        }
        this.strFileName = jceInputStream.read(cache_strFileName, 11, false);
        if (cache_vMd5 == null) {
            cache_vMd5 = r0;
            byte[] bArr4 = {0};
        }
        this.vMd5 = jceInputStream.read(cache_vMd5, 12, false);
        this.lSessionId = jceInputStream.read(this.lSessionId, 13, false);
        if (cache_strOriginfile_md5 == null) {
            cache_strOriginfile_md5 = r0;
            byte[] bArr5 = {0};
        }
        this.strOriginfile_md5 = jceInputStream.read(cache_strOriginfile_md5, 14, false);
        this.uOriginfiletype = jceInputStream.read(this.uOriginfiletype, 15, false);
        this.uSeq = jceInputStream.read(this.uSeq, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uSrcAppId, 0);
        jceOutputStream.write(this.uSrcInstId, 1);
        jceOutputStream.write(this.uDstAppId, 2);
        jceOutputStream.write(this.uDstInstId, 3);
        jceOutputStream.write(this.uDstUin, 4);
        jceOutputStream.write(this.uType, 5);
        jceOutputStream.write(this.uServerIp, 6);
        jceOutputStream.write(this.uServerPort, 7);
        byte[] bArr = this.vUrlNotify;
        if (bArr != null) {
            jceOutputStream.write(bArr, 8);
        }
        byte[] bArr2 = this.vTokenKey;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 9);
        }
        jceOutputStream.write(this.uFileLen, 10);
        byte[] bArr3 = this.strFileName;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 11);
        }
        byte[] bArr4 = this.vMd5;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 12);
        }
        jceOutputStream.write(this.lSessionId, 13);
        byte[] bArr5 = this.strOriginfile_md5;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 14);
        }
        jceOutputStream.write(this.uOriginfiletype, 15);
        jceOutputStream.write(this.uSeq, 16);
    }

    public MsgType0x210SubMsgType0xa(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, byte[] bArr, byte[] bArr2, long j29, byte[] bArr3, byte[] bArr4, long j36, byte[] bArr5, long j37, long j38) {
        this.uSrcAppId = j3;
        this.uSrcInstId = j16;
        this.uDstAppId = j17;
        this.uDstInstId = j18;
        this.uDstUin = j19;
        this.uType = j26;
        this.uServerIp = j27;
        this.uServerPort = j28;
        this.vUrlNotify = bArr;
        this.vTokenKey = bArr2;
        this.uFileLen = j29;
        this.strFileName = bArr3;
        this.vMd5 = bArr4;
        this.lSessionId = j36;
        this.strOriginfile_md5 = bArr5;
        this.uOriginfiletype = j37;
        this.uSeq = j38;
    }
}
