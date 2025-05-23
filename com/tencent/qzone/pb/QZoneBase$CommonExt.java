package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneBase$CommonExt extends MessageMicro<QZoneBase$CommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"map_info", "attach_info"}, new Object[]{null, ""}, QZoneBase$CommonExt.class);
    public final PBRepeatMessageField<QZoneBase$Entry> map_info = PBField.initRepeatMessage(QZoneBase$Entry.class);
    public final PBStringField attach_info = PBField.initString("");
}
