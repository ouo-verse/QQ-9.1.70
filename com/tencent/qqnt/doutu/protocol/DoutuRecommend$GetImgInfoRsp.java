package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DoutuRecommend$GetImgInfoRsp extends MessageMicro<DoutuRecommend$GetImgInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg;
    public final PBBytesField bytes_pass_through;
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<DoutuRecommend$ImgInfo> rpt_msg_img_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_pass_through"}, new Object[]{0, byteStringMicro, null, byteStringMicro}, DoutuRecommend$GetImgInfoRsp.class);
    }

    public DoutuRecommend$GetImgInfoRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_fail_msg = PBField.initBytes(byteStringMicro);
        this.rpt_msg_img_info = PBField.initRepeatMessage(DoutuRecommend$ImgInfo.class);
        this.bytes_pass_through = PBField.initBytes(byteStringMicro);
    }
}
