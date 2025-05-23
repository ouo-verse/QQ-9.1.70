package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class VaProfileGate$GetGiftListReq extends MessageMicro<VaProfileGate$GetGiftListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0}, VaProfileGate$GetGiftListReq.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
}
