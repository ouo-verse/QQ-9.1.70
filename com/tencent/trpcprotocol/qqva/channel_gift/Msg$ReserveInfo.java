package com.tencent.trpcprotocol.qqva.channel_gift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Msg$ReserveInfo extends MessageMicro<Msg$ReserveInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"spend_coins", "need_play_animation", "send_type", "charm_value"}, new Object[]{null, Boolean.FALSE, 0, 0}, Msg$ReserveInfo.class);
    public final PBRepeatMessageField<Msg$SpendCoinItem> spend_coins = PBField.initRepeatMessage(Msg$SpendCoinItem.class);
    public final PBBoolField need_play_animation = PBField.initBool(false);
    public final PBInt32Field send_type = PBField.initInt32(0);
    public final PBInt32Field charm_value = PBField.initInt32(0);
}
