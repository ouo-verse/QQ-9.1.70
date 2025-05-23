package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$PackageGiftItem extends MessageMicro<giftMidgroundPanel$PackageGiftItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"gift_item", "total_num", "expire_info"}, new Object[]{null, 0L, null}, giftMidgroundPanel$PackageGiftItem.class);
    public giftMidgroundPanel$GiftItem gift_item = new giftMidgroundPanel$GiftItem();
    public final PBInt64Field total_num = PBField.initInt64(0);
    public final PBRepeatMessageField<giftMidgroundPanel$RecentExpireInfo> expire_info = PBField.initRepeatMessage(giftMidgroundPanel$RecentExpireInfo.class);
}
