package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class VaProfileGate$CardItem extends MessageMicro<VaProfileGate$CardItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "card_id"}, new Object[]{"", ""}, VaProfileGate$CardItem.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField card_id = PBField.initString("");
}
