package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$GetSharePublicAccountListResponse extends MessageMicro<mobileqq_mp$GetSharePublicAccountListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"ret_info", "seqno", "share_info"}, new Object[]{null, 0, null}, mobileqq_mp$GetSharePublicAccountListResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBRepeatMessageField<mobileqq_mp$ShareInfo> share_info = PBField.initRepeatMessage(mobileqq_mp$ShareInfo.class);
}
