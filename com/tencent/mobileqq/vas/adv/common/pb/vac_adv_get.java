package com.tencent.mobileqq.vas.adv.common.pb;

import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.vip.pb.TianShuAccess;
import s4.c;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class vac_adv_get {
    public static final int DoHideAdv = 2;
    public static final int ENUM_CERTIFIED_ACCOUNT_DETAIL = 5;
    public static final int ENUM_CERTIFIED_ACCOUNT_DISCOVERY = 4;
    public static final int ENUM_FEEDS_NOTIFY = 8;
    public static final int ENUM_KUOLIE_FEEDS_ADV = 3;
    public static final int ENUM_PC_QQTAB_ADV = 1;
    public static final int ENUM_QQ_GROUP_CPS_ADV = 6;
    public static final int ENUM_QQ_VIP_PERSONAL = 1;
    public static final int ENUM_QQ_WALLET_CPS_ADV = 9;
    public static final int ENUM_QZONE_GIFT = 2;
    public static final int ENUM_QZONE_PIC_LAYER_ADV = 2;
    public static final int ENUM_REWARD_ADV = 7;
    public static final int ENUM_XSJ_ADV_BANNER = 10;
    public static final int ENUM_XSJ_BANNER_GIFT = 4;
    public static final int ENUM_XSJ_BANNER_ROCKET = 5;
    public static final int ENUM_XSJ_BANNER_WALLET = 3;
    public static final int ENUM_XSJ_FUEL_TIPS = 9;
    public static final int ENUM_XSJ_MISSION = 8;
    public static final int ENUM_XSJ_POPUP_GIFT = 6;
    public static final int ENUM_XSJ_POPUP_ROCKET = 7;
    public static final int GET_COMM_FEEDS_ADV = 3;
    public static final int GET_COMM_GDT_ADV = 1;
    public static final int GET_QZONE_WEBAPP_ADV = 2;
    public static final int OpenWebPage = 1;
    public static final int UNKNOWN = 0;
    public static final int VIDEO_VIP_1 = 1;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class Activity extends MessageMicro<Activity> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"reward_type", "icon_url", "title", "images", "desc_before", "desc_after", "btn_before", "btn_after", "jump_url"}, new Object[]{0, "", "", "", "", "", "", "", ""}, Activity.class);
        public final PBEnumField reward_type = PBField.initEnum(0);
        public final PBStringField icon_url = PBField.initString("");
        public final PBStringField title = PBField.initString("");
        public final PBRepeatField<String> images = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField desc_before = PBField.initString("");
        public final PBStringField desc_after = PBField.initString("");
        public final PBStringField btn_before = PBField.initString("");
        public final PBStringField btn_after = PBField.initString("");
        public final PBStringField jump_url = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class DefaultConf extends MessageMicro<DefaultConf> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"left_bottom_text", "right_bottom_button"}, new Object[]{"", ""}, DefaultConf.class);
        public final PBStringField left_bottom_text = PBField.initString("");
        public final PBStringField right_bottom_button = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class DropList extends MessageMicro<DropList> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{TangramAppConstants.ICON_URL, "optext", "jumpurl", "action_type"}, new Object[]{"", "", "", 1}, DropList.class);
        public final PBStringField iconurl = PBField.initString("");
        public final PBStringField optext = PBField.initString("");
        public final PBStringField jumpurl = PBField.initString("");
        public final PBEnumField action_type = PBField.initEnum(1);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class ExtendInfo extends MessageMicro<ExtendInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ExtendInfo.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class FeedsContextInfo extends MessageMicro<FeedsContextInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"index", c.UGCKEY}, new Object[]{0, ""}, FeedsContextInfo.class);
        public final PBInt32Field index = PBField.initInt32(0);
        public final PBStringField ugckey = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class NonstandardAdInfo extends MessageMicro<NonstandardAdInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ad_item", "report_attachment"}, new Object[]{null, ""}, NonstandardAdInfo.class);
        public TianShuAccess.AdItem ad_item = new TianShuAccess.AdItem();
        public final PBStringField report_attachment = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class QzoneActivity extends MessageMicro<QzoneActivity> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"adv", "activities", "trace_id", "click_mode"}, new Object[]{null, null, "", 0}, QzoneActivity.class);
        public VacAdvRsp adv = new VacAdvRsp();
        public final PBRepeatMessageField<Activity> activities = PBField.initRepeatMessage(Activity.class);
        public final PBStringField trace_id = PBField.initString("");
        public final PBInt32Field click_mode = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class QzoneBusiMsg extends MessageMicro<QzoneBusiMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"page_num", "cur_page_infos", "device_info"}, new Object[]{0, null, ""}, QzoneBusiMsg.class);
        public final PBInt32Field page_num = PBField.initInt32(0);
        public final PBRepeatMessageField<FeedsContextInfo> cur_page_infos = PBField.initRepeatMessage(FeedsContextInfo.class);
        public final PBStringField device_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class RewardReqInfo extends MessageMicro<RewardReqInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"reward_type", "reward_item"}, new Object[]{1, ByteStringMicro.EMPTY}, RewardReqInfo.class);
        public final PBEnumField reward_type = PBField.initEnum(1);
        public final PBBytesField reward_item = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class RewardRspInfo extends MessageMicro<RewardRspInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"time", "nonce", "signature"}, new Object[]{0L, 0, ""}, RewardRspInfo.class);
        public final PBUInt64Field time = PBField.initUInt64(0);
        public final PBInt32Field nonce = PBField.initInt32(0);
        public final PBStringField signature = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class TianShuMsg extends MessageMicro<TianShuMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"adv", "trace_id", "ad_pos_type"}, new Object[]{null, "", 0}, TianShuMsg.class);
        public NonstandardAdInfo adv = new NonstandardAdInfo();
        public final PBStringField trace_id = PBField.initString("");
        public final PBEnumField ad_pos_type = PBField.initEnum(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacAdvMetaMsg extends MessageMicro<VacAdvMetaMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"adv_rsp", "insert_pos", "recomm_cookie"}, new Object[]{null, 0, ""}, VacAdvMetaMsg.class);
        public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
        public final PBInt32Field insert_pos = PBField.initInt32(0);
        public final PBStringField recomm_cookie = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacAdvReq extends MessageMicro<VacAdvReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 58, 64, 74, 82}, new String[]{"qq", "device_info", "adv_pos", "qzone_busi_info", "attach_info", "reward_req_info", "source_from", "exp_ids", "client_mod"}, new Object[]{0L, null, 1, null, "", null, 0, "", ""}, VacAdvReq.class);

        /* renamed from: qq, reason: collision with root package name */
        public final PBUInt64Field f308018qq = PBField.initUInt64(0);
        public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
        public final PBEnumField adv_pos = PBField.initEnum(1);
        public QzoneBusiMsg qzone_busi_info = new QzoneBusiMsg();
        public final PBStringField attach_info = PBField.initString("");
        public RewardReqInfo reward_req_info = new RewardReqInfo();
        public final PBUInt32Field source_from = PBField.initUInt32(0);
        public final PBRepeatField<String> exp_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField client_mod = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacAdvRsp extends MessageMicro<VacAdvRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "vac_adv_msgs", "attach_info", "reward_rsp_info", "busi_buffer", ReportDataBuilder.KEY_EXTEND_INFO}, new Object[]{0, "", null, "", null, ByteStringMicro.EMPTY, null}, VacAdvRsp.class);
        public final PBInt32Field err_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBRepeatMessageField<VacAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(VacAdvMetaMsg.class);
        public final PBStringField attach_info = PBField.initString("");
        public RewardRspInfo reward_rsp_info = new RewardRspInfo();
        public final PBBytesField busi_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<ExtendInfo> extend_info = PBField.initRepeatMessage(ExtendInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacFeedsAdvMetaInfo extends MessageMicro<VacFeedsAdvMetaInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"adv_rsp", "default_conf", "droplist", "recomm_cookie"}, new Object[]{null, null, null, ""}, VacFeedsAdvMetaInfo.class);
        public qq_ad_get.QQAdGetRsp.AdInfo adv_rsp = new qq_ad_get.QQAdGetRsp.AdInfo();
        public DefaultConf default_conf = new DefaultConf();
        public final PBRepeatMessageField<DropList> droplist = PBField.initRepeatMessage(DropList.class);
        public final PBStringField recomm_cookie = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacFeedsAdvMetaMsg extends MessageMicro<VacFeedsAdvMetaMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rsp_buffer", "insert_pos"}, new Object[]{ByteStringMicro.EMPTY, 0}, VacFeedsAdvMetaMsg.class);
        public final PBBytesField rsp_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field insert_pos = PBField.initInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacFeedsAdvMetaReq extends MessageMicro<VacFeedsAdvMetaReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"device_info"}, new Object[]{null}, VacFeedsAdvMetaReq.class);
        public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacFeedsAdvReq extends MessageMicro<VacFeedsAdvReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58}, new String[]{"qq", "adv_pos", "req_buffer", "page_num", "pre_feed_index", "recom_adv_pos", "attach_info"}, new Object[]{0L, 1, ByteStringMicro.EMPTY, 0, 0, "", ""}, VacFeedsAdvReq.class);

        /* renamed from: qq, reason: collision with root package name */
        public final PBUInt64Field f308019qq = PBField.initUInt64(0);
        public final PBEnumField adv_pos = PBField.initEnum(1);
        public final PBBytesField req_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBInt32Field page_num = PBField.initInt32(0);
        public final PBInt32Field pre_feed_index = PBField.initInt32(0);
        public final PBRepeatField<String> recom_adv_pos = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField attach_info = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class VacFeedsAdvRsp extends MessageMicro<VacFeedsAdvRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "vac_adv_msgs", "attach_info", "adv_export_cnt"}, new Object[]{0, "", null, "", 0}, VacFeedsAdvRsp.class);
        public final PBInt32Field err_code = PBField.initInt32(0);
        public final PBStringField err_msg = PBField.initString("");
        public final PBRepeatMessageField<VacFeedsAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(VacFeedsAdvMetaMsg.class);
        public final PBStringField attach_info = PBField.initString("");
        public final PBInt32Field adv_export_cnt = PBField.initInt32(0);
    }

    vac_adv_get() {
    }
}
