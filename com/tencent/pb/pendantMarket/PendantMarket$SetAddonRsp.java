package com.tencent.pb.pendantMarket;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class PendantMarket$SetAddonRsp extends MessageMicro<PendantMarket$SetAddonRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int_result", "str_msg", "str_url", "tips_info"}, new Object[]{0, "", "", null}, PendantMarket$SetAddonRsp.class);
    public final PBUInt32Field int_result = PBField.initUInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public PendantMarket$TipsInfo tips_info = new PendantMarket$TipsInfo();
}
