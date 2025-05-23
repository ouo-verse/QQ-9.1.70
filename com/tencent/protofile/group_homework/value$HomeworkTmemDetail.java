package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$HomeworkTmemDetail extends MessageMicro<value$HomeworkTmemDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"info", "status", "created", "feed_topic_id"}, new Object[]{null, 0, 0L, ByteStringMicro.EMPTY}, value$HomeworkTmemDetail.class);
    public value$HomeworkInfo info = new value$HomeworkInfo();
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBInt64Field created = PBField.initInt64(0);
    public final PBBytesField feed_topic_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
