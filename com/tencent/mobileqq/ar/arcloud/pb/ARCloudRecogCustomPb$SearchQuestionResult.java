package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$SearchQuestionResult extends MessageMicro<ARCloudRecogCustomPb$SearchQuestionResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"search_question_errorcode", "search_question_errormsg", "cdb_res", "question_res"}, new Object[]{0, "", ByteStringMicro.EMPTY, null}, ARCloudRecogCustomPb$SearchQuestionResult.class);
    public final PBInt32Field search_question_errorcode = PBField.initInt32(0);
    public final PBStringField search_question_errormsg = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public ARCloudRecogCustomPb$QuestionRes question_res = new ARCloudRecogCustomPb$QuestionRes();
}
