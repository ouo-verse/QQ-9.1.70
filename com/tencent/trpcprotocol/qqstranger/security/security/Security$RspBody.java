package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$RspBody extends MessageMicro<Security$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"dw_score_level"}, new Object[]{0}, Security$RspBody.class);
    public final PBUInt32Field dw_score_level = PBField.initUInt32(0);
}
