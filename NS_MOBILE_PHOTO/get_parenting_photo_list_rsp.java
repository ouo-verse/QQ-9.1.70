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
public final class get_parenting_photo_list_rsp extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static Map<Integer, byte[]> cache_features;
    static int cache_photo_search_status;
    static ArrayList<Album> cache_recommand_album;
    static RecommendPhotos cache_recommend_photos;
    static s_outshare cache_shareinfo;
    static ArrayList<TimeEvent> cache_timeevent;
    static ArrayList<TimeLine> cache_timeline;
    public Album albuminfo;
    public int appid;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public Map<Integer, byte[]> features;
    public int hasmore;
    public int photo_search_status;
    public ArrayList<s_picdata> photolist;
    public ArrayList<Album> recommand_album;
    public RecommendPhotos recommend_photos;
    public s_outshare shareinfo;
    public ArrayList<TimeEvent> timeevent;
    public ArrayList<TimeLine> timeline;
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();

    static {
        cache_photolist.add(new s_picdata());
        cache_timeline = new ArrayList<>();
        cache_timeline.add(new TimeLine());
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_shareinfo = new s_outshare();
        cache_timeevent = new ArrayList<>();
        cache_timeevent.add(new TimeEvent());
        cache_recommand_album = new ArrayList<>();
        cache_recommand_album.add(new Album());
        cache_features = new HashMap();
        cache_features.put(0, new byte[]{0});
        cache_recommend_photos = new RecommendPhotos();
        cache_photo_search_status = 0;
    }

    public get_parenting_photo_list_rsp() {
        this.albuminfo = null;
        this.photolist = null;
        this.attach_info = "";
        this.hasmore = 0;
        this.timeline = null;
        this.busi_param = null;
        this.appid = 0;
        this.shareinfo = null;
        this.timeevent = null;
        this.recommand_album = null;
        this.features = null;
        this.recommend_photos = null;
        this.photo_search_status = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 0, true);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 1, true);
        this.attach_info = jceInputStream.readString(2, false);
        this.hasmore = jceInputStream.read(this.hasmore, 3, false);
        this.timeline = (ArrayList) jceInputStream.read((JceInputStream) cache_timeline, 4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.appid = jceInputStream.read(this.appid, 6, false);
        this.shareinfo = (s_outshare) jceInputStream.read((JceStruct) cache_shareinfo, 7, false);
        this.timeevent = (ArrayList) jceInputStream.read((JceInputStream) cache_timeevent, 8, false);
        this.recommand_album = (ArrayList) jceInputStream.read((JceInputStream) cache_recommand_album, 9, false);
        this.features = (Map) jceInputStream.read((JceInputStream) cache_features, 10, false);
        this.recommend_photos = (RecommendPhotos) jceInputStream.read((JceStruct) cache_recommend_photos, 11, false);
        this.photo_search_status = jceInputStream.read(this.photo_search_status, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.albuminfo, 0);
        jceOutputStream.write((Collection) this.photolist, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.hasmore, 3);
        ArrayList<TimeLine> arrayList = this.timeline;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.appid, 6);
        s_outshare s_outshareVar = this.shareinfo;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 7);
        }
        ArrayList<TimeEvent> arrayList2 = this.timeevent;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 8);
        }
        ArrayList<Album> arrayList3 = this.recommand_album;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 9);
        }
        Map<Integer, byte[]> map2 = this.features;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 10);
        }
        RecommendPhotos recommendPhotos = this.recommend_photos;
        if (recommendPhotos != null) {
            jceOutputStream.write((JceStruct) recommendPhotos, 11);
        }
        jceOutputStream.write(this.photo_search_status, 12);
    }

    public get_parenting_photo_list_rsp(Album album, ArrayList<s_picdata> arrayList, String str, int i3, ArrayList<TimeLine> arrayList2, Map<Integer, String> map, int i16, s_outshare s_outshareVar, ArrayList<TimeEvent> arrayList3, ArrayList<Album> arrayList4, Map<Integer, byte[]> map2, RecommendPhotos recommendPhotos, int i17) {
        this.albuminfo = album;
        this.photolist = arrayList;
        this.attach_info = str;
        this.hasmore = i3;
        this.timeline = arrayList2;
        this.busi_param = map;
        this.appid = i16;
        this.shareinfo = s_outshareVar;
        this.timeevent = arrayList3;
        this.recommand_album = arrayList4;
        this.features = map2;
        this.recommend_photos = recommendPhotos;
        this.photo_search_status = i17;
    }
}
