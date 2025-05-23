package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetUserEqqListResponse extends MessageMicro<mobileqq_mp$GetUserEqqListResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"ret_info", "accountInfo", "seqno", "is_over", "next_pos"}, new Object[]{null, null, 0, Boolean.FALSE, 0}, mobileqq_mp$GetUserEqqListResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBRepeatMessageField<mobileqq_mp$EqqAccountInfo> accountInfo = PBField.initRepeatMessage(mobileqq_mp$EqqAccountInfo.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBBoolField is_over = PBField.initBool(false);
    public final PBUInt32Field next_pos = PBField.initUInt32(0);
}
