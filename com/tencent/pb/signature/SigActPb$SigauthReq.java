package com.tencent.pb.signature;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class SigActPb$SigauthReq extends MessageMicro<SigActPb$SigauthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"uin_disable", "itemid", c.E, "data", "fontid"}, new Object[]{0L, 0, 0, ByteStringMicro.EMPTY, 0}, SigActPb$SigauthReq.class);
    public final PBUInt64Field uin_disable = PBField.initUInt64(0);
    public final PBInt32Field itemid = PBField.initInt32(0);
    public final PBInt32Field len = PBField.initInt32(0);
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field fontid = PBField.initInt32(0);
}
