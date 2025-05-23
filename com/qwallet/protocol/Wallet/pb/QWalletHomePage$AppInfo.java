package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.state.mmkv.SKey;

/* loaded from: classes3.dex */
public final class QWalletHomePage$AppInfo extends MessageMicro<QWalletHomePage$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 88, 96, 104, 114, 122, 130}, new String[]{"id", "type", "name", "url", "pv", "icon", "small_icon", "market", SKey.DetailMe.KEY_TITLE_RED_POINT_SP, "company_name", "bit_flag", "app_id", "has_statement", "background", "night_background", "desc"}, new Object[]{0, 0, "", "", "", "", "", null, null, "", 0L, 0L, Boolean.FALSE, "", "", ""}, QWalletHomePage$AppInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41686id = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField url = PBField.initString("");

    /* renamed from: pv, reason: collision with root package name */
    public final PBStringField f41687pv = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField small_icon = PBField.initString("");
    public QWalletHomePage$Market market = new QWalletHomePage$Market();
    public QWalletHomePage$RedPoint red_point = new QWalletHomePage$RedPoint();
    public final PBStringField company_name = PBField.initString("");
    public final PBInt64Field bit_flag = PBField.initInt64(0);
    public final PBInt64Field app_id = PBField.initInt64(0);
    public final PBBoolField has_statement = PBField.initBool(false);
    public final PBStringField background = PBField.initString("");
    public final PBStringField night_background = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
