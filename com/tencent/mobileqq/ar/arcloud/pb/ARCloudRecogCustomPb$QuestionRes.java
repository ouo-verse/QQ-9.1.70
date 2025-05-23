package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$QuestionRes extends MessageMicro<ARCloudRecogCustomPb$QuestionRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin64_question_id", "str_question_content", "str_jump_url"}, new Object[]{0L, "", ""}, ARCloudRecogCustomPb$QuestionRes.class);
    public final PBUInt64Field uin64_question_id = PBField.initUInt64(0);
    public final PBStringField str_question_content = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
}
