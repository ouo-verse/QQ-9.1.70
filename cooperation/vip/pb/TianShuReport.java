package cooperation.vip.pb;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.view.FilterEnum;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class TianShuReport {
    public static final int ENUM_ACTION_ATTR_CHANGE = 127;
    public static final int ENUM_AUTO_PAY_CLICK = 134;
    public static final int ENUM_CANCEL_COLLECTION = 136;
    public static final int ENUM_COLLECTION = 135;
    public static final int ENUM_DIRECT = 5;
    public static final int ENUM_FLOAT_VIEW = 4;
    public static final int ENUM_IS_AUTO_PLAY = 1;
    public static final int ENUM_ITEM_CLICK = 102;
    public static final int ENUM_ITEM_CLICK_RED_OLD = 123;
    public static final int ENUM_ITEM_CLOSE = 122;
    public static final int ENUM_ITEM_DOWNLOAD = 103;
    public static final int ENUM_ITEM_EXPORT = 101;
    public static final int ENUM_ITEM_FOLLOW = 120;
    public static final int ENUM_ITEM_GIVE = 114;
    public static final int ENUM_ITEM_INTERCEPT = 213;
    public static final int ENUM_ITEM_LIKE = 116;
    public static final int ENUM_ITEM_LIST_FIVE_EXPORT = 141;
    public static final int ENUM_ITEM_LIST_FOUR_EXPORT = 139;
    public static final int ENUM_ITEM_PAY = 109;
    public static final int ENUM_ITEM_PAY_SUCC = 110;
    public static final int ENUM_ITEM_SHARE = 115;
    public static final int ENUM_ITEM_SKIP = 162;
    public static final int ENUM_ITEM_SPLASH_SHAKE = 138;
    public static final int ENUM_ITEM_SPLASH_TOUCH_SLIDE = 118;
    public static final int ENUM_ITEM_SUB_LIST_CLICK = 138;
    public static final int ENUM_ITEM_SUB_LIST_EXPORT = 137;
    public static final int ENUM_ITEM_SUB_LIST_FIVE_CLICK = 142;
    public static final int ENUM_ITEM_SUB_LIST_FOUR_CLICK = 140;
    public static final int ENUM_ITEM_TYPE_CHANGE = 126;
    public static final int ENUM_ITEM_UNUSE = 128;
    public static final int ENUM_ITEM_USE = 113;
    public static final int ENUM_MESSAGE_ARRIVE = 119;
    public static final int ENUM_MESSAGE_CLICK = 118;
    public static final int ENUM_MESSAGE_EXPORT = 117;
    public static final int ENUM_MODULE_CLIKC = 124;
    public static final int ENUM_MODULE_EXPORT = 111;
    public static final int ENUM_PAGE_COST = 133;
    public static final int ENUM_PAGE_EXCEPTION_COST = 132;
    public static final int ENUM_PAGE_EXPORT = 100;
    public static final int ENUM_PAGE_INIT_COST = 130;
    public static final int ENUM_PAGE_LOADURL_COST = 131;
    public static final int ENUM_PAGE_LOAD_COST = 129;
    public static final int ENUM_PUBLIC_ACC_RED_DOT_DEL = 205;
    public static final int ENUM_QQPAY = 3;
    public static final int ENUM_RED_MESSAGE_ARRIVE = 121;
    public static final int ENUM_SUBMODULE_CLICK = 125;
    public static final int ENUM_SUB_MODULE_EXPORT = 112;
    public static final int ENUM_UNKNOW_ID = 999;
    public static final int ENUM_USER_ACTION_STANDARD_MULTI_REPORT_PB = 4;
    public static final int ENUM_USER_ACTION_STANDARD_REPORT_PB = 3;
    public static final int ENUM_WARM_ITEM_EXPORT = 143;
    public static final int ENUM_WEPAY = 2;
    public static final int ENUM_WITH_RED = 6;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionMultiReportReq extends MessageMicro<UserActionMultiReportReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"user_comm_report", "report_infos"}, new Object[]{null, null}, UserActionMultiReportReq.class);
        public UserCommReport user_comm_report = new UserCommReport();
        public final PBRepeatMessageField<UserActionReport> report_infos = PBField.initRepeatMessage(UserActionReport.class);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionMultiReportRsp extends MessageMicro<UserActionMultiReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "multi_duration"}, new Object[]{0, "", 0}, UserActionMultiReportRsp.class);
        public final PBInt32Field err_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBInt32Field multi_duration = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionPvStatic extends MessageMicro<UserActionPvStatic> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 56, 64}, new String[]{"appid", "page_id", "module_id", "sub_module_id", "rule_id", "item_id", "action_id", "value"}, new Object[]{"", "", "", "", 0L, "", 100, 0L}, UserActionPvStatic.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField page_id = PBField.initString("");
        public final PBStringField module_id = PBField.initString("");
        public final PBStringField sub_module_id = PBField.initString("");
        public final PBInt64Field rule_id = PBField.initInt64(0);
        public final PBStringField item_id = PBField.initString("");
        public final PBEnumField action_id = PBField.initEnum(100);
        public final PBInt64Field value = PBField.initInt64(0);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionReport extends MessageMicro<UserActionReport> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128, 136, 146, 154, 162, 170}, new String[]{"trace_id", "trace_num", "trace_detail", "trace_index", "appid", "page_id", "item_id", "sub_item_id", "module_id", "sub_module_id", QCircleLpReportDc05507.KEY_POSITION_ID, "test_id", "rule_id", "oper_time", "action_id", "action_value", "action_attr", "trigger_info", "busi_info", "item_type", "to_uid"}, new Object[]{"", 0, "", "", "", "", "", "", "", "", "", 0L, 0L, 0L, 100, 0L, 1, "", "", "", ""}, UserActionReport.class);
        public final PBStringField trace_id = PBField.initString("");
        public final PBUInt32Field trace_num = PBField.initUInt32(0);
        public final PBStringField trace_detail = PBField.initString("");
        public final PBStringField trace_index = PBField.initString("");
        public final PBStringField appid = PBField.initString("");
        public final PBStringField page_id = PBField.initString("");
        public final PBStringField item_id = PBField.initString("");
        public final PBStringField sub_item_id = PBField.initString("");
        public final PBStringField module_id = PBField.initString("");
        public final PBStringField sub_module_id = PBField.initString("");
        public final PBStringField position_id = PBField.initString("");
        public final PBInt64Field test_id = PBField.initInt64(0);
        public final PBInt64Field rule_id = PBField.initInt64(0);
        public final PBInt64Field oper_time = PBField.initInt64(0);
        public final PBEnumField action_id = PBField.initEnum(100);
        public final PBInt64Field action_value = PBField.initInt64(0);
        public final PBEnumField action_attr = PBField.initEnum(1);
        public final PBStringField trigger_info = PBField.initString("");
        public final PBStringField busi_info = PBField.initString("");
        public final PBStringField item_type = PBField.initString("");
        public final PBStringField to_uid = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionReportReq extends MessageMicro<UserActionReportReq> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField uid = PBField.initString("");
        public final PBStringField to_uid = PBField.initString("");
        public final PBStringField guid = PBField.initString("");
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);
        public final PBStringField city_code = PBField.initString("");
        public final PBStringField platform = PBField.initString("");
        public final PBStringField client_type = PBField.initString("");
        public final PBStringField app_version = PBField.initString("");
        public final PBStringField market = PBField.initString("");
        public final PBStringField qua = PBField.initString("");
        public final PBStringField os_version = PBField.initString("");
        public final PBStringField mobile_type = PBField.initString("");
        public final PBStringField ip_addr = PBField.initString("");
        public final PBStringField network_type = PBField.initString("");
        public final PBStringField operators = PBField.initString("");
        public final PBStringField trace_id = PBField.initString("");
        public final PBUInt32Field trace_num = PBField.initUInt32(0);
        public final PBStringField trace_detail = PBField.initString("");
        public final PBStringField trace_index = PBField.initString("");
        public final PBStringField appid = PBField.initString("");
        public final PBStringField page_id = PBField.initString("");
        public final PBStringField item_id = PBField.initString("");
        public final PBStringField sub_item_id = PBField.initString("");
        public final PBStringField module_id = PBField.initString("");
        public final PBStringField sub_module_id = PBField.initString("");
        public final PBStringField position_id = PBField.initString("");
        public final PBInt64Field test_id = PBField.initInt64(0);
        public final PBInt64Field rule_id = PBField.initInt64(0);
        public final PBInt64Field oper_time = PBField.initInt64(0);
        public final PBEnumField action_id = PBField.initEnum(100);
        public final PBInt64Field action_value = PBField.initInt64(0);
        public final PBEnumField action_attr = PBField.initEnum(1);
        public final PBStringField trigger_info = PBField.initString("");
        public final PBStringField busi_info = PBField.initString("");
        public final PBStringField item_type = PBField.initString("");
        public final PBStringField qimei = PBField.initString("");

        static {
            int[] iArr = {10, 18, 26, 33, 41, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 144, 154, 162, 170, 178, 186, 194, 202, 210, 218, 224, 232, 240, 248, 256, 264, 274, FilterEnum.MIC_PTU_BAIXI, 290, 298};
            String[] strArr = {"uid", "to_uid", "guid", "longitude", "latitude", "city_code", "platform", AudienceReportConst.CLIENT_TYPE, "app_version", "market", "qua", "os_version", "mobile_type", "ip_addr", "network_type", "operators", "trace_id", "trace_num", "trace_detail", "trace_index", "appid", "page_id", "item_id", "sub_item_id", "module_id", "sub_module_id", QCircleLpReportDc05507.KEY_POSITION_ID, "test_id", "rule_id", "oper_time", "action_id", "action_value", "action_attr", "trigger_info", "busi_info", "item_type", TVKLiveRequestBuilder.RequestParamKey.QIMEI36};
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(iArr, strArr, new Object[]{"", "", "", valueOf, valueOf, "", "", "", "", "", "", "", "", "", "", "", "", 0, "", "", "", "", "", "", "", "", "", 0L, 0L, 0L, 100, 0L, 1, "", "", "", ""}, UserActionReportReq.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserActionReportRsp extends MessageMicro<UserActionReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, ""}, UserActionReportRsp.class);
        public final PBInt32Field err_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class UserCommReport extends MessageMicro<UserCommReport> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBStringField uid = PBField.initString("");
        public final PBStringField to_uid = PBField.initString("");
        public final PBStringField guid = PBField.initString("");
        public final PBDoubleField longitude = PBField.initDouble(0.0d);
        public final PBDoubleField latitude = PBField.initDouble(0.0d);
        public final PBStringField city_code = PBField.initString("");
        public final PBStringField platform = PBField.initString("");
        public final PBStringField client_type = PBField.initString("");
        public final PBStringField app_version = PBField.initString("");
        public final PBStringField market = PBField.initString("");
        public final PBStringField qua = PBField.initString("");
        public final PBStringField os_version = PBField.initString("");
        public final PBStringField mobile_type = PBField.initString("");
        public final PBStringField ip_addr = PBField.initString("");
        public final PBStringField network_type = PBField.initString("");
        public final PBStringField operators = PBField.initString("");
        public final PBStringField qimei = PBField.initString("");
        public final PBStringField brand = PBField.initString("");
        public final PBStringField sub_platform = PBField.initString("");
        public final PBUInt64Field appid = PBField.initUInt64(0);

        static {
            String[] strArr = {"uid", "to_uid", "guid", "longitude", "latitude", "city_code", "platform", AudienceReportConst.CLIENT_TYPE, "app_version", "market", "qua", "os_version", "mobile_type", "ip_addr", "network_type", "operators", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "brand", "sub_platform", "appid"};
            Double valueOf = Double.valueOf(0.0d);
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 33, 41, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 160}, strArr, new Object[]{"", "", "", valueOf, valueOf, "", "", "", "", "", "", "", "", "", "", "", "", "", "", 0L}, UserCommReport.class);
        }
    }

    TianShuReport() {
    }
}
