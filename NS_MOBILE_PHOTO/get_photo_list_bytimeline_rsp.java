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
public final class get_photo_list_bytimeline_rsp extends JceStruct {
    static Map<Integer, String> cache_busi_param;
    static stPhotoPoiAreaList cache_pos;
    static s_outshare cache_shareinfo;
    static ArrayList<TimeEvent> cache_timeevent;
    static ArrayList<TimeLine> cache_timeline;
    public Album albuminfo;
    public int appid;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public ArrayList<s_picdata> photolist;
    public stPhotoPoiAreaList pos;
    public s_outshare shareinfo;
    public ArrayList<TimeEvent> timeevent;
    public ArrayList<TimeLine> timeline;
    static Album cache_albuminfo = new Album();
    static ArrayList<s_picdata> cache_photolist = new ArrayList<>();

    static {
        cache_photolist.add(new s_picdata());
        cache_timeline = new ArrayList<>();
        cache_timeline.add(new TimeLine());
        cache_pos = new stPhotoPoiAreaList();
        cache_busi_param = new HashMap();
        cache_busi_param.put(0, "");
        cache_shareinfo = new s_outshare();
        cache_timeevent = new ArrayList<>();
        cache_timeevent.add(new TimeEvent());
    }

    public get_photo_list_bytimeline_rsp() {
        this.attach_info = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albuminfo = (Album) jceInputStream.read((JceStruct) cache_albuminfo, 0, true);
        this.photolist = (ArrayList) jceInputStream.read((JceInputStream) cache_photolist, 1, true);
        this.attach_info = jceInputStream.readString(2, false);
        this.timeline = (ArrayList) jceInputStream.read((JceInputStream) cache_timeline, 3, false);
        this.pos = (stPhotoPoiAreaList) jceInputStream.read((JceStruct) cache_pos, 4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.appid = jceInputStream.read(this.appid, 6, false);
        this.shareinfo = (s_outshare) jceInputStream.read((JceStruct) cache_shareinfo, 7, false);
        this.timeevent = (ArrayList) jceInputStream.read((JceInputStream) cache_timeevent, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.albuminfo, 0);
        jceOutputStream.write((Collection) this.photolist, 1);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        ArrayList<TimeLine> arrayList = this.timeline;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        stPhotoPoiAreaList stphotopoiarealist = this.pos;
        if (stphotopoiarealist != null) {
            jceOutputStream.write((JceStruct) stphotopoiarealist, 4);
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
    }

    public get_photo_list_bytimeline_rsp(Album album, ArrayList<s_picdata> arrayList, String str, ArrayList<TimeLine> arrayList2, stPhotoPoiAreaList stphotopoiarealist, Map<Integer, String> map, int i3, s_outshare s_outshareVar, ArrayList<TimeEvent> arrayList3) {
        this.albuminfo = album;
        this.photolist = arrayList;
        this.attach_info = str;
        this.timeline = arrayList2;
        this.pos = stphotopoiarealist;
        this.busi_param = map;
        this.appid = i3;
        this.shareinfo = s_outshareVar;
        this.timeevent = arrayList3;
    }
}
