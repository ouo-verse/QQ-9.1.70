package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpDownloadReq extends JceStruct {
    static byte[] cache_vEncryptUsrInfo;
    static byte[] cache_vFileKey;
    public short shPicScale;
    public int uFromPos;
    public int uLength;
    public byte[] vEncryptUsrInfo;
    public byte[] vFileKey;

    public HttpDownloadReq() {
        this.vEncryptUsrInfo = null;
        this.vFileKey = null;
        this.uFromPos = 0;
        this.uLength = 0;
        this.shPicScale = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vEncryptUsrInfo == null) {
            cache_vEncryptUsrInfo = r0;
            byte[] bArr = {0};
        }
        this.vEncryptUsrInfo = jceInputStream.read(cache_vEncryptUsrInfo, 0, true);
        if (cache_vFileKey == null) {
            cache_vFileKey = r0;
            byte[] bArr2 = {0};
        }
        this.vFileKey = jceInputStream.read(cache_vFileKey, 1, true);
        this.uFromPos = jceInputStream.read(this.uFromPos, 2, true);
        this.uLength = jceInputStream.read(this.uLength, 3, true);
        this.shPicScale = jceInputStream.read(this.shPicScale, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vEncryptUsrInfo, 0);
        jceOutputStream.write(this.vFileKey, 1);
        jceOutputStream.write(this.uFromPos, 2);
        jceOutputStream.write(this.uLength, 3);
        jceOutputStream.write(this.shPicScale, 4);
    }

    public HttpDownloadReq(byte[] bArr, byte[] bArr2, int i3, int i16, short s16) {
        this.vEncryptUsrInfo = bArr;
        this.vFileKey = bArr2;
        this.uFromPos = i3;
        this.uLength = i16;
        this.shPicScale = s16;
    }
}
