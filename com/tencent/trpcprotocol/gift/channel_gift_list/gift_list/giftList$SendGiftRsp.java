package com.tencent.trpcprotocol.gift.channel_gift_list.gift_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class giftList$SendGiftRsp extends MessageMicro<giftList$SendGiftRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret", "retmsg"}, new Object[]{0, ""}, giftList$SendGiftRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
}
