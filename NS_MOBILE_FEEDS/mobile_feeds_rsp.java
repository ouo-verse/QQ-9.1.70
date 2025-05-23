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
public final class mobile_feeds_rsp extends JceStruct {
    static ArrayList<single_feed> cache_all_feeds_data = new ArrayList<>();
    static Map<Integer, String> cache_extendinfo;
    static s_cover cache_host_cover;
    static Map<String, String> cache_kitfileData;
    static login_uin_info cache_loginuin_info;
    static Map<Integer, UnifyRecomStruct> cache_mapRecomUnifyList;
    static st_prefetch cache_prefetch_rsp;
    static Map<Integer, String> cache_rank_param;
    static s_campus_info cache_stCampusInfo;
    static FunnySpace cache_stFunnySpace;
    static s_join_list cache_stJoinList;
    static s_life_moment cache_stLifeMemntInfo;
    static Map<String, String> cache_stMapExtendinfo;
    static s_memory_seal_off cache_stMemoryInfo;
    static s_profile_timeline cache_stProfileTimeLine;
    static byte[] cache_stShangchengInfo;
    static s_event_tag cache_stTagPageData;
    static interest_list cache_uin_info;
    public ArrayList<single_feed> all_feeds_data;
    public String attach_info;
    public int auto_load;
    public boolean bPsvOpenKapu;
    public int dailyShuoShuoCount;
    public Map<Integer, String> extendinfo;
    public int gamebar_video_checking_num;
    public int hasmore;
    public long host_bitmap4;
    public s_cover host_cover;
    public long host_imbitmap;
    public long iFollowNum;
    public int is_detail_report;
    public int is_realname_succ;
    public Map<String, String> kitfileData;
    public login_uin_info loginuin_info;
    public Map<Integer, UnifyRecomStruct> mapRecomUnifyList;
    public int network_report;
    public long newcount;
    public long next_keep_alive_time;
    public int no_update;
    public st_prefetch prefetch_rsp;
    public Map<Integer, String> rank_param;
    public long req_count;
    public s_campus_info stCampusInfo;
    public FunnySpace stFunnySpace;
    public s_join_list stJoinList;
    public s_life_moment stLifeMemntInfo;
    public Map<String, String> stMapExtendinfo;
    public s_memory_seal_off stMemoryInfo;
    public s_profile_timeline stProfileTimeLine;
    public byte[] stShangchengInfo;
    public s_event_tag stTagPageData;
    public interest_list uin_info;
    public int undealFeedCount;
    public String undealFeedTime;
    public String user_sid;

    static {
        cache_all_feeds_data.add(new single_feed());
        cache_prefetch_rsp = new st_prefetch();
        cache_host_cover = new s_cover();
        cache_uin_info = new interest_list();
        cache_loginuin_info = new login_uin_info();
        cache_extendinfo = new HashMap();
        cache_extendinfo.put(0, "");
        HashMap hashMap = new HashMap();
        cache_stMapExtendinfo = hashMap;
        hashMap.put("", "");
        cache_stProfileTimeLine = new s_profile_timeline();
        cache_stJoinList = new s_join_list();
        cache_mapRecomUnifyList = new HashMap();
        cache_mapRecomUnifyList.put(0, new UnifyRecomStruct());
        cache_stMemoryInfo = new s_memory_seal_off();
        HashMap hashMap2 = new HashMap();
        cache_kitfileData = hashMap2;
        hashMap2.put("", "");
        cache_stLifeMemntInfo = new s_life_moment();
        cache_rank_param = new HashMap();
        cache_rank_param.put(0, "");
        cache_stFunnySpace = new FunnySpace();
        cache_stShangchengInfo = r1;
        byte[] bArr = {0};
        cache_stCampusInfo = new s_campus_info();
        cache_stTagPageData = new s_event_tag();
    }

