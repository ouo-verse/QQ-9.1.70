package com.tencent.mobileqq.trpc.qqecommerce.access;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class VacAdvGet$Label extends MessageMicro<VacAdvGet$Label> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"label_id", "label_name"}, new Object[]{0, ""}, VacAdvGet$Label.class);
    public final PBInt32Field label_id = PBField.initInt32(0);
    public final PBStringField label_name = PBField.initString("");
}
