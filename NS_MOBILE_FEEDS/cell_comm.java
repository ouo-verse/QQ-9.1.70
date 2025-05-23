package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.UgcRightInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_comm extends JceStruct {
    static ArrayList<s_droplist_option> cache_custom_droplist;
    static Map<String, String> cache_extendInfo;
    static Map<String, byte[]> cache_extendInfoData;
    static UgcRightInfo cache_right_info = new UgcRightInfo();
    static Map<Integer, Integer> cache_stMapABTest = new HashMap();
    public int actiontype;
    public String actionurl;
    public long adv_stytle;
    public long adv_subtype;
    public int appid;
    public String clientkey;
    public int comment_view_num;
    public String curlikekey;
    public ArrayList<s_droplist_option> custom_droplist;
    public long editmask;
    public Map<String, String> extendInfo;
    public Map<String, byte[]> extendInfoData;
    public long feedsDelTime;
    public int feedsattr;
    public int feedsattr2;
    public long feedsattr3;
    public String feedsid;
    public String feedskey;
    public int feedstype;
    public int hot_score;
    public int iClick_area;
    public String icon_token;
    public String interestkey;
    public boolean is_kuolie;
    public boolean is_stay;
    public long lastmodify_time;
    public int operatemask;
    public int operatemask2;
    public long operatemask3;
    public String orglikekey;
    public int originaltype;
    public String paykey;
    public int positionmask;
    public int positionmask2;
    public boolean pull_qzone;
    public int recom_show_type;
    public int recomlayout;
    public long recomreportid;
    public int recomtype;
    public String refer;
    public int reportfeedsattr;
    public UgcRightInfo right_info;
    public int shield;
    public long show_mask;
    public int space_right;
    public String sqDynamicFeedsKey;
    public Map<Integer, Integer> stMapABTest;
    public int subid;
    public int time;
    public int uflag;
    public String ugckey;
    public String ugcrightkey;
    public int wup_feeds_type;

    static {
        cache_stMapABTest.put(0, 0);
        cache_custom_droplist = new ArrayList<>();
        cache_custom_droplist.add(new s_droplist_option());
        HashMap hashMap = new HashMap();
        cache_extendInfo = hashMap;
        hashMap.put("", "");
        HashMap hashMap2 = new HashMap();
        cache_extendInfoData = hashMap2;
        hashMap2.put("", new byte[]{0});
    }

    public cell_comm() {
        this.appid = 0;
        this.subid = 0;
        this.refer = "";
        this.time = 0;
        this.actiontype = 0;
        this.actionurl = "";
        this.originaltype = 0;
        this.operatemask = 0;
        this.feedskey = "";
        this.orglikekey = "";
        this.curlikekey = "";
        this.feedstype = 0;
        this.feedsattr = 0;
        this.ugckey = "";
        this.clientkey = "";
        this.show_mask = 0L;
        this.uflag = 0;
        this.shield = 0;
        this.ugcrightkey = "";
        this.interestkey = "";
        this.recomtype = 0;
        this.feedsid = "";
        this.adv_stytle = 0L;
        this.adv_subtype = 0L;
        this.right_info = null;
        this.recomlayout = 0;
        this.recomreportid = 0L;
        this.space_right = 0;
        this.reportfeedsattr = 0;
        this.recom_show_type = 0;
        this.wup_feeds_type = 0;
        this.stMapABTest = null;
        this.is_stay = false;
        this.paykey = "";
        this.operatemask2 = 0;
        this.positionmask = 0;
        this.positionmask2 = 0;
        this.editmask = 4294967295L;
        this.custom_droplist = null;
        this.extendInfo = null;
        this.feedsattr2 = 0;
        this.feedsDelTime = 0L;
        this.sqDynamicFeedsKey = "";
        this.iClick_area = 0;
        this.extendInfoData = null;
        this.hot_score = 0;
        this.is_kuolie = false;
        this.pull_qzone = false;
        this.operatemask3 = 0L;
        this.feedsattr3 = 0L;
        this.lastmodify_time = 0L;
        this.icon_token = "";
        this.comment_view_num = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.appid = jceInputStream.read(this.appid, 0, false);
        this.subid = jceInputStream.read(this.subid, 1, false);
        this.refer = jceInputStream.readString(2, false);
        this.time = jceInputStream.read(this.time, 3, false);
        this.actiontype = jceInputStream.read(this.actiontype, 4, false);
        this.actionurl = jceInputStream.readString(5, false);
        this.originaltype = jceInputStream.read(this.originaltype, 6, false);
        this.operatemask = jceInputStream.read(this.operatemask, 7, false);
        this.feedskey = jceInputStream.readString(8, false);
        this.orglikekey = jceInputStream.readString(9, false);
        this.curlikekey = jceInputStream.readString(10, false);
        this.feedstype = jceInputStream.read(this.feedstype, 11, false);
        this.feedsattr = jceInputStream.read(this.feedsattr, 12, false);
        this.ugckey = jceInputStream.readString(13, false);
        this.clientkey = jceInputStream.readString(14, false);
        this.show_mask = jceInputStream.read(this.show_mask, 15, false);
        this.uflag = jceInputStream.read(this.uflag, 16, false);
        this.shield = jceInputStream.read(this.shield, 17, false);
        this.ugcrightkey = jceInputStream.readString(18, false);
        this.interestkey = jceInputStream.readString(19, false);
        this.recomtype = jceInputStream.read(this.recomtype, 20, false);
        this.feedsid = jceInputStream.readString(21, false);
        this.adv_stytle = jceInputStream.read(this.adv_stytle, 22, false);
        this.adv_subtype = jceInputStream.read(this.adv_subtype, 23, false);
        this.right_info = (UgcRightInfo) jceInputStream.read((JceStruct) cache_right_info, 24, false);
        this.recomlayout = jceInputStream.read(this.recomlayout, 25, false);
        this.recomreportid = jceInputStream.read(this.recomreportid, 26, false);
        this.space_right = jceInputStream.read(this.space_right, 27, false);
        this.reportfeedsattr = jceInputStream.read(this.reportfeedsattr, 28, false);
        this.recom_show_type = jceInputStream.read(this.recom_show_type, 29, false);
        this.wup_feeds_type = jceInputStream.read(this.wup_feeds_type, 30, false);
        this.stMapABTest = (Map) jceInputStream.read((JceInputStream) cache_stMapABTest, 31, false);
        this.is_stay = jceInputStream.read(this.is_stay, 32, false);
        this.paykey = jceInputStream.readString(33, false);
        this.operatemask2 = jceInputStream.read(this.operatemask2, 34, false);
        this.positionmask = jceInputStream.read(this.positionmask, 35, false);
        this.positionmask2 = jceInputStream.read(this.positionmask2, 36, false);
        this.editmask = jceInputStream.read(this.editmask, 37, false);
        this.custom_droplist = (ArrayList) jceInputStream.read((JceInputStream) cache_custom_droplist, 38, false);
        this.extendInfo = (Map) jceInputStream.read((JceInputStream) cache_extendInfo, 39, false);
        this.feedsattr2 = jceInputStream.read(this.feedsattr2, 40, false);
        this.feedsDelTime = jceInputStream.read(this.feedsDelTime, 41, false);
        this.sqDynamicFeedsKey = jceInputStream.readString(42, false);
        this.iClick_area = jceInputStream.read(this.iClick_area, 43, false);
        this.extendInfoData = (Map) jceInputStream.read((JceInputStream) cache_extendInfoData, 44, false);
        this.hot_score = jceInputStream.read(this.hot_score, 45, false);
        this.is_kuolie = jceInputStream.read(this.is_kuolie, 46, false);
        this.pull_qzone = jceInputStream.read(this.pull_qzone, 47, false);
        this.operatemask3 = jceInputStream.read(this.operatemask3, 48, false);
        this.feedsattr3 = jceInputStream.read(this.feedsattr3, 49, false);
        this.lastmodify_time = jceInputStream.read(this.lastmodify_time, 50, false);
        this.icon_token = jceInputStream.readString(51, false);
        this.comment_view_num = jceInputStream.read(this.comment_view_num, 52, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.appid, 0);
        jceOutputStream.write(this.subid, 1);
        String str = this.refer;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.time, 3);
        jceOutputStream.write(this.actiontype, 4);
        String str2 = this.actionurl;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        jceOutputStream.write(this.originaltype, 6);
        jceOutputStream.write(this.operatemask, 7);
        String str3 = this.feedskey;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.orglikekey;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        String str5 = this.curlikekey;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.feedstype, 11);
        jceOutputStream.write(this.feedsattr, 12);
        String str6 = this.ugckey;
        if (str6 != null) {
            jceOutputStream.write(str6, 13);
        }
        String str7 = this.clientkey;
        if (str7 != null) {
            jceOutputStream.write(str7, 14);
        }
        jceOutputStream.write(this.show_mask, 15);
        jceOutputStream.write(this.uflag, 16);
        jceOutputStream.write(this.shield, 17);
        String str8 = this.ugcrightkey;
        if (str8 != null) {
            jceOutputStream.write(str8, 18);
        }
        String str9 = this.interestkey;
        if (str9 != null) {
            jceOutputStream.write(str9, 19);
        }
        jceOutputStream.write(this.recomtype, 20);
        String str10 = this.feedsid;
        if (str10 != null) {
            jceOutputStream.write(str10, 21);
        }
        jceOutputStream.write(this.adv_stytle, 22);
        jceOutputStream.write(this.adv_subtype, 23);
        UgcRightInfo ugcRightInfo = this.right_info;
        if (ugcRightInfo != null) {
            jceOutputStream.write((JceStruct) ugcRightInfo, 24);
        }
        jceOutputStream.write(this.recomlayout, 25);
        jceOutputStream.write(this.recomreportid, 26);
        jceOutputStream.write(this.space_right, 27);
        jceOutputStream.write(this.reportfeedsattr, 28);
        jceOutputStream.write(this.recom_show_type, 29);
        jceOutputStream.write(this.wup_feeds_type, 30);
        Map<Integer, Integer> map = this.stMapABTest;
        if (map != null) {
            jceOutputStream.write((Map) map, 31);
        }
        jceOutputStream.write(this.is_stay, 32);
        String str11 = this.paykey;
        if (str11 != null) {
            jceOutputStream.write(str11, 33);
        }
        jceOutputStream.write(this.operatemask2, 34);
        jceOutputStream.write(this.positionmask, 35);
        jceOutputStream.write(this.positionmask2, 36);
        jceOutputStream.write(this.editmask, 37);
        ArrayList<s_droplist_option> arrayList = this.custom_droplist;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 38);
        }
        Map<String, String> map2 = this.extendInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 39);
        }
        jceOutputStream.write(this.feedsattr2, 40);
        jceOutputStream.write(this.feedsDelTime, 41);
        String str12 = this.sqDynamicFeedsKey;
        if (str12 != null) {
            jceOutputStream.write(str12, 42);
        }
        jceOutputStream.write(this.iClick_area, 43);
        Map<String, byte[]> map3 = this.extendInfoData;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 44);
        }
        jceOutputStream.write(this.hot_score, 45);
        jceOutputStream.write(this.is_kuolie, 46);
        jceOutputStream.write(this.pull_qzone, 47);
        jceOutputStream.write(this.operatemask3, 48);
        jceOutputStream.write(this.feedsattr3, 49);
        jceOutputStream.write(this.lastmodify_time, 50);
        String str13 = this.icon_token;
        if (str13 != null) {
            jceOutputStream.write(str13, 51);
        }
        jceOutputStream.write(this.comment_view_num, 52);
    }

    public cell_comm(int i3, int i16, String str, int i17, int i18, String str2, int i19, int i26, String str3, String str4, String str5, int i27, int i28, String str6, String str7, long j3, int i29, int i36, String str8, String str9, int i37, String str10, long j16, long j17, UgcRightInfo ugcRightInfo, int i38, long j18, int i39, int i46, int i47, int i48, Map<Integer, Integer> map, boolean z16, String str11, int i49, int i56, int i57, long j19, ArrayList<s_droplist_option> arrayList, Map<String, String> map2, int i58, long j26, String str12, int i59, Map<String, byte[]> map3, int i65, boolean z17, boolean z18, long j27, long j28, long j29, String str13, int i66) {
        this.appid = i3;
        this.subid = i16;
        this.refer = str;
        this.time = i17;
        this.actiontype = i18;
        this.actionurl = str2;
        this.originaltype = i19;
        this.operatemask = i26;
        this.feedskey = str3;
        this.orglikekey = str4;
        this.curlikekey = str5;
        this.feedstype = i27;
        this.feedsattr = i28;
        this.ugckey = str6;
        this.clientkey = str7;
        this.show_mask = j3;
        this.uflag = i29;
        this.shield = i36;
        this.ugcrightkey = str8;
        this.interestkey = str9;
        this.recomtype = i37;
        this.feedsid = str10;
        this.adv_stytle = j16;
        this.adv_subtype = j17;
        this.right_info = ugcRightInfo;
        this.recomlayout = i38;
        this.recomreportid = j18;
        this.space_right = i39;
        this.reportfeedsattr = i46;
        this.recom_show_type = i47;
        this.wup_feeds_type = i48;
        this.stMapABTest = map;
        this.is_stay = z16;
        this.paykey = str11;
        this.operatemask2 = i49;
        this.positionmask = i56;
        this.positionmask2 = i57;
        this.editmask = j19;
        this.custom_droplist = arrayList;
        this.extendInfo = map2;
        this.feedsattr2 = i58;
        this.feedsDelTime = j26;
        this.sqDynamicFeedsKey = str12;
        this.iClick_area = i59;
        this.extendInfoData = map3;
        this.hot_score = i65;
        this.is_kuolie = z17;
        this.pull_qzone = z18;
        this.operatemask3 = j27;
        this.feedsattr3 = j28;
        this.lastmodify_time = j29;
        this.icon_token = str13;
        this.comment_view_num = i66;
    }
}
