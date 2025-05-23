package common;

import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.superplayer.report.SPReportHelper;

/* loaded from: classes28.dex */
public final class QqAdGetProtos$QQAdGet extends MessageMicro<QqAdGetProtos$QQAdGet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 16010}, new String[]{"user_info", "position_info", "device_info", "context_info", SPReportHelper.KEY_DEBUG_INFO, "gdt_cookie", "support_https", "external_exp_info", "busi_cookie"}, new Object[]{null, null, null, null, null, "", Boolean.FALSE, null, ""}, QqAdGetProtos$QQAdGet.class);
    public UserInfo user_info = new UserInfo();
    public final PBRepeatMessageField<PositionInfo> position_info = PBField.initRepeatMessage(PositionInfo.class);
    public DeviceInfo device_info = new DeviceInfo();
    public ContextInfo context_info = new ContextInfo();
    public DebugInfo debug_info = new DebugInfo();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBBoolField support_https = PBField.initBool(false);
    public ExternalExpInfo external_exp_info = new ExternalExpInfo();
    public final PBStringField busi_cookie = PBField.initString("");

    /* loaded from: classes28.dex */
    public static final class ContextInfo extends MessageMicro<ContextInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66}, new String[]{"public_id", AppConstants.Key.SHARE_REQ_ARTICLE_ID, "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids", "str_source_from"}, new Object[]{0L, 0L, 0, 0, 0, ByteStringMicro.EMPTY, 0L, ""}, ContextInfo.class);
        public final PBUInt64Field public_id = PBField.initUInt64(0);
        public final PBUInt64Field article_id = PBField.initUInt64(0);
        public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
        public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
        public final PBUInt32Field source_from = PBField.initUInt32(0);
        public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBStringField str_source_from = PBField.initString("");
    }

    /* loaded from: classes28.dex */
    public static final class DebugInfo extends MessageMicro<DebugInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
        public final PBBoolField nomatch = PBField.initBool(false);
        public final PBBoolField debug = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"debug_adindexid", "nomatch", "debug"}, new Object[]{0, bool, bool}, DebugInfo.class);
        }
    }

    /* loaded from: classes28.dex */
    public static final class DeviceInfo extends MessageMicro<DeviceInfo> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField muid = PBField.initString("");
        public final PBUInt32Field muid_type = PBField.initUInt32(0);
        public final PBUInt32Field conn = PBField.initUInt32(0);
        public final PBUInt32Field carrier_code = PBField.initUInt32(0);
        public final PBStringField os_ver = PBField.initString("");
        public final PBStringField qq_ver = PBField.initString("");
        public final PBUInt32Field os_type = PBField.initUInt32(0);
        public final PBStringField client_ip = PBField.initString("");
        public final PBStringField ios_qidfa = PBField.initString("");
        public Location location = new Location();
        public final PBBoolField is_wk_webview = PBField.initBool(false);
        public final PBStringField manufacturer = PBField.initString("");
        public final PBStringField device_brand_and_model = PBField.initString("");
        public final PBStringField qadid = PBField.initString("");
        public final PBUInt32Field app_version_id = PBField.initUInt32(0);
        public final PBStringField imei = PBField.initString("");
        public final PBStringField idfa = PBField.initString("");
        public final PBStringField android_id = PBField.initString("");
        public final PBStringField mac = PBField.initString("");
        public final PBBoolField is_googleplay_version = PBField.initBool(false);
        public final PBUInt32Field device_orientation = PBField.initUInt32(0);
        public final PBBoolField is_ios_review_state = PBField.initBool(false);
        public final PBStringField oaid = PBField.initString("");
        public final PBStringField taid_ticket = PBField.initString("");
        public final PBStringField md5_mac = PBField.initString("");
        public final PBStringField md5_android_id = PBField.initString("");
        public final PBStringField client_ipv4 = PBField.initString("");
        public final PBStringField aid_ticket = PBField.initString("");
        public final PBUInt64Field wx_api_ver = PBField.initUInt64(0);
        public final PBBoolField wx_installed = PBField.initBool(false);
        public final PBBoolField wx_ul = PBField.initBool(false);
        public final PBUInt32Field origin_network_type = PBField.initUInt32(0);

        /* loaded from: classes28.dex */
        public static final class Location extends MessageMicro<Location> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"latitude", "longitude", "coordinates_type"}, new Object[]{0, 0, 0}, Location.class);
            public final PBInt32Field latitude = PBField.initInt32(0);
            public final PBInt32Field longitude = PBField.initInt32(0);
            public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
        }

        static {
            String[] strArr = {"muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "imei", "idfa", SharedPreferencedUtil.SP_KEY_ANDROID_ID, "mac", "is_googleplay_version", "device_orientation", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket", "wx_api_ver", "wx_installed", "wx_ul", "origin_network_type"};
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 130, 138, 146, 154, 160, 168, 176, 186, 194, 202, 210, 218, 226, 232, 240, 248, 256}, strArr, new Object[]{"", 0, 0, 0, "", "", 0, "", "", null, bool, "", "", "", 0, "", "", "", "", bool, 0, bool, "", "", "", "", "", "", 0L, bool, bool, 0}, DeviceInfo.class);
        }
    }

    /* loaded from: classes28.dex */
    public static final class ExternalExpInfo extends MessageMicro<ExternalExpInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"traffic_type", "exp_id"}, new Object[]{0, ""}, ExternalExpInfo.class);
        public final PBInt32Field traffic_type = PBField.initInt32(0);
        public final PBRepeatField<String> exp_id = PBField.initRepeat(PBStringField.__repeatHelper__);
    }

    /* loaded from: classes28.dex */
    public static final class PositionInfo extends MessageMicro<PositionInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{SsoReporter.POS_ID_KEY, "ad_count", "pos_ext"}, new Object[]{"", 0, null}, PositionInfo.class);
        public final PBStringField pos_id = PBField.initString("");
        public final PBUInt32Field ad_count = PBField.initUInt32(0);
        public PositionExt pos_ext = new PositionExt();

        /* loaded from: classes28.dex */
        public static final class PositionExt extends MessageMicro<PositionExt> {
            public static final int FETCH_TYPE_PREFETCH = 1;
            public static final int FETCH_TYPE_REAL_TIME = 0;
            public static final int FETCH_TYPE_SPECIFY_AD = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 56, 66, 74}, new String[]{"share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id", "black_category_list", "debug_adindexid_list", "cps_req_info", "video_req_info"}, new Object[]{null, 0, 0, null, "", 0, 0, null, null}, PositionExt.class);
            public final PBRepeatField<Integer> black_category_list;
            public final PBRepeatMessageField<CpsReqInfo> cps_req_info;
            public final PBRepeatField<Integer> debug_adindexid_list;
            public VideoReqInfo video_req_info;
            public ShareInfo share_info = new ShareInfo();
            public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
            public final PBEnumField get_ad_type = PBField.initEnum(0);
            public final PBRepeatMessageField<SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(SpecifiedAdsItem.class);
            public final PBStringField sub_position_id = PBField.initString("");

            /* loaded from: classes28.dex */
            public static final class CpsReqInfo extends MessageMicro<CpsReqInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "catelog_id", "product_link_info", "pcg_media_trace_info", "product_share_info"}, new Object[]{0L, 0L, null, null, null}, CpsReqInfo.class);
                public final PBRepeatField<Long> product_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
                public final PBUInt64Field catelog_id = PBField.initUInt64(0);
                public final PBRepeatMessageField<ProductLinkInfo> product_link_info = PBField.initRepeatMessage(ProductLinkInfo.class);
                public final PBRepeatMessageField<QqAdGetProtos$PcgMediaTraceInfo> pcg_media_trace_info = PBField.initRepeatMessage(QqAdGetProtos$PcgMediaTraceInfo.class);
                public final PBRepeatMessageField<ProductShareInfo> product_share_info = PBField.initRepeatMessage(ProductShareInfo.class);
            }

            /* loaded from: classes28.dex */
            public static final class MiniProgramLink extends MessageMicro<MiniProgramLink> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_id", "page_path", "schema_link", AudienceReportConst.USER_NAME}, new Object[]{"", "", "", ""}, MiniProgramLink.class);
                public final PBStringField app_id = PBField.initString("");
                public final PBStringField page_path = PBField.initString("");
                public final PBStringField schema_link = PBField.initString("");
                public final PBStringField user_name = PBField.initString("");
            }

            /* loaded from: classes28.dex */
            public static final class ProductLinkInfo extends MessageMicro<ProductLinkInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "h5_page", "wx_miniprogram_link", "qq_miniprogram_link"}, new Object[]{0L, "", null, null}, ProductLinkInfo.class);
                public final PBUInt64Field product_id = PBField.initUInt64(0);
                public final PBStringField h5_page = PBField.initString("");
                public MiniProgramLink wx_miniprogram_link = new MiniProgramLink();
                public MiniProgramLink qq_miniprogram_link = new MiniProgramLink();
            }

            /* loaded from: classes28.dex */
            public static final class ProductShareInfo extends MessageMicro<ProductShareInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "share_info"}, new Object[]{0L, null}, ProductShareInfo.class);
                public final PBUInt64Field product_id = PBField.initUInt64(0);
                public ShareInfo share_info = new ShareInfo();
            }

            /* loaded from: classes28.dex */
            public static final class ShareInfo extends MessageMicro<ShareInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"share_rate", "share_check"}, new Object[]{0, ""}, ShareInfo.class);
                public final PBUInt32Field share_rate = PBField.initUInt32(0);
                public final PBStringField share_check = PBField.initString("");
            }

            /* loaded from: classes28.dex */
            public static final class SpecifiedAdsItem extends MessageMicro<SpecifiedAdsItem> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"aid", "creative_id", "prefetch_timestamp"}, new Object[]{0L, 0L, 0}, SpecifiedAdsItem.class);
                public final PBUInt64Field aid = PBField.initUInt64(0);
                public final PBUInt64Field creative_id = PBField.initUInt64(0);
                public final PBUInt32Field prefetch_timestamp = PBField.initUInt32(0);
            }

            /* loaded from: classes28.dex */
            public static final class VideoReqInfo extends MessageMicro<VideoReqInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"video_min_duration", "video_max_duration"}, new Object[]{0, 0}, VideoReqInfo.class);
                public final PBUInt32Field video_min_duration = PBField.initUInt32(0);
                public final PBUInt32Field video_max_duration = PBField.initUInt32(0);
            }

            public PositionExt() {
                PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
                this.black_category_list = PBField.initRepeat(pBUInt32Field);
                this.debug_adindexid_list = PBField.initRepeat(pBUInt32Field);
                this.cps_req_info = PBField.initRepeatMessage(CpsReqInfo.class);
                this.video_req_info = new VideoReqInfo();
            }
        }
    }

    /* loaded from: classes28.dex */
    public static final class UserInfo extends MessageMicro<UserInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58}, new String[]{"qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid", "wuid"}, new Object[]{0L, "", "", "", 0L, "", ""}, UserInfo.class);

        /* renamed from: qq, reason: collision with root package name */
        public final PBUInt64Field f390031qq = PBField.initUInt64(0);
        public final PBStringField wx_appid = PBField.initString("");
        public final PBStringField wx_openid = PBField.initString("");
        public final PBStringField media_specified_id = PBField.initString("");
        public final PBUInt64Field qq_appid = PBField.initUInt64(0);
        public final PBStringField qq_openid = PBField.initString("");
        public final PBStringField wuid = PBField.initString("");
    }
}
