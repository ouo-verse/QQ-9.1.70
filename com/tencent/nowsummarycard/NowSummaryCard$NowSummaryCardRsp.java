package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$NowSummaryCardRsp extends MessageMicro<NowSummaryCard$NowSummaryCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{"jce_data", "id", "id_type", "ret_code", "err_msg"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0, ""}, NowSummaryCard$NowSummaryCardRsp.class);
    public final PBBytesField jce_data = PBField.initBytes(ByteStringMicro.EMPTY);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f339121id = PBField.initUInt64(0);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
