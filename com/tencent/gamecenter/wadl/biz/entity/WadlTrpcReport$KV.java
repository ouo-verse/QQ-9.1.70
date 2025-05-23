package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WadlTrpcReport$KV extends MessageMicro<WadlTrpcReport$KV> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, WadlTrpcReport$KV.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
