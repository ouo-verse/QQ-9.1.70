package com.tencent.crmqq.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class StructMsg$SendMenuEventRequest extends MessageMicro<StructMsg$SendMenuEventRequest> {
    public static final int CLICK = 1;
    public static final int EVENT = 3;
    public static final int URL = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField key = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBoolField is_need_lbs = PBField.initBool(false);
    public final PBDoubleField latitude = PBField.initDouble(0.0d);
    public final PBDoubleField longitude = PBField.initDouble(0.0d);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 41, 49}, new String[]{"uin", "key", "type", "is_need_lbs", "latitude", "longitude"}, new Object[]{0L, "", 1, Boolean.FALSE, valueOf, valueOf}, StructMsg$SendMenuEventRequest.class);
    }
}
