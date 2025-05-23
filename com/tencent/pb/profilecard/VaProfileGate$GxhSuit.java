package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$GxhSuit extends MessageMicro<VaProfileGate$GxhSuit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"url", "number", "is_long_series", "id"}, new Object[]{"", 0, Boolean.FALSE, 0}, VaProfileGate$GxhSuit.class);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field number = PBField.initInt32(0);
    public final PBBoolField is_long_series = PBField.initBool(false);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f342171id = PBField.initInt32(0);
}
