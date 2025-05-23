package com.tencent.qqnt.ntrelation.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ProfileUpdateMsg$Buddy extends MessageMicro<ProfileUpdateMsg$Buddy> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8002}, new String[]{"uid"}, new Object[]{""}, ProfileUpdateMsg$Buddy.class);
    public final PBStringField uid = PBField.initString("");
}
