package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class mobileqq_bmqq$HRTXHead extends MessageMicro<mobileqq_bmqq$HRTXHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_qquin"}, new Object[]{0L}, mobileqq_bmqq$HRTXHead.class);
    public final PBUInt64Field uint64_qquin = PBField.initUInt64(0);
}
