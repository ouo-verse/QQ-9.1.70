package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ClickEManRspBody extends MessageMicro<mobileqq_qidian$ClickEManRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_ret", "str_msg"}, new Object[]{null, ""}, mobileqq_qidian$ClickEManRspBody.class);
    public mobileqq_qidian$RetInfo msg_ret = new mobileqq_qidian$RetInfo();
    public final PBStringField str_msg = PBField.initString("");
}
