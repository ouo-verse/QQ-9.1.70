package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipVoiceChange$subCmd0x1RspAuth extends MessageMicro<VipVoiceChange$subCmd0x1RspAuth> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret", "str_error_msg", "str_active_url"}, new Object[]{0, "", ""}, VipVoiceChange$subCmd0x1RspAuth.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBStringField str_active_url = PBField.initString("");
}
