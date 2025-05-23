package com.tencent.ecommerce.repo.proto.ecom.common_coupon_common;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECCouponCommon$CouponShowInfo extends MessageMicro<ECCouponCommon$CouponShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 42, 82, 88, 96, 160, 242, 322}, new String[]{"coupon_batch_id", "basic_info", "issue_rule", "user_coupon_use", AlbumCacheData.CREATE_TIME, "modify_time", "coupon_remain_num", "show_limit", "coupon_list_style"}, new Object[]{"", null, null, null, 0L, 0L, 0, null, null}, ECCouponCommon$CouponShowInfo.class);
    public final PBStringField coupon_batch_id = PBField.initString("");
    public ECCouponCommon$CouponBasicInfo basic_info = new ECCouponCommon$CouponBasicInfo();
    public ECCouponCommon$IssueRule issue_rule = new ECCouponCommon$IssueRule();
    public ECCouponCommon$UserCouponUse user_coupon_use = new MessageMicro<ECCouponCommon$UserCouponUse>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$UserCouponUse
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"user_id", "has_num", "remain_num"}, new Object[]{"", 0, 0}, ECCouponCommon$UserCouponUse.class);
        public final PBStringField user_id = PBField.initString("");
        public final PBUInt32Field has_num = PBField.initUInt32(0);
        public final PBUInt32Field remain_num = PBField.initUInt32(0);
    };
    public final PBInt64Field create_time = PBField.initInt64(0);
    public final PBInt64Field modify_time = PBField.initInt64(0);
    public final PBUInt32Field coupon_remain_num = PBField.initUInt32(0);
    public ECCouponCommon$CouponShowLimit show_limit = new MessageMicro<ECCouponCommon$CouponShowLimit>() { // from class: com.tencent.ecommerce.repo.proto.ecom.common_coupon_common.ECCouponCommon$CouponShowLimit
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"limit"}, new Object[]{0}, ECCouponCommon$CouponShowLimit.class);
        public final PBUInt32Field limit = PBField.initUInt32(0);
    };
    public ECCouponCommon$CouponShowStyleInfo coupon_list_style = new ECCouponCommon$CouponShowStyleInfo();
}
