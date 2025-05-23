package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$ABTestControlMsgResponse extends MessageMicro<mobileqq_mp$ABTestControlMsgResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"ret_info", "subscribe_newaio_switch", "abtest_switch", "extra_info"}, new Object[]{null, 0, 0, ""}, mobileqq_mp$ABTestControlMsgResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBInt32Field subscribe_newaio_switch = PBField.initInt32(0);
    public final PBInt32Field abtest_switch = PBField.initInt32(0);
    public final PBStringField extra_info = PBField.initString("");
}
