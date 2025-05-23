package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$SsoGetFreeCoinsRsp extends MessageMicro<giftMidgroundPanel$SsoGetFreeCoinsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"ret", "msg", "balance"}, new Object[]{0, "", 0L}, giftMidgroundPanel$SsoGetFreeCoinsRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381626msg = PBField.initString("");
    public final PBUInt64Field balance = PBField.initUInt64(0);
}
