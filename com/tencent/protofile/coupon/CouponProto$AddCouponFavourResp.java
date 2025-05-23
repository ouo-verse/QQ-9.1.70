package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes22.dex */
public final class CouponProto$AddCouponFavourResp extends MessageMicro<CouponProto$AddCouponFavourResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"retcode", "coupon", "ts", "jump_url"}, new Object[]{0, null, 0L, ""}, CouponProto$AddCouponFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public CouponProto$Coupon coupon = new MessageMicro<CouponProto$Coupon>() { // from class: com.tencent.protofile.coupon.CouponProto$Coupon
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 56, 66, 74, 80, 88, 98, 106, 114, 122, 128, 136, 146, 152, 160, 168}, new String[]{"cid", "bid", "name", "detail", TPReportKeys.PlayerStep.PLAYER_START_TIME, TPReportKeys.PlayerStep.PLAYER_END_TIME, "veri_type", "pic", "tag", "shids", "is_valid", "usage", "rebate", "qrcode", "qlife_url", "source_id", "rcv_time", "tips", "rcv_limit", "rcv_count", "is_readdable"}, new Object[]{0, 0, "", "", 0L, 0L, 0, "", "", 0, 0, "", "", "", "", 0, 0L, "", 0, 0, 0}, CouponProto$Coupon.class);
        public final PBUInt32Field cid = PBField.initUInt32(0);
        public final PBUInt32Field bid = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField detail = PBField.initString("");
        public final PBUInt64Field stime = PBField.initUInt64(0);
        public final PBUInt64Field etime = PBField.initUInt64(0);
        public final PBUInt32Field veri_type = PBField.initUInt32(0);
        public final PBStringField pic = PBField.initString("");
        public final PBStringField tag = PBField.initString("");
        public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field is_valid = PBField.initUInt32(0);
        public final PBStringField usage = PBField.initString("");
        public final PBStringField rebate = PBField.initString("");
        public final PBStringField qrcode = PBField.initString("");
        public final PBStringField qlife_url = PBField.initString("");
        public final PBUInt32Field source_id = PBField.initUInt32(0);
        public final PBUInt64Field rcv_time = PBField.initUInt64(0);
        public final PBStringField tips = PBField.initString("");
        public final PBUInt32Field rcv_limit = PBField.initUInt32(0);
        public final PBUInt32Field rcv_count = PBField.initUInt32(0);
        public final PBUInt32Field is_readdable = PBField.initUInt32(0);
    };

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342187ts = PBField.initUInt64(0);
    public final PBStringField jump_url = PBField.initString("");
}
