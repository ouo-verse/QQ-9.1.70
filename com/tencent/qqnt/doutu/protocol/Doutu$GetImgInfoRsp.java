package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Doutu$GetImgInfoRsp extends MessageMicro<Doutu$GetImgInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"int32_result", "bytes_fail_msg", "rpt_msg_img_info", "uint32_rsp_type"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0}, Doutu$GetImgInfoRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Doutu$ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(Doutu$ImgInfo.class);
    public final PBUInt32Field uint32_rsp_type = PBField.initUInt32(0);
}
