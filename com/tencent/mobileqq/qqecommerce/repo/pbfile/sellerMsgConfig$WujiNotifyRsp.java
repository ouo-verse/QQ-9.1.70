package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$WujiNotifyRsp extends MessageMicro<sellerMsgConfig$WujiNotifyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "message"}, new Object[]{0, ""}, sellerMsgConfig$WujiNotifyRsp.class);
    public final PBUInt32Field code = PBField.initUInt32(0);
    public final PBStringField message = PBField.initString("");
}
