package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.state.mmkv.SKey;

/* loaded from: classes3.dex */
public final class QWalletHomePage$Entry extends MessageMicro<QWalletHomePage$Entry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58}, new String[]{"id", "name", "sub_name", "icon", "pv", "url", SKey.DetailMe.KEY_TITLE_RED_POINT_SP}, new Object[]{0, "", "", "", "", "", null}, QWalletHomePage$Entry.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41690id = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField sub_name = PBField.initString("");
    public final PBStringField icon = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBStringField f41691pv = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public QWalletHomePage$RedPoint red_point = new QWalletHomePage$RedPoint();
}
