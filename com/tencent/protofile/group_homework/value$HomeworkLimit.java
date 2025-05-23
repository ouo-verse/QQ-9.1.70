package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HomeworkLimit extends MessageMicro<value$HomeworkLimit> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"count", "ts"}, new Object[]{0, 0}, value$HomeworkLimit.class);
    public final PBUInt32Field count = PBField.initUInt32(0);

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt32Field f342199ts = PBField.initUInt32(0);
}
