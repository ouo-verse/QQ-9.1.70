package com.qzone.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class SocialTree$WateringRsp extends MessageMicro<SocialTree$WateringRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_complete"}, new Object[]{Boolean.FALSE}, SocialTree$WateringRsp.class);
    public final PBBoolField is_complete = PBField.initBool(false);
}
