package com.tencent.mobileqq.tianshu.pb;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import s4.c;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class BusinessInfoCheckUpdate {
    static IPatchRedirector $redirector_ = null;
    public static final int PlatAnd = 109;
    public static final int PlatAndIos = 109110;
    public static final int PlatIos = 110;
    public static final int ReqSubTypeRedPartialRefresh = 1;
    public static final int ReqTypeCommon = 6;
    public static final int ReqTypeDTTabOut = 5;
    public static final int ReqTypeDismissMetaBubble = 9;
    public static final int ReqTypeEnterForeground = 2;
    public static final int ReqTypeGetLbs = 8;
    public static final int ReqTypeLogin = 1;
    public static final int ReqTypeNumPush = 4;
    public static final int ReqTypeQCirclePush = 10;
    public static final int ReqTypeQQTabSwitch = 11;
    public static final int ReqTypeRedPush = 3;
    public static final int ReqTypeStudyMode = 7;
    public static final int ReqTypeTimingRefresh = 12;
    public static final int ReqTypeUnknown = 0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class AppInfo extends MessageMicro<AppInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 24, 32, 42, 50, 56, 66, 72, 80, 90, 96, 104, 112, 120, 130, 136, 144, 154, 160, 168, 176, 184, 192, 200, 210, 216, 226}, new String[]{"uiAppId", "iNewFlag", "type", "buffer", "path", "modify_ts", "missions", "appset", WidgetCacheConstellationData.NUM, "icon_url", "icon_flag", "icon_type", "push_red_ts", "mission_level", "red_display_info", "use_cache", "preload_ts", QFSEdgeItem.KEY_EXTEND, "exposure_max", "id_list", "push_to", "click_max", "carousel", "delay_show", "hash", "version", "busi_data"}, new Object[]{0, 0, 0, "", "", 0, "", 0, 0, "", 0, 0, 0, 0, null, Boolean.FALSE, 0L, "", 0, 0L, 0, 0, 0, 0, "", 0L, ByteStringMicro.EMPTY}, AppInfo.class);
        public final PBUInt32Field uiAppId = PBField.initUInt32(0);
        public final PBInt32Field iNewFlag = PBField.initInt32(0);
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBStringField buffer = PBField.initString("");
        public final PBStringField path = PBField.initString("");
        public final PBUInt32Field modify_ts = PBField.initUInt32(0);
        public final PBRepeatField<String> missions = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBInt32Field appset = PBField.initInt32(0);
        public final PBInt32Field num = PBField.initInt32(0);
        public final PBStringField icon_url = PBField.initString("");
        public final PBInt32Field icon_flag = PBField.initInt32(0);
        public final PBInt32Field icon_type = PBField.initInt32(0);
        public final PBUInt32Field push_red_ts = PBField.initUInt32(0);
        public final PBInt32Field mission_level = PBField.initInt32(0);
        public RedDisplayInfo red_display_info = new RedDisplayInfo();
        public final PBBoolField use_cache = PBField.initBool(false);
        public final PBInt64Field preload_ts = PBField.initInt64(0);
        public final PBStringField extend = PBField.initString("");
        public final PBUInt32Field exposure_max = PBField.initUInt32(0);
        public final PBRepeatField<Long> id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field push_to = PBField.initUInt32(0);
        public final PBUInt32Field click_max = PBField.initUInt32(0);
        public final PBUInt32Field carousel = PBField.initUInt32(0);
        public final PBUInt32Field delay_show = PBField.initUInt32(0);
        public final PBStringField hash = PBField.initString("");
        public final PBUInt64Field version = PBField.initUInt64(0);
        public final PBBytesField busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class AppSetting extends MessageMicro<AppSetting> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"appid", "setting", "modify_ts"}, new Object[]{0, Boolean.FALSE, 0L}, AppSetting.class);
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBBoolField setting = PBField.initBool(false);
        public final PBUInt64Field modify_ts = PBField.initUInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class BatchSetSettingReqBody extends MessageMicro<BatchSetSettingReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uiUin", "uiClientPlatID", "sClientVer", "rptSetting"}, new Object[]{0L, 0, "", null}, BatchSetSettingReqBody.class);
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
        public final PBStringField sClientVer = PBField.initString("");
        public final PBRepeatMessageField<AppSetting> rptSetting = PBField.initRepeatMessage(AppSetting.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class BatchSetSettingRspBody extends MessageMicro<BatchSetSettingRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"iResult", "sErrMsg"}, new Object[]{0, ""}, BatchSetSettingRspBody.class);
        public final PBInt32Field iResult = PBField.initInt32(0);
        public final PBStringField sErrMsg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class BooleanEntry extends MessageMicro<BooleanEntry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"key", "value"}, new Object[]{0, Boolean.FALSE}, BooleanEntry.class);
        public final PBUInt32Field key = PBField.initUInt32(0);
        public final PBBoolField value = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class Entry extends MessageMicro<Entry> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"key", "value"}, new Object[]{0, 0}, Entry.class);
        public final PBUInt32Field key = PBField.initUInt32(0);
        public final PBInt32Field value = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsCellInfo extends MessageMicro<LbsCellInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"mcc", "mnc", "lac", c.CELLID, "rssi", "stationLat", "stationLng"}, new Object[]{0, 0, 0, 0, 0, 0, 0}, LbsCellInfo.class);
        public final PBInt32Field mcc = PBField.initInt32(0);
        public final PBInt32Field mnc = PBField.initInt32(0);
        public final PBInt32Field lac = PBField.initInt32(0);
        public final PBInt32Field cellid = PBField.initInt32(0);
        public final PBInt32Field rssi = PBField.initInt32(0);
        public final PBInt32Field stationLat = PBField.initInt32(0);
        public final PBInt32Field stationLng = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsDetailInfo extends MessageMicro<LbsDetailInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"subnation", "poilist"}, new Object[]{null, null}, LbsDetailInfo.class);
        public LbsSubnation subnation = new LbsSubnation();
        public final PBRepeatMessageField<LbsPoiInfo> poilist = PBField.initRepeatMessage(LbsPoiInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsDispatchReqBody extends MessageMicro<LbsDispatchReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50}, new String[]{"iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "sClientIP", "lbs"}, new Object[]{0, 0, "", 0L, 0, null}, LbsDispatchReqBody.class);
        public final PBInt32Field iProtocolVer = PBField.initInt32(0);
        public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
        public final PBStringField sClientVer = PBField.initString("");
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBUInt32Field sClientIP = PBField.initUInt32(0);
        public LbsInfo lbs = new LbsInfo();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsDispatchRspBody extends MessageMicro<LbsDispatchRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"iRetCode"}, new Object[]{0}, LbsDispatchRspBody.class);
        public final PBInt32Field iRetCode = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsInfo extends MessageMicro<LbsInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"location", "cells", "wlan", "detail_info"}, new Object[]{null, null, null, null}, LbsInfo.class);
        public LbsLocationInfo location = new LbsLocationInfo();
        public final PBRepeatMessageField<LbsCellInfo> cells = PBField.initRepeatMessage(LbsCellInfo.class);
        public final PBRepeatMessageField<LbsWlanInfo> wlan = PBField.initRepeatMessage(LbsWlanInfo.class);
        public LbsDetailInfo detail_info = new LbsDetailInfo();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsLocationInfo extends MessageMicro<LbsLocationInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"coordinate", "latitude", "longitude", "additional"}, new Object[]{0, 0, 0, ""}, LbsLocationInfo.class);
        public final PBInt32Field coordinate = PBField.initInt32(0);
        public final PBInt32Field latitude = PBField.initInt32(0);
        public final PBInt32Field longitude = PBField.initInt32(0);
        public final PBStringField additional = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsPoiInfo extends MessageMicro<LbsPoiInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 128}, new String[]{"name", "addr", "catalog", "latitude", "longitude", "dist", "uid", "catalogid", "city", "cityid", "dianping_id", "hotvalue", "is_business_area", "province", TtmlNode.TAG_REGION, "shopping_mall"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", 0, "", "", 0}, LbsPoiInfo.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField addr = PBField.initString("");
        public final PBStringField catalog = PBField.initString("");
        public final PBStringField latitude = PBField.initString("");
        public final PBStringField longitude = PBField.initString("");
        public final PBStringField dist = PBField.initString("");
        public final PBStringField uid = PBField.initString("");
        public final PBStringField catalogid = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBStringField cityid = PBField.initString("");
        public final PBStringField dianping_id = PBField.initString("");
        public final PBStringField hotvalue = PBField.initString("");
        public final PBInt32Field is_business_area = PBField.initInt32(0);
        public final PBStringField province = PBField.initString("");
        public final PBStringField region = PBField.initString("");
        public final PBInt32Field shopping_mall = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsSubnation extends MessageMicro<LbsSubnation> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130}, new String[]{"name", "code", "nation", "province", "city", "district", "town", "village", "street", "street_no", "ad_area_level_1", "ad_area_level_2", "ad_area_level_3", "locality", "sublocality", "colloquial_area"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, LbsSubnation.class);
        public final PBStringField name = PBField.initString("");
        public final PBStringField code = PBField.initString("");
        public final PBStringField nation = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBStringField district = PBField.initString("");
        public final PBStringField town = PBField.initString("");
        public final PBStringField village = PBField.initString("");
        public final PBStringField street = PBField.initString("");
        public final PBStringField street_no = PBField.initString("");
        public final PBStringField ad_area_level_1 = PBField.initString("");
        public final PBStringField ad_area_level_2 = PBField.initString("");
        public final PBStringField ad_area_level_3 = PBField.initString("");
        public final PBStringField locality = PBField.initString("");
        public final PBStringField sublocality = PBField.initString("");
        public final PBStringField colloquial_area = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class LbsWlanInfo extends MessageMicro<LbsWlanInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"mac", TPDownloadProxyEnum.USER_SSID, "rssi"}, new Object[]{"", "", 0}, LbsWlanInfo.class);
        public final PBStringField mac = PBField.initString("");
        public final PBStringField ssid = PBField.initString("");
        public final PBInt32Field rssi = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgBusi extends MessageMicro<NumMsgBusi> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 66, 74}, new String[]{"uint64_msgid", "uint32_appid", "str_path", "str_missionid", "uint32_expire_time", "str_content", "str_url", "str_ext", "str_ret"}, new Object[]{0L, 0, "", "", 0, "", "", "", ""}, NumMsgBusi.class);
        public final PBUInt64Field uint64_msgid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBStringField str_path = PBField.initString("");
        public final PBStringField str_missionid = PBField.initString("");
        public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
        public final PBStringField str_content = PBField.initString("");
        public final PBStringField str_url = PBField.initString("");
        public final PBStringField str_ext = PBField.initString("");
        public final PBStringField str_ret = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgReqBody extends MessageMicro<NumMsgReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_msg"}, new Object[]{0, 0, "", 0L, null}, NumMsgReqBody.class);
        public final PBInt32Field i_proto_ver = PBField.initInt32(0);
        public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
        public final PBStringField str_client_ver = PBField.initString("");
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumMsgBusi> rpt_num_msg = PBField.initRepeatMessage(NumMsgBusi.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumMsgRspBody extends MessageMicro<NumMsgRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"i_retcode", "str_errmsg", "uint64_uin", "rpt_num_red"}, new Object[]{0, "", 0L, null}, NumMsgRspBody.class);
        public final PBInt32Field i_retcode = PBField.initInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumMsgBusi> rpt_num_red = PBField.initRepeatMessage(NumMsgBusi.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumRedBusi extends MessageMicro<NumRedBusi> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58}, new String[]{"uint32_appid", "i_new_flag", "uint32_modify_ts", "rpt_num_red_path", "int32_appset", "uint32_red_total_num", "str_extend"}, new Object[]{0, 0, 0, null, 0, 0, ""}, NumRedBusi.class);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
        public final PBInt32Field i_new_flag = PBField.initInt32(0);
        public final PBUInt32Field uint32_modify_ts = PBField.initUInt32(0);
        public final PBRepeatMessageField<NumRedPath> rpt_num_red_path = PBField.initRepeatMessage(NumRedPath.class);
        public final PBInt32Field int32_appset = PBField.initInt32(0);
        public final PBUInt32Field uint32_red_total_num = PBField.initUInt32(0);
        public final PBStringField str_extend = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumRedInfo extends MessageMicro<NumRedInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58}, new String[]{"appid", "flag", "modify_ts", "num_red_path", "appset", "red_total_num", QFSEdgeItem.KEY_EXTEND}, new Object[]{0, Boolean.FALSE, 0, null, 0, 0, ""}, NumRedInfo.class);
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBBoolField flag = PBField.initBool(false);
        public final PBUInt32Field modify_ts = PBField.initUInt32(0);
        public final PBRepeatMessageField<NumRedPath> num_red_path = PBField.initRepeatMessage(NumRedPath.class);
        public final PBInt32Field appset = PBField.initInt32(0);
        public final PBUInt32Field red_total_num = PBField.initUInt32(0);
        public final PBStringField extend = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumRedPath extends MessageMicro<NumRedPath> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40, 48, 56, 64}, new String[]{"str_path", "str_missionid", "uint64_msgid", "uint32_msg_status", "uint32_expire_time", "uint32_push_num_red_ts", "uint32_local_recv_ts", "push_to"}, new Object[]{"", "", 0L, 0, 0, 0, 0, 0}, NumRedPath.class);
        public final PBStringField str_path = PBField.initString("");
        public final PBStringField str_missionid = PBField.initString("");
        public final PBUInt64Field uint64_msgid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_msg_status = PBField.initUInt32(0);
        public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_push_num_red_ts = PBField.initUInt32(0);
        public final PBUInt32Field uint32_local_recv_ts = PBField.initUInt32(0);
        public final PBUInt32Field push_to = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumRedReqBody extends MessageMicro<NumRedReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"i_proto_ver", "uint32_plat_id", "str_client_ver", "uint64_uin", "rpt_num_red"}, new Object[]{0, 0, "", 0L, null}, NumRedReqBody.class);
        public final PBInt32Field i_proto_ver = PBField.initInt32(0);
        public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
        public final PBStringField str_client_ver = PBField.initString("");
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumRedBusi> rpt_num_red = PBField.initRepeatMessage(NumRedBusi.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class NumRedRspBody extends MessageMicro<NumRedRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"i_retcode", "str_errmsg", "i_inteval", "uint64_uin", "rpt_num_red"}, new Object[]{0, "", 0, 0L, null}, NumRedRspBody.class);
        public final PBInt32Field i_retcode = PBField.initInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
        public final PBInt32Field i_inteval = PBField.initInt32(0);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBRepeatMessageField<NumRedBusi> rpt_num_red = PBField.initRepeatMessage(NumRedBusi.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class OfficialInfo extends MessageMicro<OfficialInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, "unread", "last_time"}, new Object[]{0L, 0, 0, 0L}, OfficialInfo.class);
        public final PBUInt64Field puin = PBField.initUInt64(0);
        public final PBUInt32Field serial = PBField.initUInt32(0);
        public final PBUInt32Field unread = PBField.initUInt32(0);
        public final PBInt64Field last_time = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class RedDisplayInfo extends MessageMicro<RedDisplayInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"red_type_info", "tab_display_info", "grid_red_info"}, new Object[]{null, null, null}, RedDisplayInfo.class);
        public final PBRepeatMessageField<RedTypeInfo> red_type_info = PBField.initRepeatMessage(RedTypeInfo.class);
        public RedTypeInfo tab_display_info = new RedTypeInfo();
        public final PBRepeatMessageField<RedTypeInfo> grid_red_info = PBField.initRepeatMessage(RedTypeInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class RedTypeInfo extends MessageMicro<RedTypeInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"red_type", "red_content", "red_desc", "red_priority"}, new Object[]{0, "", "", 0}, RedTypeInfo.class);
        public final PBUInt32Field red_type = PBField.initUInt32(0);
        public final PBStringField red_content = PBField.initString("");
        public final PBStringField red_desc = PBField.initString("");
        public final PBUInt32Field red_priority = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class ReportReqBody extends MessageMicro<ReportReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 66, 72, 80, 88, 98}, new String[]{"uin", "platid", "clientver", "platver", "appid", "missionid", "buffer", HippyTKDImageView.EXTRA_REPORTDATA_NAME, "msgids", "cmd", "bHebaFlag", QFSEdgeItem.KEY_EXTEND}, new Object[]{0L, 0, "", "", 0, "", "", null, 0L, 0, Boolean.FALSE, ""}, ReportReqBody.class);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field platid = PBField.initUInt32(0);
        public final PBStringField clientver = PBField.initString("");
        public final PBStringField platver = PBField.initString("");
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBRepeatField<String> missionid = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField buffer = PBField.initString("");
        public final PBRepeatMessageField<ReportStaticsData> reportdata = PBField.initRepeatMessage(ReportStaticsData.class);
        public final PBRepeatField<Long> msgids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field cmd = PBField.initUInt32(0);
        public final PBBoolField bHebaFlag = PBField.initBool(false);
        public final PBStringField extend = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class ReportRspBody extends MessageMicro<ReportRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"code", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "uin", "appid", "buffer"}, new Object[]{0, "", 0L, 0, ""}, ReportRspBody.class);
        public final PBInt32Field code = PBField.initInt32(0);
        public final PBStringField errmsg = PBField.initString("");
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBStringField buffer = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class ReportStaticsData extends MessageMicro<ReportStaticsData> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ReportStaticsData.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class SettingReqBody extends MessageMicro<SettingReqBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptAppid"}, new Object[]{0, 0, "", 0L, 0}, SettingReqBody.class);
        public final PBInt32Field iProtocolVer = PBField.initInt32(0);
        public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
        public final PBStringField sClientVer = PBField.initString("");
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBRepeatField<Integer> rptAppid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class SettingRspBody extends MessageMicro<SettingRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"iResult", "sErrMsg", "iInterval", "uiUin", "rptSetting"}, new Object[]{0, "", 0, 0L, null}, SettingRspBody.class);
        public final PBInt32Field iResult = PBField.initInt32(0);
        public final PBStringField sErrMsg = PBField.initString("");
        public final PBInt32Field iInterval = PBField.initInt32(0);
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBRepeatMessageField<AppSetting> rptSetting = PBField.initRepeatMessage(AppSetting.class);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class TimeReqBody extends MessageMicro<TimeReqBody> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBInt32Field iProtocolVer = PBField.initInt32(0);
        public final PBUInt32Field uiClientPlatID = PBField.initUInt32(0);
        public final PBStringField sClientVer = PBField.initString("");
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBRepeatMessageField<AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(AppInfo.class);
        public final PBRepeatMessageField<AppSetting> rptSetting = PBField.initRepeatMessage(AppSetting.class);
        public final PBRepeatField<String> rptNoRedPath = PBField.initRepeat(PBStringField.__repeatHelper__);
        public LbsInfo lbs = new LbsInfo();
        public final PBUInt32Field uiNetType = PBField.initUInt32(0);
        public final PBBoolField bHebaFlag = PBField.initBool(false);
        public final PBStringField sQimei = PBField.initString("");
        public final PBUInt32Field uReqType = PBField.initUInt32(0);
        public final PBRepeatField<Long> rptIdList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field mode = PBField.initUInt32(0);
        public final PBUInt32Field system_notify_status = PBField.initUInt32(0);
        public final PBBoolField bBackendFillRedPath = PBField.initBool(false);
        public final PBStringField sVendor = PBField.initString("");
        public final PBUInt32Field uReqTypeList = PBField.initUInt32(0);
        public final PBUInt32Field a11yMode = PBField.initUInt32(0);
        public final PBRepeatMessageField<OfficialInfo> officialList = PBField.initRepeatMessage(OfficialInfo.class);
        public final PBBoolField use_red_component = PBField.initBool(false);
        public final PBRepeatMessageField<TranInfo> transinfo = PBField.initRepeatMessage(TranInfo.class);
        public final PBUInt32Field uReqSubType = PBField.initUInt32(0);
        public final PBStringField qua = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50, 58, 66, 72, 80, 90, 96, 104, 112, 120, 128, 138, 144, 152, 162, 168, 178, 184, 194}, new String[]{"iProtocolVer", "uiClientPlatID", "sClientVer", "uiUin", "rptMsgAppInfo", "rptSetting", "rptNoRedPath", "lbs", "uiNetType", "bHebaFlag", "sQimei", "uReqType", "rptIdList", "mode", "system_notify_status", "bBackendFillRedPath", "sVendor", "uReqTypeList", "a11yMode", "officialList", "use_red_component", "transinfo", "uReqSubType", "qua"}, new Object[]{0, 0, "", 0L, null, null, "", null, 0, bool, "", 0, 0L, 0, 0, bool, "", 0, 0, null, bool, null, 0, ""}, TimeReqBody.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class TimeRspBody extends MessageMicro<TimeRspBody> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 58, 64, 72, 82, 90, 98, 106}, new String[]{"iResult", "sErrMsg", "iInterval", "rptMsgAppInfo", "uiUin", "rptSetting", "rptMsgNumRedInfo", "iLbsInterval", "iStatInterval", "reqTypeInterval", "redPullPathList", "invalidRedPaths", "reportCmdCtrl"}, new Object[]{0, "", 0, null, 0L, null, null, 0, 0, null, "", "", null}, TimeRspBody.class);
        public final PBRepeatField<String> invalidRedPaths;
        public final PBRepeatField<String> redPullPathList;
        public final PBRepeatMessageField<BooleanEntry> reportCmdCtrl;
        public final PBInt32Field iResult = PBField.initInt32(0);
        public final PBStringField sErrMsg = PBField.initString("");
        public final PBInt32Field iInterval = PBField.initInt32(0);
        public final PBRepeatMessageField<AppInfo> rptMsgAppInfo = PBField.initRepeatMessage(AppInfo.class);
        public final PBUInt64Field uiUin = PBField.initUInt64(0);
        public final PBRepeatMessageField<AppSetting> rptSetting = PBField.initRepeatMessage(AppSetting.class);
        public final PBRepeatMessageField<NumRedInfo> rptMsgNumRedInfo = PBField.initRepeatMessage(NumRedInfo.class);
        public final PBInt32Field iLbsInterval = PBField.initInt32(0);
        public final PBInt32Field iStatInterval = PBField.initInt32(0);
        public final PBRepeatMessageField<Entry> reqTypeInterval = PBField.initRepeatMessage(Entry.class);

        public TimeRspBody() {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.redPullPathList = PBField.initRepeat(pBStringField);
            this.invalidRedPaths = PBField.initRepeat(pBStringField);
            this.reportCmdCtrl = PBField.initRepeatMessage(BooleanEntry.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class TranInfo extends MessageMicro<TranInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"key", "value"}, new Object[]{0L, ByteStringMicro.EMPTY}, TranInfo.class);
        public final PBUInt64Field key = PBField.initUInt64(0);
        public final PBBytesField value = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    BusinessInfoCheckUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
