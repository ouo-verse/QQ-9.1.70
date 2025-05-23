package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipVoiceChange$voiceChangeReq extends MessageMicro<VipVoiceChange$voiceChangeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 82}, new String[]{"int32_sub_cmd", "int32_platform", "str_qq_version", "msg_subcmd0x1_req_auth"}, new Object[]{0, 0, "", null}, VipVoiceChange$voiceChangeReq.class);
    public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
    public final PBInt32Field int32_platform = PBField.initInt32(0);
    public final PBStringField str_qq_version = PBField.initString("");
    public VipVoiceChange$subCmd0x1ReqAuth msg_subcmd0x1_req_auth = new VipVoiceChange$subCmd0x1ReqAuth();
}
