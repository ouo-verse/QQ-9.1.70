package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class ECSampleData$ProductSnapshot extends MessageMicro<ECSampleData$ProductSnapshot> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56, 66, 72, 82, 90}, new String[]{"sku_id", "spu_id", "title", "count", "spec_info", "service", "price", "pic_list", "total_amount", "detail_link", "first_cat_id"}, new Object[]{"", "", "", 0, null, null, 0L, null, 0L, "", ""}, ECSampleData$ProductSnapshot.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
    public ECSampleData$SpecInfo spec_info = new ECSampleData$SpecInfo();
    public ECSampleData$Service service = new ECSampleData$Service();
    public final PBUInt64Field price = PBField.initUInt64(0);
    public final PBRepeatMessageField<ECSampleData$PicInfo> pic_list = PBField.initRepeatMessage(ECSampleData$PicInfo.class);
    public final PBUInt64Field total_amount = PBField.initUInt64(0);
    public final PBStringField detail_link = PBField.initString("");
    public final PBStringField first_cat_id = PBField.initString("");
}
