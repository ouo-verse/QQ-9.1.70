package com.tencent.trpcprotocol.zplan;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class GetZPlanAction$LabelList extends MessageMicro<GetZPlanAction$LabelList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"id", "name", "action_list"}, new Object[]{0, "", 0}, GetZPlanAction$LabelList.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f381672id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBRepeatField<Integer> action_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
