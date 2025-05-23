package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$UpdateUserFreeGiftRsp extends MessageMicro<ShopOuterClass$UpdateUserFreeGiftRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enter_room_time", "send_gift_time"}, new Object[]{0, null}, ShopOuterClass$UpdateUserFreeGiftRsp.class);
    public final PBUInt32Field enter_room_time = PBField.initUInt32(0);
    public ShopOuterClass$SendGiftTimeInfo send_gift_time = new MessageMicro<ShopOuterClass$SendGiftTimeInfo>() { // from class: com.tencent.icgame.trpc.yes.common.ShopOuterClass$SendGiftTimeInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"gift_id", "last_send_gift_time"}, new Object[]{0, 0}, ShopOuterClass$SendGiftTimeInfo.class);
        public final PBInt32Field gift_id = PBField.initInt32(0);
        public final PBUInt32Field last_send_gift_time = PBField.initUInt32(0);
    };
}
