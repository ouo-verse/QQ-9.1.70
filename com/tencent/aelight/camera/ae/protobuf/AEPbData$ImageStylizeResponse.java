package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes32.dex */
public final class AEPbData$ImageStylizeResponse extends MessageMicro<AEPbData$ImageStylizeResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", "imageRawData"}, new Object[]{0, "", ByteStringMicro.EMPTY}, AEPbData$ImageStylizeResponse.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f65665msg = PBField.initString("");
    public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
}
