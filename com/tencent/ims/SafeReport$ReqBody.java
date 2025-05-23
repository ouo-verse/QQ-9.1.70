package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SafeReport$ReqBody extends MessageMicro<SafeReport$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"LogItem_reportdata"}, new Object[]{null}, SafeReport$ReqBody.class);
    public final PBRepeatMessageField<SafeReport$LogItem> LogItem_reportdata = PBField.initRepeatMessage(SafeReport$LogItem.class);
}
