package com.tencent.mobileqq.datarecv.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ZhituReportMsg$ReqBody extends MessageMicro<ZhituReportMsg$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_aio_type;
    public final PBBytesField bytes_current_text;
    public final PBBytesField bytes_mobile_type;
    public final PBBytesField bytes_pass;
    public final PBBytesField bytes_pic_id;
    public final PBBytesField bytes_pre_one_text;
    public final PBBytesField bytes_pre_two_text;
    public final PBBytesField bytes_style;
    public final PBUInt32Field uint32_action;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 66, 74}, new String[]{"bytes_pass", "bytes_pic_id", "bytes_style", "uint32_action", "bytes_aio_type", "bytes_mobile_type", "bytes_current_text", "bytes_pre_one_text", "bytes_pre_two_text"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ZhituReportMsg$ReqBody.class);
    }

    public ZhituReportMsg$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pass = PBField.initBytes(byteStringMicro);
        this.bytes_pic_id = PBField.initBytes(byteStringMicro);
        this.bytes_style = PBField.initBytes(byteStringMicro);
        this.uint32_action = PBField.initUInt32(0);
        this.bytes_aio_type = PBField.initBytes(byteStringMicro);
        this.bytes_mobile_type = PBField.initBytes(byteStringMicro);
        this.bytes_current_text = PBField.initBytes(byteStringMicro);
        this.bytes_pre_one_text = PBField.initBytes(byteStringMicro);
        this.bytes_pre_two_text = PBField.initBytes(byteStringMicro);
    }
}
