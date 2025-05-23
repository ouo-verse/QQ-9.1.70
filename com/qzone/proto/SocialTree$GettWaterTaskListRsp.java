package com.qzone.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class SocialTree$GettWaterTaskListRsp extends MessageMicro<SocialTree$GettWaterTaskListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18}, new String[]{"task_list"}, new Object[]{null}, SocialTree$GettWaterTaskListRsp.class);
    public final PBRepeatMessageField<SocialTreeCommon$WaterTask> task_list = PBField.initRepeatMessage(SocialTreeCommon$WaterTask.class);
}
