package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class richtext$Picture extends MessageMicro<richtext$Picture> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", "size"}, new Object[]{"", 0}, richtext$Picture.class);
    public final PBStringField url = PBField.initString("");
    public final PBRepeatField<Integer> size = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
