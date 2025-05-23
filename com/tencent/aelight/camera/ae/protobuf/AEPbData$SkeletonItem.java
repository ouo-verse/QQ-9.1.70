package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$SkeletonItem extends MessageMicro<AEPbData$SkeletonItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "scale", "position"}, new Object[]{"", null, null}, AEPbData$SkeletonItem.class);
    public final PBStringField name = PBField.initString("");
    public AEPbData$Point3f scale = new AEPbData$Point3f();
    public AEPbData$Point3f position = new AEPbData$Point3f();
}
