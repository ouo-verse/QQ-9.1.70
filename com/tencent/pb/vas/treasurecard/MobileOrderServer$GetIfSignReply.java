package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetIfSignReply extends MessageMicro<MobileOrderServer$GetIfSignReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"RetCode", "RetMsg", "sign"}, new Object[]{0, "", ""}, MobileOrderServer$GetIfSignReply.class);
    public final PBInt32Field RetCode = PBField.initInt32(0);
    public final PBStringField RetMsg = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
}
