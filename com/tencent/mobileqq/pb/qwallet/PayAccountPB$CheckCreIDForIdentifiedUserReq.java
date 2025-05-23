package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayAccountPB$CheckCreIDForIdentifiedUserReq extends MessageMicro<PayAccountPB$CheckCreIDForIdentifiedUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"token_id", "cre_id"}, new Object[]{"", ""}, PayAccountPB$CheckCreIDForIdentifiedUserReq.class);
    public final PBStringField token_id = PBField.initString("");
    public final PBStringField cre_id = PBField.initString("");
}
