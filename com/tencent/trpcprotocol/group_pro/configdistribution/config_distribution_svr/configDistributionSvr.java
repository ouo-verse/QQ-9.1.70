package com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class configDistributionSvr {
    public static final int ALL = 1;
    public static final int ALL_V2 = 3;
    public static final int ANDROID = 2;
    public static final int CHECK_RESOURCE_FAILED = 4;
    public static final int CLIENT_CUSTOM_FIELD_CHANGE = 6;
    public static final int CLIENT_LOCAL_CACHE_ERR = 5;
    public static final int CLIENT_UPDATE = 4;
    public static final int COMMON = 2;
    public static final int CONFIG_SNAPSHOT = 4;
    public static final int CONFIG_USED_COUNT = 6;
    public static final int DEFAULT = 0;
    public static final int DOWNLOAD_RESOURCE_FAILED = 2;
    public static final int FIRST_TIME = 5;
    public static final int FULL = 1;
    public static final int GET_ALL_IMMEDIATELY = 1;
    public static final int HIGH_FREQUENCY = 7;
    public static final int INCREAMENT = 8;
    public static final int INCREAMENT_FETCH = 4;
    public static final int INCREAMENT_FETCH_IMMEDIATELY = 6;
    public static final int INCREAMENT_FETCH_WITH_SNAPSHOT_ID = 3;
    public static final int INCREAMENT_FETCH_WITH_SNAPSHOT_ID_IMMEDIATELY = 5;
    public static final int INCREAMENT_UPDATE = 2;
    public static final int INC_REGULAR_CHECK = 9;
    public static final int IOS = 1;
    public static final int LINUX = 5;
    public static final int MAC = 4;
    public static final int MINIAPP = 1;
    public static final int NO_CHANGE = 0;
    public static final int NO_UPDATE = 1;
    public static final int OP_RESOURCE_IO_FAILED = 5;
    public static final int PAGING_FETCH = 0;
    public static final int PARSE_FAILED = 1;
    public static final int PUSH = 6;
    public static final int RESTART = 1;
    public static final int RSA_VERSION0 = 0;
    public static final int SNAPSHOT_FETCH_IMMEDIATELY = 2;
    public static final int SPECIFIC = 2;
    public static final int SPECIFY = 2;
    public static final int SWITCH = 3;
    public static final int SYSTEM_UPDATE = 7;
    public static final int UNKNOW = 0;
    public static final int UNKNOWN = 0;
    public static final int UNZIP_RESOURCE_FAILED = 3;
    public static final int USER_ACTION = 2;
    public static final int WINDOWS = 3;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class BusinessInfo extends MessageMicro<BusinessInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bussiness_id", "group_infos"}, new Object[]{"", null}, BusinessInfo.class);
        public final PBStringField bussiness_id = PBField.initString("");
        public final PBRepeatMessageField<GroupInfo> group_infos = PBField.initRepeatMessage(GroupInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class CommonInfo extends MessageMicro<CommonInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"scene_id", "model_type", "trigger_type", "trigger_interval"}, new Object[]{0, 1, 0, 0}, CommonInfo.class);
        public final PBUInt32Field scene_id = PBField.initUInt32(0);
        public final PBEnumField model_type = PBField.initEnum(1);
        public final PBInt32Field trigger_type = PBField.initInt32(0);
        public final PBUInt32Field trigger_interval = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Content extends MessageMicro<Content> {
        public static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field compress = PBField.initInt32(0);
        public final PBInt64Field size = PBField.initInt64(0);
        public final PBBoolField switch_status = PBField.initBool(false);
        public final PBBoolField is_cdn_config = PBField.initBool(false);
        public final PBUInt32Field check_sum = PBField.initUInt32(0);

        static {
            String[] strArr = {"content", ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS, "size", ProfileCardBlacklistReportConst.ELEM_PARAM_SWITCH_STATUS, "is_cdn_config", "check_sum"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48}, strArr, new Object[]{ByteStringMicro.EMPTY, 0, 0L, bool, bool, 0}, Content.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ControlInfo extends MessageMicro<ControlInfo> {
        public static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField config_nologin_snapshot;
        public final PBUInt64Field config_seq;
        public final PBBytesField cookies;
        public final PBStringField env;
        public final PBBytesField inc_cookies;
        public final PBBytesField inc_nologin_cookies;

        static {
            String[] strArr = {"cookies", MosaicConstants$JsProperty.PROP_ENV, "config_seq", "config_nologin_snapshot", "inc_cookies", "inc_nologin_cookies"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 32, 42, 50, 58}, strArr, new Object[]{byteStringMicro, "", 0L, "", byteStringMicro, byteStringMicro}, ControlInfo.class);
        }

        public ControlInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.cookies = PBField.initBytes(byteStringMicro);
            this.env = PBField.initString("");
            this.config_seq = PBField.initUInt64(0L);
            this.config_nologin_snapshot = PBField.initString("");
            this.inc_cookies = PBField.initBytes(byteStringMicro);
            this.inc_nologin_cookies = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class CustomField extends MessageMicro<CustomField> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"kv"}, new Object[]{null}, CustomField.class);

        /* renamed from: kv, reason: collision with root package name */
        public final PBRepeatMessageField<KV> f381453kv = PBField.initRepeatMessage(KV.class);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class DeviceInfo extends MessageMicro<DeviceInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"brand", "model", "os"}, new Object[]{"", "", null}, DeviceInfo.class);
        public final PBStringField brand = PBField.initString("");
        public final PBStringField model = PBField.initString("");

        /* renamed from: os, reason: collision with root package name */
        public OS f381454os = new OS();
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class Extend extends MessageMicro<Extend> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"custom_field", "four_digit_version"}, new Object[]{null, ""}, Extend.class);
        public CustomField custom_field = new CustomField();
        public final PBStringField four_digit_version = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GetConfigReq extends MessageMicro<GetConfigReq> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 90}, new String[]{"common_info", "business_infos", "device_info", "user_info", "control_info", "group_infos", "project_infos", "page_info", "fetch_type", QFSEdgeItem.KEY_EXTEND, "config_snapshot"}, new Object[]{null, null, null, null, null, null, null, null, 0, null, ""}, GetConfigReq.class);
        public CommonInfo common_info = new CommonInfo();
        public final PBRepeatMessageField<BusinessInfo> business_infos = PBField.initRepeatMessage(BusinessInfo.class);
        public DeviceInfo device_info = new DeviceInfo();
        public UserInfo user_info = new UserInfo();
        public ControlInfo control_info = new ControlInfo();
        public final PBRepeatMessageField<GroupInfo> group_infos = PBField.initRepeatMessage(GroupInfo.class);
        public final PBRepeatMessageField<ProjectInfo> project_infos = PBField.initRepeatMessage(ProjectInfo.class);
        public ReqPageInfo page_info = new ReqPageInfo();
        public final PBEnumField fetch_type = PBField.initEnum(0);
        public Extend extend = new Extend();
        public final PBStringField config_snapshot = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GetConfigRsp extends MessageMicro<GetConfigRsp> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58, 72, 80}, new String[]{"ext_info", Constants.Configs.CONFIGS, "debug_msgs", "resp_control_info", "page_info", "enable_config_snapshot", "config_verify", "resource_report_denominator", "snapshot_result"}, new Object[]{ByteStringMicro.EMPTY, null, "", null, null, Boolean.FALSE, "", 0, 0}, GetConfigRsp.class);
        public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<RespConfig> configs = PBField.initRepeatMessage(RespConfig.class);
        public final PBRepeatField<String> debug_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
        public RespControlInfo resp_control_info = new RespControlInfo();
        public RespPageInfo page_info = new RespPageInfo();
        public final PBBoolField enable_config_snapshot = PBField.initBool(false);
        public final PBStringField config_verify = PBField.initString("");
        public final PBUInt32Field resource_report_denominator = PBField.initUInt32(0);
        public final PBEnumField snapshot_result = PBField.initEnum(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GetRecoverConfigReq extends MessageMicro<GetRecoverConfigReq> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "req_bytes"}, new Object[]{0, ByteStringMicro.EMPTY}, GetRecoverConfigReq.class);
        public final PBEnumField version = PBField.initEnum(0);
        public final PBBytesField req_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GetRecoverConfigRsp extends MessageMicro<GetRecoverConfigRsp> {
        public static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField rsp_bytes;
        public final PBBytesField rsp_sign;
        public final PBEnumField version = PBField.initEnum(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"version", "rsp_bytes", "rsp_sign"}, new Object[]{0, byteStringMicro, byteStringMicro}, GetRecoverConfigRsp.class);
        }

        public GetRecoverConfigRsp() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.rsp_bytes = PBField.initBytes(byteStringMicro);
            this.rsp_sign = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class GroupInfo extends MessageMicro<GroupInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 32, 40}, new String[]{VipFunCallConstants.KEY_GROUP, "version", "group_id", "new_version"}, new Object[]{"", "", 0, 0}, GroupInfo.class);
        public final PBStringField group = PBField.initString("");
        public final PBStringField version = PBField.initString("");
        public final PBUInt32Field group_id = PBField.initUInt32(0);
        public final PBUInt32Field new_version = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class KV extends MessageMicro<KV> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, KV.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField val = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class MuteDuration extends MessageMicro<MuteDuration> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"start_time", "end_time"}, new Object[]{0L, 0L}, MuteDuration.class);
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class OS extends MessageMicro<OS> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "version"}, new Object[]{0, ""}, OS.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField version = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ProjectInfo extends MessageMicro<ProjectInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"id"}, new Object[]{""}, ProjectInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f381455id = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RecoverConfigReq extends MessageMicro<RecoverConfigReq> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 66, 74}, new String[]{"config_req", "timestamp", "uin", "client_version", "client_appid", "client_plat", "client_plat_id", "client_sub_plat", TVKLiveRequestBuilder.RequestParamKey.QIMEI36}, new Object[]{null, 0, 0L, "", 0, 0, 0, "", ""}, RecoverConfigReq.class);
        public GetConfigReq config_req = new GetConfigReq();
        public final PBUInt32Field timestamp = PBField.initUInt32(0);
        public final PBUInt64Field uin = PBField.initUInt64(0);
        public final PBStringField client_version = PBField.initString("");
        public final PBUInt32Field client_appid = PBField.initUInt32(0);
        public final PBUInt32Field client_plat = PBField.initUInt32(0);
        public final PBUInt32Field client_plat_id = PBField.initUInt32(0);
        public final PBStringField client_sub_plat = PBField.initString("");
        public final PBStringField qimei = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class ReqPageInfo extends MessageMicro<ReqPageInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"last_idx"}, new Object[]{0}, ReqPageInfo.class);
        public final PBInt32Field last_idx = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RespConfig extends MessageMicro<RespConfig> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56}, new String[]{VipFunCallConstants.KEY_GROUP, "version", "contents", "bussiness_id", "group_id", "new_version", "is_no_login_config"}, new Object[]{"", "", null, "", 0, 0, Boolean.FALSE}, RespConfig.class);
        public final PBStringField group = PBField.initString("");
        public final PBStringField version = PBField.initString("");
        public final PBRepeatMessageField<Content> contents = PBField.initRepeatMessage(Content.class);
        public final PBStringField bussiness_id = PBField.initString("");
        public final PBUInt32Field group_id = PBField.initUInt32(0);
        public final PBUInt32Field new_version = PBField.initUInt32(0);
        public final PBBoolField is_no_login_config = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RespControlInfo extends MessageMicro<RespControlInfo> {
        public static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt64Field config_seq;
        public final PBBytesField cookies;
        public final PBRepeatField<String> groups;
        public final PBBytesField inc_cookies;
        public final PBBytesField inc_nologin_cookies;
        public final PBUInt32Field interval_reconnect;
        public final PBRepeatMessageField<MuteDuration> mute_durations;
        public final PBEnumField next_fetch_type;
        public final PBRepeatField<Integer> next_int_req_groups;
        public final PBRepeatMessageField<BusinessInfo> next_req_businesss;
        public final PBRepeatMessageField<GroupInfo> qps_limited_groups;
        public final PBUInt32Field update_interval;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 48, 58, 64, 74, 80, 90, 98}, new String[]{"cookies", "interval_reconnect", "next_req_businesss", "groups", "next_int_req_groups", "update_interval", "mute_durations", "config_seq", "qps_limited_groups", "next_fetch_type", "inc_cookies", "inc_nologin_cookies"}, new Object[]{byteStringMicro, 0, null, "", 0, 0, null, 0L, null, 0, byteStringMicro, byteStringMicro}, RespControlInfo.class);
        }

        public RespControlInfo() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.cookies = PBField.initBytes(byteStringMicro);
            this.interval_reconnect = PBField.initUInt32(0);
            this.next_req_businesss = PBField.initRepeatMessage(BusinessInfo.class);
            this.groups = PBField.initRepeat(PBStringField.__repeatHelper__);
            this.next_int_req_groups = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
            this.update_interval = PBField.initUInt32(0);
            this.mute_durations = PBField.initRepeatMessage(MuteDuration.class);
            this.config_seq = PBField.initUInt64(0L);
            this.qps_limited_groups = PBField.initRepeatMessage(GroupInfo.class);
            this.next_fetch_type = PBField.initEnum(0);
            this.inc_cookies = PBField.initBytes(byteStringMicro);
            this.inc_nologin_cookies = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class RespPageInfo extends MessageMicro<RespPageInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"last_idx", "is_finish"}, new Object[]{0, Boolean.FALSE}, RespPageInfo.class);
        public final PBInt32Field last_idx = PBField.initInt32(0);
        public final PBBoolField is_finish = PBField.initBool(false);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SsoReportReq extends MessageMicro<SsoReportReq> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{TVKDataBinder.KEY_REPORT_TYPE, "device_info", "user_info", "group_infos", "ext_info"}, new Object[]{1, null, null, null, ByteStringMicro.EMPTY}, SsoReportReq.class);
        public final PBEnumField report_type = PBField.initEnum(1);
        public DeviceInfo device_info = new DeviceInfo();
        public UserInfo user_info = new UserInfo();
        public final PBRepeatMessageField<GroupInfo> group_infos = PBField.initRepeatMessage(GroupInfo.class);
        public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class SsoReportRsp extends MessageMicro<SsoReportRsp> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"interval_reconnect"}, new Object[]{0}, SsoReportRsp.class);
        public final PBUInt32Field interval_reconnect = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class TabRule extends MessageMicro<TabRule> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{QAdVrReportParams.ParamKey.EXPERIMENT_ID, "group_id", "experiment_param"}, new Object[]{"", "", ""}, TabRule.class);
        public final PBStringField experiment_id = PBField.initString("");
        public final PBStringField group_id = PBField.initString("");
        public final PBStringField experiment_param = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        public static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"province", "city", QCircleSchemeAttr.Polymerize.LAT, "lon", CarrierImgDownloader.PROTOCAL_CARRIER_IMG}, new Object[]{"", "", 0, 0, 0}, UserInfo.class);
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBInt32Field lat = PBField.initInt32(0);
        public final PBInt32Field lon = PBField.initInt32(0);
        public final PBInt32Field carrier = PBField.initInt32(0);
    }

    configDistributionSvr() {
    }
}