    public mobile_feeds_rsp() {
        this.hasmore = 0;
        this.attach_info = "";
        this.all_feeds_data = null;
        this.newcount = 0L;
        this.auto_load = 0;
        this.no_update = 0;
        this.req_count = 0L;
        this.iFollowNum = 0L;
        this.host_imbitmap = 0L;
        this.user_sid = "";
        this.prefetch_rsp = null;
        this.is_realname_succ = 0;
        this.host_cover = null;
        this.uin_info = null;
        this.gamebar_video_checking_num = 0;
        this.loginuin_info = null;
        this.extendinfo = null;
        this.is_detail_report = 0;
        this.network_report = 1;
        this.undealFeedTime = "";
        this.stMapExtendinfo = null;
        this.undealFeedCount = 0;
        this.stProfileTimeLine = null;
        this.next_keep_alive_time = 0L;
        this.stJoinList = null;
        this.mapRecomUnifyList = null;
        this.stMemoryInfo = null;
        this.kitfileData = null;
        this.stLifeMemntInfo = null;
        this.rank_param = null;
        this.stFunnySpace = null;
        this.stShangchengInfo = null;
        this.dailyShuoShuoCount = 0;
        this.bPsvOpenKapu = true;
        this.stCampusInfo = null;
        this.stTagPageData = null;
        this.host_bitmap4 = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hasmore = jceInputStream.read(this.hasmore, 0, false);
        this.attach_info = jceInputStream.readString(1, false);
        this.all_feeds_data = (ArrayList) jceInputStream.read((JceInputStream) cache_all_feeds_data, 2, false);
        this.newcount = jceInputStream.read(this.newcount, 3, false);
        this.auto_load = jceInputStream.read(this.auto_load, 4, false);
        this.no_update = jceInputStream.read(this.no_update, 5, false);
        this.req_count = jceInputStream.read(this.req_count, 6, false);
        this.iFollowNum = jceInputStream.read(this.iFollowNum, 7, false);
        this.host_imbitmap = jceInputStream.read(this.host_imbitmap, 8, false);
        this.user_sid = jceInputStream.readString(9, false);
        this.prefetch_rsp = (st_prefetch) jceInputStream.read((JceStruct) cache_prefetch_rsp, 10, false);
        this.is_realname_succ = jceInputStream.read(this.is_realname_succ, 11, false);
        this.host_cover = (s_cover) jceInputStream.read((JceStruct) cache_host_cover, 12, false);
        this.uin_info = (interest_list) jceInputStream.read((JceStruct) cache_uin_info, 13, false);
        this.gamebar_video_checking_num = jceInputStream.read(this.gamebar_video_checking_num, 14, false);
        this.loginuin_info = (login_uin_info) jceInputStream.read((JceStruct) cache_loginuin_info, 15, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 16, false);
        this.is_detail_report = jceInputStream.read(this.is_detail_report, 17, false);
        this.network_report = jceInputStream.read(this.network_report, 18, false);
        this.undealFeedTime = jceInputStream.readString(19, false);
        this.stMapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_stMapExtendinfo, 20, false);
        this.undealFeedCount = jceInputStream.read(this.undealFeedCount, 21, false);
        this.stProfileTimeLine = (s_profile_timeline) jceInputStream.read((JceStruct) cache_stProfileTimeLine, 22, false);
        this.next_keep_alive_time = jceInputStream.read(this.next_keep_alive_time, 23, false);
        this.stJoinList = (s_join_list) jceInputStream.read((JceStruct) cache_stJoinList, 24, false);
        this.mapRecomUnifyList = (Map) jceInputStream.read((JceInputStream) cache_mapRecomUnifyList, 25, false);
        this.stMemoryInfo = (s_memory_seal_off) jceInputStream.read((JceStruct) cache_stMemoryInfo, 26, false);
        this.kitfileData = (Map) jceInputStream.read((JceInputStream) cache_kitfileData, 27, false);
        this.stLifeMemntInfo = (s_life_moment) jceInputStream.read((JceStruct) cache_stLifeMemntInfo, 28, false);
        this.rank_param = (Map) jceInputStream.read((JceInputStream) cache_rank_param, 29, false);
        this.stFunnySpace = (FunnySpace) jceInputStream.read((JceStruct) cache_stFunnySpace, 30, false);
        this.stShangchengInfo = jceInputStream.read(cache_stShangchengInfo, 31, false);
        this.dailyShuoShuoCount = jceInputStream.read(this.dailyShuoShuoCount, 32, false);
        this.bPsvOpenKapu = jceInputStream.read(this.bPsvOpenKapu, 33, false);
        this.stCampusInfo = (s_campus_info) jceInputStream.read((JceStruct) cache_stCampusInfo, 34, false);
        this.stTagPageData = (s_event_tag) jceInputStream.read((JceStruct) cache_stTagPageData, 35, false);
        this.host_bitmap4 = jceInputStream.read(this.host_bitmap4, 36, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.hasmore, 0);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<single_feed> arrayList = this.all_feeds_data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.newcount, 3);
        jceOutputStream.write(this.auto_load, 4);
        jceOutputStream.write(this.no_update, 5);
        jceOutputStream.write(this.req_count, 6);
        jceOutputStream.write(this.iFollowNum, 7);
        jceOutputStream.write(this.host_imbitmap, 8);
        String str2 = this.user_sid;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        st_prefetch st_prefetchVar = this.prefetch_rsp;
        if (st_prefetchVar != null) {
            jceOutputStream.write((JceStruct) st_prefetchVar, 10);
        }
        jceOutputStream.write(this.is_realname_succ, 11);
        s_cover s_coverVar = this.host_cover;
        if (s_coverVar != null) {
            jceOutputStream.write((JceStruct) s_coverVar, 12);
        }
        interest_list interest_listVar = this.uin_info;
        if (interest_listVar != null) {
            jceOutputStream.write((JceStruct) interest_listVar, 13);
        }
        jceOutputStream.write(this.gamebar_video_checking_num, 14);
        login_uin_info login_uin_infoVar = this.loginuin_info;
        if (login_uin_infoVar != null) {
            jceOutputStream.write((JceStruct) login_uin_infoVar, 15);
        }
        Map<Integer, String> map = this.extendinfo;
        if (map != null) {
            jceOutputStream.write((Map) map, 16);
        }
        jceOutputStream.write(this.is_detail_report, 17);
        jceOutputStream.write(this.network_report, 18);
        String str3 = this.undealFeedTime;
        if (str3 != null) {
            jceOutputStream.write(str3, 19);
        }
        Map<String, String> map2 = this.stMapExtendinfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 20);
        }
        jceOutputStream.write(this.undealFeedCount, 21);
        s_profile_timeline s_profile_timelineVar = this.stProfileTimeLine;
        if (s_profile_timelineVar != null) {
            jceOutputStream.write((JceStruct) s_profile_timelineVar, 22);
        }
        jceOutputStream.write(this.next_keep_alive_time, 23);
        s_join_list s_join_listVar = this.stJoinList;
        if (s_join_listVar != null) {
            jceOutputStream.write((JceStruct) s_join_listVar, 24);
        }
        Map<Integer, UnifyRecomStruct> map3 = this.mapRecomUnifyList;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 25);
        }
        s_memory_seal_off s_memory_seal_offVar = this.stMemoryInfo;
        if (s_memory_seal_offVar != null) {
            jceOutputStream.write((JceStruct) s_memory_seal_offVar, 26);
        }
        Map<String, String> map4 = this.kitfileData;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 27);
        }
        s_life_moment s_life_momentVar = this.stLifeMemntInfo;
        if (s_life_momentVar != null) {
            jceOutputStream.write((JceStruct) s_life_momentVar, 28);
        }
        Map<Integer, String> map5 = this.rank_param;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 29);
        }
        FunnySpace funnySpace = this.stFunnySpace;
        if (funnySpace != null) {
            jceOutputStream.write((JceStruct) funnySpace, 30);
        }
        byte[] bArr = this.stShangchengInfo;
        if (bArr != null) {
            jceOutputStream.write(bArr, 31);
        }
        jceOutputStream.write(this.dailyShuoShuoCount, 32);
        jceOutputStream.write(this.bPsvOpenKapu, 33);
        s_campus_info s_campus_infoVar = this.stCampusInfo;
        if (s_campus_infoVar != null) {
            jceOutputStream.write((JceStruct) s_campus_infoVar, 34);
        }
        s_event_tag s_event_tagVar = this.stTagPageData;
        if (s_event_tagVar != null) {
            jceOutputStream.write((JceStruct) s_event_tagVar, 35);
        }
        jceOutputStream.write(this.host_bitmap4, 36);
    }

    public mobile_feeds_rsp(int i3, String str, ArrayList<single_feed> arrayList, long j3, int i16, int i17, long j16, long j17, long j18, String str2, st_prefetch st_prefetchVar, int i18, s_cover s_coverVar, interest_list interest_listVar, int i19, login_uin_info login_uin_infoVar, Map<Integer, String> map, int i26, int i27, String str3, Map<String, String> map2, int i28, s_profile_timeline s_profile_timelineVar, long j19, s_join_list s_join_listVar, Map<Integer, UnifyRecomStruct> map3, s_memory_seal_off s_memory_seal_offVar, Map<String, String> map4, s_life_moment s_life_momentVar, Map<Integer, String> map5, FunnySpace funnySpace, byte[] bArr, int i29, boolean z16, s_campus_info s_campus_infoVar, s_event_tag s_event_tagVar, long j26) {
        this.hasmore = i3;
        this.attach_info = str;
        this.all_feeds_data = arrayList;
        this.newcount = j3;
        this.auto_load = i16;
        this.no_update = i17;
        this.req_count = j16;
        this.iFollowNum = j17;
        this.host_imbitmap = j18;
        this.user_sid = str2;
        this.prefetch_rsp = st_prefetchVar;
        this.is_realname_succ = i18;
        this.host_cover = s_coverVar;
        this.uin_info = interest_listVar;
        this.gamebar_video_checking_num = i19;
        this.loginuin_info = login_uin_infoVar;
        this.extendinfo = map;
        this.is_detail_report = i26;
        this.network_report = i27;
        this.undealFeedTime = str3;
        this.stMapExtendinfo = map2;
        this.undealFeedCount = i28;
        this.stProfileTimeLine = s_profile_timelineVar;
        this.next_keep_alive_time = j19;
        this.stJoinList = s_join_listVar;
        this.mapRecomUnifyList = map3;
        this.stMemoryInfo = s_memory_seal_offVar;
        this.kitfileData = map4;
        this.stLifeMemntInfo = s_life_momentVar;
        this.rank_param = map5;
        this.stFunnySpace = funnySpace;
        this.stShangchengInfo = bArr;
        this.dailyShuoShuoCount = i29;
        this.bPsvOpenKapu = z16;
        this.stCampusInfo = s_campus_infoVar;
        this.stTagPageData = s_event_tagVar;
        this.host_bitmap4 = j26;
    }
}
