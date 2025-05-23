package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes24.dex */
public final class PicSearchSvr$RspBody extends MessageMicro<PicSearchSvr$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext_info;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_rsp_other;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<PicSearchSvr$ImgInfo> rpt_msg_img_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_rsp_other", "bytes_ext_info"}, new Object[]{0, byteStringMicro, null, byteStringMicro, byteStringMicro}, PicSearchSvr$RspBody.class);
    }

    public PicSearchSvr$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.rpt_msg_img_info = PBField.initRepeatMessage(PicSearchSvr$ImgInfo.class);
        this.bytes_rsp_other = PBField.initBytes(byteStringMicro);
        this.bytes_ext_info = PBField.initBytes(byteStringMicro);
    }
}
