package com.tencent.pb.qqvalue;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqvalue$UserQQValueInfo extends MessageMicro<qqvalue$UserQQValueInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 64, 74}, new String[]{LocalPhotoFaceInfo.SCORE, "level", "trend", "xy_id", "url", "on_off", "material_id", "uin", "ext_info"}, new Object[]{0, 0, 0, 0, "", 0, "", 0L, null}, qqvalue$UserQQValueInfo.class);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBInt32Field trend = PBField.initInt32(0);
    public final PBInt32Field xy_id = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field on_off = PBField.initInt32(0);
    public final PBStringField material_id = PBField.initString("");
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBRepeatMessageField<ExtInfo> ext_info = PBField.initRepeatMessage(ExtInfo.class);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class ExtInfo extends MessageMicro<ExtInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ExtInfo.class);
        public final PBStringField key = PBField.initString("");
        public final PBStringField value = PBField.initString("");
    }
}
