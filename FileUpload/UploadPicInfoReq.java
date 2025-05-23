package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class UploadPicInfoReq extends JceStruct {
    static Map<String, byte[]> cache_ExternalData;
    static Map<String, String> cache_mapExt;
    static int cache_resource_type;
    static Map<String, String> cache_stExternalMapExt;
    static stPoi cache_uploadPoi;
    static byte[] cache_vBusiNessData;
    static stWaterTemplate cache_waterTemplate;
    public Map<String, byte[]> ExternalData;
    public int iAlbumTypeID;
    public long iBatchID;
    public int iBitmap;
    public int iBusiNessType;
    public int iDistinctUse;
    public int iNeedFeeds;
    public int iPicHight;
    public int iPicWidth;
    public int iUpPicType;
    public long iUploadTime;
    public int iUploadType;
    public int iWaterType;
    public Map<String, String> mapExt;
    public MultiPicInfo mutliPicInfo;
    public String otherParams;
    public int resource_type;
    public String sAlbumID;
    public String sAlbumName;
    public String sExif_CameraMaker;
    public String sExif_CameraModel;
    public String sExif_Latitude;
    public String sExif_LatitudeRef;
    public String sExif_Longitude;
    public String sExif_LongitudeRef;
    public String sExif_Time;
    public String sPicDesc;
    public String sPicPath;
    public String sPicTitle;
    public PicExtendInfo stExtendInfo;
    public Map<String, String> stExternalMapExt;
    public stPoi uploadPoi;
    public byte[] vBusiNessData;
    public stWaterTemplate waterTemplate;
    static MultiPicInfo cache_mutliPicInfo = new MultiPicInfo();
    static PicExtendInfo cache_stExtendInfo = new PicExtendInfo();

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        cache_uploadPoi = new stPoi();
        cache_waterTemplate = new stWaterTemplate();
        cache_vBusiNessData = r2;
        byte[] bArr = {0};
        HashMap hashMap2 = new HashMap();
        cache_stExternalMapExt = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        cache_ExternalData = hashMap3;
        hashMap3.put("", new byte[]{0});
        cache_resource_type = 0;
    }

    public UploadPicInfoReq() {
        this.sPicTitle = "";
        this.sPicDesc = "";
        this.sAlbumName = "";
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBitmap = 0;
        this.iUploadType = 0;
        this.iUpPicType = 0;
        this.iBatchID = 0L;
        this.mutliPicInfo = null;
        this.stExtendInfo = null;
        this.sPicPath = "";
        this.iPicWidth = 0;
        this.iPicHight = 0;
        this.iWaterType = 0;
        this.sExif_CameraMaker = "";
        this.sExif_CameraModel = "";
        this.sExif_Time = "";
        this.sExif_LatitudeRef = "";
        this.sExif_Latitude = "";
        this.sExif_LongitudeRef = "";
        this.sExif_Longitude = "";
        this.iNeedFeeds = 0;
        this.iUploadTime = 0L;
        this.mapExt = null;
        this.iDistinctUse = 0;
        this.uploadPoi = null;
        this.waterTemplate = null;
        this.otherParams = "";
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.stExternalMapExt = null;
        this.ExternalData = null;
        this.resource_type = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sPicTitle = jceInputStream.readString(0, false);
        this.sPicDesc = jceInputStream.readString(1, false);
        this.sAlbumName = jceInputStream.readString(2, false);
        this.sAlbumID = jceInputStream.readString(3, false);
        this.iAlbumTypeID = jceInputStream.read(this.iAlbumTypeID, 4, false);
        this.iBitmap = jceInputStream.read(this.iBitmap, 5, false);
        this.iUploadType = jceInputStream.read(this.iUploadType, 6, false);
        this.iUpPicType = jceInputStream.read(this.iUpPicType, 7, false);
        this.iBatchID = jceInputStream.read(this.iBatchID, 8, false);
        this.mutliPicInfo = (MultiPicInfo) jceInputStream.read((JceStruct) cache_mutliPicInfo, 9, false);
        this.stExtendInfo = (PicExtendInfo) jceInputStream.read((JceStruct) cache_stExtendInfo, 10, false);
        this.sPicPath = jceInputStream.readString(11, false);
        this.iPicWidth = jceInputStream.read(this.iPicWidth, 12, false);
        this.iPicHight = jceInputStream.read(this.iPicHight, 13, false);
        this.iWaterType = jceInputStream.read(this.iWaterType, 14, false);
        this.sExif_CameraMaker = jceInputStream.readString(15, false);
        this.sExif_CameraModel = jceInputStream.readString(16, false);
        this.sExif_Time = jceInputStream.readString(17, false);
        this.sExif_LatitudeRef = jceInputStream.readString(18, false);
        this.sExif_Latitude = jceInputStream.readString(19, false);
        this.sExif_LongitudeRef = jceInputStream.readString(20, false);
        this.sExif_Longitude = jceInputStream.readString(21, false);
        this.iNeedFeeds = jceInputStream.read(this.iNeedFeeds, 22, false);
        this.iUploadTime = jceInputStream.read(this.iUploadTime, 23, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 24, false);
        this.iDistinctUse = jceInputStream.read(this.iDistinctUse, 25, false);
        this.uploadPoi = (stPoi) jceInputStream.read((JceStruct) cache_uploadPoi, 26, false);
        this.waterTemplate = (stWaterTemplate) jceInputStream.read((JceStruct) cache_waterTemplate, 27, false);
        this.otherParams = jceInputStream.readString(28, false);
        this.iBusiNessType = jceInputStream.read(this.iBusiNessType, 29, false);
        this.vBusiNessData = jceInputStream.read(cache_vBusiNessData, 30, false);
        this.stExternalMapExt = (Map) jceInputStream.read((JceInputStream) cache_stExternalMapExt, 31, false);
        this.ExternalData = (Map) jceInputStream.read((JceInputStream) cache_ExternalData, 32, false);
        this.resource_type = jceInputStream.read(this.resource_type, 33, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sPicTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sPicDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sAlbumName;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.sAlbumID;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.iAlbumTypeID, 4);
        jceOutputStream.write(this.iBitmap, 5);
        jceOutputStream.write(this.iUploadType, 6);
        jceOutputStream.write(this.iUpPicType, 7);
        jceOutputStream.write(this.iBatchID, 8);
        MultiPicInfo multiPicInfo = this.mutliPicInfo;
        if (multiPicInfo != null) {
            jceOutputStream.write((JceStruct) multiPicInfo, 9);
        }
        PicExtendInfo picExtendInfo = this.stExtendInfo;
        if (picExtendInfo != null) {
            jceOutputStream.write((JceStruct) picExtendInfo, 10);
        }
        String str5 = this.sPicPath;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        jceOutputStream.write(this.iPicWidth, 12);
        jceOutputStream.write(this.iPicHight, 13);
        jceOutputStream.write(this.iWaterType, 14);
        String str6 = this.sExif_CameraMaker;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        String str7 = this.sExif_CameraModel;
        if (str7 != null) {
            jceOutputStream.write(str7, 16);
        }
        String str8 = this.sExif_Time;
        if (str8 != null) {
            jceOutputStream.write(str8, 17);
        }
        String str9 = this.sExif_LatitudeRef;
        if (str9 != null) {
            jceOutputStream.write(str9, 18);
        }
        String str10 = this.sExif_Latitude;
        if (str10 != null) {
            jceOutputStream.write(str10, 19);
        }
        String str11 = this.sExif_LongitudeRef;
        if (str11 != null) {
            jceOutputStream.write(str11, 20);
        }
        String str12 = this.sExif_Longitude;
        if (str12 != null) {
            jceOutputStream.write(str12, 21);
        }
        jceOutputStream.write(this.iNeedFeeds, 22);
        jceOutputStream.write(this.iUploadTime, 23);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 24);
        }
        jceOutputStream.write(this.iDistinctUse, 25);
        stPoi stpoi = this.uploadPoi;
        if (stpoi != null) {
            jceOutputStream.write((JceStruct) stpoi, 26);
        }
        stWaterTemplate stwatertemplate = this.waterTemplate;
        if (stwatertemplate != null) {
            jceOutputStream.write((JceStruct) stwatertemplate, 27);
        }
        String str13 = this.otherParams;
        if (str13 != null) {
            jceOutputStream.write(str13, 28);
        }
        jceOutputStream.write(this.iBusiNessType, 29);
        byte[] bArr = this.vBusiNessData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 30);
        }
        Map<String, String> map2 = this.stExternalMapExt;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 31);
        }
        Map<String, byte[]> map3 = this.ExternalData;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 32);
        }
        jceOutputStream.write(this.resource_type, 33);
    }

    public UploadPicInfoReq(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, long j3, MultiPicInfo multiPicInfo, PicExtendInfo picExtendInfo, String str5, int i19, int i26, int i27, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i28, long j16, Map<String, String> map, int i29, stPoi stpoi, stWaterTemplate stwatertemplate, String str13, int i36, byte[] bArr, Map<String, String> map2, Map<String, byte[]> map3, int i37) {
        this.sPicTitle = str;
        this.sPicDesc = str2;
        this.sAlbumName = str3;
        this.sAlbumID = str4;
        this.iAlbumTypeID = i3;
        this.iBitmap = i16;
        this.iUploadType = i17;
        this.iUpPicType = i18;
        this.iBatchID = j3;
        this.mutliPicInfo = multiPicInfo;
        this.stExtendInfo = picExtendInfo;
        this.sPicPath = str5;
        this.iPicWidth = i19;
        this.iPicHight = i26;
        this.iWaterType = i27;
        this.sExif_CameraMaker = str6;
        this.sExif_CameraModel = str7;
        this.sExif_Time = str8;
        this.sExif_LatitudeRef = str9;
        this.sExif_Latitude = str10;
        this.sExif_LongitudeRef = str11;
        this.sExif_Longitude = str12;
        this.iNeedFeeds = i28;
        this.iUploadTime = j16;
        this.mapExt = map;
        this.iDistinctUse = i29;
        this.uploadPoi = stpoi;
        this.waterTemplate = stwatertemplate;
        this.otherParams = str13;
        this.iBusiNessType = i36;
        this.vBusiNessData = bArr;
        this.stExternalMapExt = map2;
        this.ExternalData = map3;
        this.resource_type = i37;
    }
}
