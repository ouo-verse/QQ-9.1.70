package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class SigActPb$SigactRsp extends MessageMicro<SigActPb$SigactRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "rank"}, new Object[]{0L, 0}, SigActPb$SigactRsp.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field rank = PBField.initUInt32(0);
}
