package com.tencent.mobileqq.trpc.qqecommerce.access;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VacAdvGet$Coupon extends MessageMicro<VacAdvGet$Coupon> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 66, 74, 88, 96, 104, 112, 122, 130, 136}, new String[]{AppConstants.Key.BIND_TYPE, "discount", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "platform_type", "quota", "get_start_time", "get_end_time", "use_start_time", "use_end_time", "is_best", "hot_value", "remain_quantity", "total_quantity", "coupon_no", "coupon_name", "coupon_type"}, new Object[]{0, 0L, "", 0, 0L, "", "", "", "", 0, 0, 0L, 0L, "", "", 0}, VacAdvGet$Coupon.class);
    public final PBInt32Field bind_type = PBField.initInt32(0);
    public final PBInt64Field discount = PBField.initInt64(0);
    public final PBStringField link = PBField.initString("");
    public final PBInt32Field platform_type = PBField.initInt32(0);
    public final PBInt64Field quota = PBField.initInt64(0);
    public final PBStringField get_start_time = PBField.initString("");
    public final PBStringField get_end_time = PBField.initString("");
    public final PBStringField use_start_time = PBField.initString("");
    public final PBStringField use_end_time = PBField.initString("");
    public final PBInt32Field is_best = PBField.initInt32(0);
    public final PBInt32Field hot_value = PBField.initInt32(0);
    public final PBInt64Field remain_quantity = PBField.initInt64(0);
    public final PBInt64Field total_quantity = PBField.initInt64(0);
    public final PBStringField coupon_no = PBField.initString("");
    public final PBStringField coupon_name = PBField.initString("");
    public final PBInt32Field coupon_type = PBField.initInt32(0);
}
