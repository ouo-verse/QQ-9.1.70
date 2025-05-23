package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$Voice extends MessageMicro<value$Voice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"url", "time", "size", "url_mp3"}, new Object[]{"", 0, 0, ""}, value$Voice.class);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBStringField url_mp3 = PBField.initString("");
}
