package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_picdata extends JceStruct {
    static Map<String, byte[]> cache_binaryExtInfo;
    static Map<Integer, String> cache_busi_param;
    static s_imgcrop cache_cropinfo;
    static ArrayList<stFaceItem> cache_facelist;
    static ArrayList<stFaceItem> cache_facelist_info;
    static stPoi cache_geo;
    static s_LabelInfo cache_label_info;
    static Map<Integer, String> cache_mapExifInfo;
    static Map<String, String> cache_mapExtern;
    static Map<Integer, String> cache_mapOcrInfo;
    static cell_music cache_musicdata;
    static cell_operation cache_operation;
    static ArrayList<stPhotoTag> cache_photoTag;
    static Map<Integer, s_picurl> cache_photourl = new HashMap();
    static s_pic_host cache_pic_host_nick;
    static stPoi cache_poi;
    static Map<Integer, String> cache_shouzhang_extend_map;
    static ArrayList<showdrying_taginfo> cache_vecShowDryingTagInfo;
    static cell_video cache_videodata;
    public String albumid;
    public String audio_summary;
    public long batchid;
    public Map<String, byte[]> binaryExtInfo;
    public Map<Integer, String> busi_param;
    public String clientkey;
    public int commentcount;
    public s_imgcrop cropinfo;
    public String curlikekey;
    public String desc;
    public ArrayList<stFaceItem> facelist;
    public ArrayList<stFaceItem> facelist_info;
    public String fashion_tag_key;
    public int flag;
    public stPoi geo;
    public boolean isAutoPlayGif;
    public boolean isCoverPic;
    public int isIndependentUgc;
    public boolean ismylike;
    public s_LabelInfo label_info;
    public int likecount;
    public String lloc;
    public String luckyMoneyDesc;
    public Map<Integer, String> mapExifInfo;
    public Map<String, String> mapExtern;
    public Map<Integer, String> mapOcrInfo;
    public long modifytime;
    public cell_music musicdata;
    public cell_operation operation;
    public byte opmask;
    public int opsynflag;
    public String orglikekey;
    public long origin_height;
    public long origin_phototype;
    public long origin_size;
    public long origin_width;
    public ArrayList<stPhotoTag> photoTag;
    public Map<Integer, s_picurl> photourl;
    public s_pic_host pic_host_nick;
    public int piccategory;
    public String picname;
    public stPoi poi;
    public String quankey;
    public int raw;
    public String realLloc;
    public int shoottime;
    public Map<Integer, String> shouzhang_extend_map;
    public String sloc;
    public int type;
    public long uUploadTime;
    public long uploadUin;
    public ArrayList<showdrying_taginfo> vecShowDryingTagInfo;
    public cell_video videodata;
    public int videoflag;
    public int view_cnt;

    static {
        cache_photourl.put(0, new s_picurl());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_cropinfo = new s_imgcrop();
        cache_poi = new stPoi();
        cache_facelist = new ArrayList<>();
        cache_facelist.add(new stFaceItem());
        cache_photoTag = new ArrayList<>();
        cache_photoTag.add(new stPhotoTag());
        cache_videodata = new cell_video();
        cache_pic_host_nick = new s_pic_host();
        cache_geo = new stPoi();
        cache_operation = new cell_operation();
        cache_musicdata = new cell_music();
        HashMap hashMap = new HashMap();
        cache_binaryExtInfo = hashMap;
        hashMap.put("", new byte[]{0});
        cache_vecShowDryingTagInfo = new ArrayList<>();
        cache_vecShowDryingTagInfo.add(new showdrying_taginfo());
        cache_shouzhang_extend_map = new HashMap();
        cache_shouzhang_extend_map.put(0, "");
        cache_label_info = new s_LabelInfo();
        cache_facelist_info = new ArrayList<>();
        cache_facelist_info.add(new stFaceItem());
        cache_mapOcrInfo = new HashMap();
        cache_mapOcrInfo.put(0, "");
        cache_mapExifInfo = new HashMap();
        cache_mapExifInfo.put(0, "");
        HashMap hashMap2 = new HashMap();
        cache_mapExtern = hashMap2;
        hashMap2.put("", "");
    }

    public s_picdata() {
        this.picname = "";
        this.sloc = "";
        this.lloc = "";
        this.photourl = null;
        this.type = 0;
        this.ismylike = false;
        this.likecount = 0;
        this.commentcount = 0;
        this.busi_param = null;
        this.clientkey = "";
        this.isIndependentUgc = 0;
        this.opsynflag = 0;
        this.uUploadTime = 0L;
        this.modifytime = 0L;
        this.desc = "";
        this.orglikekey = "";
        this.curlikekey = "";
        this.cropinfo = null;
        this.uploadUin = 0L;
        this.shoottime = 0;
        this.flag = 0;
        this.poi = null;
        this.facelist = null;
        this.raw = 0;
        this.isAutoPlayGif = false;
        this.photoTag = null;
        this.opmask = (byte) 7;
        this.albumid = "";
        this.piccategory = 0;
        this.videoflag = 0;
        this.videodata = null;
        this.isCoverPic = false;
        this.pic_host_nick = null;
        this.luckyMoneyDesc = "";
        this.geo = null;
        this.operation = null;
        this.musicdata = null;
        this.audio_summary = "";
        this.batchid = 0L;
        this.quankey = "";
        this.origin_size = 0L;
        this.origin_width = 0L;
        this.origin_height = 0L;
        this.origin_phototype = 0L;
        this.binaryExtInfo = null;
        this.vecShowDryingTagInfo = null;
        this.fashion_tag_key = "";
        this.shouzhang_extend_map = null;
        this.label_info = null;
        this.facelist_info = null;
        this.mapOcrInfo = null;
        this.mapExifInfo = null;
        this.mapExtern = null;
        this.realLloc = "";
        this.view_cnt = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.picname = jceInputStream.readString(0, false);
        this.sloc = jceInputStream.readString(1, false);
        this.lloc = jceInputStream.readString(2, false);
        this.photourl = (Map) jceInputStream.read((JceInputStream) cache_photourl, 3, false);
        this.type = jceInputStream.read(this.type, 4, false);
        this.ismylike = jceInputStream.read(this.ismylike, 5, false);
        this.likecount = jceInputStream.read(this.likecount, 6, false);
        this.commentcount = jceInputStream.read(this.commentcount, 7, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 8, false);
        this.clientkey = jceInputStream.readString(9, false);
        this.isIndependentUgc = jceInputStream.read(this.isIndependentUgc, 10, false);
        this.opsynflag = jceInputStream.read(this.opsynflag, 11, false);
        this.uUploadTime = jceInputStream.read(this.uUploadTime, 12, false);
        this.modifytime = jceInputStream.read(this.modifytime, 13, false);
        this.desc = jceInputStream.readString(14, false);
        this.orglikekey = jceInputStream.readString(15, false);
        this.curlikekey = jceInputStream.readString(16, false);
        this.cropinfo = (s_imgcrop) jceInputStream.read((JceStruct) cache_cropinfo, 17, false);
        this.uploadUin = jceInputStream.read(this.uploadUin, 18, false);
        this.shoottime = jceInputStream.read(this.shoottime, 19, false);
        this.flag = jceInputStream.read(this.flag, 20, false);
        this.poi = (stPoi) jceInputStream.read((JceStruct) cache_poi, 21, false);
        this.facelist = (ArrayList) jceInputStream.read((JceInputStream) cache_facelist, 22, false);
        this.raw = jceInputStream.read(this.raw, 23, false);
        this.isAutoPlayGif = jceInputStream.read(this.isAutoPlayGif, 24, false);
        this.photoTag = (ArrayList) jceInputStream.read((JceInputStream) cache_photoTag, 25, false);
        this.opmask = jceInputStream.read(this.opmask, 26, false);
        this.albumid = jceInputStream.readString(27, false);
        this.piccategory = jceInputStream.read(this.piccategory, 28, false);
        this.videoflag = jceInputStream.read(this.videoflag, 29, false);
        this.videodata = (cell_video) jceInputStream.read((JceStruct) cache_videodata, 30, false);
        this.isCoverPic = jceInputStream.read(this.isCoverPic, 31, false);
        this.pic_host_nick = (s_pic_host) jceInputStream.read((JceStruct) cache_pic_host_nick, 32, false);
        this.luckyMoneyDesc = jceInputStream.readString(33, false);
        this.geo = (stPoi) jceInputStream.read((JceStruct) cache_geo, 34, false);
        this.operation = (cell_operation) jceInputStream.read((JceStruct) cache_operation, 35, false);
        this.musicdata = (cell_music) jceInputStream.read((JceStruct) cache_musicdata, 36, false);
        this.audio_summary = jceInputStream.readString(37, false);
        this.batchid = jceInputStream.read(this.batchid, 38, false);
        this.quankey = jceInputStream.readString(39, false);
        this.origin_size = jceInputStream.read(this.origin_size, 40, false);
        this.origin_width = jceInputStream.read(this.origin_width, 41, false);
        this.origin_height = jceInputStream.read(this.origin_height, 42, false);
        this.origin_phototype = jceInputStream.read(this.origin_phototype, 43, false);
        this.binaryExtInfo = (Map) jceInputStream.read((JceInputStream) cache_binaryExtInfo, 44, false);
        this.vecShowDryingTagInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecShowDryingTagInfo, 45, false);
        this.fashion_tag_key = jceInputStream.readString(46, false);
        this.shouzhang_extend_map = (Map) jceInputStream.read((JceInputStream) cache_shouzhang_extend_map, 47, false);
        this.label_info = (s_LabelInfo) jceInputStream.read((JceStruct) cache_label_info, 48, false);
        this.facelist_info = (ArrayList) jceInputStream.read((JceInputStream) cache_facelist_info, 49, false);
        this.mapOcrInfo = (Map) jceInputStream.read((JceInputStream) cache_mapOcrInfo, 50, false);
        this.mapExifInfo = (Map) jceInputStream.read((JceInputStream) cache_mapExifInfo, 51, false);
        this.mapExtern = (Map) jceInputStream.read((JceInputStream) cache_mapExtern, 52, false);
        this.realLloc = jceInputStream.readString(53, false);
        this.view_cnt = jceInputStream.read(this.view_cnt, 54, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.picname;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sloc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.lloc;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        Map<Integer, s_picurl> map = this.photourl;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.type, 4);
        jceOutputStream.write(this.ismylike, 5);
        jceOutputStream.write(this.likecount, 6);
        jceOutputStream.write(this.commentcount, 7);
        Map<Integer, String> map2 = this.busi_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
        String str4 = this.clientkey;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        jceOutputStream.write(this.isIndependentUgc, 10);
        jceOutputStream.write(this.opsynflag, 11);
        jceOutputStream.write(this.uUploadTime, 12);
        jceOutputStream.write(this.modifytime, 13);
        String str5 = this.desc;
        if (str5 != null) {
            jceOutputStream.write(str5, 14);
        }
        String str6 = this.orglikekey;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        String str7 = this.curlikekey;
        if (str7 != null) {
            jceOutputStream.write(str7, 16);
        }
        s_imgcrop s_imgcropVar = this.cropinfo;
        if (s_imgcropVar != null) {
            jceOutputStream.write((JceStruct) s_imgcropVar, 17);
        }
        jceOutputStream.write(this.uploadUin, 18);
        jceOutputStream.write(this.shoottime, 19);
        jceOutputStream.write(this.flag, 20);
        stPoi stpoi = this.poi;
        if (stpoi != null) {
            jceOutputStream.write((JceStruct) stpoi, 21);
        }
        ArrayList<stFaceItem> arrayList = this.facelist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 22);
        }
        jceOutputStream.write(this.raw, 23);
        jceOutputStream.write(this.isAutoPlayGif, 24);
        ArrayList<stPhotoTag> arrayList2 = this.photoTag;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 25);
        }
        jceOutputStream.write(this.opmask, 26);
        String str8 = this.albumid;
        if (str8 != null) {
            jceOutputStream.write(str8, 27);
        }
        jceOutputStream.write(this.piccategory, 28);
        jceOutputStream.write(this.videoflag, 29);
        cell_video cell_videoVar = this.videodata;
        if (cell_videoVar != null) {
            jceOutputStream.write((JceStruct) cell_videoVar, 30);
        }
        jceOutputStream.write(this.isCoverPic, 31);
        s_pic_host s_pic_hostVar = this.pic_host_nick;
        if (s_pic_hostVar != null) {
            jceOutputStream.write((JceStruct) s_pic_hostVar, 32);
        }
        String str9 = this.luckyMoneyDesc;
        if (str9 != null) {
            jceOutputStream.write(str9, 33);
        }
        stPoi stpoi2 = this.geo;
        if (stpoi2 != null) {
            jceOutputStream.write((JceStruct) stpoi2, 34);
        }
        cell_operation cell_operationVar = this.operation;
        if (cell_operationVar != null) {
            jceOutputStream.write((JceStruct) cell_operationVar, 35);
        }
        cell_music cell_musicVar = this.musicdata;
        if (cell_musicVar != null) {
            jceOutputStream.write((JceStruct) cell_musicVar, 36);
        }
        String str10 = this.audio_summary;
        if (str10 != null) {
            jceOutputStream.write(str10, 37);
        }
        jceOutputStream.write(this.batchid, 38);
        String str11 = this.quankey;
        if (str11 != null) {
            jceOutputStream.write(str11, 39);
        }
        jceOutputStream.write(this.origin_size, 40);
        jceOutputStream.write(this.origin_width, 41);
        jceOutputStream.write(this.origin_height, 42);
        jceOutputStream.write(this.origin_phototype, 43);
        Map<String, byte[]> map3 = this.binaryExtInfo;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 44);
        }
        ArrayList<showdrying_taginfo> arrayList3 = this.vecShowDryingTagInfo;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 45);
        }
        String str12 = this.fashion_tag_key;
        if (str12 != null) {
            jceOutputStream.write(str12, 46);
        }
        Map<Integer, String> map4 = this.shouzhang_extend_map;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 47);
        }
        s_LabelInfo s_labelinfo = this.label_info;
        if (s_labelinfo != null) {
            jceOutputStream.write((JceStruct) s_labelinfo, 48);
        }
        ArrayList<stFaceItem> arrayList4 = this.facelist_info;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 49);
        }
        Map<Integer, String> map5 = this.mapOcrInfo;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 50);
        }
        Map<Integer, String> map6 = this.mapExifInfo;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 51);
        }
        Map<String, String> map7 = this.mapExtern;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 52);
        }
        String str13 = this.realLloc;
        if (str13 != null) {
            jceOutputStream.write(str13, 53);
        }
        jceOutputStream.write(this.view_cnt, 54);
    }

    public s_picdata(String str, String str2, String str3, Map<Integer, s_picurl> map, int i3, boolean z16, int i16, int i17, Map<Integer, String> map2, String str4, int i18, int i19, long j3, long j16, String str5, String str6, String str7, s_imgcrop s_imgcropVar, long j17, int i26, int i27, stPoi stpoi, ArrayList<stFaceItem> arrayList, int i28, boolean z17, ArrayList<stPhotoTag> arrayList2, byte b16, String str8, int i29, int i36, cell_video cell_videoVar, boolean z18, s_pic_host s_pic_hostVar, String str9, stPoi stpoi2, cell_operation cell_operationVar, cell_music cell_musicVar, String str10, long j18, String str11, long j19, long j26, long j27, long j28, Map<String, byte[]> map3, ArrayList<showdrying_taginfo> arrayList3, String str12, Map<Integer, String> map4, s_LabelInfo s_labelinfo, ArrayList<stFaceItem> arrayList4, Map<Integer, String> map5, Map<Integer, String> map6, Map<String, String> map7, String str13, int i37) {
        this.picname = str;
        this.sloc = str2;
        this.lloc = str3;
        this.photourl = map;
        this.type = i3;
        this.ismylike = z16;
        this.likecount = i16;
        this.commentcount = i17;
        this.busi_param = map2;
        this.clientkey = str4;
        this.isIndependentUgc = i18;
        this.opsynflag = i19;
        this.uUploadTime = j3;
        this.modifytime = j16;
        this.desc = str5;
        this.orglikekey = str6;
        this.curlikekey = str7;
        this.cropinfo = s_imgcropVar;
        this.uploadUin = j17;
        this.shoottime = i26;
        this.flag = i27;
        this.poi = stpoi;
        this.facelist = arrayList;
        this.raw = i28;
        this.isAutoPlayGif = z17;
        this.photoTag = arrayList2;
        this.opmask = b16;
        this.albumid = str8;
        this.piccategory = i29;
        this.videoflag = i36;
        this.videodata = cell_videoVar;
        this.isCoverPic = z18;
        this.pic_host_nick = s_pic_hostVar;
        this.luckyMoneyDesc = str9;
        this.geo = stpoi2;
        this.operation = cell_operationVar;
        this.musicdata = cell_musicVar;
        this.audio_summary = str10;
        this.batchid = j18;
        this.quankey = str11;
        this.origin_size = j19;
        this.origin_width = j26;
        this.origin_height = j27;
        this.origin_phototype = j28;
        this.binaryExtInfo = map3;
        this.vecShowDryingTagInfo = arrayList3;
        this.fashion_tag_key = str12;
        this.shouzhang_extend_map = map4;
        this.label_info = s_labelinfo;
        this.facelist_info = arrayList4;
        this.mapOcrInfo = map5;
        this.mapExifInfo = map6;
        this.mapExtern = map7;
        this.realLloc = str13;
        this.view_cnt = i37;
    }
}
