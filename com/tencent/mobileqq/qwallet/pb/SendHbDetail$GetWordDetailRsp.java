package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class SendHbDetail$GetWordDetailRsp extends MessageMicro<SendHbDetail$GetWordDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50, 58, 66}, new String[]{"retcode", "message", "pronunciation", "radical", "stroke_count", "traditional_character", "comment", "tone_pronunciation"}, new Object[]{0, "", "", "", 0, "", "", ""}, SendHbDetail$GetWordDetailRsp.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField message = PBField.initString("");
    public final PBStringField pronunciation = PBField.initString("");
    public final PBStringField radical = PBField.initString("");
    public final PBInt32Field stroke_count = PBField.initInt32(0);
    public final PBStringField traditional_character = PBField.initString("");
    public final PBStringField comment = PBField.initString("");
    public final PBStringField tone_pronunciation = PBField.initString("");
}
