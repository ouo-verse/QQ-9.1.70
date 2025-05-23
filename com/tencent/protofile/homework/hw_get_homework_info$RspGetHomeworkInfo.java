package com.tencent.protofile.homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.protofile.group_homework.value$HomeworkInfo;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class hw_get_homework_info$RspGetHomeworkInfo extends MessageMicro<hw_get_homework_info$RspGetHomeworkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"errinfo", "info"}, new Object[]{null, null}, hw_get_homework_info$RspGetHomeworkInfo.class);
    public hw_get_homework_info$ErrorInfo errinfo = new hw_get_homework_info$ErrorInfo();
    public value$HomeworkInfo info = new value$HomeworkInfo();
}
