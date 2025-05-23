package com.tencent.ecommerce.repo.proto.ecom.coupon_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponBacth extends MessageMicro<ECCouponCommon$CouponBacth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"basic_info", "privilege", "user_limit", "product_limit", "get_time_limit", "use_time_limit", "quantity_limit"}, new Object[]{null, null, null, null, null, null, null}, ECCouponCommon$CouponBacth.class);
    public ECCouponCommon$CouponBacthBasicInfo basic_info = new MessageMicro<ECCouponCommon$CouponBacthBasicInfo>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$CouponBacthBasicInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66}, new String[]{JobDbManager.COL_UP_BATCH_ID, "batch_name", "shop_id", "batch_comment", "goods_name", AlbumCacheData.CREATE_TIME, "status", "batch_bill_no"}, new Object[]{"", "", "", "", "", 0L, 0, ""}, ECCouponCommon$CouponBacthBasicInfo.class);
        public final PBStringField batch_id = PBField.initString("");
        public final PBStringField batch_name = PBField.initString("");
        public final PBStringField shop_id = PBField.initString("");
        public final PBStringField batch_comment = PBField.initString("");
        public final PBStringField goods_name = PBField.initString("");
        public final PBInt64Field create_time = PBField.initInt64(0);
        public final PBEnumField status = PBField.initEnum(0);
        public final PBStringField batch_bill_no = PBField.initString("");
    };
    public ECCouponCommon$CouponPrivilege privilege = new ECCouponCommon$CouponPrivilege();
    public ECCouponCommon$UserLimit user_limit = new MessageMicro<ECCouponCommon$UserLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$UserLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"type"}, new Object[]{0}, ECCouponCommon$UserLimit.class);
        public final PBEnumField type = PBField.initEnum(0);
    };
    public ECCouponCommon$PorductLimit product_limit = new MessageMicro<ECCouponCommon$PorductLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$PorductLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"scope_type", "type", "product_list"}, new Object[]{0, 0, ""}, ECCouponCommon$PorductLimit.class);
        public final PBEnumField scope_type = PBField.initEnum(0);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBRepeatField<String> product_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public ECCouponCommon$GetTimeLimit get_time_limit = new MessageMicro<ECCouponCommon$GetTimeLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$GetTimeLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time"}, new Object[]{0L, 0L}, ECCouponCommon$GetTimeLimit.class);
        public final PBInt64Field begin_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
    };
    public ECCouponCommon$UseTimeLimit use_time_limit = new MessageMicro<ECCouponCommon$UseTimeLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$UseTimeLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"time_type", QCircleLpReportDc05502.KEY_BEGIN_TIME, "end_time", "expired_days"}, new Object[]{0, 0L, 0L, 0}, ECCouponCommon$UseTimeLimit.class);
        public final PBEnumField time_type = PBField.initEnum(0);
        public final PBInt64Field begin_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
        public final PBInt32Field expired_days = PBField.initInt32(0);
    };
    public ECCouponCommon$QuantityLimit quantity_limit = new MessageMicro<ECCouponCommon$QuantityLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.coupon_common.ECCouponCommon$QuantityLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"tatal", "single_user"}, new Object[]{0, 0}, ECCouponCommon$QuantityLimit.class);
        public final PBInt32Field tatal = PBField.initInt32(0);
        public final PBInt32Field single_user = PBField.initInt32(0);
    };
}
