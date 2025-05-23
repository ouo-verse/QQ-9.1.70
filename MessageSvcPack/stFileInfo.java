package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFileInfo extends JceStruct {
    static byte[] cache_strIndex;
    static byte[] cache_strKey;
    static byte[] cache_strMd5;
    static byte[] cache_strName;
    static byte[] cache_strOriginFileMd5;
    public long lLen;
    public long lSessionId;
    public byte[] strIndex;
    public byte[] strKey;
    public byte[] strMd5;
    public byte[] strName;
    public byte[] strOriginFileMd5;
    public long uOriginFileType;
    public long uSvrIp;
    public long uSvrPort;

    public stFileInfo() {
        this.strName = null;
        this.strIndex = null;
        this.strMd5 = null;
        this.strKey = null;
        this.uSvrIp = 0L;
        this.uSvrPort = 0L;
        this.strOriginFileMd5 = null;
        this.lLen = 0L;
        this.lSessionId = 0L;
        this.uOriginFileType = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_strName == null) {
            cache_strName = r0;
            byte[] bArr = {0};
        }
        this.strName = jceInputStream.read(cache_strName, 0, true);
        if (cache_strIndex == null) {
            cache_strIndex = r0;
            byte[] bArr2 = {0};
        }
        this.strIndex = jceInputStream.read(cache_strIndex, 1, true);
        if (cache_strMd5 == null) {
            cache_strMd5 = r0;
            byte[] bArr3 = {0};
        }
        this.strMd5 = jceInputStream.read(cache_strMd5, 2, true);
        if (cache_strKey == null) {
            cache_strKey = r0;
            byte[] bArr4 = {0};
        }
        this.strKey = jceInputStream.read(cache_strKey, 3, true);
        this.uSvrIp = jceInputStream.read(this.uSvrIp, 4, true);
        this.uSvrPort = jceInputStream.read(this.uSvrPort, 5, true);
        if (cache_strOriginFileMd5 == null) {
            cache_strOriginFileMd5 = r0;
            byte[] bArr5 = {0};
        }
        this.strOriginFileMd5 = jceInputStream.read(cache_strOriginFileMd5, 6, false);
        this.lLen = jceInputStream.read(this.lLen, 7, false);
        this.lSessionId = jceInputStream.read(this.lSessionId, 8, false);
        this.uOriginFileType = jceInputStream.read(this.uOriginFileType, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strName, 0);
        jceOutputStream.write(this.strIndex, 1);
        jceOutputStream.write(this.strMd5, 2);
        jceOutputStream.write(this.strKey, 3);
        jceOutputStream.write(this.uSvrIp, 4);
        jceOutputStream.write(this.uSvrPort, 5);
        byte[] bArr = this.strOriginFileMd5;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        jceOutputStream.write(this.lLen, 7);
        jceOutputStream.write(this.lSessionId, 8);
        jceOutputStream.write(this.uOriginFileType, 9);
    }

    public stFileInfo(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j3, long j16, byte[] bArr5, long j17, long j18, long j19) {
        this.strName = bArr;
        this.strIndex = bArr2;
        this.strMd5 = bArr3;
        this.strKey = bArr4;
        this.uSvrIp = j3;
        this.uSvrPort = j16;
        this.strOriginFileMd5 = bArr5;
        this.lLen = j17;
        this.lSessionId = j18;
        this.uOriginFileType = j19;
    }
}
