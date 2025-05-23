package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$SecMsgConfigsResponse extends MessageMicro<mobileqq_mp$SecMsgConfigsResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"int32_ret", "int32_show_in_palist"}, new Object[]{0, 0}, mobileqq_mp$SecMsgConfigsResponse.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt32Field int32_show_in_palist = PBField.initInt32(0);
}
