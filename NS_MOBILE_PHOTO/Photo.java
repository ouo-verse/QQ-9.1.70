package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.cell_colorful_tail;
import NS_MOBILE_FEEDS.cell_video;
import NS_MOBILE_FEEDS.stFaceItem;
import NS_MOBILE_FEEDS.stPhotoTag;
import NS_MOBILE_FEEDS.stPoi;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.pic_host;

/* loaded from: classes.dex */
public final class Photo extends JceStruct {
    static Map<String, byte[]> cache_binaryExtInfo;
    static Map<Integer, String> cache_busi_param = new HashMap();
    static stFaceInfo cache_face_info;
    static ArrayList<stFaceItem> cache_facelist;
    static stLabelInfo cache_label_info;
    static Map<Integer, String> cache_mapExifInfo;
    static Map<String, String> cache_mapExtern;
    static Map<Integer, String> cache_mapOcrInfo;
    static cell_colorful_tail cache_material_info;
    static ArrayList<stPhotoTag> cache_photoTag;
    static pic_host cache_pic_host_nick;
    static Map<Integer, Integer> cache_pics_enlargerate;
    static s_outshare cache_share_info;
    static stPoi cache_shoot_place_info;
    static Map<Integer, String> cache_shouzhang_extend_map;
    static cell_video cache_videodata;
    public String albumid;
    public String bigurl;
    public Map<String, byte[]> binaryExtInfo;
    public Map<Integer, String> busi_param;
    public String client_key;
    public int cmtnum;
    public String curkey;
    public String currenturl;
    public String desc;
    public String downloadURL;
    public stFaceInfo face_info;
    public ArrayList<stFaceItem> facelist;
    public int flag;
    public int height;
    public int isIndependentUgc;
    public boolean is_show_repair;
    public stLabelInfo label_info;
    public int likenum;
    public String lloc;
    public Map<Integer, String> mapExifInfo;
    public Map<String, String> mapExtern;
    public Map<Integer, String> mapOcrInfo;
    public cell_colorful_tail material_info;
    public String midurl;
    public int modifytime;
    public byte mylike;
    public String name;
    public byte opmask;
    public int opsynflag;
    public long origin_size;
    public ArrayList<stPhotoTag> photoTag;
    public String photo_visitor_ugc_key;
    public pic_host pic_host_nick;
    public Map<Integer, Integer> pics_enlargerate;
    public int quanflag;
    public long raw;
    public long raw_height;
    public long raw_width;
    public s_outshare share_info;
    public stPoi shoot_place_info;
    public int shoottime;
    public Map<Integer, String> shouzhang_extend_map;
    public String sloc;
    public String smallurl;
    public String thumburl;
    public int trannum;
    public int type;
    public long uin;
    public String unikey;
    public int uploadtime;
    public String url;
    public cell_video videodata;
    public int videoflag;
    public long view_count;
    public int width;

    static {
        cache_busi_param.put(0, "");
        cache_pics_enlargerate = new HashMap();
        cache_pics_enlargerate.put(0, 0);
        cache_photoTag = new ArrayList<>();
        cache_photoTag.add(new stPhotoTag());
        cache_videodata = new cell_video();
        cache_pic_host_nick = new pic_host();
        cache_share_info = new s_outshare();
        cache_shoot_place_info = new stPoi();
        cache_face_info = new stFaceInfo();
        cache_label_info = new stLabelInfo();
        cache_facelist = new ArrayList<>();
        cache_facelist.add(new stFaceItem());
        cache_mapExifInfo = new HashMap();
        cache_mapExifInfo.put(0, "");
        cache_mapOcrInfo = new HashMap();
        cache_mapOcrInfo.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapExtern = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_binaryExtInfo = hashMap2;
        hashMap2.put("", new byte[]{0});
        cache_shouzhang_extend_map = new HashMap();
        cache_shouzhang_extend_map.put(0, "");
        cache_material_info = new cell_colorful_tail();
    }

