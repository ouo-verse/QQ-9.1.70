package com.tencent.protofile.coupon;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class CouponProto$AddBusinessFavourResp extends MessageMicro<CouponProto$AddBusinessFavourResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"retcode", "business", "ts"}, new Object[]{0, null, 0L}, CouponProto$AddBusinessFavourResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public CouponProto$Business business = new MessageMicro<CouponProto$Business>() { // from class: com.tencent.protofile.coupon.CouponProto$Business
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 90, 96, 106, 112, 120, 128, 136}, new String[]{"bid", "name", "detail", "type", "city", "tag", "contact", "tel", "logo", "mt", "cname", "update_count", "qlife_url", "source_id", "add2favour_time", "shids", "last_add_time"}, new Object[]{0, "", "", 0, "", "", "", "", "", 0L, "", 0, "", 0, 0L, 0, 0L}, CouponProto$Business.class);
        public final PBUInt32Field bid = PBField.initUInt32(0);
        public final PBStringField name = PBField.initString("");
        public final PBStringField detail = PBField.initString("");
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBStringField city = PBField.initString("");
        public final PBStringField tag = PBField.initString("");
        public final PBStringField contact = PBField.initString("");
        public final PBStringField tel = PBField.initString("");
        public final PBStringField logo = PBField.initString("");

        /* renamed from: mt, reason: collision with root package name */
        public final PBUInt64Field f342188mt = PBField.initUInt64(0);
        public final PBStringField cname = PBField.initString("");
        public final PBUInt32Field update_count = PBField.initUInt32(0);
        public final PBStringField qlife_url = PBField.initString("");
        public final PBUInt32Field source_id = PBField.initUInt32(0);
        public final PBUInt64Field add2favour_time = PBField.initUInt64(0);
        public final PBRepeatField<Integer> shids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt64Field last_add_time = PBField.initUInt64(0);
    };

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt64Field f342186ts = PBField.initUInt64(0);
}
