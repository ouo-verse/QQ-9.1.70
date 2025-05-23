package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes20.dex */
public final class WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp extends MessageMicro<WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp> {
    public static final int DST_PATH_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"dst_path"}, new Object[]{ByteStringMicro.EMPTY}, WeiyunPB$CrossBidProxyCopyFileToOtherBidMsgRsp.class);
    public final PBBytesField dst_path = PBField.initBytes(ByteStringMicro.EMPTY);
}
