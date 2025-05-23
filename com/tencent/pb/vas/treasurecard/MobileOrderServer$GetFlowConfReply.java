package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetFlowConfReply extends MessageMicro<MobileOrderServer$GetFlowConfReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"RetCode", "RetMsg", "JumpUrl", "Tips", "BizType"}, new Object[]{0, "", "", "", 0}, MobileOrderServer$GetFlowConfReply.class);
    public final PBInt32Field RetCode = PBField.initInt32(0);
    public final PBStringField RetMsg = PBField.initString("");
    public final PBStringField JumpUrl = PBField.initString("");
    public final PBStringField Tips = PBField.initString("");
    public final PBInt32Field BizType = PBField.initInt32(0);
}
