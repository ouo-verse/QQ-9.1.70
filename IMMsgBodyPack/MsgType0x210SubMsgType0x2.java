package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0x2 extends JceStruct {
    static byte[] cache_strFileIndex;
    static byte[] cache_strFileKey;
    static byte[] cache_strFileMd5;
    static byte[] cache_strFileName;
    static byte[] cache_strOriginfile_md5;
    public long lFileLen;
    public long lSessionId;
    public byte[] strFileIndex;
    public byte[] strFileKey;
    public byte[] strFileMd5;
    public byte[] strFileName;
    public byte[] strOriginfile_md5;
    public long uDstAppId;
    public long uDstInstId;
    public long uDstUin;
    public long uOriginfiletype;
    public long uSeq;
    public long uServerIp;
    public long uServerPort;
    public long uSrcAppId;
    public long uSrcInstId;

    public MsgType0x210SubMsgType0x2() {
        this.uSrcAppId = 0L;
        this.uSrcInstId = 0L;
        this.uDstAppId = 0L;
        this.uDstInstId = 0L;
        this.uDstUin = 0L;
        this.strFileName = null;
        this.strFileIndex = null;
        this.strFileMd5 = null;
        this.strFileKey = null;
        this.uServerIp = 0L;
        this.uServerPort = 0L;
        this.lFileLen = 0L;
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
        if (cache_strFileName == null) {
            cache_strFileName = r0;
            byte[] bArr = {0};
        }
        this.strFileName = jceInputStream.read(cache_strFileName, 5, false);
        if (cache_strFileIndex == null) {
            cache_strFileIndex = r0;
            byte[] bArr2 = {0};
        }
        this.strFileIndex = jceInputStream.read(cache_strFileIndex, 6, false);
        if (cache_strFileMd5 == null) {
            cache_strFileMd5 = r0;
            byte[] bArr3 = {0};
        }
        this.strFileMd5 = jceInputStream.read(cache_strFileMd5, 7, false);
        if (cache_strFileKey == null) {
            cache_strFileKey = r0;
            byte[] bArr4 = {0};
        }
        this.strFileKey = jceInputStream.read(cache_strFileKey, 8, false);
        this.uServerIp = jceInputStream.read(this.uServerIp, 9, false);
        this.uServerPort = jceInputStream.read(this.uServerPort, 10, false);
        this.lFileLen = jceInputStream.read(this.lFileLen, 11, false);
        this.lSessionId = jceInputStream.read(this.lSessionId, 12, false);
        if (cache_strOriginfile_md5 == null) {
            cache_strOriginfile_md5 = r0;
            byte[] bArr5 = {0};
        }
        this.strOriginfile_md5 = jceInputStream.read(cache_strOriginfile_md5, 13, false);
        this.uOriginfiletype = jceInputStream.read(this.uOriginfiletype, 14, false);
        this.uSeq = jceInputStream.read(this.uSeq, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uSrcAppId, 0);
        jceOutputStream.write(this.uSrcInstId, 1);
        jceOutputStream.write(this.uDstAppId, 2);
        jceOutputStream.write(this.uDstInstId, 3);
        jceOutputStream.write(this.uDstUin, 4);
        byte[] bArr = this.strFileName;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        byte[] bArr2 = this.strFileIndex;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 6);
        }
        byte[] bArr3 = this.strFileMd5;
        if (bArr3 != null) {
            jceOutputStream.write(bArr3, 7);
        }
        byte[] bArr4 = this.strFileKey;
        if (bArr4 != null) {
            jceOutputStream.write(bArr4, 8);
        }
        jceOutputStream.write(this.uServerIp, 9);
        jceOutputStream.write(this.uServerPort, 10);
        jceOutputStream.write(this.lFileLen, 11);
        jceOutputStream.write(this.lSessionId, 12);
        byte[] bArr5 = this.strOriginfile_md5;
        if (bArr5 != null) {
            jceOutputStream.write(bArr5, 13);
        }
        jceOutputStream.write(this.uOriginfiletype, 14);
        jceOutputStream.write(this.uSeq, 15);
    }

    public MsgType0x210SubMsgType0x2(long j3, long j16, long j17, long j18, long j19, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j26, long j27, long j28, long j29, byte[] bArr5, long j36, long j37) {
        this.uSrcAppId = j3;
        this.uSrcInstId = j16;
        this.uDstAppId = j17;
        this.uDstInstId = j18;
        this.uDstUin = j19;
        this.strFileName = bArr;
        this.strFileIndex = bArr2;
        this.strFileMd5 = bArr3;
        this.strFileKey = bArr4;
        this.uServerIp = j26;
        this.uServerPort = j27;
        this.lFileLen = j28;
        this.lSessionId = j29;
        this.strOriginfile_md5 = bArr5;
        this.uOriginfiletype = j36;
        this.uSeq = j37;
    }
}
