package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetGiftItemsReq extends MessageMicro<giftMidgroundPanel$SsoGetGiftItemsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ids"}, new Object[]{0L}, giftMidgroundPanel$SsoGetGiftItemsReq.class);
    public final PBRepeatField<Long> ids = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}
