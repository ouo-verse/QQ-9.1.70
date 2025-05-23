package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$GetPackageItemsReq extends MessageMicro<giftMidgroundPanel$GetPackageItemsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"business_id", "gift_ids"}, new Object[]{"", 0L}, giftMidgroundPanel$GetPackageItemsReq.class);
    public final PBStringField business_id = PBField.initString("");
    public final PBRepeatField<Long> gift_ids = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}
