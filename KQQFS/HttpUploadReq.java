package KQQFS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class HttpUploadReq extends JceStruct {
    static DefineAvatarInfo cache_AvatarInfo;
    static byte[] cache_v10MMd5;
    static byte[] cache_vEncryptUsrInfo;
    static byte[] cache_vFileData;

    /* renamed from: AvatarInfo, reason: collision with root package name */
    public DefineAvatarInfo f24908AvatarInfo;
    public byte ifUpQQAvatar;
    public String strFileName;
    public int uFileSize;
    public int uFromPos;
    public int uLength;
    public byte[] v10MMd5;
    public byte[] vEncryptUsrInfo;
    public byte[] vFileData;

    public HttpUploadReq() {
        this.vEncryptUsrInfo = null;
        this.uFileSize = 0;
        this.v10MMd5 = null;
        this.uFromPos = 0;
        this.uLength = 0;
        this.vFileData = null;
        this.ifUpQQAvatar = (byte) 0;
        this.f24908AvatarInfo = null;
        this.strFileName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vEncryptUsrInfo == null) {
            cache_vEncryptUsrInfo = r0;
            byte[] bArr = {0};
        }
        this.vEncryptUsrInfo = jceInputStream.read(cache_vEncryptUsrInfo, 0, true);
        this.uFileSize = jceInputStream.read(this.uFileSize, 1, true);
        if (cache_v10MMd5 == null) {
            cache_v10MMd5 = r0;
            byte[] bArr2 = {0};
        }
        this.v10MMd5 = jceInputStream.read(cache_v10MMd5, 2, true);
        this.uFromPos = jceInputStream.read(this.uFromPos, 3, true);
        this.uLength = jceInputStream.read(this.uLength, 4, true);
        if (cache_vFileData == null) {
            cache_vFileData = r0;
            byte[] bArr3 = {0};
        }
        this.vFileData = jceInputStream.read(cache_vFileData, 5, true);
        this.ifUpQQAvatar = jceInputStream.read(this.ifUpQQAvatar, 6, false);
        if (cache_AvatarInfo == null) {
            cache_AvatarInfo = new DefineAvatarInfo();
        }
        this.f24908AvatarInfo = (DefineAvatarInfo) jceInputStream.read((JceStruct) cache_AvatarInfo, 7, false);
        this.strFileName = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vEncryptUsrInfo, 0);
        jceOutputStream.write(this.uFileSize, 1);
        jceOutputStream.write(this.v10MMd5, 2);
        jceOutputStream.write(this.uFromPos, 3);
        jceOutputStream.write(this.uLength, 4);
        jceOutputStream.write(this.vFileData, 5);
        jceOutputStream.write(this.ifUpQQAvatar, 6);
        DefineAvatarInfo defineAvatarInfo = this.f24908AvatarInfo;
        if (defineAvatarInfo != null) {
            jceOutputStream.write((JceStruct) defineAvatarInfo, 7);
        }
        String str = this.strFileName;
        if (str != null) {
            jceOutputStream.write(str, 8);
        }
    }

    public HttpUploadReq(byte[] bArr, int i3, byte[] bArr2, int i16, int i17, byte[] bArr3, byte b16, DefineAvatarInfo defineAvatarInfo, String str) {
        this.vEncryptUsrInfo = bArr;
        this.uFileSize = i3;
        this.v10MMd5 = bArr2;
        this.uFromPos = i16;
        this.uLength = i17;
        this.vFileData = bArr3;
        this.ifUpQQAvatar = b16;
        this.f24908AvatarInfo = defineAvatarInfo;
        this.strFileName = str;
    }
}
