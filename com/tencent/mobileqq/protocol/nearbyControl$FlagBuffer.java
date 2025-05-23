package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$FlagBuffer extends MessageMicro<nearbyControl$FlagBuffer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 64}, new String[]{"indexId", "flag", "buffer", "bufferType", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "bufferMd5", "customizeKey", "subcode"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0, 0L, "", "", 0}, nearbyControl$FlagBuffer.class);
    public final PBUInt32Field indexId = PBField.initUInt32(0);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field bufferType = PBField.initUInt32(0);
    public final PBUInt64Field timeStamp = PBField.initUInt64(0);
    public final PBStringField bufferMd5 = PBField.initString("");
    public final PBStringField customizeKey = PBField.initString("");
    public final PBUInt32Field subcode = PBField.initUInt32(0);
}
