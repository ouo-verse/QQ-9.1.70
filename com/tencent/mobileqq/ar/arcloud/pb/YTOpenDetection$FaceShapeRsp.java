package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenDetection$FaceShapeRsp extends MessageMicro<YTOpenDetection$FaceShapeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58}, new String[]{ServiceConst.PARA_SESSION_ID, "face_shape", "image_height", "image_width", "image", "errorcode", "errormsg"}, new Object[]{"", null, 0, 0, ByteStringMicro.EMPTY, 0, ""}, YTOpenDetection$FaceShapeRsp.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<YTOpenBase$FaceShapeItem> face_shape = PBField.initRepeatMessage(YTOpenBase$FaceShapeItem.class);
    public final PBInt32Field image_height = PBField.initInt32(0);
    public final PBInt32Field image_width = PBField.initInt32(0);
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
}
