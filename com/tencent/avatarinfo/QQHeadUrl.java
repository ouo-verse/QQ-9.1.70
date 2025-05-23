package com.tencent.avatarinfo;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class QQHeadUrl {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class QQHeadUrlReq extends MessageMicro<QQHeadUrlReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40}, new String[]{"srcUsrType", "srcUin", "dstUsrType", "dstUsrInfos", "dstEncryptType"}, new Object[]{0, 0L, 0, null, 0}, QQHeadUrlReq.class);
        public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
        public final PBUInt64Field srcUin = PBField.initUInt64(0);
        public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
        public final PBRepeatMessageField<ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(ReqUsrInfo.class);
        public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class QQHeadUrlRsp extends MessageMicro<QQHeadUrlRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"srcUsrType", "srcUin", "result", "dstUsrType", "dstHeadInfos", "dstEncryptType"}, new Object[]{0, 0L, 0, 0, null, 0}, QQHeadUrlRsp.class);
        public final PBUInt32Field srcUsrType = PBField.initUInt32(0);
        public final PBUInt64Field srcUin = PBField.initUInt64(0);
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBUInt32Field dstUsrType = PBField.initUInt32(0);
        public final PBRepeatMessageField<RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(RspHeadInfo.class);
        public final PBUInt32Field dstEncryptType = PBField.initUInt32(0);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ReqUsrInfo extends MessageMicro<ReqUsrInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"dstUin", "timestamp", "dstEncid"}, new Object[]{0L, 0, ""}, ReqUsrInfo.class);
        public final PBUInt64Field dstUin = PBField.initUInt64(0);
        public final PBUInt32Field timestamp = PBField.initUInt32(0);
        public final PBStringField dstEncid = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class RspHeadInfo extends MessageMicro<RspHeadInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 88}, new String[]{"dstUin", "faceType", "timestamp", FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, "url", "sysid", "dstUid", "headVerify", FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG, "outBoundsFaceFlag", "outBoundsDynamicFaceFlag"}, new Object[]{0L, 0, 0, 0, "", 0, "", "", 0, 0, 0}, RspHeadInfo.class);
        public final PBUInt64Field dstUin = PBField.initUInt64(0);
        public final PBUInt32Field faceType = PBField.initUInt32(0);
        public final PBUInt32Field timestamp = PBField.initUInt32(0);
        public final PBUInt32Field faceFlag = PBField.initUInt32(0);
        public final PBStringField url = PBField.initString("");
        public final PBUInt32Field sysid = PBField.initUInt32(0);
        public final PBStringField dstUid = PBField.initString("");
        public final PBStringField headVerify = PBField.initString("");
        public final PBUInt32Field apngFaceFlag = PBField.initUInt32(0);
        public final PBUInt32Field outBoundsFaceFlag = PBField.initUInt32(0);
        public final PBUInt32Field outBoundsDynamicFaceFlag = PBField.initUInt32(0);
    }

    QQHeadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
