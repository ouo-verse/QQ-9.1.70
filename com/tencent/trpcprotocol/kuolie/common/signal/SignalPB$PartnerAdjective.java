package com.tencent.trpcprotocol.kuolie.common.signal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class SignalPB$PartnerAdjective extends MessageMicro<SignalPB$PartnerAdjective> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"partner_adj_id", "partner_adj_name"}, new Object[]{0L, ""}, SignalPB$PartnerAdjective.class);
    public final PBUInt64Field partner_adj_id = PBField.initUInt64(0);
    public final PBStringField partner_adj_name = PBField.initString("");
}
