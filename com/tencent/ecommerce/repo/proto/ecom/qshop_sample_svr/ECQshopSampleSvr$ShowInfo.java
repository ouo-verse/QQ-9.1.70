package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopSampleSvr$ShowInfo extends MessageMicro<ECQshopSampleSvr$ShowInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"sub_title", "expire_left_time", "modify_expire_time"}, new Object[]{"", 0L, 0L}, ECQshopSampleSvr$ShowInfo.class);
    public final PBStringField sub_title = PBField.initString("");
    public final PBInt64Field expire_left_time = PBField.initInt64(0);
    public final PBInt64Field modify_expire_time = PBField.initInt64(0);
}
