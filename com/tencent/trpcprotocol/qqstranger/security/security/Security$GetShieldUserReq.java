package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$GetShieldUserReq extends MessageMicro<Security$GetShieldUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"source", INetChannelCallback.KEY_TINY_ID}, new Object[]{"", 0L}, Security$GetShieldUserReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
}