    public Photo() {
        this.uin = 0L;
        this.lloc = "";
        this.sloc = "";
        this.name = "";
        this.desc = "";
        this.uploadtime = 0;
        this.modifytime = 0;
        this.width = 0;
        this.height = 0;
        this.url = "";
        this.bigurl = "";
        this.smallurl = "";
        this.cmtnum = 0;
        this.likenum = 0;
        this.mylike = (byte) 0;
        this.trannum = 0;
        this.unikey = "";
        this.curkey = "";
        this.midurl = "";
        this.thumburl = "";
        this.busi_param = null;
        this.type = 0;
        this.isIndependentUgc = 0;
        this.opsynflag = 0;
        this.quanflag = 0;
        this.raw = 0L;
        this.currenturl = "";
        this.pics_enlargerate = null;
        this.photoTag = null;
        this.opmask = (byte) 7;
        this.shoottime = 0;
        this.flag = 0;
        this.albumid = "";
        this.videoflag = 0;
        this.videodata = null;
        this.pic_host_nick = null;
        this.share_info = null;
        this.view_count = 0L;
        this.photo_visitor_ugc_key = "";
        this.client_key = "";
        this.shoot_place_info = null;
        this.face_info = null;
        this.label_info = null;
        this.facelist = null;
        this.origin_size = 0L;
        this.mapExifInfo = null;
        this.mapOcrInfo = null;
        this.mapExtern = null;
        this.raw_width = 0L;
        this.raw_height = 0L;
        this.binaryExtInfo = null;
        this.shouzhang_extend_map = null;
        this.downloadURL = "";
        this.is_show_repair = false;
        this.material_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.lloc = jceInputStream.readString(1, true);
        this.sloc = jceInputStream.readString(2, true);
        this.name = jceInputStream.readString(3, true);
        this.desc = jceInputStream.readString(4, true);
        this.uploadtime = jceInputStream.read(this.uploadtime, 5, true);
        this.modifytime = jceInputStream.read(this.modifytime, 6, true);
        this.width = jceInputStream.read(this.width, 7, true);
        this.height = jceInputStream.read(this.height, 8, true);
        this.url = jceInputStream.readString(9, true);
        this.bigurl = jceInputStream.readString(10, true);
        this.smallurl = jceInputStream.readString(11, true);
        this.cmtnum = jceInputStream.read(this.cmtnum, 12, true);
        this.likenum = jceInputStream.read(this.likenum, 13, true);
        this.mylike = jceInputStream.read(this.mylike, 14, true);
        this.trannum = jceInputStream.read(this.trannum, 15, true);
        this.unikey = jceInputStream.readString(16, false);
        this.curkey = jceInputStream.readString(17, false);
        this.midurl = jceInputStream.readString(18, false);
        this.thumburl = jceInputStream.readString(19, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 20, false);
        this.type = jceInputStream.read(this.type, 21, false);
        this.isIndependentUgc = jceInputStream.read(this.isIndependentUgc, 22, false);
        this.opsynflag = jceInputStream.read(this.opsynflag, 23, false);
        this.quanflag = jceInputStream.read(this.quanflag, 24, false);
        this.raw = jceInputStream.read(this.raw, 25, false);
        this.currenturl = jceInputStream.readString(26, false);
        this.pics_enlargerate = (Map) jceInputStream.read((JceInputStream) cache_pics_enlargerate, 27, false);
        this.photoTag = (ArrayList) jceInputStream.read((JceInputStream) cache_photoTag, 28, false);
        this.opmask = jceInputStream.read(this.opmask, 29, false);
        this.shoottime = jceInputStream.read(this.shoottime, 30, false);
        this.flag = jceInputStream.read(this.flag, 31, false);
        this.albumid = jceInputStream.readString(32, false);
        this.videoflag = jceInputStream.read(this.videoflag, 33, false);
        this.videodata = (cell_video) jceInputStream.read((JceStruct) cache_videodata, 34, false);
        this.pic_host_nick = (pic_host) jceInputStream.read((JceStruct) cache_pic_host_nick, 35, false);
        this.share_info = (s_outshare) jceInputStream.read((JceStruct) cache_share_info, 36, false);
        this.view_count = jceInputStream.read(this.view_count, 37, false);
        this.photo_visitor_ugc_key = jceInputStream.readString(38, false);
        this.client_key = jceInputStream.readString(39, false);
        this.shoot_place_info = (stPoi) jceInputStream.read((JceStruct) cache_shoot_place_info, 40, false);
        this.face_info = (stFaceInfo) jceInputStream.read((JceStruct) cache_face_info, 41, false);
        this.label_info = (stLabelInfo) jceInputStream.read((JceStruct) cache_label_info, 42, false);
        this.facelist = (ArrayList) jceInputStream.read((JceInputStream) cache_facelist, 43, false);
        this.origin_size = jceInputStream.read(this.origin_size, 44, false);
        this.mapExifInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExifInfo, 45, false);
        this.mapOcrInfo = (Map) jceInputStream.read((JceInputStream) cache_mapOcrInfo, 46, false);
        this.mapExtern = (Map) jceInputStream.read((JceInputStream) cache_mapExtern, 47, false);
        this.raw_width = jceInputStream.read(this.raw_width, 48, false);
        this.raw_height = jceInputStream.read(this.raw_height, 49, false);
        this.binaryExtInfo = (Map) jceInputStream.read((JceInputStream) cache_binaryExtInfo, 50, false);
        this.shouzhang_extend_map = (Map) jceInputStream.read((JceInputStream) cache_shouzhang_extend_map, 51, false);
        this.downloadURL = jceInputStream.read(this.downloadURL, 52, false);
        this.is_show_repair = jceInputStream.read(this.is_show_repair, 53, false);
        this.material_info = (cell_colorful_tail) jceInputStream.read((JceStruct) cache_material_info, 54, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.lloc, 1);
        jceOutputStream.write(this.sloc, 2);
        jceOutputStream.write(this.name, 3);
        jceOutputStream.write(this.desc, 4);
        jceOutputStream.write(this.uploadtime, 5);
        jceOutputStream.write(this.modifytime, 6);
        jceOutputStream.write(this.width, 7);
        jceOutputStream.write(this.height, 8);
        jceOutputStream.write(this.url, 9);
        jceOutputStream.write(this.bigurl, 10);
        jceOutputStream.write(this.smallurl, 11);
        jceOutputStream.write(this.cmtnum, 12);
        jceOutputStream.write(this.likenum, 13);
        jceOutputStream.write(this.mylike, 14);
        jceOutputStream.write(this.trannum, 15);
        String str = this.unikey;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        String str2 = this.curkey;
        if (str2 != null) {
            jceOutputStream.write(str2, 17);
        }
        String str3 = this.midurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 18);
        }
        String str4 = this.thumburl;
        if (str4 != null) {
            jceOutputStream.write(str4, 19);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 20);
        }
        jceOutputStream.write(this.type, 21);
        jceOutputStream.write(this.isIndependentUgc, 22);
        jceOutputStream.write(this.opsynflag, 23);
        jceOutputStream.write(this.quanflag, 24);
        jceOutputStream.write(this.raw, 25);
        String str5 = this.currenturl;
        if (str5 != null) {
            jceOutputStream.write(str5, 26);
        }
        Map<Integer, Integer> map2 = this.pics_enlargerate;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 27);
        }
        ArrayList<stPhotoTag> arrayList = this.photoTag;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 28);
        }
        jceOutputStream.write(this.opmask, 29);
        jceOutputStream.write(this.shoottime, 30);
        jceOutputStream.write(this.flag, 31);
        String str6 = this.albumid;
        if (str6 != null) {
            jceOutputStream.write(str6, 32);
        }
        jceOutputStream.write(this.videoflag, 33);
        cell_video cell_videoVar = this.videodata;
        if (cell_videoVar != null) {
            jceOutputStream.write((JceStruct) cell_videoVar, 34);
        }
        pic_host pic_hostVar = this.pic_host_nick;
        if (pic_hostVar != null) {
            jceOutputStream.write((JceStruct) pic_hostVar, 35);
        }
        s_outshare s_outshareVar = this.share_info;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 36);
        }
        jceOutputStream.write(this.view_count, 37);
        String str7 = this.photo_visitor_ugc_key;
        if (str7 != null) {
            jceOutputStream.write(str7, 38);
        }
        String str8 = this.client_key;
        if (str8 != null) {
            jceOutputStream.write(str8, 39);
        }
        stPoi stpoi = this.shoot_place_info;
        if (stpoi != null) {
            jceOutputStream.write((JceStruct) stpoi, 40);
        }
        stFaceInfo stfaceinfo = this.face_info;
        if (stfaceinfo != null) {
            jceOutputStream.write((JceStruct) stfaceinfo, 41);
        }
        stLabelInfo stlabelinfo = this.label_info;
        if (stlabelinfo != null) {
            jceOutputStream.write((JceStruct) stlabelinfo, 42);
        }
        ArrayList<stFaceItem> arrayList2 = this.facelist;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 43);
        }
        jceOutputStream.write(this.origin_size, 44);
        Map<Integer, String> map3 = this.mapExifInfo;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 45);
        }
        Map<Integer, String> map4 = this.mapOcrInfo;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 46);
        }
        Map<String, String> map5 = this.mapExtern;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 47);
        }
        jceOutputStream.write(this.raw_width, 48);
        jceOutputStream.write(this.raw_height, 49);
        Map<String, byte[]> map6 = this.binaryExtInfo;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 50);
        }
        Map<Integer, String> map7 = this.shouzhang_extend_map;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 51);
        }
        String str9 = this.downloadURL;
        if (str9 != null) {
            jceOutputStream.write(str9, 52);
        }
        jceOutputStream.write(this.is_show_repair, 53);
        cell_colorful_tail cell_colorful_tailVar = this.material_info;
        if (cell_colorful_tailVar != null) {
            jceOutputStream.write((JceStruct) cell_colorful_tailVar, 54);
        }
    }

    public Photo(long j3, String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, String str5, String str6, String str7, int i19, int i26, byte b16, int i27, String str8, String str9, String str10, String str11, Map<Integer, String> map, int i28, int i29, int i36, int i37, long j16, String str12, Map<Integer, Integer> map2, ArrayList<stPhotoTag> arrayList, byte b17, int i38, int i39, String str13, int i46, cell_video cell_videoVar, pic_host pic_hostVar, s_outshare s_outshareVar, long j17, String str14, String str15, stPoi stpoi, stFaceInfo stfaceinfo, stLabelInfo stlabelinfo, ArrayList<stFaceItem> arrayList2, long j18, Map<Integer, String> map3, Map<Integer, String> map4, Map<String, String> map5, long j19, long j26, Map<String, byte[]> map6, Map<Integer, String> map7, String str16, boolean z16, cell_colorful_tail cell_colorful_tailVar) {
        this.uin = j3;
        this.lloc = str;
        this.sloc = str2;
        this.name = str3;
        this.desc = str4;
        this.uploadtime = i3;
        this.modifytime = i16;
        this.width = i17;
        this.height = i18;
        this.url = str5;
        this.bigurl = str6;
        this.smallurl = str7;
        this.cmtnum = i19;
        this.likenum = i26;
        this.mylike = b16;
        this.trannum = i27;
        this.unikey = str8;
        this.curkey = str9;
        this.midurl = str10;
        this.thumburl = str11;
        this.busi_param = map;
        this.type = i28;
        this.isIndependentUgc = i29;
        this.opsynflag = i36;
        this.quanflag = i37;
        this.raw = j16;
        this.currenturl = str12;
        this.pics_enlargerate = map2;
        this.photoTag = arrayList;
        this.opmask = b17;
        this.shoottime = i38;
        this.flag = i39;
        this.albumid = str13;
        this.videoflag = i46;
        this.videodata = cell_videoVar;
        this.pic_host_nick = pic_hostVar;
        this.share_info = s_outshareVar;
        this.view_count = j17;
        this.photo_visitor_ugc_key = str14;
        this.client_key = str15;
        this.shoot_place_info = stpoi;
        this.face_info = stfaceinfo;
        this.label_info = stlabelinfo;
        this.facelist = arrayList2;
        this.origin_size = j18;
        this.mapExifInfo = map3;
        this.mapOcrInfo = map4;
        this.mapExtern = map5;
        this.raw_width = j19;
        this.raw_height = j26;
        this.binaryExtInfo = map6;
        this.shouzhang_extend_map = map7;
        this.downloadURL = str16;
        this.is_show_repair = z16;
        this.material_info = cell_colorful_tailVar;
    }
}
