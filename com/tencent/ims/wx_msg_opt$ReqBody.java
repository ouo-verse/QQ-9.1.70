package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class wx_msg_opt$ReqBody extends MessageMicro<wx_msg_opt$ReqBody> {
    public static final int UINT32_CMD_FIELD_NUMBER = 2;
    public static final int UINT32_OPT_FIELD_NUMBER = 4;
    public static final int UINT32_SEQ_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "uint32_cmd", "uint32_seq", "uint32_opt"}, new Object[]{0L, 0, 0, 0}, wx_msg_opt$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_opt = PBField.initUInt32(0);
}
