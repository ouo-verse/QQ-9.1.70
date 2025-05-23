package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$ModifyInfoCheckReq extends MessageMicro<Security$ModifyInfoCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"modify_info", "sync_from_qq"}, new Object[]{null, Boolean.FALSE}, Security$ModifyInfoCheckReq.class);
    public final PBRepeatMessageField<Security$ModifyInfo> modify_info = PBField.initRepeatMessage(Security$ModifyInfo.class);
    public final PBBoolField sync_from_qq = PBField.initBool(false);
}
