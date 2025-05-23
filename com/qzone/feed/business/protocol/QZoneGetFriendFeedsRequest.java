package com.qzone.feed.business.protocol;

import NS_MOBILE_FEEDS.cnst.GDT_ADV_COOKIE;
import NS_MOBILE_FEEDS.mobile_feeds_req;
import NS_MOBILE_FEEDS.s_gps;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.app.k;
import com.qzone.business.lbsv2.business.c;
import com.qzone.common.requestengine.request.WnsRequest;
import com.qzone.commoncode.module.gdt.a;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.common.config.AppSetting;
import com.tencent.oskplayer.util.PlayerUtils;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LbsDataV2;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetFriendFeedsRequest extends WnsRequest {
    public static final int CMD_GET_ACITIVE_FEEDS = 0;
    public static final int CMD_GET_APPLIST_FEEDS = 17;
    public static final int CMD_GET_COMMON_PUSH_FEED = 28;
    public static final int CMD_GET_DETAIL_FEEDS = 16;
    public static final int CMD_GET_EVENT_FEEDS = 15;
    public static final int CMD_GET_EVENT_TAG_FEEDS = 19;
    public static final int CMD_GET_EXTEND_FEED = 24;
    public static final int CMD_GET_GROUP_FEED = 25;
    public static final int CMD_GET_HOT_FEEDS = 3;
    public static final int CMD_GET_LOCAL_FEEDS = 13;
    public static final int CMD_GET_NEW_ACTIVE_FEEDS = 10;
    public static final int CMD_GET_NUAN_FRIEND_FEED = 26;
    public static final int CMD_GET_NUAN_PROFILE_FEED = 27;
    public static final int CMD_GET_PRE_ACITIVE_FEEDS = 11;
    public static final int CMD_GET_PRE_PASSIVE_FEEDS = 14;
    public static final int CMD_GET_RECOMMEND_FEEDS = 23;
    public static final int CMD_GET_SEARCH_UGC_FEEDS = 9;
    public static final int CMD_GET_SECRET_ACT_FEEDS = 5;
    public static final int CMD_GET_SECRET_MSG_LIST = 7;
    public static final int CMD_GET_SECRET_PASSIVE_FEEDS = 6;
    public static final int CMD_GET_SPECIAL_ACTIVE_FEEDS = 12;
    public static final int CMD_GET_TIH_FEEDS = 8;
    public static final int CMD_GET_TIMELINE_FEEDS = 18;
    public static final int CMD_GET_UNREAD_FOLLOW_FEED = 22;
    public static final int CMD_GET_VIEW_MORE_FEEDS = 16;
    public static final int CMD_GTE_PASSIVE_FEEDS = 1;
    public static final int CMD_GTE_PROFILE_FEEDS = 2;
    public static final int CMD_GTE_RELATION_FEEDS = 4;
    public static final String CMD_STRING_GET_ACITIVE_FEEDS = "getActiveFeeds";
    public static final String CMD_STRING_GET_EVENT_TAG_FEEDS = "Feeds.getTagEventFeeds";
    public static final String CMD_STRING_GET_EXTEND_FEEDS = "Feeds.getKuolieFeeds";
    public static final String CMD_STRING_GET_GROUP_FEEDS = "Feeds.getgroupfeed";
    public static final String CMD_STRING_GET_HOT_FEEDS = "getHotFeeds";
    public static final String CMD_STRING_GET_LBS_EVENT_FEEDS = "getEventFeeds";
    public static final String CMD_STRING_GET_LOCAL_FEEDS = "getLocalFeeds";
    public static final String CMD_STRING_GET_NEW_ACITIVE_FEEDS = "getNewActiveFeeds";
    public static final String CMD_STRING_GET_NUAN_FRIEND_FEEDS = "Feeds.getKuolieActiveFeeds";
    public static final String CMD_STRING_GET_NUAN_PROFILE_FEEDS = "Feeds.getKuolieProfileFeeds";
    public static final String CMD_STRING_GET_PRE_ACITIVE_FEEDS = "getPreActiveFeeds";
    public static final String CMD_STRING_GET_PRE_PASSIVE_FEEDS = "preGetPassiveFeeds";
    public static final String CMD_STRING_GET_PROFILE_FEEDS_BY_TIME = "getProfileFeedsByTime";
    public static final String CMD_STRING_GET_RECOMMEND_FEEDS = "Feeds.getRankTabFeeds";
    public static final String CMD_STRING_GET_RELATION_FEEDS = "getRelationFeeds";
    public static final String CMD_STRING_GET_SECRET_ACT_FEEDS = "getSecretActFeeds";
    public static final String CMD_STRING_GET_SECRET_MSG_LIST = "getSecretMsgList";
    public static final String CMD_STRING_GET_SECRET_PASSIVE_FEEDS = "getSecretPavFeeds";
    public static final String CMD_STRING_GET_SPECIAL_ACTIVE_FEEDS = "getSpecialCareNewFeeds";
    public static final String CMD_STRING_GET_STORY_FEEDS = "Feeds.getUnreadFeeds";
    public static final String CMD_STRING_GET_TIH_FEEDS = "getTodayInHistoryFeeds";
    public static final String CMD_STRING_GET_UNREAD_FOLLOW_FEEDS = "Feeds.getUnreadFollowFeeds";
    public static final String CMD_STRING_GET_VIEW_MORE_FEEDS = "getViewMoreFeeds";
    public static final String CMD_STRING_GTE_PASSIVE_FEEDS = "getPassiveFeeds";
    public static final String CMD_STRING_GTE_PROFILE_FEEDS = "getProfileFeeds";
    public static final String CMD_STRING_UPDATE_FEEDS_LAYOUT_FILE = "Feeds.getLayoutKits";
    public static final int CMD_UPDATE_FEEDS_LAYOUT_FILE = 20;
    public static final int REFRESH_TYPE_LOAD_MORE = 2;
    public static final int REFRESH_TYPE_REFRESH_ALL = 1;
    public static final int RELATION_TYPE_AIO = 8;
    public static final int RELATION_TYPE_ALL = 3;
    public static final int RELATION_TYPE_CARE = 1;
    public static final int RELATION_TYPE_FAMOUS = 2;
    public static final int RELATION_TYPE_FRIEND = 0;
    public static final int RELATION_TYPE_LOCAL = 7;
    public static final int RELATION_TYPE_READLIST = 5;
    public static final int RELATION_TYPE_READLIST_RECOM = 6;
    public static final int SEARCH_TYPE_GUEST = 5;
    public static final int SEARCH_TYPE_NONE = -1;
    public static final int SEARCH_TYPE_SELF = 1;
    private int cmd;
    private mobile_feeds_req feedsReq;
    private long hostUin;
    private boolean mIsSupportPiece;
    private JceStruct mJceReq;
    private long ownerUin;

    public QZoneGetFriendFeedsRequest(int i3, int i16, int i17, int i18, String str, s_gps s_gpsVar, long j3, boolean z16, String str2, long j16, String str3, HashMap<Integer, String> hashMap) {
        this(i3, i16, i17, i18, str, s_gpsVar, j3, z16, str2, j16, str3, hashMap, null, null, null);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    protected long getHostUin() {
        return this.ownerUin;
    }

    public JceStruct getJceStruct() {
        return this.mJceReq;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    @Override // com.qzone.common.requestengine.request.WnsRequest, com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public boolean isSupportPiece() {
        return this.mIsSupportPiece;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    protected boolean needClientRetry() {
        String requestCmd = getRequestCmd();
        return "getActiveFeeds".equals(requestCmd) || "getPassiveFeeds".equals(requestCmd);
    }

    public void setAttachInfo(String str) {
        mobile_feeds_req mobile_feeds_reqVar = this.feedsReq;
        if (str == null) {
            str = "";
        }
        mobile_feeds_reqVar.attach_info = str;
    }

    public void setConfigurableCommand(String str) {
        setCmdString(str);
    }

    public void setConfigurableExtendInfo(HashMap<String, String> hashMap) {
        mobile_feeds_req mobile_feeds_reqVar = this.feedsReq;
        if (mobile_feeds_reqVar.stMapExtendinfo == null) {
            mobile_feeds_reqVar.stMapExtendinfo = new HashMap();
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.feedsReq.stMapExtendinfo.putAll(hashMap);
    }

    public void setDeviceInfo(String str) {
        this.feedsReq.device_info = str;
    }

    public void setFeedInfos(HashMap<String, String> hashMap) {
        this.feedsReq.feed_infos = hashMap;
    }

    public void setForceRefresh(boolean z16) {
        this.feedsReq.force = z16 ? (byte) 1 : (byte) 0;
    }

    public void setGdtAdvCookie() {
        mobile_feeds_req mobile_feeds_reqVar;
        if (getCmdString() == null || !getCmdString().contains(getCmdString(0))) {
            return;
        }
        String a16 = a.a();
        if (TextUtils.isEmpty(a16) || (mobile_feeds_reqVar = this.feedsReq) == null) {
            return;
        }
        if (mobile_feeds_reqVar.stMapExtendinfo == null) {
            mobile_feeds_reqVar.stMapExtendinfo = new HashMap();
        }
        this.feedsReq.stMapExtendinfo.put(GDT_ADV_COOKIE.value, a16);
    }

    @Override // cooperation.qzone.QzoneExternalRequest
    public void setHostUin(long j3) {
        this.hostUin = j3;
    }

    public void setJceStruct(JceStruct jceStruct) {
        this.mJceReq = jceStruct;
    }

    public void setLayoutFileInfo(Map<String, String> map) {
        this.feedsReq.kitFileInfos = map;
    }

    public void setScene(int i3) {
        this.feedsReq.scene = i3;
    }

    public void setSupportPiece(boolean z16) {
        this.mIsSupportPiece = z16;
    }

    public void setTlvAttachInfo(String str) {
        mobile_feeds_req mobile_feeds_reqVar = this.feedsReq;
        if (str == null) {
            str = "";
        }
        mobile_feeds_reqVar.tlv_attach_info = str;
    }

    @Override // com.qzone.common.requestengine.request.WnsRequest, com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        if (CMD_STRING_GET_EVENT_TAG_FEEDS.equals(getRequestCmd())) {
            return "getTagEventFeeds";
        }
        if (CMD_STRING_UPDATE_FEEDS_LAYOUT_FILE.equals(getRequestCmd())) {
            return "getLayoutKits";
        }
        if (CMD_STRING_GET_UNREAD_FOLLOW_FEEDS.equals(getRequestCmd())) {
            return "getUnreadFollowFeeds";
        }
        if (CMD_STRING_GET_EXTEND_FEEDS.equals(getRequestCmd())) {
            return "getKuolieFeeds";
        }
        if (CMD_STRING_GET_GROUP_FEEDS.equals(getRequestCmd())) {
            return "getgroupfeed";
        }
        if (CMD_STRING_GET_RECOMMEND_FEEDS.equals(getRequestCmd())) {
            return "getRankTabFeeds";
        }
        if (CMD_STRING_GET_NUAN_FRIEND_FEEDS.equals(getRequestCmd())) {
            return "getKuolieActiveFeeds";
        }
        if (CMD_STRING_GET_NUAN_PROFILE_FEEDS.equals(getRequestCmd())) {
            return "getKuolieProfileFeeds";
        }
        return getRequestCmd();
    }

    public QZoneGetFriendFeedsRequest(int i3, int i16, int i17, int i18, String str, s_gps s_gpsVar, long j3, boolean z16, String str2, long j16, String str3, HashMap<Integer, String> hashMap, Map<Integer, String> map, Map<String, byte[]> map2, HashMap<Integer, String> hashMap2) {
        super(getCmdString(i3));
        this.cmd = i3;
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        this.feedsReq = mobile_feeds_reqVar;
        mobile_feeds_reqVar.refresh_type = i16;
        mobile_feeds_reqVar.relation_type = i17;
        mobile_feeds_reqVar.count = i18;
        mobile_feeds_reqVar.attach_info = str == null ? "" : str;
        mobile_feeds_reqVar.gps_info = s_gpsVar;
        mobile_feeds_reqVar.rank_param = map;
        mobile_feeds_reqVar.mapBinaryExtendInfo = map2;
        this.ownerUin = j3;
        if (mobile_feeds_reqVar.busi_param == null) {
            mobile_feeds_reqVar.busi_param = new HashMap();
        }
        if (hashMap != null) {
            this.feedsReq.busi_param.putAll(hashMap);
        }
        mobile_feeds_req mobile_feeds_reqVar2 = this.feedsReq;
        if (mobile_feeds_reqVar2.mapDesc == null) {
            mobile_feeds_reqVar2.mapDesc = new HashMap();
        }
        if (hashMap2 != null) {
            this.feedsReq.mapDesc.putAll(hashMap2);
        }
        this.feedsReq.busi_param.put(29, "1");
        this.feedsReq.busi_param.put(182, "" + AppSetting.f());
        if (i3 == 1) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("source=1&from_notify=");
            sb5.append(z16 ? "1" : "0");
            this.feedsReq.busi_param.put(41, sb5.toString());
        }
        if (i3 == 14 && !TextUtils.isEmpty(str2)) {
            this.feedsReq.busi_param.put(94, str2);
        }
        if (i3 == 15) {
            this.feedsReq.busi_param.put(78, Long.toString(j16));
        }
        if (i3 == 19) {
            this.feedsReq.busi_param.put(126, str3 != null ? str3 : "");
        }
        mobile_feeds_req mobile_feeds_reqVar3 = this.feedsReq;
        if (mobile_feeds_reqVar3.stMapExtendinfo == null) {
            mobile_feeds_reqVar3.stMapExtendinfo = new HashMap();
        }
        if (i3 == 23) {
            this.feedsReq.rank_param = new HashMap();
        }
        if (k.f44493a) {
            this.feedsReq.stMapExtendinfo.put("HasGetSecretFeeds", "1");
        } else {
            this.feedsReq.stMapExtendinfo.put("HasGetSecretFeeds", "0");
        }
        if (hashMap2 != null && !hashMap2.isEmpty()) {
            this.feedsReq.mapDesc = hashMap2;
        }
        this.feedsReq.stMapExtendinfo.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        setGdtAdvCookie();
        this.req = this.feedsReq;
    }

    public void setNeedUnreadLine(boolean z16) {
        mobile_feeds_req mobile_feeds_reqVar;
        Map<Integer, String> map;
        if (!z16 || (mobile_feeds_reqVar = this.feedsReq) == null || (map = mobile_feeds_reqVar.busi_param) == null) {
            return;
        }
        map.put(164, "1");
    }

    private void addLbsInfoToRequest(mobile_feeds_req mobile_feeds_reqVar) {
        LbsDataV2.GpsInfo a16;
        if (mobile_feeds_reqVar == null || (a16 = c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_OTHER).a()) == null) {
            return;
        }
        if (mobile_feeds_reqVar.gps_info == null) {
            mobile_feeds_reqVar.gps_info = new s_gps();
        }
        s_gps s_gpsVar = mobile_feeds_reqVar.gps_info;
        s_gpsVar.longitude = a16.lon;
        s_gpsVar.latitude = a16.lat;
    }

    private static String getCmdString(int i3) {
        switch (i3) {
            case 0:
                return "getActiveFeeds";
            case 1:
                return "getPassiveFeeds";
            case 2:
            case 9:
            case 17:
            case 21:
            default:
                return CMD_STRING_GTE_PROFILE_FEEDS;
            case 3:
                return CMD_STRING_GET_HOT_FEEDS;
            case 4:
                return CMD_STRING_GET_RELATION_FEEDS;
            case 5:
                return CMD_STRING_GET_SECRET_ACT_FEEDS;
            case 6:
                return CMD_STRING_GET_SECRET_PASSIVE_FEEDS;
            case 7:
                return CMD_STRING_GET_SECRET_MSG_LIST;
            case 8:
                return CMD_STRING_GET_TIH_FEEDS;
            case 10:
                return CMD_STRING_GET_NEW_ACITIVE_FEEDS;
            case 11:
                return CMD_STRING_GET_PRE_ACITIVE_FEEDS;
            case 12:
                return CMD_STRING_GET_SPECIAL_ACTIVE_FEEDS;
            case 13:
                return CMD_STRING_GET_LOCAL_FEEDS;
            case 14:
                return CMD_STRING_GET_PRE_PASSIVE_FEEDS;
            case 15:
                return CMD_STRING_GET_LBS_EVENT_FEEDS;
            case 16:
                return CMD_STRING_GET_VIEW_MORE_FEEDS;
            case 18:
                return CMD_STRING_GET_PROFILE_FEEDS_BY_TIME;
            case 19:
                return CMD_STRING_GET_EVENT_TAG_FEEDS;
            case 20:
                return CMD_STRING_UPDATE_FEEDS_LAYOUT_FILE;
            case 22:
                return CMD_STRING_GET_UNREAD_FOLLOW_FEEDS;
            case 23:
                return CMD_STRING_GET_RECOMMEND_FEEDS;
            case 24:
                return CMD_STRING_GET_EXTEND_FEEDS;
            case 25:
                return CMD_STRING_GET_GROUP_FEEDS;
            case 26:
                return CMD_STRING_GET_NUAN_FRIEND_FEEDS;
            case 27:
                return CMD_STRING_GET_NUAN_PROFILE_FEEDS;
        }
    }

    public QZoneGetFriendFeedsRequest(int i3, int i16, int i17, int i18, long j3, boolean z16, long j16, s_gps s_gpsVar) {
        super(getCmdString(i3));
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        this.feedsReq = mobile_feeds_reqVar;
        mobile_feeds_reqVar.refresh_type = i16;
        mobile_feeds_reqVar.relation_type = i17;
        mobile_feeds_reqVar.count = i18;
        this.ownerUin = j3;
        if (mobile_feeds_reqVar.busi_param == null) {
            mobile_feeds_reqVar.busi_param = new HashMap();
        }
        mobile_feeds_req mobile_feeds_reqVar2 = this.feedsReq;
        mobile_feeds_reqVar2.gps_info = s_gpsVar;
        mobile_feeds_reqVar2.busi_param.put(29, "1");
        this.feedsReq.busi_param.put(78, Long.toString(j16));
        setSupportPiece(z16);
        mobile_feeds_req mobile_feeds_reqVar3 = this.feedsReq;
        if (mobile_feeds_reqVar3.stMapExtendinfo == null) {
            mobile_feeds_reqVar3.stMapExtendinfo = new HashMap();
        }
        this.feedsReq.stMapExtendinfo.put("mobile_detail_info", PlayerUtils.getMobileDetailInfo());
        setJceStruct(this.feedsReq);
    }

    public QZoneGetFriendFeedsRequest(int i3, long j3, BusinessFeedData businessFeedData) {
        super(getCmdString(i3));
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        this.feedsReq = mobile_feeds_reqVar;
        mobile_feeds_reqVar.refresh_type = 1;
        mobile_feeds_reqVar.busi_param = new HashMap();
        if (businessFeedData != null && businessFeedData.cellFollowGuide != null) {
            this.feedsReq.busi_param.put(97, businessFeedData.cellFollowGuide.attach_info);
        }
        this.ownerUin = j3;
        this.req = this.feedsReq;
    }

    public QZoneGetFriendFeedsRequest(Map<String, String> map) {
        super(getCmdString(20));
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        this.feedsReq = mobile_feeds_reqVar;
        mobile_feeds_reqVar.kitFileInfos = map;
        this.req = mobile_feeds_reqVar;
    }

    public QZoneGetFriendFeedsRequest(int i3, int i16, int i17, String str, int i18, long j3, boolean z16, int i19) {
        super(getCmdString(i3));
        mobile_feeds_req mobile_feeds_reqVar = new mobile_feeds_req();
        this.feedsReq = mobile_feeds_reqVar;
        mobile_feeds_reqVar.refresh_type = i16;
        mobile_feeds_reqVar.relation_type = i17;
        mobile_feeds_reqVar.count = i18;
        this.ownerUin = j3;
        if (mobile_feeds_reqVar.busi_param == null) {
            mobile_feeds_reqVar.busi_param = new HashMap();
        }
        str = str == null ? "" : str;
        this.feedsReq.busi_param.put(29, "1");
        this.feedsReq.busi_param.put(57, str);
        if (i19 != -1) {
            this.feedsReq.busi_param.put(73, String.valueOf(i19));
        }
        if (i3 == 0) {
            addLbsInfoToRequest(this.feedsReq);
        }
        setSupportPiece(z16);
        mobile_feeds_req mobile_feeds_reqVar2 = this.feedsReq;
        if (mobile_feeds_reqVar2.stMapExtendinfo == null) {
            mobile_feeds_reqVar2.stMapExtendinfo = new HashMap();
        }
        setGdtAdvCookie();
        setJceStruct(this.feedsReq);
        this.req = this.feedsReq;
    }
}
