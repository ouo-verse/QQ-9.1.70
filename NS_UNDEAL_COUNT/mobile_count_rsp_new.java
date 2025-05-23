package NS_UNDEAL_COUNT;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class mobile_count_rsp_new extends JceStruct {
    static byte[] cache_QzmallProfileDecoGetRsp;
    static int cache_cancellation_status;
    static Map<Integer, String> cache_extendinfo;
    static Map<Integer, Boolean> cache_featureSwitch;
    static Map<String, String> cache_holidayInfo;
    static stIntimateSpaceInfo cache_intimateSpaceInfo;
    static int cache_isShowNewFeedBanner;
    static int cache_jumpType;
    static Map<String, byte[]> cache_mapAutoTransData;
    static Map<Long, s_comm_data> cache_mapBuf;
    static Map<Long, Long> cache_mapDyncShowTime;
    static Map<Integer, ArrayList<entrance_cfg>> cache_mapEntranceCfg = new HashMap();
    static Map<String, String> cache_mapExtendinfo;
    static Map<Integer, mobile_feeds_tab_info> cache_mapFeedsTabInfo;
    static Map<Long, Long> cache_mapLastGetTime;
    static Map<String, byte[]> cache_mapTransData;
    static Map<Integer, yy_icon> cache_mapYYIconInfo;
    static Map<Integer, String> cache_map_strAdvUrl;
    static master_info cache_masterinfo;
    static stMomentInfo cache_momentInfo;
    static stPlusRecomInfo cache_plusRecom;
    static stNuanNuanComment cache_sContentOpComment;
    static stNuanNuanComment cache_snnComment;
    static ban_info cache_stBanInfo;
    static birth_info cache_stBirthInfo;
    static Map<Integer, count_info> cache_stMapCountInfo;
    static master_info cache_stMasterInfo;
    static medal_banner cache_stMedalBanner;
    static medal_info cache_stMedalInfo;
    static yellow_info cache_stYellowInfo;
    static combine_diamond_info cache_stuCombineDiamondInfo;
    static star_info cache_stuStarInfo;
    static ArrayList<operat_data> cache_vecOperateInfo;
    static ArrayList<String> cache_vec_blackReportPid;
    static ArrayList<String> cache_vec_reportid;
    static ArrayList<stSoftInfo> cache_vec_soft_infos;
    static ArrayList<String> cache_veckuolieHotTag;
    static stVerticalVideoDisplay cache_vertVideoDisplay;
    public byte[] QzmallProfileDecoGetRsp;
    public int cancellation_status;
    public Map<Integer, String> extendinfo;
    public Map<Integer, Boolean> featureSwitch;
    public int grayOperateMask;
    public Map<String, String> holidayInfo;
    public int iNextTimeout;
    public stIntimateSpaceInfo intimateSpaceInfo;
    public int isGetActiveWeiShi;
    public int isLiveShow;
    public int isNotRegisterQzone;
    public int isOpenFeedUpdate;
    public int isPlusRedBous;
    public int isPreLoad;
    public int isSetMemorySeal;
    public int isShowNewFeedBanner;
    public int isShowNewStyles;
    public int isTeenagerModelActFeedRestriction;
    public int isUpdateFeed;
    public int isVistorRedBous;
    public int jumpType;
    public Map<String, byte[]> mapAutoTransData;
    public Map<Long, s_comm_data> mapBuf;
    public Map<Long, Long> mapDyncShowTime;
    public Map<Integer, ArrayList<entrance_cfg>> mapEntranceCfg;
    public Map<String, String> mapExtendinfo;
    public Map<Integer, mobile_feeds_tab_info> mapFeedsTabInfo;
    public Map<Long, Long> mapLastGetTime;
    public Map<String, byte[]> mapTransData;
    public Map<Integer, yy_icon> mapYYIconInfo;
    public Map<Integer, String> map_strAdvUrl;
    public master_info masterinfo;
    public stMomentInfo momentInfo;
    public int operate_nbp_type;
    public int operate_newyear_mask;
    public stPlusRecomInfo plusRecom;
    public int report_counts;
    public int report_nexttime;
    public int report_sq_switch;
    public stNuanNuanComment sContentOpComment;
    public String sTransParam;
    public stNuanNuanComment snnComment;
    public String sqDyncFeedsJson;
    public ban_info stBanInfo;
    public birth_info stBirthInfo;
    public Map<Integer, count_info> stMapCountInfo;
    public master_info stMasterInfo;
    public medal_banner stMedalBanner;
    public medal_info stMedalInfo;
    public yellow_info stYellowInfo;
    public String strABTestId;
    public String strDeviceName;
    public String strNick;
    public String strRedBousUrl;
    public combine_diamond_info stuCombineDiamondInfo;
    public star_info stuStarInfo;
    public int switchTimeout;
    public String undealCountTime;
    public ArrayList<operat_data> vecOperateInfo;
    public ArrayList<String> vec_blackReportPid;
    public ArrayList<String> vec_reportid;
    public ArrayList<stSoftInfo> vec_soft_infos;
    public ArrayList<String> veckuolieHotTag;
    public stVerticalVideoDisplay vertVideoDisplay;

    static {
        ArrayList<entrance_cfg> arrayList = new ArrayList<>();
        arrayList.add(new entrance_cfg());
        cache_mapEntranceCfg.put(0, arrayList);
        cache_stMapCountInfo = new HashMap();
        cache_stMapCountInfo.put(0, new count_info());
        cache_stBanInfo = new ban_info();
        cache_stBirthInfo = new birth_info();
        cache_stYellowInfo = new yellow_info();
        cache_mapBuf = new HashMap();
        cache_mapBuf.put(0L, new s_comm_data());
        cache_masterinfo = new master_info();
        cache_vecOperateInfo = new ArrayList<>();
        cache_vecOperateInfo.add(new operat_data());
        cache_mapLastGetTime = new HashMap();
        cache_mapLastGetTime.put(0L, 0L);
        cache_stMasterInfo = new master_info();
        cache_stMedalInfo = new medal_info();
        cache_jumpType = 0;
        cache_stMedalBanner = new medal_banner();
        cache_mapYYIconInfo = new HashMap();
        cache_mapYYIconInfo.put(0, new yy_icon());
        cache_stuStarInfo = new star_info();
        cache_stuCombineDiamondInfo = new combine_diamond_info();
        cache_extendinfo = new HashMap();
        cache_extendinfo.put(0, "");
        cache_QzmallProfileDecoGetRsp = r5;
        byte[] bArr = {0};
        cache_isShowNewFeedBanner = 0;
        cache_mapFeedsTabInfo = new HashMap();
        cache_mapFeedsTabInfo.put(0, new mobile_feeds_tab_info());
        cache_map_strAdvUrl = new HashMap();
        cache_map_strAdvUrl.put(0, "");
        HashMap hashMap = new HashMap();
        cache_mapTransData = hashMap;
        hashMap.put("", new byte[]{0});
        HashMap hashMap2 = new HashMap();
        cache_mapExtendinfo = hashMap2;
        hashMap2.put("", "");
        cache_vertVideoDisplay = new stVerticalVideoDisplay();
        cache_snnComment = new stNuanNuanComment();
        cache_mapDyncShowTime = new HashMap();
        cache_mapDyncShowTime.put(0L, 0L);
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_vec_reportid = arrayList2;
        arrayList2.add("");
        ArrayList<String> arrayList3 = new ArrayList<>();
        cache_vec_blackReportPid = arrayList3;
        arrayList3.add("");
        cache_sContentOpComment = new stNuanNuanComment();
        cache_vec_soft_infos = new ArrayList<>();
        cache_vec_soft_infos.add(new stSoftInfo());
        cache_plusRecom = new stPlusRecomInfo();
        cache_cancellation_status = 0;
        ArrayList<String> arrayList4 = new ArrayList<>();
        cache_veckuolieHotTag = arrayList4;
        arrayList4.add("");
        HashMap hashMap3 = new HashMap();
        cache_mapAutoTransData = hashMap3;
        hashMap3.put("", new byte[]{0});
        cache_featureSwitch = new HashMap();
        cache_featureSwitch.put(0, Boolean.FALSE);
        cache_momentInfo = new stMomentInfo();
        cache_intimateSpaceInfo = new stIntimateSpaceInfo();
        HashMap hashMap4 = new HashMap();
        cache_holidayInfo = hashMap4;
        hashMap4.put("", "");
    }

    public mobile_count_rsp_new() {
        this.mapEntranceCfg = null;
        this.stMapCountInfo = null;
        this.stBanInfo = null;
        this.stBirthInfo = null;
        this.strNick = "";
        this.iNextTimeout = 0;
        this.stYellowInfo = null;
        this.strDeviceName = "";
        this.mapBuf = null;
        this.masterinfo = null;
        this.vecOperateInfo = null;
        this.mapLastGetTime = null;
        this.sTransParam = "";
        this.stMasterInfo = null;
        this.stMedalInfo = null;
        this.jumpType = 0;
        this.stMedalBanner = null;
        this.mapYYIconInfo = null;
        this.stuStarInfo = null;
        this.stuCombineDiamondInfo = null;
        this.extendinfo = null;
        this.undealCountTime = "";
        this.isPreLoad = 0;
        this.switchTimeout = 0;
        this.isLiveShow = 0;
        this.isShowNewStyles = 0;
        this.QzmallProfileDecoGetRsp = null;
        this.isShowNewFeedBanner = 0;
        this.isPlusRedBous = 0;
        this.isVistorRedBous = 0;
        this.strRedBousUrl = "";
        this.isSetMemorySeal = 0;
        this.isNotRegisterQzone = 0;
        this.isOpenFeedUpdate = 0;
        this.mapFeedsTabInfo = null;
        this.isUpdateFeed = 0;
        this.sqDyncFeedsJson = "";
        this.map_strAdvUrl = null;
        this.mapTransData = null;
        this.mapExtendinfo = null;
        this.grayOperateMask = 0;
        this.vertVideoDisplay = null;
        this.isGetActiveWeiShi = 50;
        this.snnComment = null;
        this.mapDyncShowTime = null;
        this.operate_newyear_mask = 0;
        this.strABTestId = "";
        this.operate_nbp_type = 0;
        this.vec_reportid = null;
        this.report_nexttime = 0;
        this.report_counts = 0;
        this.report_sq_switch = 0;
        this.vec_blackReportPid = null;
        this.sContentOpComment = null;
        this.vec_soft_infos = null;
        this.plusRecom = null;
        this.cancellation_status = 0;
        this.veckuolieHotTag = null;
        this.mapAutoTransData = null;
        this.isTeenagerModelActFeedRestriction = 0;
        this.featureSwitch = null;
        this.momentInfo = null;
        this.intimateSpaceInfo = null;
        this.holidayInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mapEntranceCfg = (Map) jceInputStream.read((JceInputStream) cache_mapEntranceCfg, 0, false);
        this.stMapCountInfo = (Map) jceInputStream.read((JceInputStream) cache_stMapCountInfo, 1, false);
        this.stBanInfo = (ban_info) jceInputStream.read((JceStruct) cache_stBanInfo, 2, false);
        this.stBirthInfo = (birth_info) jceInputStream.read((JceStruct) cache_stBirthInfo, 3, false);
        this.strNick = jceInputStream.readString(4, false);
        this.iNextTimeout = jceInputStream.read(this.iNextTimeout, 5, false);
        this.stYellowInfo = (yellow_info) jceInputStream.read((JceStruct) cache_stYellowInfo, 6, false);
        this.strDeviceName = jceInputStream.readString(7, false);
        this.mapBuf = (Map) jceInputStream.read((JceInputStream) cache_mapBuf, 8, false);
        this.masterinfo = (master_info) jceInputStream.read((JceStruct) cache_masterinfo, 9, false);
        this.vecOperateInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecOperateInfo, 10, false);
        this.mapLastGetTime = (Map) jceInputStream.read((JceInputStream) cache_mapLastGetTime, 11, false);
        this.sTransParam = jceInputStream.readString(12, false);
        this.stMasterInfo = (master_info) jceInputStream.read((JceStruct) cache_stMasterInfo, 13, false);
        this.stMedalInfo = (medal_info) jceInputStream.read((JceStruct) cache_stMedalInfo, 14, false);
        this.jumpType = jceInputStream.read(this.jumpType, 15, false);
        this.stMedalBanner = (medal_banner) jceInputStream.read((JceStruct) cache_stMedalBanner, 16, false);
        this.mapYYIconInfo = (Map) jceInputStream.read((JceInputStream) cache_mapYYIconInfo, 17, false);
        this.stuStarInfo = (star_info) jceInputStream.read((JceStruct) cache_stuStarInfo, 18, false);
        this.stuCombineDiamondInfo = (combine_diamond_info) jceInputStream.read((JceStruct) cache_stuCombineDiamondInfo, 19, false);
        this.extendinfo = (Map) jceInputStream.read((JceInputStream) cache_extendinfo, 20, false);
        this.undealCountTime = jceInputStream.readString(21, false);
        this.isPreLoad = jceInputStream.read(this.isPreLoad, 22, false);
        this.switchTimeout = jceInputStream.read(this.switchTimeout, 23, false);
        this.isLiveShow = jceInputStream.read(this.isLiveShow, 24, false);
        this.isShowNewStyles = jceInputStream.read(this.isShowNewStyles, 25, false);
        this.QzmallProfileDecoGetRsp = jceInputStream.read(cache_QzmallProfileDecoGetRsp, 26, false);
        this.isShowNewFeedBanner = jceInputStream.read(this.isShowNewFeedBanner, 27, false);
        this.isPlusRedBous = jceInputStream.read(this.isPlusRedBous, 28, false);
        this.isVistorRedBous = jceInputStream.read(this.isVistorRedBous, 29, false);
        this.strRedBousUrl = jceInputStream.readString(30, false);
        this.isSetMemorySeal = jceInputStream.read(this.isSetMemorySeal, 31, false);
        this.isNotRegisterQzone = jceInputStream.read(this.isNotRegisterQzone, 32, false);
        this.isOpenFeedUpdate = jceInputStream.read(this.isOpenFeedUpdate, 33, false);
        this.mapFeedsTabInfo = (Map) jceInputStream.read((JceInputStream) cache_mapFeedsTabInfo, 34, false);
        this.isUpdateFeed = jceInputStream.read(this.isUpdateFeed, 35, false);
        this.sqDyncFeedsJson = jceInputStream.readString(36, false);
        this.map_strAdvUrl = (Map) jceInputStream.read((JceInputStream) cache_map_strAdvUrl, 37, false);
        this.mapTransData = (Map) jceInputStream.read((JceInputStream) cache_mapTransData, 38, false);
        this.mapExtendinfo = (Map) jceInputStream.read((JceInputStream) cache_mapExtendinfo, 39, false);
        this.grayOperateMask = jceInputStream.read(this.grayOperateMask, 40, false);
        this.vertVideoDisplay = (stVerticalVideoDisplay) jceInputStream.read((JceStruct) cache_vertVideoDisplay, 41, false);
        this.isGetActiveWeiShi = jceInputStream.read(this.isGetActiveWeiShi, 42, false);
        this.snnComment = (stNuanNuanComment) jceInputStream.read((JceStruct) cache_snnComment, 43, false);
        this.mapDyncShowTime = (Map) jceInputStream.read((JceInputStream) cache_mapDyncShowTime, 44, false);
        this.operate_newyear_mask = jceInputStream.read(this.operate_newyear_mask, 45, false);
        this.strABTestId = jceInputStream.readString(46, false);
        this.operate_nbp_type = jceInputStream.read(this.operate_nbp_type, 47, false);
        this.vec_reportid = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_reportid, 48, false);
        this.report_nexttime = jceInputStream.read(this.report_nexttime, 49, false);
        this.report_counts = jceInputStream.read(this.report_counts, 50, false);
        this.report_sq_switch = jceInputStream.read(this.report_sq_switch, 51, false);
        this.vec_blackReportPid = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_blackReportPid, 52, false);
        this.sContentOpComment = (stNuanNuanComment) jceInputStream.read((JceStruct) cache_sContentOpComment, 53, false);
        this.vec_soft_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_vec_soft_infos, 54, false);
        this.plusRecom = (stPlusRecomInfo) jceInputStream.read((JceStruct) cache_plusRecom, 55, false);
        this.cancellation_status = jceInputStream.read(this.cancellation_status, 56, false);
        this.veckuolieHotTag = (ArrayList) jceInputStream.read((JceInputStream) cache_veckuolieHotTag, 57, false);
        this.mapAutoTransData = (Map) jceInputStream.read((JceInputStream) cache_mapAutoTransData, 58, false);
        this.isTeenagerModelActFeedRestriction = jceInputStream.read(this.isTeenagerModelActFeedRestriction, 59, false);
        this.featureSwitch = (Map) jceInputStream.read((JceInputStream) cache_featureSwitch, 60, false);
        this.momentInfo = (stMomentInfo) jceInputStream.read((JceStruct) cache_momentInfo, 61, false);
        this.intimateSpaceInfo = (stIntimateSpaceInfo) jceInputStream.read((JceStruct) cache_intimateSpaceInfo, 62, false);
        this.holidayInfo = (Map) jceInputStream.read((JceInputStream) cache_holidayInfo, 63, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Integer, ArrayList<entrance_cfg>> map = this.mapEntranceCfg;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        Map<Integer, count_info> map2 = this.stMapCountInfo;
        if (map2 != null) {
            jceOutputStream.write((Map) map2, 1);
        }
        ban_info ban_infoVar = this.stBanInfo;
        if (ban_infoVar != null) {
            jceOutputStream.write((JceStruct) ban_infoVar, 2);
        }
        birth_info birth_infoVar = this.stBirthInfo;
        if (birth_infoVar != null) {
            jceOutputStream.write((JceStruct) birth_infoVar, 3);
        }
        String str = this.strNick;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
        jceOutputStream.write(this.iNextTimeout, 5);
        yellow_info yellow_infoVar = this.stYellowInfo;
        if (yellow_infoVar != null) {
            jceOutputStream.write((JceStruct) yellow_infoVar, 6);
        }
        String str2 = this.strDeviceName;
        if (str2 != null) {
            jceOutputStream.write(str2, 7);
        }
        Map<Long, s_comm_data> map3 = this.mapBuf;
        if (map3 != null) {
            jceOutputStream.write((Map) map3, 8);
        }
        master_info master_infoVar = this.masterinfo;
        if (master_infoVar != null) {
            jceOutputStream.write((JceStruct) master_infoVar, 9);
        }
        ArrayList<operat_data> arrayList = this.vecOperateInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        Map<Long, Long> map4 = this.mapLastGetTime;
        if (map4 != null) {
            jceOutputStream.write((Map) map4, 11);
        }
        String str3 = this.sTransParam;
        if (str3 != null) {
            jceOutputStream.write(str3, 12);
        }
        master_info master_infoVar2 = this.stMasterInfo;
        if (master_infoVar2 != null) {
            jceOutputStream.write((JceStruct) master_infoVar2, 13);
        }
        medal_info medal_infoVar = this.stMedalInfo;
        if (medal_infoVar != null) {
            jceOutputStream.write((JceStruct) medal_infoVar, 14);
        }
        jceOutputStream.write(this.jumpType, 15);
        medal_banner medal_bannerVar = this.stMedalBanner;
        if (medal_bannerVar != null) {
            jceOutputStream.write((JceStruct) medal_bannerVar, 16);
        }
        Map<Integer, yy_icon> map5 = this.mapYYIconInfo;
        if (map5 != null) {
            jceOutputStream.write((Map) map5, 17);
        }
        star_info star_infoVar = this.stuStarInfo;
        if (star_infoVar != null) {
            jceOutputStream.write((JceStruct) star_infoVar, 18);
        }
        combine_diamond_info combine_diamond_infoVar = this.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            jceOutputStream.write((JceStruct) combine_diamond_infoVar, 19);
        }
        Map<Integer, String> map6 = this.extendinfo;
        if (map6 != null) {
            jceOutputStream.write((Map) map6, 20);
        }
        String str4 = this.undealCountTime;
        if (str4 != null) {
            jceOutputStream.write(str4, 21);
        }
        jceOutputStream.write(this.isPreLoad, 22);
        jceOutputStream.write(this.switchTimeout, 23);
        jceOutputStream.write(this.isLiveShow, 24);
        jceOutputStream.write(this.isShowNewStyles, 25);
        byte[] bArr = this.QzmallProfileDecoGetRsp;
        if (bArr != null) {
            jceOutputStream.write(bArr, 26);
        }
        jceOutputStream.write(this.isShowNewFeedBanner, 27);
        jceOutputStream.write(this.isPlusRedBous, 28);
        jceOutputStream.write(this.isVistorRedBous, 29);
        String str5 = this.strRedBousUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 30);
        }
        jceOutputStream.write(this.isSetMemorySeal, 31);
        jceOutputStream.write(this.isNotRegisterQzone, 32);
        jceOutputStream.write(this.isOpenFeedUpdate, 33);
        Map<Integer, mobile_feeds_tab_info> map7 = this.mapFeedsTabInfo;
        if (map7 != null) {
            jceOutputStream.write((Map) map7, 34);
        }
        jceOutputStream.write(this.isUpdateFeed, 35);
        String str6 = this.sqDyncFeedsJson;
        if (str6 != null) {
            jceOutputStream.write(str6, 36);
        }
        Map<Integer, String> map8 = this.map_strAdvUrl;
        if (map8 != null) {
            jceOutputStream.write((Map) map8, 37);
        }
        Map<String, byte[]> map9 = this.mapTransData;
        if (map9 != null) {
            jceOutputStream.write((Map) map9, 38);
        }
        Map<String, String> map10 = this.mapExtendinfo;
        if (map10 != null) {
            jceOutputStream.write((Map) map10, 39);
        }
        jceOutputStream.write(this.grayOperateMask, 40);
        stVerticalVideoDisplay stverticalvideodisplay = this.vertVideoDisplay;
        if (stverticalvideodisplay != null) {
            jceOutputStream.write((JceStruct) stverticalvideodisplay, 41);
        }
        jceOutputStream.write(this.isGetActiveWeiShi, 42);
        stNuanNuanComment stnuannuancomment = this.snnComment;
        if (stnuannuancomment != null) {
            jceOutputStream.write((JceStruct) stnuannuancomment, 43);
        }
        Map<Long, Long> map11 = this.mapDyncShowTime;
        if (map11 != null) {
            jceOutputStream.write((Map) map11, 44);
        }
        jceOutputStream.write(this.operate_newyear_mask, 45);
        String str7 = this.strABTestId;
        if (str7 != null) {
            jceOutputStream.write(str7, 46);
        }
        jceOutputStream.write(this.operate_nbp_type, 47);
        ArrayList<String> arrayList2 = this.vec_reportid;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 48);
        }
        jceOutputStream.write(this.report_nexttime, 49);
        jceOutputStream.write(this.report_counts, 50);
        jceOutputStream.write(this.report_sq_switch, 51);
        ArrayList<String> arrayList3 = this.vec_blackReportPid;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 52);
        }
        stNuanNuanComment stnuannuancomment2 = this.sContentOpComment;
        if (stnuannuancomment2 != null) {
            jceOutputStream.write((JceStruct) stnuannuancomment2, 53);
        }
        ArrayList<stSoftInfo> arrayList4 = this.vec_soft_infos;
        if (arrayList4 != null) {
            jceOutputStream.write((Collection) arrayList4, 54);
        }
        stPlusRecomInfo stplusrecominfo = this.plusRecom;
        if (stplusrecominfo != null) {
            jceOutputStream.write((JceStruct) stplusrecominfo, 55);
        }
        jceOutputStream.write(this.cancellation_status, 56);
        ArrayList<String> arrayList5 = this.veckuolieHotTag;
        if (arrayList5 != null) {
            jceOutputStream.write((Collection) arrayList5, 57);
        }
        Map<String, byte[]> map12 = this.mapAutoTransData;
        if (map12 != null) {
            jceOutputStream.write((Map) map12, 58);
        }
        jceOutputStream.write(this.isTeenagerModelActFeedRestriction, 59);
        Map<Integer, Boolean> map13 = this.featureSwitch;
        if (map13 != null) {
            jceOutputStream.write((Map) map13, 60);
        }
        stMomentInfo stmomentinfo = this.momentInfo;
        if (stmomentinfo != null) {
            jceOutputStream.write((JceStruct) stmomentinfo, 61);
        }
        stIntimateSpaceInfo stintimatespaceinfo = this.intimateSpaceInfo;
        if (stintimatespaceinfo != null) {
            jceOutputStream.write((JceStruct) stintimatespaceinfo, 62);
        }
        Map<String, String> map14 = this.holidayInfo;
        if (map14 != null) {
            jceOutputStream.write((Map) map14, 63);
        }
    }

    public mobile_count_rsp_new(Map<Integer, ArrayList<entrance_cfg>> map, Map<Integer, count_info> map2, ban_info ban_infoVar, birth_info birth_infoVar, String str, int i3, yellow_info yellow_infoVar, String str2, Map<Long, s_comm_data> map3, master_info master_infoVar, ArrayList<operat_data> arrayList, Map<Long, Long> map4, String str3, master_info master_infoVar2, medal_info medal_infoVar, int i16, medal_banner medal_bannerVar, Map<Integer, yy_icon> map5, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, Map<Integer, String> map6, String str4, int i17, int i18, int i19, int i26, byte[] bArr, int i27, int i28, int i29, String str5, int i36, int i37, int i38, Map<Integer, mobile_feeds_tab_info> map7, int i39, String str6, Map<Integer, String> map8, Map<String, byte[]> map9, Map<String, String> map10, int i46, stVerticalVideoDisplay stverticalvideodisplay, int i47, stNuanNuanComment stnuannuancomment, Map<Long, Long> map11, int i48, String str7, int i49, ArrayList<String> arrayList2, int i56, int i57, int i58, ArrayList<String> arrayList3, stNuanNuanComment stnuannuancomment2, ArrayList<stSoftInfo> arrayList4, stPlusRecomInfo stplusrecominfo, int i59, ArrayList<String> arrayList5, Map<String, byte[]> map12, int i65, Map<Integer, Boolean> map13, stMomentInfo stmomentinfo, stIntimateSpaceInfo stintimatespaceinfo, Map<String, String> map14) {
        this.mapEntranceCfg = map;
        this.stMapCountInfo = map2;
        this.stBanInfo = ban_infoVar;
        this.stBirthInfo = birth_infoVar;
        this.strNick = str;
        this.iNextTimeout = i3;
        this.stYellowInfo = yellow_infoVar;
        this.strDeviceName = str2;
        this.mapBuf = map3;
        this.masterinfo = master_infoVar;
        this.vecOperateInfo = arrayList;
        this.mapLastGetTime = map4;
        this.sTransParam = str3;
        this.stMasterInfo = master_infoVar2;
        this.stMedalInfo = medal_infoVar;
        this.jumpType = i16;
        this.stMedalBanner = medal_bannerVar;
        this.mapYYIconInfo = map5;
        this.stuStarInfo = star_infoVar;
        this.stuCombineDiamondInfo = combine_diamond_infoVar;
        this.extendinfo = map6;
        this.undealCountTime = str4;
        this.isPreLoad = i17;
        this.switchTimeout = i18;
        this.isLiveShow = i19;
        this.isShowNewStyles = i26;
        this.QzmallProfileDecoGetRsp = bArr;
        this.isShowNewFeedBanner = i27;
        this.isPlusRedBous = i28;
        this.isVistorRedBous = i29;
        this.strRedBousUrl = str5;
        this.isSetMemorySeal = i36;
        this.isNotRegisterQzone = i37;
        this.isOpenFeedUpdate = i38;
        this.mapFeedsTabInfo = map7;
        this.isUpdateFeed = i39;
        this.sqDyncFeedsJson = str6;
        this.map_strAdvUrl = map8;
        this.mapTransData = map9;
        this.mapExtendinfo = map10;
        this.grayOperateMask = i46;
        this.vertVideoDisplay = stverticalvideodisplay;
        this.isGetActiveWeiShi = i47;
        this.snnComment = stnuannuancomment;
        this.mapDyncShowTime = map11;
        this.operate_newyear_mask = i48;
        this.strABTestId = str7;
        this.operate_nbp_type = i49;
        this.vec_reportid = arrayList2;
        this.report_nexttime = i56;
        this.report_counts = i57;
        this.report_sq_switch = i58;
        this.vec_blackReportPid = arrayList3;
        this.sContentOpComment = stnuannuancomment2;
        this.vec_soft_infos = arrayList4;
        this.plusRecom = stplusrecominfo;
        this.cancellation_status = i59;
        this.veckuolieHotTag = arrayList5;
        this.mapAutoTransData = map12;
        this.isTeenagerModelActFeedRestriction = i65;
        this.featureSwitch = map13;
        this.momentInfo = stmomentinfo;
        this.intimateSpaceInfo = stintimatespaceinfo;
        this.holidayInfo = map14;
    }
}
