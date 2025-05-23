package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aioMsg$SsoCanGreetRsp extends MessageMicro<aioMsg$SsoCanGreetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"ret_code", "ret_msg", "is_pass", "remind_text", "hit_type"}, new Object[]{0, "", Boolean.FALSE, "", 0}, aioMsg$SsoCanGreetRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_pass = PBField.initBool(false);
    public final PBStringField remind_text = PBField.initString("");
    public final PBEnumField hit_type = PBField.initEnum(0);
}
