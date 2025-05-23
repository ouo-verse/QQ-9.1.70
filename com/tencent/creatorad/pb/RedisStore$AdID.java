package com.tencent.creatorad.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class RedisStore$AdID extends MessageMicro<RedisStore$AdID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"ad_id", "job_id", "task_end_time"}, new Object[]{0L, 0L, 0L}, RedisStore$AdID.class);
    public final PBUInt64Field ad_id = PBField.initUInt64(0);
    public final PBInt64Field job_id = PBField.initInt64(0);
    public final PBInt64Field task_end_time = PBField.initInt64(0);
}
