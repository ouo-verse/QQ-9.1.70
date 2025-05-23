package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$GetGiftListReq extends MessageMicro<giftList$GetGiftListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"giftListId", "attachInfo"}, new Object[]{"", ""}, giftList$GetGiftListReq.class);
    public final PBStringField giftListId = PBField.initString("");
    public final PBStringField attachInfo = PBField.initString("");
}
