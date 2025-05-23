package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class SendHbDetail$GetPronRsp extends MessageMicro<SendHbDetail$GetPronRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"retcode", "message", "show_pron", "real_pron"}, new Object[]{0, "", "", ""}, SendHbDetail$GetPronRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBStringField show_pron = PBField.initString("");
    public final PBStringField real_pron = PBField.initString("");
}
