package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class CommonUserProto$LoginCheckReq extends MessageMicro<CommonUserProto$LoginCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField refresh = PBField.initBool(false);
    public final PBBoolField is_test = PBField.initBool(false);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field room_code = PBField.initUInt64(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"refresh", "is_test", "group_code", "room_code"}, new Object[]{bool, bool, 0L, 0L}, CommonUserProto$LoginCheckReq.class);
    }
}
