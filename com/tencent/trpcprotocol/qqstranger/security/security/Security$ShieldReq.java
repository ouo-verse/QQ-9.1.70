package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$ShieldReq extends MessageMicro<Security$ShieldReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"source", INetChannelCallback.KEY_TINY_ID, "is_shield"}, new Object[]{"", 0L, Boolean.FALSE}, Security$ShieldReq.class);
    public final PBStringField source = PBField.initString("");
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBBoolField is_shield = PBField.initBool(false);
}
