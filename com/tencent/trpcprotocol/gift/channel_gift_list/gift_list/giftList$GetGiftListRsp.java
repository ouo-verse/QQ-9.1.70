package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$GetGiftListRsp extends MessageMicro<giftList$GetGiftListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"ret", "attachInfo", "hasMore", "giftList", "duration", "total"}, new Object[]{0L, "", Boolean.FALSE, null, 0, 0L}, giftList$GetGiftListRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField attachInfo = PBField.initString("");
    public final PBBoolField hasMore = PBField.initBool(false);
    public final PBRepeatMessageField<giftList$GroupGiftItem> giftList = PBField.initRepeatMessage(giftList$GroupGiftItem.class);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt64Field total = PBField.initUInt64(0);
}
