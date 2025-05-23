package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class adv_report {
    public static final int ADV_CLICK = 2;
    public static final int ADV_EXPORT = 1;
    public static final int ADV_FEEDBACK = 3;
    public static final int ADV_REWARD = 4;
    public static final int ADV_SUBSCRIBE = 5;
    public static final int AUTH_FAIL = -21011;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class MobileAdvReportReq extends MessageMicro<MobileAdvReportReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 66, 74}, new String[]{"qq", "device_info", "adv_pos", "recomm_cookie", "action_type", "action_value", "feed_index", "reward_report_info", "subscribe_info"}, new Object[]{0L, null, 0, "", 0, 0, 0, null, null}, MobileAdvReportReq.class);

        /* renamed from: qq, reason: collision with root package name */
        public final PBUInt64Field f308016qq = PBField.initUInt64(0);
        public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
        public final PBInt32Field adv_pos = PBField.initInt32(0);
        public final PBStringField recomm_cookie = PBField.initString("");
        public final PBInt32Field action_type = PBField.initInt32(0);
        public final PBInt32Field action_value = PBField.initInt32(0);
        public final PBUInt32Field feed_index = PBField.initUInt32(0);
        public RewardReportInfo reward_report_info = new RewardReportInfo();
        public SubscribeInfo subscribe_info = new SubscribeInfo();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class MobileAdvReportRsp extends MessageMicro<MobileAdvReportRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "error_msg", "busi_buffer"}, new Object[]{0, "", ByteStringMicro.EMPTY}, MobileAdvReportRsp.class);
        public final PBInt32Field ret_code = PBField.initInt32(0);
        public final PBStringField error_msg = PBField.initString("");
        public final PBBytesField busi_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class RewardReportInfo extends MessageMicro<RewardReportInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"reward_type", "reward_item", "time", "nonce", "signature"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0, ""}, RewardReportInfo.class);
        public final PBInt32Field reward_type = PBField.initInt32(0);
        public final PBBytesField reward_item = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field time = PBField.initUInt64(0);
        public final PBInt32Field nonce = PBField.initInt32(0);
        public final PBStringField signature = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class SubscribeInfo extends MessageMicro<SubscribeInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"id"}, new Object[]{""}, SubscribeInfo.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBStringField f308017id = PBField.initString("");
    }

    adv_report() {
    }
}
