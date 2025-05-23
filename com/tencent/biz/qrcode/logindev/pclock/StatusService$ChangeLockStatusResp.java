package com.tencent.biz.qrcode.logindev.pclock;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StatusService$ChangeLockStatusResp extends MessageMicro<StatusService$ChangeLockStatusResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"reply_code", "reply_string"}, new Object[]{0, ByteStringMicro.EMPTY}, StatusService$ChangeLockStatusResp.class);
    public final PBUInt32Field reply_code = PBField.initUInt32(0);
    public final PBBytesField reply_string = PBField.initBytes(ByteStringMicro.EMPTY);
}
