package com.qq.mobile.datarecv.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class IMaxADReport$ReqBody extends MessageMicro<IMaxADReport$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"bytes_ad_id", "uint32_action_type"}, new Object[]{ByteStringMicro.EMPTY, 0}, IMaxADReport$ReqBody.class);
    public final PBBytesField bytes_ad_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
}
