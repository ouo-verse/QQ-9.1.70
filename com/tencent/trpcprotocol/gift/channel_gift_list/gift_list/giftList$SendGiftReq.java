package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$SendGiftReq extends MessageMicro<giftList$SendGiftReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"senderTinyid", "recverTinyid", "giftId", "sendType", "channelId", "groupId", "authKey"}, new Object[]{0L, 0L, 0, 0, 0L, 0L, ""}, giftList$SendGiftReq.class);
    public final PBUInt64Field senderTinyid = PBField.initUInt64(0);
    public final PBUInt64Field recverTinyid = PBField.initUInt64(0);
    public final PBUInt32Field giftId = PBField.initUInt32(0);
    public final PBEnumField sendType = PBField.initEnum(0);
    public final PBUInt64Field channelId = PBField.initUInt64(0);
    public final PBUInt64Field groupId = PBField.initUInt64(0);
    public final PBStringField authKey = PBField.initString("");
}
