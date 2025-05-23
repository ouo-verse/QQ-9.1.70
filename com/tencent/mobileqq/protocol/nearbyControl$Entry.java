package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class nearbyControl$Entry extends MessageMicro<nearbyControl$Entry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"title", "sub_title", "back_ground", "gif", "jump_url", "qq_data", "name"}, new Object[]{"", "", "", "", "", "", ""}, nearbyControl$Entry.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField back_ground = PBField.initString("");
    public final PBStringField gif = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField qq_data = PBField.initString("");
    public final PBStringField name = PBField.initString("");
}
