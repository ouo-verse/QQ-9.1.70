package com.tencent.avatarinfo;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class MultiHeadUrl {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MultiBusidUrlReq extends MessageMicro<MultiBusidUrlReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58}, new String[]{"srcUidType", "srcUin", "srcTid", "srcOpenid", "dstUsrType", "dstUidType", "dstUsrInfos"}, new Object[]{0, 0L, 0L, "", 0, 0, null}, MultiBusidUrlReq.class);
        public final PBUInt32Field srcUidType = PBField.initUInt32(0);
        public final PBUInt64Field srcUin = PBField.initUInt64(0);
        public final PBUInt64Field srcTid = PBField.initUInt64(0);
        public final PBStringField srcOpenid = PBField.initString("");
        public final PBRepeatField<Integer> dstUsrType = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
        public final PBUInt32Field dstUidType = PBField.initUInt32(0);
        public final PBRepeatMessageField<ReqUsrInfo> dstUsrInfos = PBField.initRepeatMessage(ReqUsrInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class MultiBusidUrlRsp extends MessageMicro<MultiBusidUrlRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48, 58}, new String[]{"srcUidType", "srcUin", "srcTid", "srcOpenid", "result", "dstUidType", "dstUsrHeadInfos"}, new Object[]{0, 0L, 0L, "", 0, 0, null}, MultiBusidUrlRsp.class);
        public final PBUInt32Field srcUidType = PBField.initUInt32(0);
        public final PBUInt64Field srcUin = PBField.initUInt64(0);
        public final PBUInt64Field srcTid = PBField.initUInt64(0);
        public final PBStringField srcOpenid = PBField.initString("");
        public final PBInt32Field result = PBField.initInt32(0);
        public final PBUInt32Field dstUidType = PBField.initUInt32(0);
        public final PBRepeatMessageField<RspUsrHeadInfo> dstUsrHeadInfos = PBField.initRepeatMessage(RspUsrHeadInfo.class);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class ReqUsrInfo extends MessageMicro<ReqUsrInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"dstUin", "dstTid", "dstOpenid"}, new Object[]{0L, 0L, ""}, ReqUsrInfo.class);
        public final PBUInt64Field dstUin = PBField.initUInt64(0);
        public final PBUInt64Field dstTid = PBField.initUInt64(0);
        public final PBStringField dstOpenid = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class RspHeadInfo extends MessageMicro<RspHeadInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 58}, new String[]{"usrType", "faceType", "timestamp", FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, "url", "sysid", "headVerify"}, new Object[]{0, 0, 0, 0, "", 0, ""}, RspHeadInfo.class);
        public final PBUInt32Field usrType = PBField.initUInt32(0);
        public final PBUInt32Field faceType = PBField.initUInt32(0);
        public final PBUInt32Field timestamp = PBField.initUInt32(0);
        public final PBUInt32Field faceFlag = PBField.initUInt32(0);
        public final PBStringField url = PBField.initString("");
        public final PBUInt32Field sysid = PBField.initUInt32(0);
        public final PBStringField headVerify = PBField.initString("");
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static final class RspUsrHeadInfo extends MessageMicro<RspUsrHeadInfo> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"dstUin", "dstTid", "dstOpenid", "dstHeadInfos"}, new Object[]{0L, 0L, "", null}, RspUsrHeadInfo.class);
        public final PBUInt64Field dstUin = PBField.initUInt64(0);
        public final PBUInt64Field dstTid = PBField.initUInt64(0);
        public final PBStringField dstOpenid = PBField.initString("");
        public final PBRepeatMessageField<RspHeadInfo> dstHeadInfos = PBField.initRepeatMessage(RspHeadInfo.class);
    }

    MultiHeadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
