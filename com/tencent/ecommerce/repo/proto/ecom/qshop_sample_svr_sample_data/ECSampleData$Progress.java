package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes31.dex */
public final class ECSampleData$Progress extends MessageMicro<ECSampleData$Progress> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"desc", "done"}, new Object[]{"", Boolean.FALSE}, ECSampleData$Progress.class);
    public final PBStringField desc = PBField.initString("");
    public final PBBoolField done = PBField.initBool(false);
}
