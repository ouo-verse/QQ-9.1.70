package SWU;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SWUploadPicRsp extends JceStruct {
    static int cache_ePicType;
    public int ePicType;
    public int iCode;
    public int iHeight;
    public int iUploadTs;
    public int iWidth;
    public String sAlbumID;
    public String sName;
    public String sPhotoID;
    public String sURL;

    public SWUploadPicRsp() {
        this.iCode = 0;
        this.sURL = "";
        this.sAlbumID = "";
        this.sPhotoID = "";
        this.iWidth = 0;
        this.iHeight = 0;
        this.sName = "";
        this.iUploadTs = 0;
        this.ePicType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iCode = jceInputStream.read(this.iCode, 0, false);
        this.sURL = jceInputStream.readString(1, false);
        this.sAlbumID = jceInputStream.readString(2, false);
        this.sPhotoID = jceInputStream.readString(3, false);
        this.iWidth = jceInputStream.read(this.iWidth, 4, false);
        this.iHeight = jceInputStream.read(this.iHeight, 5, false);
        this.sName = jceInputStream.readString(6, false);
        this.iUploadTs = jceInputStream.read(this.iUploadTs, 7, false);
        this.ePicType = jceInputStream.read(this.ePicType, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iCode, 0);
        String str = this.sURL;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.sAlbumID;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.sPhotoID;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.iWidth, 4);
        jceOutputStream.write(this.iHeight, 5);
        String str4 = this.sName;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.iUploadTs, 7);
        jceOutputStream.write(this.ePicType, 8);
    }

    public SWUploadPicRsp(int i3, String str, String str2, String str3, int i16, int i17, String str4, int i18, int i19) {
        this.iCode = i3;
        this.sURL = str;
        this.sAlbumID = str2;
        this.sPhotoID = str3;
        this.iWidth = i16;
        this.iHeight = i17;
        this.sName = str4;
        this.iUploadTs = i18;
        this.ePicType = i19;
    }
}
