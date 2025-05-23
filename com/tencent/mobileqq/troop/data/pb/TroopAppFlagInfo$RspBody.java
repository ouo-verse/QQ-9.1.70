package com.tencent.mobileqq.troop.data.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class TroopAppFlagInfo$RspBody extends MessageMicro<TroopAppFlagInfo$RspBody> {
    public static final int STR_TAG_FIELD_NUMBER = 8;
    public static final int UINT32_APP_COUNT_FIELD_NUMBER = 4;
    public static final int UINT32_RET_CODE_FIELD_NUMBER = 1;
    public static final int UINT32_TAG_NUM_FIELD_NUMBER = 6;
    public static final int UINT32_TAG_RED_FIELD_NUMBER = 7;
    public static final int UINT64_GCODE_FIELD_NUMBER = 3;
    public static final int UINT64_TIME_FIELD_NUMBER = 5;
    public static final int UINT64_UIN_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"uint32_ret_code", "uint64_uin", "uint64_gcode", "uint32_app_count", "uint64_time", "uint32_tag_num", "uint32_tag_red", "str_tag"}, new Object[]{0, 0L, 0L, 0, 0L, 0, 0, ByteStringMicro.EMPTY}, TroopAppFlagInfo$RspBody.class);
    public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_gcode = PBField.initUInt64(0);
    public final PBUInt32Field uint32_app_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_tag_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tag_red = PBField.initUInt32(0);
    public final PBBytesField str_tag = PBField.initBytes(ByteStringMicro.EMPTY);
}
