package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$TabItem extends MessageMicro<giftMidgroundPanel$TabItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"id", "name", "enable_desc", "desc", "items"}, new Object[]{"", "", Boolean.FALSE, "", null}, giftMidgroundPanel$TabItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381630id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBBoolField enable_desc = PBField.initBool(false);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<giftMidgroundPanel$GiftItem> items = PBField.initRepeatMessage(giftMidgroundPanel$GiftItem.class);
}
