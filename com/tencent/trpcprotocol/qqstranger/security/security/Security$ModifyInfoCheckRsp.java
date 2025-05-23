package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$ModifyInfoCheckRsp extends MessageMicro<Security$ModifyInfoCheckRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "beat_infos"}, new Object[]{0, null}, Security$ModifyInfoCheckRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBRepeatMessageField<Security$BeatInfo> beat_infos = PBField.initRepeatMessage(Security$BeatInfo.class);
}
