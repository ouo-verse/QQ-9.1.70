package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class frequencyCtrl$SsoCanGreetInNearbyRsp extends MessageMicro<frequencyCtrl$SsoCanGreetInNearbyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"ret_code", "ret_msg", "can_greet", "alert_text"}, new Object[]{0, "", Boolean.FALSE, ""}, frequencyCtrl$SsoCanGreetInNearbyRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField can_greet = PBField.initBool(false);
    public final PBStringField alert_text = PBField.initString("");
}
