package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$BatchPackage extends MessageMicro<giftMidgroundPanel$BatchPackage> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"batch_gifts"}, new Object[]{null}, giftMidgroundPanel$BatchPackage.class);
    public final PBRepeatMessageField<giftMidgroundPanel$BatchGift> batch_gifts = PBField.initRepeatMessage(giftMidgroundPanel$BatchGift.class);
}
