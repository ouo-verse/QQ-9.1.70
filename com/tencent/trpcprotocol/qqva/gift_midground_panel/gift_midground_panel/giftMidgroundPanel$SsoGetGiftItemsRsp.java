package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetGiftItemsRsp extends MessageMicro<giftMidgroundPanel$SsoGetGiftItemsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", "items"}, new Object[]{0, "", null}, giftMidgroundPanel$SsoGetGiftItemsRsp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381627msg = PBField.initString("");
    public final PBRepeatMessageField<giftMidgroundPanel$GiftItem> items = PBField.initRepeatMessage(giftMidgroundPanel$GiftItem.class);
}
