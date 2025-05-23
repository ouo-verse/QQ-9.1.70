package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARFaceRecogResult extends MessageMicro<ARCloudRecogCustomPb$ARFaceRecogResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"ar_face_recog_errorcode", "ar_face_recog_errormsg", "cdb_res", "image_ar_face_recog_res"}, new Object[]{0, "", ByteStringMicro.EMPTY, null}, ARCloudRecogCustomPb$ARFaceRecogResult.class);
    public final PBInt32Field ar_face_recog_errorcode = PBField.initInt32(0);
    public final PBStringField ar_face_recog_errormsg = PBField.initString("");
    public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public ARCloudRecogCustomPb$ARFaceRecogRes image_ar_face_recog_res = new ARCloudRecogCustomPb$ARFaceRecogRes();
}
