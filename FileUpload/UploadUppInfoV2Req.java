package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadUppInfoV2Req extends JceStruct {
    static stPhotoSepcInfo cache_PhotoSpecInfo = new stPhotoSepcInfo();
    static Map<String, String> cache_mapExt;
    static MultiPicInfo cache_mutlipicinfo;
    public stPhotoSepcInfo PhotoSpecInfo;
    public long iBatchID;
    public int iPhotoType;
    public int iType;
    public long iUploadIp;
    public Map<String, String> mapExt;
    public MultiPicInfo mutlipicinfo;
    public String sAlbumId;
    public String sAppId;
    public String sDesc;
    public String sPicPath;
    public String sTitle;
    public String sUserId;

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        cache_mutlipicinfo = new MultiPicInfo();
    }

    public UploadUppInfoV2Req() {
        this.sAppId = "";
        this.sUserId = "";
        this.sAlbumId = "";
        this.sTitle = "";
        this.sDesc = "";
        this.iType = 0;
        this.iUploadIp = 0L;
        this.PhotoSpecInfo = null;
        this.mapExt = null;
        this.sPicPath = "";
        this.iBatchID = 0L;
        this.mutlipicinfo = null;
        this.iPhotoType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sAppId = jceInputStream.readString(0, true);
        this.sUserId = jceInputStream.readString(1, true);
        this.sAlbumId = jceInputStream.readString(2, true);
        this.sTitle = jceInputStream.readString(3, true);
        this.sDesc = jceInputStream.readString(4, true);
        this.iType = jceInputStream.read(this.iType, 5, true);
        this.iUploadIp = jceInputStream.read(this.iUploadIp, 6, true);
        this.PhotoSpecInfo = (stPhotoSepcInfo) jceInputStream.read((JceStruct) cache_PhotoSpecInfo, 7, true);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 8, false);
        this.sPicPath = jceInputStream.readString(9, false);
        this.iBatchID = jceInputStream.read(this.iBatchID, 10, false);
        this.mutlipicinfo = (MultiPicInfo) jceInputStream.read((JceStruct) cache_mutlipicinfo, 11, false);
        this.iPhotoType = jceInputStream.read(this.iPhotoType, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sAppId, 0);
        jceOutputStream.write(this.sUserId, 1);
        jceOutputStream.write(this.sAlbumId, 2);
        jceOutputStream.write(this.sTitle, 3);
        jceOutputStream.write(this.sDesc, 4);
        jceOutputStream.write(this.iType, 5);
        jceOutputStream.write(this.iUploadIp, 6);
        jceOutputStream.write((JceStruct) this.PhotoSpecInfo, 7);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        String str = this.sPicPath;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        jceOutputStream.write(this.iBatchID, 10);
        MultiPicInfo multiPicInfo = this.mutlipicinfo;
        if (multiPicInfo != null) {
            jceOutputStream.write((JceStruct) multiPicInfo, 11);
        }
        jceOutputStream.write(this.iPhotoType, 12);
    }

    public UploadUppInfoV2Req(String str, String str2, String str3, String str4, String str5, int i3, long j3, stPhotoSepcInfo stphotosepcinfo, Map<String, String> map, String str6, long j16, MultiPicInfo multiPicInfo, int i16) {
        this.sAppId = str;
        this.sUserId = str2;
        this.sAlbumId = str3;
        this.sTitle = str4;
        this.sDesc = str5;
        this.iType = i3;
        this.iUploadIp = j3;
        this.PhotoSpecInfo = stphotosepcinfo;
        this.mapExt = map;
        this.sPicPath = str6;
        this.iBatchID = j16;
        this.mutlipicinfo = multiPicInfo;
        this.iPhotoType = i16;
    }
}
