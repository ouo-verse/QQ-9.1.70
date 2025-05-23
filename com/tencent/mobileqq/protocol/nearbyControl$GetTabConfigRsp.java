package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$GetTabConfigRsp extends MessageMicro<nearbyControl$GetTabConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"tab_config"}, new Object[]{null}, nearbyControl$GetTabConfigRsp.class);
    public final PBRepeatMessageField<nearbyControl$TabConfig> tab_config = PBField.initRepeatMessage(nearbyControl$TabConfig.class);
}
