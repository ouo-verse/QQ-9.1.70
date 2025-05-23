package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$GetPackageRsp extends MessageMicro<giftMidgroundPanel$GetPackageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"gift_items", "time_stamp", "empty_info", "gift_ids"}, new Object[]{null, 0L, null, ""}, giftMidgroundPanel$GetPackageRsp.class);
    public final PBRepeatMessageField<giftMidgroundPanel$PackageGiftItem> gift_items = PBField.initRepeatMessage(giftMidgroundPanel$PackageGiftItem.class);
    public final PBInt64Field time_stamp = PBField.initInt64(0);
    public giftMidgroundPanel$EmptyInfo empty_info = new giftMidgroundPanel$EmptyInfo();
    public final PBRepeatField<String> gift_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
