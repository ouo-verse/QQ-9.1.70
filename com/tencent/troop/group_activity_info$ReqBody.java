package com.tencent.troop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class group_activity_info$ReqBody extends MessageMicro<group_activity_info$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBBoolField act_id = PBField.initBool(false);
    public final PBBoolField title = PBField.initBool(false);
    public final PBBoolField summary = PBField.initBool(false);
    public final PBBoolField url = PBField.initBool(false);
    public final PBBoolField small_pic = PBField.initBool(false);
    public final PBBoolField big_pic = PBField.initBool(false);
    public final PBBoolField start_time = PBField.initBool(false);
    public final PBBoolField end_time = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80}, new String[]{"type", "group_code", "act_id", "title", "summary", "url", "small_pic", "big_pic", "start_time", "end_time"}, new Object[]{1, 0L, bool, bool, bool, bool, bool, bool, bool, bool}, group_activity_info$ReqBody.class);
    }
}
