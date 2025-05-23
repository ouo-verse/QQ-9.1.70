package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes17.dex */
public final class QQShopPAMenuPB$MenuItem extends MessageMicro<QQShopPAMenuPB$MenuItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"id", "name", "icon", "url", "pv", "sub_menu"}, new Object[]{0, "", "", "", "", null}, QQShopPAMenuPB$MenuItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f274501id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField url = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBStringField f274502pv = PBField.initString("");
    public final PBRepeatMessageField<QQShopPAMenuPB$MenuItem> sub_menu = PBField.initRepeatMessage(QQShopPAMenuPB$MenuItem.class);
}
