package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$ModifyInfo extends MessageMicro<Security$ModifyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"security_scene", "desc", "picture_urls"}, new Object[]{0, "", ""}, Security$ModifyInfo.class);
    public final PBEnumField security_scene = PBField.initEnum(0);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatField<String> picture_urls = PBField.initRepeat(PBStringField.__repeatHelper__);
}
