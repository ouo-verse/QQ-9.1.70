package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_memory_seal_off;
import NS_MOBILE_FEEDS.single_feed;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class get_all_feedsphoto_ex_rsp extends JceStruct {
    static ArrayList<PhotoFeedsData> cache_all_applist_data = new ArrayList<>();
    static photo_tab_category_control cache_category_infos;
    static Map<String, String> cache_extend_info;
    static single_feed cache_share_album;
    static s_memory_seal_off cache_stMemoryInfo;
    static ArrayList<TabTimeLine> cache_timeline;
    public ArrayList<PhotoFeedsData> all_applist_data;
    public String attach_info;
    public int auto_load;
    public photo_tab_category_control category_infos;
    public Map<String, String> extend_info;
    public int hasmore;
    public int lossy_service;
    public int remain_count;
    public single_feed share_album;
    public s_memory_seal_off stMemoryInfo;
    public ArrayList<TabTimeLine> timeline;

    static {
        cache_all_applist_data.add(new PhotoFeedsData());
        cache_share_album = new single_feed();
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_category_infos = new photo_tab_category_control();
        cache_timeline = new ArrayList<>();
        cache_timeline.add(new TabTimeLine());
        cache_stMemoryInfo = new s_memory_seal_off();
    }

    public get_all_feedsphoto_ex_rsp() {
        this.all_applist_data = null;
        this.hasmore = 0;
        this.remain_count = 0;
        this.attach_info = "";
        this.auto_load = 0;
        this.share_album = null;
        this.lossy_service = 0;
        this.extend_info = null;
        this.category_infos = null;
        this.timeline = null;
        this.stMemoryInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.all_applist_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_applist_data, 0, false);
        this.hasmore = jceInputStream.read(this.hasmore, 1, false);
        this.remain_count = jceInputStream.read(this.remain_count, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.auto_load = jceInputStream.read(this.auto_load, 4, false);
        this.share_album = (single_feed) jceInputStream.read((JceStruct) cache_share_album, 5, false);
        this.lossy_service = jceInputStream.read(this.lossy_service, 7, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 8, false);
        this.category_infos = (photo_tab_category_control) jceInputStream.read((JceStruct) cache_category_infos, 9, false);
        this.timeline = (ArrayList) jceInputStream.read((JceInputStream) cache_timeline, 10, false);
        this.stMemoryInfo = (s_memory_seal_off) jceInputStream.read((JceStruct) cache_stMemoryInfo, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PhotoFeedsData> arrayList = this.all_applist_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.hasmore, 1);
        jceOutputStream.write(this.remain_count, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        jceOutputStream.write(this.auto_load, 4);
        single_feed single_feedVar = this.share_album;
        if (single_feedVar != null) {
            jceOutputStream.write((JceStruct) single_feedVar, 5);
        }
        jceOutputStream.write(this.lossy_service, 7);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 8);
        }
        photo_tab_category_control photo_tab_category_controlVar = this.category_infos;
        if (photo_tab_category_controlVar != null) {
            jceOutputStream.write((JceStruct) photo_tab_category_controlVar, 9);
        }
        ArrayList<TabTimeLine> arrayList2 = this.timeline;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 10);
        }
        s_memory_seal_off s_memory_seal_offVar = this.stMemoryInfo;
        if (s_memory_seal_offVar != null) {
            jceOutputStream.write((JceStruct) s_memory_seal_offVar, 11);
        }
    }

    public get_all_feedsphoto_ex_rsp(ArrayList<PhotoFeedsData> arrayList, int i3, int i16, String str, int i17, single_feed single_feedVar, int i18, Map<String, String> map, photo_tab_category_control photo_tab_category_controlVar, ArrayList<TabTimeLine> arrayList2, s_memory_seal_off s_memory_seal_offVar) {
        this.all_applist_data = arrayList;
        this.hasmore = i3;
        this.remain_count = i16;
        this.attach_info = str;
        this.auto_load = i17;
        this.share_album = single_feedVar;
        this.lossy_service = i18;
        this.extend_info = map;
        this.category_infos = photo_tab_category_controlVar;
        this.timeline = arrayList2;
        this.stMemoryInfo = s_memory_seal_offVar;
    }
}
