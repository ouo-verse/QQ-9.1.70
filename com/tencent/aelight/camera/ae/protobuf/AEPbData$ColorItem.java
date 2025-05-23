package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$ColorItem extends MessageMicro<AEPbData$ColorItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "hsv", "rgb"}, new Object[]{"", null, null}, AEPbData$ColorItem.class);
    public final PBStringField name = PBField.initString("");
    public AEPbData$Point3f hsv = new AEPbData$Point3f();
    public AEPbData$Point3f rgb = new AEPbData$Point3f();
}
