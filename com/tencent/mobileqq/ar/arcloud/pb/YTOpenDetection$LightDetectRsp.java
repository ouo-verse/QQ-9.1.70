package com.tencent.mobileqq.ar.arcloud.pb;

import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenDetection$LightDetectRsp extends MessageMicro<YTOpenDetection$LightDetectRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 66}, new String[]{ServiceConst.PARA_SESSION_ID, LocalPhotoFaceInfo.SCORE, "lr_gram_dif", "lr_dif", "face_whole", "face_dif", "errorcode", "errormsg"}, new Object[]{"", 0, 0, 0, 0, 0, 0, ""}, YTOpenDetection$LightDetectRsp.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBInt32Field lr_gram_dif = PBField.initInt32(0);
    public final PBInt32Field lr_dif = PBField.initInt32(0);
    public final PBInt32Field face_whole = PBField.initInt32(0);
    public final PBInt32Field face_dif = PBField.initInt32(0);
    public final PBInt32Field errorcode = PBField.initInt32(0);
    public final PBStringField errormsg = PBField.initString("");
}
