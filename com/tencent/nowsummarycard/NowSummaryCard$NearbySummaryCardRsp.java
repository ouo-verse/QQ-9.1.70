package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$NearbySummaryCardRsp extends MessageMicro<NowSummaryCard$NearbySummaryCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err_msg;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f339116id;
    public final PBUInt32Field id_type;
    public final PBBytesField pb_data;
    public final PBUInt32Field ret_code;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"pb_data", "id", "id_type", "ret_code", "err_msg"}, new Object[]{byteStringMicro, 0L, 0, 0, byteStringMicro}, NowSummaryCard$NearbySummaryCardRsp.class);
    }

    public NowSummaryCard$NearbySummaryCardRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.pb_data = PBField.initBytes(byteStringMicro);
        this.f339116id = PBField.initUInt64(0L);
        this.id_type = PBField.initUInt32(0);
        this.ret_code = PBField.initUInt32(0);
        this.err_msg = PBField.initBytes(byteStringMicro);
    }
}
