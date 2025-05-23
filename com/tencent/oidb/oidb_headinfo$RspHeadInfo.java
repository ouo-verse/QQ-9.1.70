package com.tencent.oidb;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class oidb_headinfo$RspHeadInfo extends MessageMicro<oidb_headinfo$RspHeadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 88, 96}, new String[]{"result", "faceType", "timestamp", FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, "url", "sysid", "dstUid", "headVerify", "dstEncryptType", FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG, "dynamicZplanFaceFlag"}, new Object[]{0, 0, 0, 0, "", 0, "", "", 0, 0, 0, 0}, oidb_headinfo$RspHeadInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field faceType = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field faceFlag = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field sysid = PBField.initUInt32(0);
    public final PBStringField dstUid = PBField.initString("");
    public final PBStringField headVerify = PBField.initString("");
    public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
    public final PBUInt32Field apngFaceFlag = PBField.initUInt32(0);
    public final PBUInt32Field staticZplanFaceFlag = PBField.initUInt32(0);
    public final PBUInt32Field dynamicZplanFaceFlag = PBField.initUInt32(0);
}
