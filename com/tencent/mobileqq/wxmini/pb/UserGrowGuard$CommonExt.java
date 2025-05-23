package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class UserGrowGuard$CommonExt extends MessageMicro<UserGrowGuard$CommonExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"map_info", "attach_info"}, new Object[]{null, ""}, UserGrowGuard$CommonExt.class);
    public final PBRepeatMessageField<UserGrowGuard$Entry> map_info = PBField.initRepeatMessage(UserGrowGuard$Entry.class);
    public final PBStringField attach_info = PBField.initString("");
}
