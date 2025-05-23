package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_photo_list_2_rsp extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static Map<Integer, byte[]> cache_features;
    static int cache_photo_search_status;
    static stPhotoPoiAreaList cache_pos;
    static ArrayList<Album> cache_recommand_album;
    static RecommendPhotos cache_recommend_photos;
    static s_outshare cache_shareinfo;
    static ArrayList<TimeLine> cache_timeline;
    static s_videoflow_user cache_user;
    public Album albuminfo;
    public int appid;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public int curindex;
    public Map<Integer, byte[]> features;
    public long finish;
    public int lossy_service;
    public int photo_search_status;
    public ArrayList<s_picdata> photolist;
    public stPhotoPoiAreaList pos;
    public ArrayList<Album> recommand_album;
    public RecommendPhotos recommend_photos;
    public s_outshare shareinfo;
    public ArrayList<TimeLine> timeline;
    public long total;
    public s_videoflow_user user;
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();

    static {
        cache_photolist.add(new s_picdata());
        cache_shareinfo = new s_outshare();
        cache_recommand_album = new ArrayList<>();
        cache_recommand_album.add(new Album());
        cache_user = new s_videoflow_user();
        cache_features = new HashMap();
        cache_features.put(0, new byte[]{0});
        cache_recommend_photos = new RecommendPhotos();
        cache_pos = new stPhotoPoiAreaList();
        cache_timeline = new ArrayList<>();
        cache_timeline.add(new TimeLine());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_photo_search_status = 0;
    }

    public get_photo_list_2_rsp() {
        this.albuminfo = null;
        this.photolist = null;
        this.curindex = 0;
        this.appid = 0;
        this.total = 0L;
        this.finish = 0L;
        this.shareinfo = null;
        this.lossy_service = 0;
        this.recommand_album = null;
        this.user = null;
        this.features = null;
        this.recommend_photos = null;
        this.pos = null;
        this.timeline = null;
        this.attach_info = "";
        this.busi_param = null;
        this.photo_search_status = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 1, true);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 2, true);
        this.curindex = jceInputStream.read(this.curindex, 3, false);
        this.appid = jceInputStream.read(this.appid, 4, false);
        this.total = jceInputStream.read(this.total, 5, false);
        this.finish = jceInputStream.read(this.finish, 6, false);
        this.shareinfo = (s_outshare) jceInputStream.read((JceStruct) cache_shareinfo, 7, false);
        this.lossy_service = jceInputStream.read(this.lossy_service, 8, false);
        this.recommand_album = (ArrayList) jceInputStream.read((JceInputStream) cache_recommand_album, 9, false);
        this.user = (s_videoflow_user) jceInputStream.read((JceStruct) cache_user, 11, false);
        this.features = (Map) jceInputStream.read((JceInputStream) cache_features, 12, false);
        this.recommend_photos = (RecommendPhotos) jceInputStream.read((JceStruct) cache_recommend_photos, 13, false);
        this.pos = (stPhotoPoiAreaList) jceInputStream.read((JceStruct) cache_pos, 14, false);
        this.timeline = (ArrayList) jceInputStream.read((JceInputStream) cache_timeline, 15, false);
        this.attach_info = jceInputStream.readString(16, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 17, false);
        this.photo_search_status = jceInputStream.read(this.photo_search_status, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.albuminfo, 1);
        jceOutputStream.write((Collection) this.photolist, 2);
        jceOutputStream.write(this.curindex, 3);
        jceOutputStream.write(this.appid, 4);
        jceOutputStream.write(this.total, 5);
        jceOutputStream.write(this.finish, 6);
        s_outshare s_outshareVar = this.shareinfo;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 7);
        }
        jceOutputStream.write(this.lossy_service, 8);
        ArrayList<Album> arrayList = this.recommand_album;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        s_videoflow_user s_videoflow_userVar = this.user;
        if (s_videoflow_userVar != null) {
            jceOutputStream.write((JceStruct) s_videoflow_userVar, 11);
        }
        Map<Integer, byte[]> map = this.features;
        if (map != null) {
            jceOutputStream.write((Map) map, 12);
        }
        RecommendPhotos recommendPhotos = this.recommend_photos;
        if (recommendPhotos != null) {
            jceOutputStream.write((JceStruct) recommendPhotos, 13);
        }
        stPhotoPoiAreaList stphotopoiarealist = this.pos;
        if (stphotopoiarealist != null) {
            jceOutputStream.write((JceStruct) stphotopoiarealist, 14);
        }
        ArrayList<TimeLine> arrayList2 = this.timeline;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 15);
        }
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 16);
        }
        Map<Integer, String> map2 = this.busi_param;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 17);
        }
        jceOutputStream.write(this.photo_search_status, 18);
    }

    public get_photo_list_2_rsp(Album album, ArrayList<s_picdata> arrayList, int i3, int i16, long j3, long j16, s_outshare s_outshareVar, int i17, ArrayList<Album> arrayList2, s_videoflow_user s_videoflow_userVar, Map<Integer, byte[]> map, RecommendPhotos recommendPhotos, stPhotoPoiAreaList stphotopoiarealist, ArrayList<TimeLine> arrayList3, String str, Map<Integer, String> map2, int i18) {
        this.albuminfo = album;
        this.photolist = arrayList;
        this.curindex = i3;
        this.appid = i16;
        this.total = j3;
        this.finish = j16;
        this.shareinfo = s_outshareVar;
        this.lossy_service = i17;
        this.recommand_album = arrayList2;
        this.user = s_videoflow_userVar;
        this.features = map;
        this.recommend_photos = recommendPhotos;
        this.pos = stphotopoiarealist;
        this.timeline = arrayList3;
        this.attach_info = str;
        this.busi_param = map2;
        this.photo_search_status = i18;
    }
}
