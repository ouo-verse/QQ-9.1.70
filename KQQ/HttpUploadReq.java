package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpUploadReq extends JceStruct {
    static byte[] cache_vEncryptUploadInfo;
    static byte[] cache_vFileData;
    public byte[] vEncryptUploadInfo;
    public byte[] vFileData;

    public HttpUploadReq() {
        this.vEncryptUploadInfo = null;
        this.vFileData = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vEncryptUploadInfo == null) {
            cache_vEncryptUploadInfo = r0;
            byte[] bArr = {0};
        }
        this.vEncryptUploadInfo = jceInputStream.read(cache_vEncryptUploadInfo, 0, true);
        if (cache_vFileData == null) {
            cache_vFileData = r0;
            byte[] bArr2 = {0};
        }
        this.vFileData = jceInputStream.read(cache_vFileData, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vEncryptUploadInfo, 0);
        jceOutputStream.write(this.vFileData, 1);
    }

    public HttpUploadReq(byte[] bArr, byte[] bArr2) {
        this.vEncryptUploadInfo = bArr;
        this.vFileData = bArr2;
    }
}
