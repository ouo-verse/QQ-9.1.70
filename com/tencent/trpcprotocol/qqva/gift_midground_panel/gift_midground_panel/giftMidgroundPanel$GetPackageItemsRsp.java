package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$GetPackageItemsRsp extends MessageMicro<giftMidgroundPanel$GetPackageItemsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"gift_items", "time_stamp"}, new Object[]{null, 0L}, giftMidgroundPanel$GetPackageItemsRsp.class);
    public final PBRepeatMessageField<giftMidgroundPanel$PackageGiftItem> gift_items = PBField.initRepeatMessage(giftMidgroundPanel$PackageGiftItem.class);
    public final PBInt64Field time_stamp = PBField.initInt64(0);
}
