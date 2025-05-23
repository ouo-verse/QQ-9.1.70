package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetQiDianGroupInfoRsp extends MessageMicro<mobileqq_qidian$GetQiDianGroupInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_grouplink;
    public final PBBytesField bytes_qrcodelink;
    public final PBBytesField bytes_wpalink;
    public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg_ret", "bytes_grouplink", "bytes_wpalink", "bytes_qrcodelink"}, new Object[]{null, byteStringMicro, byteStringMicro, byteStringMicro}, mobileqq_qidian$GetQiDianGroupInfoRsp.class);
    }

    public mobileqq_qidian$GetQiDianGroupInfoRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_grouplink = PBField.initBytes(byteStringMicro);
        this.bytes_wpalink = PBField.initBytes(byteStringMicro);
        this.bytes_qrcodelink = PBField.initBytes(byteStringMicro);
    }
}
