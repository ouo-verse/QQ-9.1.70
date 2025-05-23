package com.tencent.ecommerce.repo.proto.ecom.cir.api_gateway;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes31.dex */
public final class PROTOCAL$StQWebRsp extends MessageMicro<PROTOCAL$StQWebRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<COMM$Entry> Extinfo;
    public final PBBytesField busiBuff;
    public final PBBytesField errMsg;
    public final PBUInt64Field Seq = PBField.initUInt64(0);
    public final PBInt64Field retCode = PBField.initInt64(0);

    public PROTOCAL$StQWebRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.errMsg = PBField.initBytes(byteStringMicro);
        this.busiBuff = PBField.initBytes(byteStringMicro);
        this.Extinfo = PBField.initRepeatMessage(COMM$Entry.class);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"Seq", "retCode", "errMsg", "busiBuff", "Extinfo"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, null}, PROTOCAL$StQWebRsp.class);
    }
}
