package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes11.dex */
public final class ARCloudRecogCustomPb$ARFaceRecogRes extends MessageMicro<ARCloudRecogCustomPb$ARFaceRecogRes> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48}, new String[]{"errorcode", "errormsg", ServiceConst.PARA_SESSION_ID, "star_info", "time_ms", "group_size"}, new Object[]{0, "", "", null, 0, 0}, ARCloudRecogCustomPb$ARFaceRecogRes.class);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
    public final PBRepeatMessageField<ARCloudRecogCustomPb$StarInfo> star_info = PBField.initRepeatMessage(ARCloudRecogCustomPb$StarInfo.class);
    public final PBInt32Field time_ms = PBField.initInt32(0);
    public final PBInt32Field group_size = PBField.initInt32(0);
}
