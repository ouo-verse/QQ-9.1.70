package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class UploadPicInfoRsp extends JceStruct {
    static byte[] cache_vBusiNessDataRsp;
    static stWaterTemplate cache_waterTemplate = new stWaterTemplate();
    public int iBusiNessType;
    public int iHeight;
    public int iOriHeight;
    public int iOriWidth;
    public int iPicType;
    public int iWidth;
    public String sAdaptUrl_1000;
    public String sAdaptUrl_160;
    public String sAdaptUrl_200;
    public String sAdaptUrl_400;
    public String sAdaptUrl_640;
    public String sAlbumID;
    public String sBURL;
    public String sOriPhotoID;
    public String sOriUrl;
    public String sPhotoID;
    public String sPhotoMD5;
    public String sRealLloc;
    public String sSURL;
    public String sSloc;
    public byte[] vBusiNessDataRsp;
    public stWaterTemplate waterTemplate;

    static {
        cache_vBusiNessDataRsp = r0;
        byte[] bArr = {0};
    }

    public UploadPicInfoRsp() {
        this.sSURL = "";
        this.sBURL = "";
        this.sAlbumID = "";
        this.sPhotoID = "";
        this.sSloc = "";
        this.iWidth = 0;
        this.iHeight = 0;
        this.sOriUrl = "";
        this.iOriWidth = 0;
        this.iOriHeight = 0;
        this.sOriPhotoID = "";
        this.iPicType = 0;
        this.sAdaptUrl_160 = "";
        this.sAdaptUrl_200 = "";
        this.sAdaptUrl_400 = "";
        this.sAdaptUrl_640 = "";
        this.sAdaptUrl_1000 = "";
        this.waterTemplate = null;
        this.iBusiNessType = 0;
        this.vBusiNessDataRsp = null;
        this.sRealLloc = "";
        this.sPhotoMD5 = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sSURL = jceInputStream.readString(0, false);
        this.sBURL = jceInputStream.readString(1, false);
        this.sAlbumID = jceInputStream.readString(2, false);
        this.sPhotoID = jceInputStream.readString(3, false);
        this.sSloc = jceInputStream.readString(4, false);
        this.iWidth = jceInputStream.read(this.iWidth, 5, false);
        this.iHeight = jceInputStream.read(this.iHeight, 6, false);
        this.sOriUrl = jceInputStream.readString(7, false);
        this.iOriWidth = jceInputStream.read(this.iOriWidth, 8, false);
        this.iOriHeight = jceInputStream.read(this.iOriHeight, 9, false);
        this.sOriPhotoID = jceInputStream.readString(10, false);
        this.iPicType = jceInputStream.read(this.iPicType, 11, false);
        this.sAdaptUrl_160 = jceInputStream.readString(12, false);
        this.sAdaptUrl_200 = jceInputStream.readString(13, false);
        this.sAdaptUrl_400 = jceInputStream.readString(14, false);
        this.sAdaptUrl_640 = jceInputStream.readString(15, false);
        this.sAdaptUrl_1000 = jceInputStream.readString(16, false);
        this.waterTemplate = (stWaterTemplate) jceInputStream.read((JceStruct) cache_waterTemplate, 17, false);
        this.iBusiNessType = jceInputStream.read(this.iBusiNessType, 18, false);
        this.vBusiNessDataRsp = jceInputStream.read(cache_vBusiNessDataRsp, 19, false);
        this.sRealLloc = jceInputStream.readString(20, false);
        this.sPhotoMD5 = jceInputStream.readString(21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sSURL;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sBURL;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sAlbumID;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.sPhotoID;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        String str5 = this.sSloc;
        if (str5 != null) {
            jceOutputStream.write(str5, 4);
        }
        jceOutputStream.write(this.iWidth, 5);
        jceOutputStream.write(this.iHeight, 6);
        String str6 = this.sOriUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        jceOutputStream.write(this.iOriWidth, 8);
        jceOutputStream.write(this.iOriHeight, 9);
        String str7 = this.sOriPhotoID;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
        jceOutputStream.write(this.iPicType, 11);
        String str8 = this.sAdaptUrl_160;
        if (str8 != null) {
            jceOutputStream.write(str8, 12);
        }
        String str9 = this.sAdaptUrl_200;
        if (str9 != null) {
            jceOutputStream.write(str9, 13);
        }
        String str10 = this.sAdaptUrl_400;
        if (str10 != null) {
            jceOutputStream.write(str10, 14);
        }
        String str11 = this.sAdaptUrl_640;
        if (str11 != null) {
            jceOutputStream.write(str11, 15);
        }
        String str12 = this.sAdaptUrl_1000;
        if (str12 != null) {
            jceOutputStream.write(str12, 16);
        }
        stWaterTemplate stwatertemplate = this.waterTemplate;
        if (stwatertemplate != null) {
            jceOutputStream.write((JceStruct) stwatertemplate, 17);
        }
        jceOutputStream.write(this.iBusiNessType, 18);
        byte[] bArr = this.vBusiNessDataRsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 19);
        }
        String str13 = this.sRealLloc;
        if (str13 != null) {
            jceOutputStream.write(str13, 20);
        }
        String str14 = this.sPhotoMD5;
        if (str14 != null) {
            jceOutputStream.write(str14, 21);
        }
    }

    public UploadPicInfoRsp(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, int i17, int i18, String str7, int i19, String str8, String str9, String str10, String str11, String str12, stWaterTemplate stwatertemplate, int i26, byte[] bArr, String str13, String str14) {
        this.sSURL = str;
        this.sBURL = str2;
        this.sAlbumID = str3;
        this.sPhotoID = str4;
        this.sSloc = str5;
        this.iWidth = i3;
        this.iHeight = i16;
        this.sOriUrl = str6;
        this.iOriWidth = i17;
        this.iOriHeight = i18;
        this.sOriPhotoID = str7;
        this.iPicType = i19;
        this.sAdaptUrl_160 = str8;
        this.sAdaptUrl_200 = str9;
        this.sAdaptUrl_400 = str10;
        this.sAdaptUrl_640 = str11;
        this.sAdaptUrl_1000 = str12;
        this.waterTemplate = stwatertemplate;
        this.iBusiNessType = i26;
        this.vBusiNessDataRsp = bArr;
        this.sRealLloc = str13;
        this.sPhotoMD5 = str14;
    }
}
