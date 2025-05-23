package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class SubmitPromotePage$SubmitResultItem extends MessageMicro<SubmitPromotePage$SubmitResultItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "item_id", "result"}, new Object[]{0, "", 0}, SubmitPromotePage$SubmitResultItem.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField item_id = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
}
