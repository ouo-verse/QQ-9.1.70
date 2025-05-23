package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class mobileqq_mp$GetMessageConfigurationResponse extends MessageMicro<mobileqq_mp$GetMessageConfigurationResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ret_info", "type"}, new Object[]{null, 0}, mobileqq_mp$GetMessageConfigurationResponse.class);
    public mobileqq_mp$RetInfo ret_info = new mobileqq_mp$RetInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
}
