package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$DressItem extends MessageMicro<AEPbData$DressItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"name", "id"}, new Object[]{"", 0}, AEPbData$DressItem.class);
    public final PBStringField name = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f65664id = PBField.initInt32(0);
}
