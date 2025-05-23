package com.tencent.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class group_activity_info$GroupActInfo extends MessageMicro<group_activity_info$GroupActInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 64}, new String[]{"act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time"}, new Object[]{0L, "", "", "", "", "", 0, 0}, group_activity_info$GroupActInfo.class);
    public final PBUInt64Field act_id = PBField.initUInt64(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField summary = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField small_pic = PBField.initString("");
    public final PBStringField big_pic = PBField.initString("");
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
}
