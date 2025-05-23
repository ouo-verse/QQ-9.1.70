package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetPublicInfoResponse extends MessageMicro<mobileqq_mp$GetPublicInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ret_info", "seqno", "info"}, new Object[]{null, 0, null}, mobileqq_mp$GetPublicInfoResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public mobileqq_mp$PublicAccountInfo info = new mobileqq_mp$PublicAccountInfo();
}
