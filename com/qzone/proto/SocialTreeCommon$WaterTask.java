package com.qzone.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class SocialTreeCommon$WaterTask extends MessageMicro<SocialTreeCommon$WaterTask> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 56, 66}, new String[]{"id", "type", "name", "weight", "incr_weight", "icon_url", "is_complete", "remaining_time_text"}, new Object[]{0, 0, "", 0L, 0L, "", Boolean.FALSE, ""}, SocialTreeCommon$WaterTask.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f50094id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field weight = PBField.initUInt64(0);
    public final PBUInt64Field incr_weight = PBField.initUInt64(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBBoolField is_complete = PBField.initBool(false);
    public final PBStringField remaining_time_text = PBField.initString("");
}
