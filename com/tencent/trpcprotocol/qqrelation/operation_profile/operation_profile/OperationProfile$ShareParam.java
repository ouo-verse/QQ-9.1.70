package com.tencent.trpcprotocol.qqrelation.operation_profile.operation_profile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class OperationProfile$ShareParam extends MessageMicro<OperationProfile$ShareParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, OperationProfile$ShareParam.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
