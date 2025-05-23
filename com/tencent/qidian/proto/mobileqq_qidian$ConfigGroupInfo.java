package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ConfigGroupInfo extends MessageMicro<mobileqq_qidian$ConfigGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_config_info"}, new Object[]{null}, mobileqq_qidian$ConfigGroupInfo.class);
    public final PBRepeatMessageField<mobileqq_qidian$ConfigInfo> rpt_msg_config_info = PBField.initRepeatMessage(mobileqq_qidian$ConfigInfo.class);
}
