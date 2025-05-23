package com.tencent.mobileqq.onlinestatus.networkhandler;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class ZplanAvatarProto$SetStatusReq extends MessageMicro<ZplanAvatarProto$SetStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"key"}, new Object[]{""}, ZplanAvatarProto$SetStatusReq.class);
    public final PBStringField key = PBField.initString("");
}
