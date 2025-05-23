package com.tencent.qqprotect.qsec.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes25.dex */
public final class QSecPushSeriveMsg$QSecPushSeriveBody extends MessageMicro<QSecPushSeriveMsg$QSecPushSeriveBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 74, 82}, new String[]{"ver", "platform", "qsecJavaVer", "qsecNativeVer", "pluginId", "pluginCmd", "pluginVer", "canCache", "extraInfo", "packageName"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0, ByteStringMicro.EMPTY, ""}, QSecPushSeriveMsg$QSecPushSeriveBody.class);
    public final PBUInt32Field ver = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBUInt32Field qsecJavaVer = PBField.initUInt32(0);
    public final PBUInt32Field qsecNativeVer = PBField.initUInt32(0);
    public final PBUInt32Field pluginId = PBField.initUInt32(0);
    public final PBUInt32Field pluginCmd = PBField.initUInt32(0);
    public final PBUInt32Field pluginVer = PBField.initUInt32(0);
    public final PBUInt32Field canCache = PBField.initUInt32(0);
    public final PBBytesField extraInfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField packageName = PBField.initString("");
}
