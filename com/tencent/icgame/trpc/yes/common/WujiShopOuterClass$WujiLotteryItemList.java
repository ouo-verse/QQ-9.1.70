package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class WujiShopOuterClass$WujiLotteryItemList extends MessageMicro<WujiShopOuterClass$WujiLotteryItemList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, WujiShopOuterClass$WujiLotteryItemList.class);
    public final PBRepeatMessageField<WujiShopOuterClass$WujiLotteryItem> data = PBField.initRepeatMessage(WujiShopOuterClass$WujiLotteryItem.class);
}
