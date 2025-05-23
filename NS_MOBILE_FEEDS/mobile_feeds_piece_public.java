package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_feeds_piece_public extends JceStruct {
    static Map<String, String> cache_stMapExtendinfo;
    public String attach_info;
    public Map<Integer, String> extendinfo;
    public int hasmore;
    public s_cover host_cover;
    public long host_imbitmap;
    public String hostnick;
    public long iFollowNum;
    public int iYellowLevel;
    public int iYellowType;
    public int is_detail_report;
    public int network_report;
    public long newcount;
    public int no_update;
    public long req_count;
    public Map<String, String> stMapExtendinfo;
    public interest_list uin_info;
    public String user_sid;
    static s_cover cache_host_cover = new s_cover();
    static interest_list cache_uin_info = new interest_list();
    static Map<Integer, String> cache_extendinfo = new HashMap();

    static {
        cache_extendinfo.put(0, "");
        HashMap hashMap = new HashMap();
        cache_stMapExtendinfo = hashMap;
        hashMap.put("", "");
    }

    public mobile_feeds_piece_public() {
        this.hasmore = 0;
        this.newcount = 0L;
        this.hostnick = "";
        this.attach_info = "";
        this.no_update = 0;
        this.req_count = 0L;
        this.iYellowType = 0;
        this.iYellowLevel = 0;
        this.iFollowNum = 0L;
        this.host_imbitmap = 0L;
        this.user_sid = "";
        this.host_cover = null;
        this.uin_info = null;
        this.extendinfo = null;
        this.is_detail_report = 0;
        this.network_report = 1;
        this.stMapExtendinfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 0, false);
        this.newcount = jceInputStream.read(this.newcount, 1, false);
        this.hostnick = jceInputStream.readString(2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.no_update = jceInputStream.read(this.no_update, 4, false);
        this.req_count = jceInputStream.read(this.req_count, 5, false);
        this.iYellowType = jceInputStream.read(this.iYellowType, 6, false);
        this.iYellowLevel = jceInputStream.read(this.iYellowLevel, 7, false);
        this.iFollowNum = jceInputStream.read(this.iFollowNum, 8, false);
        this.host_imbitmap = jceInputStream.read(this.host_imbitmap, 9, false);
        this.user_sid = jceInputStream.readString(10, false);
        this.host_cover = (s_cover) jceInputStream.read((JceStruct) cache_host_cover, 11, false);
        this.uin_info = (interest_list) jceInputStream.read((JceStruct) cache_uin_info, 12, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 13, false);
        this.is_detail_report = jceInputStream.read(this.is_detail_report, 14, false);
        this.network_report = jceInputStream.read(this.network_report, 15, false);
        this.stMapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_stMapExtendinfo, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 0);
        jceOutputStream.write(this.newcount, 1);
        String str = this.hostnick;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.attach_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.no_update, 4);
        jceOutputStream.write(this.req_count, 5);
        jceOutputStream.write(this.iYellowType, 6);
        jceOutputStream.write(this.iYellowLevel, 7);
        jceOutputStream.write(this.iFollowNum, 8);
        jceOutputStream.write(this.host_imbitmap, 9);
        String str3 = this.user_sid;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        s_cover s_coverVar = this.host_cover;
        if (s_coverVar != null) {
            jceOutputStream.write((JceStruct) s_coverVar, 11);
        }
        interest_list interest_listVar = this.uin_info;
        if (interest_listVar != null) {
            jceOutputStream.write((JceStruct) interest_listVar, 12);
        }
        Map<Integer, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        jceOutputStream.write(this.is_detail_report, 14);
        jceOutputStream.write(this.network_report, 15);
        Map<String, String> map2 = this.stMapExtendinfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 16);
        }
    }

    public mobile_feeds_piece_public(int i3, long j3, String str, String str2, int i16, long j16, int i17, int i18, long j17, long j18, String str3, s_cover s_coverVar, interest_list interest_listVar, Map<Integer, String> map, int i19, int i26, Map<String, String> map2) {
        this.hasmore = i3;
        this.newcount = j3;
        this.hostnick = str;
        this.attach_info = str2;
        this.no_update = i16;
        this.req_count = j16;
        this.iYellowType = i17;
        this.iYellowLevel = i18;
        this.iFollowNum = j17;
        this.host_imbitmap = j18;
        this.user_sid = str3;
        this.host_cover = s_coverVar;
        this.uin_info = interest_listVar;
        this.extendinfo = map;
        this.is_detail_report = i19;
        this.network_report = i26;
        this.stMapExtendinfo = map2;
    }
}
