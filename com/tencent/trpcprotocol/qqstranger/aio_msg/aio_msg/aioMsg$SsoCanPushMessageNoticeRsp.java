package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class aioMsg$SsoCanPushMessageNoticeRsp extends MessageMicro<aioMsg$SsoCanPushMessageNoticeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret_code", "ret_msg", "is_pass"}, new Object[]{0, "", Boolean.FALSE}, aioMsg$SsoCanPushMessageNoticeRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBBoolField is_pass = PBField.initBool(false);
}
