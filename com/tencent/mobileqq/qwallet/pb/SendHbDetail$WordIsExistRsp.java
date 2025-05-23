package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$WordIsExistRsp extends MessageMicro<SendHbDetail$WordIsExistRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"status", "paperwork", "retcode", "message"}, new Object[]{0, "", 0, ""}, SendHbDetail$WordIsExistRsp.class);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField paperwork = PBField.initString("");
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
}
