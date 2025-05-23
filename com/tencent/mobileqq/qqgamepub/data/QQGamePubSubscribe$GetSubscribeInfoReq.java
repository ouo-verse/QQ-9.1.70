package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetSubscribeInfoReq extends MessageMicro<QQGamePubSubscribe$GetSubscribeInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"appidList"}, new Object[]{0}, QQGamePubSubscribe$GetSubscribeInfoReq.class);
    public final PBRepeatField<Integer> appidList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
