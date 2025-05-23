package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpUploadResp extends JceStruct {
    static VerifyCode cache_stVerifyCode;
    static byte[] cache_vFileKey;
    static byte[] cache_vSig;
    public int iReplyCode;
    public long lFromMID;
    public long lToMID;
    public int sessionID;
    public VerifyCode stVerifyCode;
    public String strResult;
    public int uFromPos;
    public int uSeq;
    public byte[] vFileKey;
    public byte[] vSig;

    public HttpUploadResp() {
        this.lFromMID = 0L;
        this.lToMID = 0L;
        this.sessionID = 0;
        this.uSeq = 0;
        this.iReplyCode = 0;
        this.strResult = "";
        this.uFromPos = 0;
        this.vFileKey = null;
        this.stVerifyCode = null;
        this.vSig = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lFromMID = jceInputStream.read(this.lFromMID, 0, true);
        this.lToMID = jceInputStream.read(this.lToMID, 1, true);
        this.sessionID = jceInputStream.read(this.sessionID, 2, true);
        this.uSeq = jceInputStream.read(this.uSeq, 3, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 4, true);
        this.strResult = jceInputStream.readString(5, true);
        this.uFromPos = jceInputStream.read(this.uFromPos, 6, false);
        if (cache_vFileKey == null) {
            cache_vFileKey = r0;
            byte[] bArr = {0};
        }
        this.vFileKey = jceInputStream.read(cache_vFileKey, 7, false);
        if (cache_stVerifyCode == null) {
            cache_stVerifyCode = new VerifyCode();
        }
        this.stVerifyCode = (VerifyCode) jceInputStream.read((JceStruct) cache_stVerifyCode, 8, false);
        if (cache_vSig == null) {
            cache_vSig = r0;
            byte[] bArr2 = {0};
        }
        this.vSig = jceInputStream.read(cache_vSig, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lFromMID, 0);
        jceOutputStream.write(this.lToMID, 1);
        jceOutputStream.write(this.sessionID, 2);
        jceOutputStream.write(this.uSeq, 3);
        jceOutputStream.write(this.iReplyCode, 4);
        jceOutputStream.write(this.strResult, 5);
        jceOutputStream.write(this.uFromPos, 6);
        byte[] bArr = this.vFileKey;
        if (bArr != null) {
            jceOutputStream.write(bArr, 7);
        }
        VerifyCode verifyCode = this.stVerifyCode;
        if (verifyCode != null) {
            jceOutputStream.write((JceStruct) verifyCode, 8);
        }
        byte[] bArr2 = this.vSig;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 9);
        }
    }

    public HttpUploadResp(long j3, long j16, int i3, int i16, int i17, String str, int i18, byte[] bArr, VerifyCode verifyCode, byte[] bArr2) {
        this.lFromMID = j3;
        this.lToMID = j16;
        this.sessionID = i3;
        this.uSeq = i16;
        this.iReplyCode = i17;
        this.strResult = str;
        this.uFromPos = i18;
        this.vFileKey = bArr;
        this.stVerifyCode = verifyCode;
        this.vSig = bArr2;
    }
}
