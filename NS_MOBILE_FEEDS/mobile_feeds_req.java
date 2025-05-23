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
public final class mobile_feeds_req extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_feed_infos;
    static s_gps cache_gps_info;
    static Map<String, String> cache_kitFileInfos;
    static Map<String, byte[]> cache_mapBinaryExtendInfo;
    static Map<Integer, String> cache_mapDesc;
    static Map<Integer, String> cache_rank_param;
    static ArrayList<single_feeds_req_info> cache_req_feeds_info;
    static Map<String, String> cache_stMapExtendinfo;
    public String attach_info;
    public Map<Integer, String> busi_param;
    public int count;
    public String device_info;
    public String feed_attach_info;
    public Map<String, String> feed_infos;
    public byte force;
    public s_gps gps_info;
    public boolean is_fetch_fake_feeds;
    public int is_fetch_specific_feeds;
    public Map<String, String> kitFileInfos;
    public Map<String, byte[]> mapBinaryExtendInfo;
    public Map<Integer, String> mapDesc;
    public long offset;
    public Map<Integer, String> rank_param;
    public int refresh_type;
    public int relation_type;
    public ArrayList<single_feeds_req_info> req_feeds_info;
    public int scene;
    public int shaishai_scene;
    public Map<String, String> stMapExtendinfo;
    public String tlv_attach_info;

    static {
        cache_busi_param.put(0, "");
        HashMap hashMap = new HashMap();
        cache_feed_infos = hashMap;
        hashMap.put("", "");
        cache_gps_info = new s_gps();
        HashMap hashMap2 = new HashMap();
        cache_stMapExtendinfo = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        cache_kitFileInfos = hashMap3;
        hashMap3.put("", "");
        cache_rank_param = new HashMap();
        cache_rank_param.put(0, "");
        cache_mapDesc = new HashMap();
        cache_mapDesc.put(0, "");
        HashMap hashMap4 = new HashMap();
        cache_mapBinaryExtendInfo = hashMap4;
        hashMap4.put("", new byte[]{0});
        cache_req_feeds_info = new ArrayList<>();
        cache_req_feeds_info.add(new single_feeds_req_info());
    }

    public mobile_feeds_req() {
        this.refresh_type = 0;
        this.relation_type = 0;
        this.count = 0;
        this.attach_info = "";
        this.device_info = "";
        this.busi_param = null;
        this.offset = 0L;
        this.tlv_attach_info = "";
        this.feed_infos = null;
        this.feed_attach_info = "";
        this.force = (byte) 0;
        this.gps_info = null;
        this.stMapExtendinfo = null;
        this.kitFileInfos = null;
        this.rank_param = null;
        this.mapDesc = null;
        this.mapBinaryExtendInfo = null;
        this.scene = 0;
        this.shaishai_scene = 0;
        this.req_feeds_info = null;
        this.is_fetch_specific_feeds = 0;
        this.is_fetch_fake_feeds = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.refresh_type = jceInputStream.read(this.refresh_type, 0, false);
        this.relation_type = jceInputStream.read(this.relation_type, 1, false);
        this.count = jceInputStream.read(this.count, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.device_info = jceInputStream.readString(4, false);
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 5, false);
        this.offset = jceInputStream.read(this.offset, 6, false);
        this.tlv_attach_info = jceInputStream.readString(7, false);
        this.feed_infos = (Map) jceInputStream.read((JceInputStream) cache_feed_infos, 8, false);
        this.feed_attach_info = jceInputStream.readString(9, false);
        this.force = jceInputStream.read(this.force, 10, false);
        this.gps_info = (s_gps) jceInputStream.read((JceStruct) cache_gps_info, 11, false);
        this.stMapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_stMapExtendinfo, 12, false);
        this.kitFileInfos = (Map) jceInputStream.read((JceInputStream) cache_kitFileInfos, 13, false);
        this.rank_param = (Map) jceInputStream.read((JceInputStream) cache_rank_param, 14, false);
        this.mapDesc = (Map) jceInputStream.read((JceInputStream) cache_mapDesc, 15, false);
        this.mapBinaryExtendInfo = (Map) jceInputStream.read((JceInputStream) cache_mapBinaryExtendInfo, 16, false);
        this.scene = jceInputStream.read(this.scene, 17, false);
        this.shaishai_scene = jceInputStream.read(this.shaishai_scene, 18, false);
        this.req_feeds_info = (ArrayList) jceInputStream.read((JceInputStream) cache_req_feeds_info, 19, false);
        this.is_fetch_specific_feeds = jceInputStream.read(this.is_fetch_specific_feeds, 20, false);
        this.is_fetch_fake_feeds = jceInputStream.read(this.is_fetch_fake_feeds, 21, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.refresh_type, 0);
        jceOutputStream.write(this.relation_type, 1);
        jceOutputStream.write(this.count, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.device_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 5);
        }
        jceOutputStream.write(this.offset, 6);
        String str3 = this.tlv_attach_info;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        Map<String, String> map2 = this.feed_infos;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 8);
        }
        String str4 = this.feed_attach_info;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        jceOutputStream.write(this.force, 10);
        s_gps s_gpsVar = this.gps_info;
        if (s_gpsVar != null) {
            jceOutputStream.write((JceStruct) s_gpsVar, 11);
        }
        Map<String, String> map3 = this.stMapExtendinfo;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 12);
        }
        Map<String, String> map4 = this.kitFileInfos;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 13);
        }
        Map<Integer, String> map5 = this.rank_param;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 14);
        }
        Map<Integer, String> map6 = this.mapDesc;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 15);
        }
        Map<String, byte[]> map7 = this.mapBinaryExtendInfo;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 16);
        }
        jceOutputStream.write(this.scene, 17);
        jceOutputStream.write(this.shaishai_scene, 18);
        ArrayList<single_feeds_req_info> arrayList = this.req_feeds_info;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 19);
        }
        jceOutputStream.write(this.is_fetch_specific_feeds, 20);
        jceOutputStream.write(this.is_fetch_fake_feeds, 21);
    }

    public mobile_feeds_req(int i3, int i16, int i17, String str, String str2, Map<Integer, String> map, long j3, String str3, Map<String, String> map2, String str4, byte b16, s_gps s_gpsVar, Map<String, String> map3, Map<String, String> map4, Map<Integer, String> map5, Map<Integer, String> map6, Map<String, byte[]> map7, int i18, int i19, ArrayList<single_feeds_req_info> arrayList, int i26, boolean z16) {
        this.refresh_type = i3;
        this.relation_type = i16;
        this.count = i17;
        this.attach_info = str;
        this.device_info = str2;
        this.busi_param = map;
        this.offset = j3;
        this.tlv_attach_info = str3;
        this.feed_infos = map2;
        this.feed_attach_info = str4;
        this.force = b16;
        this.gps_info = s_gpsVar;
        this.stMapExtendinfo = map3;
        this.kitFileInfos = map4;
        this.rank_param = map5;
        this.mapDesc = map6;
        this.mapBinaryExtendInfo = map7;
        this.scene = i18;
        this.shaishai_scene = i19;
        this.req_feeds_info = arrayList;
        this.is_fetch_specific_feeds = i26;
        this.is_fetch_fake_feeds = z16;
    }
}
