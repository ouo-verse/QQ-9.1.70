package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetFlowConfRequest extends MessageMicro<MobileOrderServer$GetFlowConfRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"appid", "BizType"}, new Object[]{0, 0}, MobileOrderServer$GetFlowConfRequest.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field BizType = PBField.initInt32(0);
}
