package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HomeworkTmemList extends MessageMicro<value$HomeworkTmemList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, value$HomeworkTmemList.class);
    public final PBRepeatMessageField<value$HomeworkInfo> infos = PBField.initRepeatMessage(value$HomeworkInfo.class);
}
