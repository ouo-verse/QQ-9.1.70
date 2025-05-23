package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$GetVerifyFaceKeyReq extends MessageMicro<BindBank$GetVerifyFaceKeyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"channel_id", "busi_info"}, new Object[]{"", ""}, BindBank$GetVerifyFaceKeyReq.class);
    public final PBStringField channel_id = PBField.initString("");
    public final PBStringField busi_info = PBField.initString("");
}
