package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$SetSubscribeStatusReq extends MessageMicro<QQGamePubSubscribe$SetSubscribeStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleDaTongConstant.ElementParamValue.OPERATION, "appidList"}, new Object[]{0, 0}, QQGamePubSubscribe$SetSubscribeStatusReq.class);
    public final PBEnumField operation = PBField.initEnum(0);
    public final PBRepeatField<Integer> appidList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
