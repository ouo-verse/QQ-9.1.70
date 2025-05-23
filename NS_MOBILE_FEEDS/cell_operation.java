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
public final class cell_operation extends JceStruct {
    static Map<Integer, String> cache_busi_param = new HashMap();
    static Map<String, String> cache_bypass_param;
    static Map<Integer, Map<String, String>> cache_click_stream_report;
    static ArrayList<s_op_btn> cache_custom_btn;
    static Map<Integer, String> cache_droplist_cookie;
    static Map<Integer, String> cache_feed_report_cookie;
    static Map<Integer, String> cache_rank_param;
    static Map<Integer, String> cache_recomm_cookie;
    static s_schema cache_schema_info;
    static s_outshare cache_share_info;
    public Map<Integer, String> busi_param;
    public String button_gif_url;
    public Map<String, String> bypass_param;
    public Map<Integer, Map<String, String>> click_stream_report;
    public ArrayList<s_op_btn> custom_btn;
    public Map<Integer, String> droplist_cookie;
    public Map<Integer, String> feed_report_cookie;
    public String generic_url;
    public long offline_resource_bid;
    public String qboss_trace;
    public String qq_url;
    public String qzone_feedid;
    public Map<Integer, String> rank_param;
    public Map<Integer, String> recomm_cookie;
    public s_schema schema_info;
    public s_outshare share_info;
    public String weixin_url;

    static {
        cache_busi_param.put(0, "");
        cache_share_info = new s_outshare();
        cache_schema_info = new s_schema();
        cache_recomm_cookie = new HashMap();
        cache_recomm_cookie.put(0, "");
        cache_click_stream_report = new HashMap();
        HashMap hashMap = new HashMap();
        hashMap.put("", "");
        cache_click_stream_report.put(0, hashMap);
        cache_custom_btn = new ArrayList<>();
        cache_custom_btn.add(new s_op_btn());
        cache_feed_report_cookie = new HashMap();
        cache_feed_report_cookie.put(0, "");
        HashMap hashMap2 = new HashMap();
        cache_bypass_param = hashMap2;
        hashMap2.put("", "");
        cache_droplist_cookie = new HashMap();
        cache_droplist_cookie.put(0, "");
        cache_rank_param = new HashMap();
        cache_rank_param.put(0, "");
    }

    public cell_operation() {
        this.busi_param = null;
        this.weixin_url = "";
        this.qq_url = "";
        this.share_info = null;
        this.schema_info = null;
        this.recomm_cookie = null;
        this.click_stream_report = null;
        this.qboss_trace = "";
        this.custom_btn = null;
        this.feed_report_cookie = null;
        this.generic_url = "";
        this.bypass_param = null;
        this.droplist_cookie = null;
        this.rank_param = null;
        this.button_gif_url = "";
        this.offline_resource_bid = 0L;
        this.qzone_feedid = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.busi_param = (Map) jceInputStream.read((JceInputStream) cache_busi_param, 0, false);
        this.weixin_url = jceInputStream.readString(1, false);
        this.qq_url = jceInputStream.readString(2, false);
        this.share_info = (s_outshare) jceInputStream.read((JceStruct) cache_share_info, 3, false);
        this.schema_info = (s_schema) jceInputStream.read((JceStruct) cache_schema_info, 4, false);
        this.recomm_cookie = (Map) jceInputStream.read((JceInputStream) cache_recomm_cookie, 5, false);
        this.click_stream_report = (Map) jceInputStream.read((JceInputStream) cache_click_stream_report, 6, false);
        this.qboss_trace = jceInputStream.readString(7, false);
        this.custom_btn = (ArrayList) jceInputStream.read((JceInputStream) cache_custom_btn, 8, false);
        this.feed_report_cookie = (Map) jceInputStream.read((JceInputStream) cache_feed_report_cookie, 9, false);
        this.generic_url = jceInputStream.readString(10, false);
        this.bypass_param = (Map) jceInputStream.read((JceInputStream) cache_bypass_param, 11, false);
        this.droplist_cookie = (Map) jceInputStream.read((JceInputStream) cache_droplist_cookie, 12, false);
        this.rank_param = (Map) jceInputStream.read((JceInputStream) cache_rank_param, 13, false);
        this.button_gif_url = jceInputStream.readString(14, false);
        this.offline_resource_bid = jceInputStream.read(this.offline_resource_bid, 15, false);
        this.qzone_feedid = jceInputStream.readString(16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, String> map = this.busi_param;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        String str = this.weixin_url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.qq_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        s_outshare s_outshareVar = this.share_info;
        if (s_outshareVar != null) {
            jceOutputStream.write((JceStruct) s_outshareVar, 3);
        }
        s_schema s_schemaVar = this.schema_info;
        if (s_schemaVar != null) {
            jceOutputStream.write((JceStruct) s_schemaVar, 4);
        }
        Map<Integer, String> map2 = this.recomm_cookie;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 5);
        }
        Map<Integer, Map<String, String>> map3 = this.click_stream_report;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 6);
        }
        String str3 = this.qboss_trace;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        ArrayList<s_op_btn> arrayList = this.custom_btn;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        Map<Integer, String> map4 = this.feed_report_cookie;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 9);
        }
        String str4 = this.generic_url;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        Map<String, String> map5 = this.bypass_param;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 11);
        }
        Map<Integer, String> map6 = this.droplist_cookie;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 12);
        }
        Map<Integer, String> map7 = this.rank_param;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 13);
        }
        String str5 = this.button_gif_url;
        if (str5 != null) {
            jceOutputStream.write(str5, 14);
        }
        jceOutputStream.write(this.offline_resource_bid, 15);
        String str6 = this.qzone_feedid;
        if (str6 != null) {
            jceOutputStream.write(str6, 16);
        }
    }

    public cell_operation(Map<Integer, String> map, String str, String str2, s_outshare s_outshareVar, s_schema s_schemaVar, Map<Integer, String> map2, Map<Integer, Map<String, String>> map3, String str3, ArrayList<s_op_btn> arrayList, Map<Integer, String> map4, String str4, Map<String, String> map5, Map<Integer, String> map6, Map<Integer, String> map7, String str5, long j3, String str6) {
        this.busi_param = map;
        this.weixin_url = str;
        this.qq_url = str2;
        this.share_info = s_outshareVar;
        this.schema_info = s_schemaVar;
        this.recomm_cookie = map2;
        this.click_stream_report = map3;
        this.qboss_trace = str3;
        this.custom_btn = arrayList;
        this.feed_report_cookie = map4;
        this.generic_url = str4;
        this.bypass_param = map5;
        this.droplist_cookie = map6;
        this.rank_param = map7;
        this.button_gif_url = str5;
        this.offline_resource_bid = j3;
        this.qzone_feedid = str6;
    }
}
