package com.qwallet.protocol.Wallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class QWalletHomePage$RedDot extends MessageMicro<QWalletHomePage$RedDot> {
    public static final int NORMAL = 1;
    public static final int PICTURE = 3;
    public static final int TEXT = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{"id", "app_id", "type", "content", "date_range"}, new Object[]{0, 0, 1, "", null}, QWalletHomePage$RedDot.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt32Field f41695id = PBField.initInt32(0);
    public final PBInt32Field app_id = PBField.initInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField content = PBField.initString("");
    public QWalletHomePage$DateRange date_range = new QWalletHomePage$DateRange();
}
