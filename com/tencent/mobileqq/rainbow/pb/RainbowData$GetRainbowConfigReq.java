package com.tencent.mobileqq.rainbow.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class RainbowData$GetRainbowConfigReq extends MessageMicro<RainbowData$GetRainbowConfigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"project", VipFunCallConstants.KEY_GROUP, "key", "field"}, new Object[]{"", "", "", ""}, RainbowData$GetRainbowConfigReq.class);
    public final PBStringField project = PBField.initString("");
    public final PBStringField group = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField field = PBField.initString("");
}
