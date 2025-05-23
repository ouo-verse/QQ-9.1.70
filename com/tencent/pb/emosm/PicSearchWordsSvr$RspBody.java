package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class PicSearchWordsSvr$RspBody extends MessageMicro<PicSearchWordsSvr$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_rsp_other;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public PicSearchWordsSvr$WordsMsg words_msg;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_result", "bytes_fail_msg", "words_msg", "bytes_rsp_other"}, new Object[]{0, byteStringMicro, null, byteStringMicro}, PicSearchWordsSvr$RspBody.class);
    }

    public PicSearchWordsSvr$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.words_msg = new PicSearchWordsSvr$WordsMsg();
        this.bytes_rsp_other = PBField.initBytes(byteStringMicro);
    }
}
