package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class GetZPlanAction$RspBody extends MessageMicro<GetZPlanAction$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"actionInfo", "labelList", "icon_nums", "seq"}, new Object[]{null, null, 0, ""}, GetZPlanAction$RspBody.class);
    public final PBRepeatMessageField<GetZPlanAction$ActionInfo> actionInfo = PBField.initRepeatMessage(GetZPlanAction$ActionInfo.class);
    public final PBRepeatMessageField<GetZPlanAction$LabelList> labelList = PBField.initRepeatMessage(GetZPlanAction$LabelList.class);
    public final PBUInt32Field icon_nums = PBField.initUInt32(0);
    public final PBStringField seq = PBField.initString("");
}
