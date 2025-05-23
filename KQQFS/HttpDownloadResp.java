package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpDownloadResp extends JceStruct {
    static byte[] cache_encryKey;
    static VerifyCode cache_stVerifyCode;
    static byte[] cache_vFileData;
    public int encryFrom;
    public byte[] encryKey;
    public int encryTo;
    public byte encryType;
    public int iReplyCode;
    public long lMID;
    public int sessionID;
    public VerifyCode stVerifyCode;
    public String strFileName;
    public String strResult;
    public long uFileLen;
    public int uSeq;
    public byte[] vFileData;

    public HttpDownloadResp() {
        this.lMID = 0L;
        this.sessionID = 0;
        this.uSeq = 0;
        this.uFileLen = 0L;
        this.iReplyCode = 0;
        this.strResult = "";
        this.encryType = (byte) 0;
        this.encryKey = null;
        this.encryFrom = 0;
        this.encryTo = 0;
        this.vFileData = null;
        this.stVerifyCode = null;
        this.strFileName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lMID = jceInputStream.read(this.lMID, 0, true);
        this.sessionID = jceInputStream.read(this.sessionID, 1, true);
        this.uSeq = jceInputStream.read(this.uSeq, 2, true);
        this.uFileLen = jceInputStream.read(this.uFileLen, 3, true);
        this.iReplyCode = jceInputStream.read(this.iReplyCode, 4, true);
        this.strResult = jceInputStream.readString(5, true);
        this.encryType = jceInputStream.read(this.encryType, 6, true);
        if (cache_encryKey == null) {
            cache_encryKey = r0;
            byte[] bArr = {0};
        }
        this.encryKey = jceInputStream.read(cache_encryKey, 7, true);
        this.encryFrom = jceInputStream.read(this.encryFrom, 8, true);
        this.encryTo = jceInputStream.read(this.encryTo, 9, true);
        if (cache_vFileData == null) {
            cache_vFileData = r0;
            byte[] bArr2 = {0};
        }
        this.vFileData = jceInputStream.read(cache_vFileData, 10, true);
        if (cache_stVerifyCode == null) {
            cache_stVerifyCode = new VerifyCode();
        }
        this.stVerifyCode = (VerifyCode) jceInputStream.read((JceStruct) cache_stVerifyCode, 11, false);
        this.strFileName = jceInputStream.readString(12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lMID, 0);
        jceOutputStream.write(this.sessionID, 1);
        jceOutputStream.write(this.uSeq, 2);
        jceOutputStream.write(this.uFileLen, 3);
        jceOutputStream.write(this.iReplyCode, 4);
        jceOutputStream.write(this.strResult, 5);
        jceOutputStream.write(this.encryType, 6);
        jceOutputStream.write(this.encryKey, 7);
        jceOutputStream.write(this.encryFrom, 8);
        jceOutputStream.write(this.encryTo, 9);
        jceOutputStream.write(this.vFileData, 10);
        VerifyCode verifyCode = this.stVerifyCode;
        if (verifyCode != null) {
            jceOutputStream.write((JceStruct) verifyCode, 11);
        }
        String str = this.strFileName;
        if (str != null) {
            jceOutputStream.write(str, 12);
        }
    }

    public HttpDownloadResp(long j3, int i3, int i16, long j16, int i17, String str, byte b16, byte[] bArr, int i18, int i19, byte[] bArr2, VerifyCode verifyCode, String str2) {
        this.lMID = j3;
        this.sessionID = i3;
        this.uSeq = i16;
        this.uFileLen = j16;
        this.iReplyCode = i17;
        this.strResult = str;
        this.encryType = b16;
        this.encryKey = bArr;
        this.encryFrom = i18;
        this.encryTo = i19;
        this.vFileData = bArr2;
        this.stVerifyCode = verifyCode;
        this.strFileName = str2;
    }
}
