package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetFreeCoinsReq extends MessageMicro<giftMidgroundPanel$SsoGetFreeCoinsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"business_id"}, new Object[]{""}, giftMidgroundPanel$SsoGetFreeCoinsReq.class);
    public final PBStringField business_id = PBField.initString("");
}
