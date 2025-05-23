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
public final class mobile_applist_rsp extends JceStruct {
    static last_album_area_info cache_album_area_info;
    static ArrayList<single_feed> cache_all_applist_data = new ArrayList<>();
    static Map<String, String> cache_extend_info;
    static s_life_moment cache_life_moment_info;
    static Map<String, byte[]> cache_mapEx;
    static single_feed cache_share_album;
    static s_memory_seal_off cache_stMemoryInfo;
    public last_album_area_info album_area_info;
    public int album_count;
    public ArrayList<single_feed> all_applist_data;
    public String attach_info;
    public int auto_load;
    public int dailyShuoShuoCount;
    public Map<String, String> extend_info;
    public int hasmore;
    public int kantu_album_count;
    public s_life_moment life_moment_info;
    public int lossy_service;
    public Map<String, byte[]> mapEx;
    public int photo_count;
    public int remain_count;
    public single_feed share_album;
    public int shuoshuo_timer_unpublished_count;
    public s_memory_seal_off stMemoryInfo;
    public int video_count;

    static {
        cache_all_applist_data.add(new single_feed());
        cache_share_album = new single_feed();
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
        cache_stMemoryInfo = new s_memory_seal_off();
        HashMap hashMap2 = new HashMap();
        cache_mapEx = hashMap2;
        hashMap2.put("", new byte[]{0});
        cache_life_moment_info = new s_life_moment();
        cache_album_area_info = new last_album_area_info();
    }

    public mobile_applist_rsp() {
        this.all_applist_data = null;
        this.hasmore = 0;
        this.remain_count = 0;
        this.attach_info = "";
        this.auto_load = 0;
        this.share_album = null;
        this.lossy_service = 0;
        this.extend_info = null;
        this.album_count = 0;
        this.photo_count = 0;
        this.video_count = 0;
        this.stMemoryInfo = null;
        this.mapEx = null;
        this.shuoshuo_timer_unpublished_count = 0;
        this.life_moment_info = null;
        this.album_area_info = null;
        this.kantu_album_count = 0;
        this.dailyShuoShuoCount = 0;
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
        this.album_count = jceInputStream.read(this.album_count, 9, false);
        this.photo_count = jceInputStream.read(this.photo_count, 10, false);
        this.video_count = jceInputStream.read(this.video_count, 11, false);
        this.stMemoryInfo = (s_memory_seal_off) jceInputStream.read((JceStruct) cache_stMemoryInfo, 12, false);
        this.mapEx = (Map) jceInputStream.read((JceInputStream) cache_mapEx, 13, false);
        this.shuoshuo_timer_unpublished_count = jceInputStream.read(this.shuoshuo_timer_unpublished_count, 14, false);
        this.life_moment_info = (s_life_moment) jceInputStream.read((JceStruct) cache_life_moment_info, 15, false);
        this.album_area_info = (last_album_area_info) jceInputStream.read((JceStruct) cache_album_area_info, 16, false);
        this.kantu_album_count = jceInputStream.read(this.kantu_album_count, 17, false);
        this.dailyShuoShuoCount = jceInputStream.read(this.dailyShuoShuoCount, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<single_feed> arrayList = this.all_applist_data;
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
        jceOutputStream.write(this.album_count, 9);
        jceOutputStream.write(this.photo_count, 10);
        jceOutputStream.write(this.video_count, 11);
        s_memory_seal_off s_memory_seal_offVar = this.stMemoryInfo;
        if (s_memory_seal_offVar != null) {
            jceOutputStream.write((JceStruct) s_memory_seal_offVar, 12);
        }
        Map<String, byte[]> map2 = this.mapEx;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 13);
        }
        jceOutputStream.write(this.shuoshuo_timer_unpublished_count, 14);
        s_life_moment s_life_momentVar = this.life_moment_info;
        if (s_life_momentVar != null) {
            jceOutputStream.write((JceStruct) s_life_momentVar, 15);
        }
        last_album_area_info last_album_area_infoVar = this.album_area_info;
        if (last_album_area_infoVar != null) {
            jceOutputStream.write((JceStruct) last_album_area_infoVar, 16);
        }
        jceOutputStream.write(this.kantu_album_count, 17);
        jceOutputStream.write(this.dailyShuoShuoCount, 18);
    }

    public mobile_applist_rsp(ArrayList<single_feed> arrayList, int i3, int i16, String str, int i17, single_feed single_feedVar, int i18, Map<String, String> map, int i19, int i26, int i27, s_memory_seal_off s_memory_seal_offVar, Map<String, byte[]> map2, int i28, s_life_moment s_life_momentVar, last_album_area_info last_album_area_infoVar, int i29, int i36) {
        this.all_applist_data = arrayList;
        this.hasmore = i3;
        this.remain_count = i16;
        this.attach_info = str;
        this.auto_load = i17;
        this.share_album = single_feedVar;
        this.lossy_service = i18;
        this.extend_info = map;
        this.album_count = i19;
        this.photo_count = i26;
        this.video_count = i27;
        this.stMemoryInfo = s_memory_seal_offVar;
        this.mapEx = map2;
        this.shuoshuo_timer_unpublished_count = i28;
        this.life_moment_info = s_life_momentVar;
        this.album_area_info = last_album_area_infoVar;
        this.kantu_album_count = i29;
        this.dailyShuoShuoCount = i36;
    }
}
