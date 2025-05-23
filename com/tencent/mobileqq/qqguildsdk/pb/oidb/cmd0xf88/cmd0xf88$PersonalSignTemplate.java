package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes17.dex */
public final class cmd0xf88$PersonalSignTemplate extends MessageMicro<cmd0xf88$PersonalSignTemplate> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"url", "context"}, new Object[]{"", ""}, cmd0xf88$PersonalSignTemplate.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField context = PBField.initString("");
}
