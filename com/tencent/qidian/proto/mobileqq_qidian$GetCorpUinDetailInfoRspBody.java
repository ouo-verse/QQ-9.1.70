package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetCorpUinDetailInfoRspBody extends MessageMicro<mobileqq_qidian$GetCorpUinDetailInfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"int32_ret", "msg_external_info", "rpt_msg_config_group_info"}, new Object[]{0, null, null}, mobileqq_qidian$GetCorpUinDetailInfoRspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public mobileqq_qidian$ExternalInfo msg_external_info = new mobileqq_qidian$ExternalInfo();
    public final PBRepeatMessageField<mobileqq_qidian$ConfigGroupInfo> rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian$ConfigGroupInfo.class);
}
