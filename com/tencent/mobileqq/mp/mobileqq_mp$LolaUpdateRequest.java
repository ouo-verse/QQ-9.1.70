package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$LolaUpdateRequest extends MessageMicro<mobileqq_mp$LolaUpdateRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"versionInfo", "request_item"}, new Object[]{"", null}, mobileqq_mp$LolaUpdateRequest.class);
    public final PBStringField versionInfo = PBField.initString("");
    public final PBRepeatMessageField<mobileqq_mp$UpdateRequestItem> request_item = PBField.initRepeatMessage(mobileqq_mp$UpdateRequestItem.class);
}
