package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECSampleData$PicInfo extends MessageMicro<ECSampleData$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"url", "is_gif", "width", "height"}, new Object[]{"", Boolean.FALSE, 0, 0}, ECSampleData$PicInfo.class);
    public final PBStringField url = PBField.initString("");
    public final PBBoolField is_gif = PBField.initBool(false);
    public final PBInt32Field width = PBField.initInt32(0);
    public final PBInt32Field height = PBField.initInt32(0);
}
