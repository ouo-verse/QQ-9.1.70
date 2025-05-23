package com.tencent.pb.icebreakhotpic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class IcebreakHotPic$RspBody extends MessageMicro<IcebreakHotPic$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_rsp_other;
    public final PBInt32Field int32_img_num;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<IcebreakHotPic$ImgInfo> rpt_msg_img_info;
    public final PBStringField trace_id;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 56, 66}, new String[]{"int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_rsp_other", "int32_img_num", "trace_id"}, new Object[]{0, byteStringMicro, null, byteStringMicro, 0, ""}, IcebreakHotPic$RspBody.class);
    }

    public IcebreakHotPic$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.rpt_msg_img_info = PBField.initRepeatMessage(IcebreakHotPic$ImgInfo.class);
        this.bytes_rsp_other = PBField.initBytes(byteStringMicro);
        this.int32_img_num = PBField.initInt32(0);
        this.trace_id = PBField.initString("");
    }
}
