package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PreuploadPicInfo extends JceStruct {
    static UploadPicInfoReq cache_picinfoReq = new UploadPicInfoReq();
    public int iAlbumTypeID;
    public int iDescLen;
    public long iFileLen;
    public int iNeedCheckAlbum;
    public long md5filelen;
    public int md5type;
    public UploadPicInfoReq picinfoReq;
    public String sAlbumID;
    public String sDescMD5;
    public String sFileMD5;
    public String seq;

    public PreuploadPicInfo() {
        this.picinfoReq = null;
        this.sFileMD5 = "";
        this.sDescMD5 = "";
        this.iFileLen = 0L;
        this.iDescLen = 0;
        this.md5type = 0;
        this.seq = "";
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iNeedCheckAlbum = 0;
        this.md5filelen = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picinfoReq = (UploadPicInfoReq) jceInputStream.read((JceStruct) cache_picinfoReq, 0, true);
        this.sFileMD5 = jceInputStream.readString(1, true);
        this.sDescMD5 = jceInputStream.readString(2, true);
        this.iFileLen = jceInputStream.read(this.iFileLen, 3, true);
        this.iDescLen = jceInputStream.read(this.iDescLen, 4, true);
        this.md5type = jceInputStream.read(this.md5type, 5, true);
        this.seq = jceInputStream.readString(6, true);
        this.sAlbumID = jceInputStream.readString(7, false);
        this.iAlbumTypeID = jceInputStream.read(this.iAlbumTypeID, 8, false);
        this.iNeedCheckAlbum = jceInputStream.read(this.iNeedCheckAlbum, 9, false);
        this.md5filelen = jceInputStream.read(this.md5filelen, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.picinfoReq, 0);
        jceOutputStream.write(this.sFileMD5, 1);
        jceOutputStream.write(this.sDescMD5, 2);
        jceOutputStream.write(this.iFileLen, 3);
        jceOutputStream.write(this.iDescLen, 4);
        jceOutputStream.write(this.md5type, 5);
        jceOutputStream.write(this.seq, 6);
        String str = this.sAlbumID;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        jceOutputStream.write(this.iAlbumTypeID, 8);
        jceOutputStream.write(this.iNeedCheckAlbum, 9);
        jceOutputStream.write(this.md5filelen, 10);
    }

    public PreuploadPicInfo(UploadPicInfoReq uploadPicInfoReq, String str, String str2, long j3, int i3, int i16, String str3, String str4, int i17, int i18, long j16) {
        this.picinfoReq = uploadPicInfoReq;
        this.sFileMD5 = str;
        this.sDescMD5 = str2;
        this.iFileLen = j3;
        this.iDescLen = i3;
        this.md5type = i16;
        this.seq = str3;
        this.sAlbumID = str4;
        this.iAlbumTypeID = i17;
        this.iNeedCheckAlbum = i18;
        this.md5filelen = j16;
    }
}
