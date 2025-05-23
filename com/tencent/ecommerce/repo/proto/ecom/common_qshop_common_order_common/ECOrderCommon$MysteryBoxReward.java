package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$MysteryBoxReward extends MessageMicro<ECOrderCommon$MysteryBoxReward> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"lottery_timestamp", "lottery_sequence", "rarity_level", "reward_product", "cost_price", "yifan_award_level"}, new Object[]{0L, "", 0, null, 0L, 0}, ECOrderCommon$MysteryBoxReward.class);
    public final PBInt64Field lottery_timestamp = PBField.initInt64(0);
    public final PBStringField lottery_sequence = PBField.initString("");
    public final PBUInt32Field rarity_level = PBField.initUInt32(0);
    public ECOrderCommon$ProductCart reward_product = new ECOrderCommon$ProductCart();
    public final PBInt64Field cost_price = PBField.initInt64(0);
    public final PBInt32Field yifan_award_level = PBField.initInt32(0);
}
