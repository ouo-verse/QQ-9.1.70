package com.tencent.pb.vas.treasurecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MobileOrderServer$GetSubscribeRequest extends MessageMicro<MobileOrderServer$GetSubscribeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"appid", "UserCode"}, new Object[]{0, ""}, MobileOrderServer$GetSubscribeRequest.class);
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBStringField UserCode = PBField.initString("");
}
