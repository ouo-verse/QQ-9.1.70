package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$UpdateUserFreeGiftReq extends MessageMicro<ShopOuterClass$UpdateUserFreeGiftReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"gift_id", AudienceReportConst.ROOM_ID}, new Object[]{0, 0L}, ShopOuterClass$UpdateUserFreeGiftReq.class);
    public final PBRepeatField<Integer> gift_id = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
}
