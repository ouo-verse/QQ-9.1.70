package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenDetection$LightDetectReq extends MessageMicro<YTOpenDetection$LightDetectReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"app_id", "image", "url", ServiceConst.PARA_SESSION_ID}, new Object[]{"", ByteStringMicro.EMPTY, "", ""}, YTOpenDetection$LightDetectReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField url = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
}
