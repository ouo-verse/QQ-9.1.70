package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PublicOfficeConfig$MenuItem extends MessageMicro<PublicOfficeConfig$MenuItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"id", "name", "icon", "url", "pv", "sub_menu"}, new Object[]{0, "", "", "", "", null}, PublicOfficeConfig$MenuItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f278698id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBStringField f278699pv = PBField.initString("");
    public final PBRepeatMessageField<PublicOfficeConfig$MenuItem> sub_menu = PBField.initRepeatMessage(PublicOfficeConfig$MenuItem.class);
}
