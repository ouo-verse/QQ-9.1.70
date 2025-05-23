package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class frequencyCtrl$SsoCanGreetInNearbyReq extends MessageMicro<frequencyCtrl$SsoCanGreetInNearbyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tinyid"}, new Object[]{0L}, frequencyCtrl$SsoCanGreetInNearbyReq.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
}
