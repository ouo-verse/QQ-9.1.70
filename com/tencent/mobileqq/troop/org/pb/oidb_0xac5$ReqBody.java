package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0xac5$ReqBody extends MessageMicro<oidb_0xac5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_msg"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0xac5$ReqBody.class);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
