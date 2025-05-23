package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class JDSearch$Rectangle extends MessageMicro<JDSearch$Rectangle> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBFloatField bottom = PBField.initFloat(0.0f);
    public final PBInt32Field is_user_rectangle = PBField.initInt32(0);
    public final PBFloatField left = PBField.initFloat(0.0f);
    public final PBFloatField right = PBField.initFloat(0.0f);
    public final PBFloatField top = PBField.initFloat(0.0f);

    static {
        Float valueOf = Float.valueOf(0.0f);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 29, 37, 45}, new String[]{"bottom", "is_user_rectangle", "left", "right", "top"}, new Object[]{valueOf, 0, valueOf, valueOf, valueOf}, JDSearch$Rectangle.class);
    }
}
