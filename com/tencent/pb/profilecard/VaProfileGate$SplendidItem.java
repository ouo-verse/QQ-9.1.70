package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$SplendidItem extends MessageMicro<VaProfileGate$SplendidItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"name", "display_url", "jump_url"}, new Object[]{"", "", ""}, VaProfileGate$SplendidItem.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField display_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
