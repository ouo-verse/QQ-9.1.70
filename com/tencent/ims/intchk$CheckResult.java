package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$CheckResult extends MessageMicro<intchk$CheckResult> {
    public static final int BYTES_MEMREPORT_RESULT_FIELD_NUMBER = 4;
    public static final int UINT32_CHECK_ITEM_ID_FIELD_NUMBER = 1;
    public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
    public static final int UINT32_MEMCHK_RESULT_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_check_item_id", "uint32_check_type", "uint32_memchk_result", "bytes_memreport_result"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY}, intchk$CheckResult.class);
    public final PBUInt32Field uint32_check_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_memchk_result = PBField.initUInt32(0);
    public final PBBytesField bytes_memreport_result = PBField.initBytes(ByteStringMicro.EMPTY);
}
