package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PrivExtV2Req extends JceStruct {
    static Map<String, String> cache_extendInfo;
    static Map<Integer, Integer> cache_mobile_info;
    static Map<String, String> cache_qqvalue_info;
    public int clientLangugeId;
    public Map<String, String> extendInfo;
    public int iGetType;
    public long iItemCfgVer;
    public int iPopupVer;
    public int iToastVer;
    public int iWkOrderState1;
    public int iWkOrderState2;
    public long lastVisitTime;
    public Map<Integer, Integer> mobile_info;
    public long pullPayRuleCfgTime;
    public Map<String, String> qqvalue_info;
    public String qua;
    public String recom_ext_info;
    public String sImsi1;
    public String sImsi2;
    public String sKey;
    public String sUin;
    public String trace_info;

    static {
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_qqvalue_info = hashMap2;
        hashMap2.put("", "");
        cache_mobile_info = new HashMap();
        cache_mobile_info.put(0, 0);
    }

    public PrivExtV2Req() {
        this.sUin = "";
        this.sKey = "";
        this.iGetType = 0;
        this.sImsi1 = "";
        this.sImsi2 = "";
        this.iPopupVer = 0;
        this.iToastVer = 0;
        this.iWkOrderState1 = 0;
        this.iWkOrderState2 = 0;
        this.lastVisitTime = 0L;
        this.iItemCfgVer = 0L;
        this.pullPayRuleCfgTime = 0L;
        this.clientLangugeId = 0;
        this.extendInfo = null;
        this.qua = "";
        this.trace_info = "";
        this.qqvalue_info = null;
        this.recom_ext_info = "";
        this.mobile_info = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUin = jceInputStream.readString(0, true);
        this.sKey = jceInputStream.readString(1, true);
        this.iGetType = jceInputStream.read(this.iGetType, 2, false);
        this.sImsi1 = jceInputStream.readString(3, false);
        this.sImsi2 = jceInputStream.readString(4, false);
        this.iPopupVer = jceInputStream.read(this.iPopupVer, 5, false);
        this.iToastVer = jceInputStream.read(this.iToastVer, 6, false);
        this.iWkOrderState1 = jceInputStream.read(this.iWkOrderState1, 7, false);
        this.iWkOrderState2 = jceInputStream.read(this.iWkOrderState2, 8, false);
        this.lastVisitTime = jceInputStream.read(this.lastVisitTime, 9, false);
        this.iItemCfgVer = jceInputStream.read(this.iItemCfgVer, 10, false);
        this.pullPayRuleCfgTime = jceInputStream.read(this.pullPayRuleCfgTime, 11, false);
        this.clientLangugeId = jceInputStream.read(this.clientLangugeId, 12, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 13, false);
        this.qua = jceInputStream.readString(14, false);
        this.trace_info = jceInputStream.readString(15, false);
        this.qqvalue_info = (Map) jceInputStream.read((JceInputStream) cache_qqvalue_info, 16, false);
        this.recom_ext_info = jceInputStream.readString(17, false);
        this.mobile_info = (Map) jceInputStream.read((JceInputStream) cache_mobile_info, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sUin, 0);
        jceOutputStream.write(this.sKey, 1);
        jceOutputStream.write(this.iGetType, 2);
        String str = this.sImsi1;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.sImsi2;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.iPopupVer, 5);
        jceOutputStream.write(this.iToastVer, 6);
        jceOutputStream.write(this.iWkOrderState1, 7);
        jceOutputStream.write(this.iWkOrderState2, 8);
        jceOutputStream.write(this.lastVisitTime, 9);
        jceOutputStream.write(this.iItemCfgVer, 10);
        jceOutputStream.write(this.pullPayRuleCfgTime, 11);
        jceOutputStream.write(this.clientLangugeId, 12);
        Map<String, String> map = this.extendInfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        String str3 = this.qua;
        if (str3 != null) {
            jceOutputStream.write(str3, 14);
        }
        String str4 = this.trace_info;
        if (str4 != null) {
            jceOutputStream.write(str4, 15);
        }
        Map<String, String> map2 = this.qqvalue_info;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 16);
        }
        String str5 = this.recom_ext_info;
        if (str5 != null) {
            jceOutputStream.write(str5, 17);
        }
        Map<Integer, Integer> map3 = this.mobile_info;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 18);
        }
    }

    public PrivExtV2Req(String str, String str2, int i3, String str3, String str4, int i16, int i17, int i18, int i19, long j3, long j16, long j17, int i26, Map<String, String> map, String str5, String str6, Map<String, String> map2, String str7, Map<Integer, Integer> map3) {
        this.sUin = str;
        this.sKey = str2;
        this.iGetType = i3;
        this.sImsi1 = str3;
        this.sImsi2 = str4;
        this.iPopupVer = i16;
        this.iToastVer = i17;
        this.iWkOrderState1 = i18;
        this.iWkOrderState2 = i19;
        this.lastVisitTime = j3;
        this.iItemCfgVer = j16;
        this.pullPayRuleCfgTime = j17;
        this.clientLangugeId = i26;
        this.extendInfo = map;
        this.qua = str5;
        this.trace_info = str6;
        this.qqvalue_info = map2;
        this.recom_ext_info = str7;
        this.mobile_info = map3;
    }
}
