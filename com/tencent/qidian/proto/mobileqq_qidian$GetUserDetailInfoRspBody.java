package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetUserDetailInfoRspBody extends MessageMicro<mobileqq_qidian$GetUserDetailInfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50}, new String[]{"msg_ret", "uint32_req_type", "msg_internal_info", "msg_external_info", "msg_corp_info", "rpt_msg_config_group_info"}, new Object[]{null, 0, null, null, null, null}, mobileqq_qidian$GetUserDetailInfoRspBody.class);
    public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public mobileqq_qidian$InternalInfo msg_internal_info = new mobileqq_qidian$InternalInfo();
    public mobileqq_qidian$ExternalInfo msg_external_info = new mobileqq_qidian$ExternalInfo();
    public mobileqq_qidian$CorpInfo msg_corp_info = new mobileqq_qidian$CorpInfo();
    public final PBRepeatMessageField<mobileqq_qidian$ConfigGroupInfo> rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian$ConfigGroupInfo.class);
}
