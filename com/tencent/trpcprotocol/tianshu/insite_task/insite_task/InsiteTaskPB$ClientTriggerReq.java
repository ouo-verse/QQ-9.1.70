package com.tencent.trpcprotocol.tianshu.insite_task.insite_task;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class InsiteTaskPB$ClientTriggerReq extends MessageMicro<InsiteTaskPB$ClientTriggerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"biz_type", "biz_sub_type"}, new Object[]{0, 0}, InsiteTaskPB$ClientTriggerReq.class);
    public final PBEnumField biz_type = PBField.initEnum(0);
    public final PBEnumField biz_sub_type = PBField.initEnum(0);
}
