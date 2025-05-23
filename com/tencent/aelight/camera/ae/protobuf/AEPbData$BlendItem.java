package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$BlendItem extends MessageMicro<AEPbData$BlendItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 21}, new String[]{"bs_key", "bs_value"}, new Object[]{"", Float.valueOf(0.0f)}, AEPbData$BlendItem.class);
    public final PBStringField bs_key = PBField.initString("");
    public final PBFloatField bs_value = PBField.initFloat(0.0f);
}
