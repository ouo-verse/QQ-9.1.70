package com.tencent.mobileqq.trpc.qqecommerce.access;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VacAdvGet$VacGetGoodsReq extends MessageMicro<VacAdvGet$VacGetGoodsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50}, new String[]{"app_id", "category_list", "current_category_id", "page_number", "ext_info", "device_info"}, new Object[]{"", 0, 0, 0, ByteStringMicro.EMPTY, null}, VacAdvGet$VacGetGoodsReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBRepeatField<Integer> category_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field current_category_id = PBField.initInt32(0);
    public final PBInt32Field page_number = PBField.initInt32(0);
    public final PBBytesField ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
}
