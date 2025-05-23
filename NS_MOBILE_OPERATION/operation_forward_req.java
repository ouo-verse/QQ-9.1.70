package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class operation_forward_req extends JceStruct {
    public static final String XCX_MAPEX_KEY_APPID = "xcxAppId";
    public static final String XCX_MAPEX_KEY_FAKE_LINK = "xcxFakeLink";
    public static final String XCX_MAPEX_KEY_PATH = "xcxPath";
    public static final String XCX_MAPEX_KEY_SOURCE_TYPE = "xcxSourceType";
    static Map<Integer, String> cache_busi_param;
    static Map<String, ArrayList<String>> cache_photoids;
    static share_tail_info cache_sharetailinfo;
    static ArrayList<String> cache_srcImages;
    static ArrayList<String> cache_srcSubid;
    static Map<String, String> cache_stored_extend_info;
    static Map<String, String> cache_xcxMapEx;
    public int appid;
    public Map<Integer, String> busi_param;
    public String category;
    public String ciphertext;
    public String dstAlbumId;
    public int dstAlbumType;
    public int iUrlInfoFrm;
    public int isverified;
    public int operatemask;
    public long ownUin;
    public Map<String, ArrayList<String>> photoids;
    public String reason;
    public share_tail_info sharetailinfo;
    public int source;
    public String srcAbstract;
    public String srcId;
    public ArrayList<String> srcImages;
    public int srcPicNum;
    public ArrayList<String> srcSubid;
    public String srcTitle;
    public Map<String, String> stored_extend_info;
    public int subid;
    public long uin;
    public Map<String, String> xcxMapEx;
    public int xcxZZType;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_srcSubid = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_srcImages = arrayList2;
        arrayList2.add("");
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_photoids = new HashMap();
        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("");
        cache_photoids.put("", arrayList3);
        HashMap hashMap = new HashMap();
        cache_xcxMapEx = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_stored_extend_info = hashMap2;
        hashMap2.put("", "");
        cache_sharetailinfo = new share_tail_info();
    }

    public operation_forward_req() {
        this.appid = 0;
        this.subid = 0;
        this.uin = 0L;
        this.ownUin = 0L;
        this.srcId = "";
        this.srcSubid = null;
        this.reason = "";
        this.srcTitle = "";
        this.srcAbstract = "";
        this.srcImages = null;
        this.srcPicNum = 0;
        this.source = 0;
        this.isverified = 0;
        this.category = "";
        this.operatemask = 0;
        this.dstAlbumId = "";
        this.dstAlbumType = 0;
        this.busi_param = null;
        this.photoids = null;
        this.iUrlInfoFrm = 0;
        this.ciphertext = "";
        this.xcxZZType = 0;
        this.xcxMapEx = null;
        this.stored_extend_info = null;
        this.sharetailinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.subid = jceInputStream.read(this.subid, 1, false);
        this.uin = jceInputStream.read(this.uin, 2, false);
        this.ownUin = jceInputStream.read(this.ownUin, 3, false);
        this.srcId = jceInputStream.readString(4, false);
        this.srcSubid = (ArrayList) jceInputStream.read((JceInputStream) cache_srcSubid, 5, false);
        this.reason = jceInputStream.readString(6, false);
        this.srcTitle = jceInputStream.readString(7, false);
        this.srcAbstract = jceInputStream.readString(8, false);
        this.srcImages = (ArrayList) jceInputStream.read((JceInputStream) cache_srcImages, 9, false);
        this.srcPicNum = jceInputStream.read(this.srcPicNum, 10, false);
        this.source = jceInputStream.read(this.source, 11, false);
        this.isverified = jceInputStream.read(this.isverified, 12, false);
        this.category = jceInputStream.readString(13, false);
        this.operatemask = jceInputStream.read(this.operatemask, 14, false);
        this.dstAlbumId = jceInputStream.readString(15, false);
        this.dstAlbumType = jceInputStream.read(this.dstAlbumType, 16, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 17, false);
        this.photoids = (Map) jceInputStream.read((JceInputStream) cache_photoids, 18, false);
        this.iUrlInfoFrm = jceInputStream.read(this.iUrlInfoFrm, 19, false);
        this.ciphertext = jceInputStream.readString(20, false);
        this.xcxZZType = jceInputStream.read(this.xcxZZType, 21, false);
        this.xcxMapEx = (Map) jceInputStream.read((JceInputStream) cache_xcxMapEx, 22, false);
        this.stored_extend_info = (Map) jceInputStream.read((JceInputStream) cache_stored_extend_info, 23, false);
        this.sharetailinfo = (share_tail_info) jceInputStream.read((JceStruct) cache_sharetailinfo, 24, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.subid, 1);
        jceOutputStream.write(this.uin, 2);
        jceOutputStream.write(this.ownUin, 3);
        String str = this.srcId;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        ArrayList<String> arrayList = this.srcSubid;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        String str2 = this.reason;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        String str3 = this.srcTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        String str4 = this.srcAbstract;
        if (str4 != null) {
            jceOutputStream.write(str4, 8);
        }
        ArrayList<String> arrayList2 = this.srcImages;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
        jceOutputStream.write(this.srcPicNum, 10);
        jceOutputStream.write(this.source, 11);
        jceOutputStream.write(this.isverified, 12);
        String str5 = this.category;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        jceOutputStream.write(this.operatemask, 14);
        String str6 = this.dstAlbumId;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        jceOutputStream.write(this.dstAlbumType, 16);
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 17);
        }
        Map<String, ArrayList<String>> map2 = this.photoids;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 18);
        }
        jceOutputStream.write(this.iUrlInfoFrm, 19);
        String str7 = this.ciphertext;
        if (str7 != null) {
            jceOutputStream.write(str7, 20);
        }
        jceOutputStream.write(this.xcxZZType, 21);
        Map<String, String> map3 = this.xcxMapEx;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 22);
        }
        Map<String, String> map4 = this.stored_extend_info;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 23);
        }
        share_tail_info share_tail_infoVar = this.sharetailinfo;
        if (share_tail_infoVar != null) {
            jceOutputStream.write((JceStruct) share_tail_infoVar, 24);
        }
    }

    public operation_forward_req(int i3, int i16, long j3, long j16, String str, ArrayList<String> arrayList, String str2, String str3, String str4, ArrayList<String> arrayList2, int i17, int i18, int i19, String str5, int i26, String str6, int i27, Map<Integer, String> map, Map<String, ArrayList<String>> map2, int i28, String str7, int i29, Map<String, String> map3, Map<String, String> map4, share_tail_info share_tail_infoVar) {
        this.appid = i3;
        this.subid = i16;
        this.uin = j3;
        this.ownUin = j16;
        this.srcId = str;
        this.srcSubid = arrayList;
        this.reason = str2;
        this.srcTitle = str3;
        this.srcAbstract = str4;
        this.srcImages = arrayList2;
        this.srcPicNum = i17;
        this.source = i18;
        this.isverified = i19;
        this.category = str5;
        this.operatemask = i26;
        this.dstAlbumId = str6;
        this.dstAlbumType = i27;
        this.busi_param = map;
        this.photoids = map2;
        this.iUrlInfoFrm = i28;
        this.ciphertext = str7;
        this.xcxZZType = i29;
        this.xcxMapEx = map3;
        this.stored_extend_info = map4;
        this.sharetailinfo = share_tail_infoVar;
    }
}
