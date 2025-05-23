package com.tencent.pb.voiceChange;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipVoiceChange$voiceChangeRsp extends MessageMicro<VipVoiceChange$voiceChangeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 42}, new String[]{"int32_sub_cmd", "msg_subcmd0x1_rsp_auth"}, new Object[]{0, null}, VipVoiceChange$voiceChangeRsp.class);
    public final PBInt32Field int32_sub_cmd = PBField.initInt32(0);
    public VipVoiceChange$subCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new VipVoiceChange$subCmd0x1RspAuth();
}
