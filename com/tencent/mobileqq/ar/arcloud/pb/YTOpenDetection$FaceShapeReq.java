package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenDetection$FaceShapeReq extends MessageMicro<YTOpenDetection$FaceShapeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 32, 40, 66, 82}, new String[]{"app_id", "image", "mode", "ret_image", "url", ServiceConst.PARA_SESSION_ID}, new Object[]{"", ByteStringMicro.EMPTY, 0, Boolean.FALSE, "", ""}, YTOpenDetection$FaceShapeReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field mode = PBField.initInt32(0);
    public final PBBoolField ret_image = PBField.initBool(false);
    public final PBStringField session_id = PBField.initString("");
}
