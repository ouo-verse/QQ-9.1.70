package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$BatchGift extends MessageMicro<giftMidgroundPanel$BatchGift> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"id", "cnt", "msg", "is_effect"}, new Object[]{0L, 0L, "", Boolean.FALSE}, giftMidgroundPanel$BatchGift.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f381622id = PBField.initInt64(0);
    public final PBUInt64Field cnt = PBField.initUInt64(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381623msg = PBField.initString("");
    public final PBBoolField is_effect = PBField.initBool(false);
}
