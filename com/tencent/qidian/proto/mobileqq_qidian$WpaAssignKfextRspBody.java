package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$WpaAssignKfextRspBody extends MessageMicro<mobileqq_qidian$WpaAssignKfextRspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sigT_ext;
    public final PBBytesField bytes_sigmsg;
    public final PBStringField str_err_msg;
    public final PBUInt32Field uint32_aio_type;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50}, new String[]{"int32_result", "uint64_ext_uin", "bytes_sigT_ext", "str_err_msg", "uint32_aio_type", "bytes_sigmsg"}, new Object[]{0, 0L, byteStringMicro, "", 0, byteStringMicro}, mobileqq_qidian$WpaAssignKfextRspBody.class);
    }

    public mobileqq_qidian$WpaAssignKfextRspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_sigT_ext = PBField.initBytes(byteStringMicro);
        this.str_err_msg = PBField.initString("");
        this.uint32_aio_type = PBField.initUInt32(0);
        this.bytes_sigmsg = PBField.initBytes(byteStringMicro);
    }
}
