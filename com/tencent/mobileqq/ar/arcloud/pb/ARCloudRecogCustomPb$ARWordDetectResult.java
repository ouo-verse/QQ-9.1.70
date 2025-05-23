package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARWordDetectResult extends MessageMicro<ARCloudRecogCustomPb$ARWordDetectResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 48, 61, 66}, new String[]{"errorcode", "errormsg", "ar_word_detect_errorcode", "ar_word_detect_errormsg", ServiceConst.PARA_SESSION_ID, "word_type", "confidence", "ocr_class"}, new Object[]{0, "", 0, "", "", 0, Float.valueOf(0.0f), null}, ARCloudRecogCustomPb$ARWordDetectResult.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBInt32Field ar_word_detect_errorcode = PBField.initInt32(0);
    public final PBStringField ar_word_detect_errormsg = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
    public final PBInt32Field word_type = PBField.initInt32(0);
    public final PBFloatField confidence = PBField.initFloat(0.0f);
    public final PBRepeatMessageField<ARCloudRecogCustomPb$OcrClassify> ocr_class = PBField.initRepeatMessage(ARCloudRecogCustomPb$OcrClassify.class);
}
