package com.tencent.trpcprotocol.qqva.channel_gift;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Msg$SpendCoinItem extends MessageMicro<Msg$SpendCoinItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"coin_type", "amt"}, new Object[]{0, 0}, Msg$SpendCoinItem.class);
    public final PBEnumField coin_type = PBField.initEnum(0);
    public final PBInt32Field amt = PBField.initInt32(0);
}
