package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes32.dex */
public final class AEPbData$CartoonPtaRequest extends MessageMicro<AEPbData$CartoonPtaRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"img", "debug"}, new Object[]{null, Boolean.FALSE}, AEPbData$CartoonPtaRequest.class);
    public AEPbData$ImageInfo img = new AEPbData$ImageInfo();
    public final PBBoolField debug = PBField.initBool(false);
}
