package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes32.dex */
public final class AEPbData$ImageStylizeRequest extends MessageMicro<AEPbData$ImageStylizeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"imgInfo", "stylizeType"}, new Object[]{null, 0}, AEPbData$ImageStylizeRequest.class);
    public AEPbData$ImageInfo imgInfo = new AEPbData$ImageInfo();
    public final PBEnumField stylizeType = PBField.initEnum(0);
}
