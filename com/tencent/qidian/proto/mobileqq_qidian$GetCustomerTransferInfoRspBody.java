package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$GetCustomerTransferInfoRspBody extends MessageMicro<mobileqq_qidian$GetCustomerTransferInfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"msg_ret", "str_transfer_info", "str_link_info", "str_link_url", "str_pt_url"}, new Object[]{null, "", "", "", ""}, mobileqq_qidian$GetCustomerTransferInfoRspBody.class);
    public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
    public final PBStringField str_transfer_info = PBField.initString("");
    public final PBStringField str_link_info = PBField.initString("");
    public final PBStringField str_link_url = PBField.initString("");
    public final PBStringField str_pt_url = PBField.initString("");
}
