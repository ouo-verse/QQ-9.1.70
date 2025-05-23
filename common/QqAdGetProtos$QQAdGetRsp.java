package common;

import com.qq.e.comm.constants.Constants;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.gdtad.util.SsoReporter;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.app.MessageHandlerConstants;
import com.tencent.mobileqq.mini.share.MiniProgramOpenSdkUtil;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.superplayer.report.SPReportHelper;
import com.tencent.xweb.FileReaderHelper;

/* loaded from: classes28.dex */
public final class QqAdGetProtos$QQAdGetRsp extends MessageMicro<QqAdGetProtos$QQAdGetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"ret", "msg", "pos_ads_info", "gdt_cookie", "busi_cookie", SPReportHelper.KEY_DEBUG_INFO}, new Object[]{0, "", null, "", "", ""}, QqAdGetProtos$QQAdGetRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f390032msg = PBField.initString("");
    public final PBRepeatMessageField<PosAdInfo> pos_ads_info = PBField.initRepeatMessage(PosAdInfo.class);
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBStringField busi_cookie = PBField.initString("");
    public final PBStringField debug_info = PBField.initString("");

    /* loaded from: classes28.dex */
    public static final class AdInfo extends MessageMicro<AdInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"product_type", "display_info", QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO, "dest_info", j.T0, "exp_info", "ext", "ext_json", "cps_rsp_info", "wechat_app_info"}, new Object[]{0, null, null, null, null, null, null, "", null, null}, AdInfo.class);
        public final PBUInt32Field product_type = PBField.initUInt32(0);
        public DisplayInfo display_info = new DisplayInfo();
        public ReportInfo report_info = new ReportInfo();
        public DestInfo dest_info = new DestInfo();
        public AppInfo app_info = new AppInfo();
        public ExpInfo exp_info = new ExpInfo();
        public Ext ext = new Ext();
        public final PBStringField ext_json = PBField.initString("");
        public final PBRepeatMessageField<CpsRspInfo> cps_rsp_info = PBField.initRepeatMessage(CpsRspInfo.class);
        public WeChatAppInfo wechat_app_info = new WeChatAppInfo();

        /* loaded from: classes28.dex */
        public static final class AppInfo extends MessageMicro<AppInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 112}, new String[]{"app_name", "app_score", "app_package_name", "app_package_size", "app_package_version", "app_logo_url", "pkg_url", "ios_app_id", "android_app_id", "pkg_download_schema", "customized_invoke_url", "channel_id", "app_score_num", "download_num"}, new Object[]{"", "", "", 0L, "", "", "", "", "", "", "", "", 0, 0L}, AppInfo.class);
            public final PBStringField app_name = PBField.initString("");
            public final PBStringField app_score = PBField.initString("");
            public final PBStringField app_package_name = PBField.initString("");
            public final PBUInt64Field app_package_size = PBField.initUInt64(0);
            public final PBStringField app_package_version = PBField.initString("");
            public final PBStringField app_logo_url = PBField.initString("");
            public final PBStringField pkg_url = PBField.initString("");
            public final PBStringField ios_app_id = PBField.initString("");
            public final PBStringField android_app_id = PBField.initString("");
            public final PBStringField pkg_download_schema = PBField.initString("");
            public final PBStringField customized_invoke_url = PBField.initString("");
            public final PBStringField channel_id = PBField.initString("");
            public final PBUInt32Field app_score_num = PBField.initUInt32(0);
            public final PBUInt64Field download_num = PBField.initUInt64(0);
        }

        /* loaded from: classes28.dex */
        public static final class CpsRspInfo extends MessageMicro<CpsRspInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 98, 106, 112, 122, MessageHandlerConstants.NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "img_list", "product_name", "product_price", "sales_tips", "h5_page", "deep_link", "apurl", "rl", "catelog_id", "source", "wechat_app_info", "qq_app_info", "product_original_price", "chantag", "product_id_str"}, new Object[]{0L, "", "", 0, "", "", "", "", "", 0L, 0, null, null, 0, "", ""}, CpsRspInfo.class);
            public final PBUInt64Field product_id = PBField.initUInt64(0);
            public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBStringField product_name = PBField.initString("");
            public final PBUInt32Field product_price = PBField.initUInt32(0);
            public final PBStringField sales_tips = PBField.initString("");
            public final PBStringField h5_page = PBField.initString("");
            public final PBStringField deep_link = PBField.initString("");
            public final PBStringField apurl = PBField.initString("");

            /* renamed from: rl, reason: collision with root package name */
            public final PBStringField f390033rl = PBField.initString("");
            public final PBUInt64Field catelog_id = PBField.initUInt64(0);
            public final PBUInt32Field source = PBField.initUInt32(0);
            public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
            public QQAppInfo qq_app_info = new QQAppInfo();
            public final PBUInt32Field product_original_price = PBField.initUInt32(0);
            public final PBStringField chantag = PBField.initString("");
            public final PBStringField product_id_str = PBField.initString("");
        }

        /* loaded from: classes28.dex */
        public static final class DestInfo extends MessageMicro<DestInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50}, new String[]{"dest_url_display_type", "landing_page", "canvas_json", "dest_type", "pop_sheet", "universal_link"}, new Object[]{0, "", "", 0, "", ""}, DestInfo.class);
            public final PBUInt32Field dest_url_display_type = PBField.initUInt32(0);
            public final PBStringField landing_page = PBField.initString("");
            public final PBStringField canvas_json = PBField.initString("");
            public final PBUInt32Field dest_type = PBField.initUInt32(0);
            public final PBStringField pop_sheet = PBField.initString("");
            public final PBStringField universal_link = PBField.initString("");
        }

        /* loaded from: classes28.dex */
        public static final class DisplayInfo extends MessageMicro<DisplayInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 74, 80, 93, 96, 106, 114, 122}, new String[]{"pattern_type", "creative_size", "animation_effect", "basic_info", "button_info", "muti_pic_text_info", "advertiser_info", "video_info", SearchConfig.ENGINE_LOCAL_INFO, MiniProgramOpenSdkUtil.ATTR_SHARE_TO_QQ_MINI_PROGRAM_TYPE, "ecpm", "inner_adshowtype", "video_info2", "mini_program_name", "mini_program_id"}, new Object[]{0, 0, 0, null, null, null, null, null, null, 0, Float.valueOf(0.0f), 0, null, "", ""}, DisplayInfo.class);
            public final PBUInt32Field pattern_type = PBField.initUInt32(0);
            public final PBUInt32Field creative_size = PBField.initUInt32(0);
            public final PBUInt32Field animation_effect = PBField.initUInt32(0);
            public BasicInfo basic_info = new BasicInfo();
            public final PBRepeatMessageField<ButtonInfo> button_info = PBField.initRepeatMessage(ButtonInfo.class);
            public MutiPicTextInfo muti_pic_text_info = new MutiPicTextInfo();
            public AdvertiserInfo advertiser_info = new AdvertiserInfo();
            public VideoInfo video_info = new VideoInfo();
            public LocalInfo local_info = new LocalInfo();
            public final PBUInt32Field mini_program_type = PBField.initUInt32(0);
            public final PBFloatField ecpm = PBField.initFloat(0.0f);
            public final PBUInt32Field inner_adshowtype = PBField.initUInt32(0);
            public VideoInfo video_info2 = new VideoInfo();
            public final PBStringField mini_program_name = PBField.initString("");
            public final PBStringField mini_program_id = PBField.initString("");

            /* loaded from: classes28.dex */
            public static final class AdvertiserInfo extends MessageMicro<AdvertiserInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"corporation_name", "corporate_image_name", "corporate_logo", "advertiser_id", "ad_first_category", "ad_second_category"}, new Object[]{"", "", "", 0L, 0L, 0L}, AdvertiserInfo.class);
                public final PBStringField corporation_name = PBField.initString("");
                public final PBStringField corporate_image_name = PBField.initString("");
                public final PBStringField corporate_logo = PBField.initString("");
                public final PBUInt64Field advertiser_id = PBField.initUInt64(0);
                public final PBUInt64Field ad_first_category = PBField.initUInt64(0);
                public final PBUInt64Field ad_second_category = PBField.initUInt64(0);
            }

            /* loaded from: classes28.dex */
            public static final class BasicInfo extends MessageMicro<BasicInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"img", "img_s", FileReaderHelper.TXT_EXT, "desc", "pic_width", "pic_height"}, new Object[]{"", "", "", "", 0, 0}, BasicInfo.class);
                public final PBStringField img = PBField.initString("");
                public final PBStringField img_s = PBField.initString("");
                public final PBStringField txt = PBField.initString("");
                public final PBStringField desc = PBField.initString("");
                public final PBUInt32Field pic_width = PBField.initUInt32(0);
                public final PBUInt32Field pic_height = PBField.initUInt32(0);
            }

            /* loaded from: classes28.dex */
            public static final class ButtonInfo extends MessageMicro<ButtonInfo> {
                public static final int BUTTON_POS_LEFT_BOTTOM_CORNER = 1;
                public static final int BUTTON_POS_RIGHT_BOTTOM_CORNER = 2;
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{FileReaderHelper.TXT_EXT, "url", c.G}, new Object[]{"", "", 1}, ButtonInfo.class);
                public final PBStringField txt = PBField.initString("");
                public final PBStringField url = PBField.initString("");
                public final PBEnumField pos = PBField.initEnum(1);
            }

            /* loaded from: classes28.dex */
            public static final class LocalInfo extends MessageMicro<LocalInfo> {
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBStringField distance_description = PBField.initString("");
                public final PBStringField store_name = PBField.initString("");
                public final PBStringField store_url = PBField.initString("");
                public final PBStringField store_address = PBField.initString("");
                public final PBDoubleField store_longitude = PBField.initDouble(0.0d);
                public final PBDoubleField store_latitude = PBField.initDouble(0.0d);

                static {
                    Double valueOf = Double.valueOf(0.0d);
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 41, 49}, new String[]{"distance_description", "store_name", "store_url", "store_address", "store_longitude", "store_latitude"}, new Object[]{"", "", "", "", valueOf, valueOf}, LocalInfo.class);
                }
            }

            /* loaded from: classes28.dex */
            public static final class MutiPicTextInfo extends MessageMicro<MutiPicTextInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{FileReaderHelper.TXT_EXT, "image", "url"}, new Object[]{"", "", ""}, MutiPicTextInfo.class);
                public final PBRepeatField<String> image;
                public final PBRepeatField<String> txt;
                public final PBRepeatField<String> url;

                public MutiPicTextInfo() {
                    PBStringField pBStringField = PBStringField.__repeatHelper__;
                    this.txt = PBField.initRepeat(pBStringField);
                    this.image = PBField.initRepeat(pBStringField);
                    this.url = PBField.initRepeat(pBStringField);
                }
            }

            /* loaded from: classes28.dex */
            public static final class VideoInfo extends MessageMicro<VideoInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"video_url", "media_duration", "tencent_video_id", "video_file_size", "no_auto_play"}, new Object[]{"", 0, "", 0, Boolean.FALSE}, VideoInfo.class);
                public final PBStringField video_url = PBField.initString("");
                public final PBUInt32Field media_duration = PBField.initUInt32(0);
                public final PBStringField tencent_video_id = PBField.initString("");
                public final PBUInt32Field video_file_size = PBField.initUInt32(0);
                public final PBBoolField no_auto_play = PBField.initBool(false);
            }
        }

        /* loaded from: classes28.dex */
        public static final class ExpInfo extends MessageMicro<ExpInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"qq_game_video_ad_style", "reward_video_download_type", "video_countdown", "video_volume", "video_countdown_style", "interstitial_ad_style"}, new Object[]{0, 0, 0, 0, 0, 0}, ExpInfo.class);
            public final PBInt32Field qq_game_video_ad_style = PBField.initInt32(0);
            public final PBInt32Field reward_video_download_type = PBField.initInt32(0);
            public final PBInt32Field video_countdown = PBField.initInt32(0);
            public final PBInt32Field video_volume = PBField.initInt32(0);
            public final PBInt32Field video_countdown_style = PBField.initInt32(0);
            public final PBInt32Field interstitial_ad_style = PBField.initInt32(0);
        }

        /* loaded from: classes28.dex */
        public static final class Ext extends MessageMicro<Ext> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBUInt32Field mini_program_preload = PBField.initUInt32(0);
            public final PBBoolField no_clkcgi_jump = PBField.initBool(false);
            public final PBInt32Field landing_page_style = PBField.initInt32(0);
            public final PBStringField market_deep_link = PBField.initString("");
            public final PBBoolField disable_auto_download = PBField.initBool(false);
            public final PBStringField market_package_name = PBField.initString("");

            static {
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50}, new String[]{"mini_program_preload", "no_clkcgi_jump", "landing_page_style", "market_deep_link", "disable_auto_download", "market_package_name"}, new Object[]{0, bool, 0, "", bool, ""}, Ext.class);
            }
        }

        /* loaded from: classes28.dex */
        public static final class QQAppInfo extends MessageMicro<QQAppInfo> {
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBBytesField app_id;
            public final PBBytesField app_path;
            public final PBBytesField app_schema;

            static {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"app_id", "app_path", "app_schema"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, QQAppInfo.class);
            }

            public QQAppInfo() {
                ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
                this.app_id = PBField.initBytes(byteStringMicro);
                this.app_path = PBField.initBytes(byteStringMicro);
                this.app_schema = PBField.initBytes(byteStringMicro);
            }
        }

        /* loaded from: classes28.dex */
        public static final class ReportInfo extends MessageMicro<ReportInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"exposure_url", "click_url", "effect_url", "landing_page_report_url", Constants.KEYS.AD_NEGATIVE_FEEDBACK_INFO, "trace_info", "video_report_url", "thirdparty_monitor_urls"}, new Object[]{"", "", "", "", "", null, "", null}, ReportInfo.class);
            public final PBStringField exposure_url = PBField.initString("");
            public final PBStringField click_url = PBField.initString("");
            public final PBStringField effect_url = PBField.initString("");
            public final PBStringField landing_page_report_url = PBField.initString("");
            public final PBStringField negative_feedback_url = PBField.initString("");
            public TraceInfo trace_info = new TraceInfo();
            public final PBStringField video_report_url = PBField.initString("");
            public ThirdPartyMonitorUrls thirdparty_monitor_urls = new ThirdPartyMonitorUrls();

            /* loaded from: classes28.dex */
            public static final class ThirdPartyMonitorUrls extends MessageMicro<ThirdPartyMonitorUrls> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 58}, new String[]{"api_exposure_monitor_url", "sdk_exposure_monitor_url", "api_click_monitor_url", "sdk_click_monitor_url", "video_play_monitor_url", "video_play_duration", "active_view_tracking_url"}, new Object[]{"", "", "", "", "", 0, ""}, ThirdPartyMonitorUrls.class);
                public final PBRepeatField<String> active_view_tracking_url;
                public final PBRepeatField<String> api_click_monitor_url;
                public final PBRepeatField<String> api_exposure_monitor_url;
                public final PBRepeatField<String> sdk_click_monitor_url;
                public final PBRepeatField<String> sdk_exposure_monitor_url;
                public final PBUInt32Field video_play_duration;
                public final PBRepeatField<String> video_play_monitor_url;

                public ThirdPartyMonitorUrls() {
                    PBStringField pBStringField = PBStringField.__repeatHelper__;
                    this.api_exposure_monitor_url = PBField.initRepeat(pBStringField);
                    this.sdk_exposure_monitor_url = PBField.initRepeat(pBStringField);
                    this.api_click_monitor_url = PBField.initRepeat(pBStringField);
                    this.sdk_click_monitor_url = PBField.initRepeat(pBStringField);
                    this.video_play_monitor_url = PBField.initRepeat(pBStringField);
                    this.video_play_duration = PBField.initUInt32(0);
                    this.active_view_tracking_url = PBField.initRepeat(pBStringField);
                }
            }

            /* loaded from: classes28.dex */
            public static final class TraceInfo extends MessageMicro<TraceInfo> {
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 64}, new String[]{"aid", "traceid", "via", "view_id", ReportDataBuilder.KEY_PRODUCT_ID, "noco_id", "net_log_req_id", "creative_id"}, new Object[]{0L, "", "", "", "", 0L, "", 0L}, TraceInfo.class);
                public final PBUInt64Field aid = PBField.initUInt64(0);
                public final PBStringField traceid = PBField.initString("");
                public final PBStringField via = PBField.initString("");
                public final PBStringField view_id = PBField.initString("");
                public final PBStringField product_id = PBField.initString("");
                public final PBInt64Field noco_id = PBField.initInt64(0);
                public final PBStringField net_log_req_id = PBField.initString("");
                public final PBUInt64Field creative_id = PBField.initUInt64(0);
            }
        }

        /* loaded from: classes28.dex */
        public static final class WeChatAppInfo extends MessageMicro<WeChatAppInfo> {
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48}, new String[]{"app_username", "app_path", "app_token", "app_id", "ad_trace_data", SsoReporter.POS_ID_KEY}, new Object[]{"", "", "", "", "", 0L}, WeChatAppInfo.class);
            public final PBStringField app_username = PBField.initString("");
            public final PBStringField app_path = PBField.initString("");
            public final PBStringField app_token = PBField.initString("");
            public final PBStringField app_id = PBField.initString("");
            public final PBStringField ad_trace_data = PBField.initString("");
            public final PBUInt64Field pos_id = PBField.initUInt64(0);
        }
    }

    /* loaded from: classes28.dex */
    public static final class PosAdInfo extends MessageMicro<PosAdInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ret", "msg", SsoReporter.POS_ID_KEY, "ads_info"}, new Object[]{0, "", "", null}, PosAdInfo.class);
        public final PBInt32Field ret = PBField.initInt32(0);

        /* renamed from: msg, reason: collision with root package name */
        public final PBStringField f390034msg = PBField.initString("");
        public final PBStringField pos_id = PBField.initString("");
        public final PBRepeatMessageField<AdInfo> ads_info = PBField.initRepeatMessage(AdInfo.class);
    }
}
