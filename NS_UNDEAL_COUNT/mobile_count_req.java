package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_count_req extends JceStruct {
    static Map<Integer, String> cache_extendinfo;
    static Map<Long, s_comm_data> cache_mapBuf = new HashMap();
    static Map<Long, Long> cache_mapDyncShowTime;
    static Map<Long, Long> cache_mapLastGetTime;
    static Map<String, String> cache_mapSqDyncFeedsInfo;
    static Map<Integer, Long> cache_mapTimeStamp;
    static Map<Integer, count_info> cache_stMapCountInfo;
    public Map<Integer, String> extendinfo;
    public int iRelationType;
    public int iVisitQZoneType;
    public long lastClickPlusButtonTime;
    public long lastSqDynamicFeedsTime;
    public String lastUndealCountTime;
    public Map<Long, s_comm_data> mapBuf;
    public Map<Long, Long> mapDyncShowTime;
    public Map<Long, Long> mapLastGetTime;
    public Map<String, String> mapSqDyncFeedsInfo;
    public Map<Integer, Long> mapTimeStamp;
    public long reqMask;
    public String sTransParam;
    public Map<Integer, count_info> stMapCountInfo;
    public long uMask;

    static {
        cache_mapBuf.put(0L, new s_comm_data());
        cache_mapTimeStamp = new HashMap();
        cache_mapTimeStamp.put(0, 0L);
        cache_mapLastGetTime = new HashMap();
        cache_mapLastGetTime.put(0L, 0L);
        cache_stMapCountInfo = new HashMap();
        cache_stMapCountInfo.put(0, new count_info());
        cache_extendinfo = new HashMap();
        cache_extendinfo.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapSqDyncFeedsInfo = hashMap;
        hashMap.put("", "");
        cache_mapDyncShowTime = new HashMap();
        cache_mapDyncShowTime.put(0L, 0L);
    }

    public mobile_count_req() {
        this.uMask = 0L;
        this.iRelationType = 0;
        this.iVisitQZoneType = 0;
        this.mapBuf = null;
        this.mapTimeStamp = null;
        this.mapLastGetTime = null;
        this.sTransParam = "";
        this.stMapCountInfo = null;
        this.extendinfo = null;
        this.lastUndealCountTime = "";
        this.lastSqDynamicFeedsTime = 0L;
        this.mapSqDyncFeedsInfo = null;
        this.mapDyncShowTime = null;
        this.lastClickPlusButtonTime = 0L;
        this.reqMask = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uMask = jceInputStream.read(this.uMask, 0, false);
        this.iRelationType = jceInputStream.read(this.iRelationType, 1, false);
        this.iVisitQZoneType = jceInputStream.read(this.iVisitQZoneType, 2, false);
        this.mapBuf = (Map) jceInputStream.read((JceInputStream) cache_mapBuf, 3, false);
        this.mapTimeStamp = (Map) jceInputStream.read((JceInputStream) cache_mapTimeStamp, 4, false);
        this.mapLastGetTime = (Map) jceInputStream.read((JceInputStream) cache_mapLastGetTime, 5, false);
        this.sTransParam = jceInputStream.readString(6, false);
        this.stMapCountInfo = (Map) jceInputStream.read((JceInputStream) cache_stMapCountInfo, 7, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 8, false);
        this.lastUndealCountTime = jceInputStream.readString(9, false);
        this.lastSqDynamicFeedsTime = jceInputStream.read(this.lastSqDynamicFeedsTime, 10, false);
        this.mapSqDyncFeedsInfo = (Map) jceInputStream.read((JceInputStream) cache_mapSqDyncFeedsInfo, 11, false);
        this.mapDyncShowTime = (Map) jceInputStream.read((JceInputStream) cache_mapDyncShowTime, 12, false);
        this.lastClickPlusButtonTime = jceInputStream.read(this.lastClickPlusButtonTime, 13, false);
        this.reqMask = jceInputStream.read(this.reqMask, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uMask, 0);
        jceOutputStream.write(this.iRelationType, 1);
        jceOutputStream.write(this.iVisitQZoneType, 2);
        Map<Long, s_comm_data> map = this.mapBuf;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        Map<Integer, Long> map2 = this.mapTimeStamp;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 4);
        }
        Map<Long, Long> map3 = this.mapLastGetTime;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 5);
        }
        String str = this.sTransParam;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        Map<Integer, count_info> map4 = this.stMapCountInfo;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 7);
        }
        Map<Integer, String> map5 = this.extendinfo;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 8);
        }
        String str2 = this.lastUndealCountTime;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        jceOutputStream.write(this.lastSqDynamicFeedsTime, 10);
        Map<String, String> map6 = this.mapSqDyncFeedsInfo;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 11);
        }
        Map<Long, Long> map7 = this.mapDyncShowTime;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 12);
        }
        jceOutputStream.write(this.lastClickPlusButtonTime, 13);
        jceOutputStream.write(this.reqMask, 14);
    }

    public mobile_count_req(long j3, int i3, int i16, Map<Long, s_comm_data> map, Map<Integer, Long> map2, Map<Long, Long> map3, String str, Map<Integer, count_info> map4, Map<Integer, String> map5, String str2, long j16, Map<String, String> map6, Map<Long, Long> map7, long j17, long j18) {
        this.uMask = j3;
        this.iRelationType = i3;
        this.iVisitQZoneType = i16;
        this.mapBuf = map;
        this.mapTimeStamp = map2;
        this.mapLastGetTime = map3;
        this.sTransParam = str;
        this.stMapCountInfo = map4;
        this.extendinfo = map5;
        this.lastUndealCountTime = str2;
        this.lastSqDynamicFeedsTime = j16;
        this.mapSqDyncFeedsInfo = map6;
        this.mapDyncShowTime = map7;
        this.lastClickPlusButtonTime = j17;
        this.reqMask = j18;
    }
}
