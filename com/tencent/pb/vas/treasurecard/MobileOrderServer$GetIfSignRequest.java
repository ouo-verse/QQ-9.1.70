package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetIfSignRequest extends MessageMicro<MobileOrderServer$GetIfSignRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "signContent"}, new Object[]{0, ""}, MobileOrderServer$GetIfSignRequest.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBStringField signContent = PBField.initString("");
}
