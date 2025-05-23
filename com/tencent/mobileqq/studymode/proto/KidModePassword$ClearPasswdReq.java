package com.tencent.mobileqq.studymode.proto;

import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes18.dex */
public final class KidModePassword$ClearPasswdReq extends MessageMicro<KidModePassword$ClearPasswdReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 48, 56, 66}, new String[]{"acct_type", "account", "scene_id", "auth_method", "face_key", "timestamp", "nonce", "private_sig"}, new Object[]{0, "", 0, 0, null, 0L, 0L, null}, KidModePassword$ClearPasswdReq.class);
    public final PBEnumField acct_type = PBField.initEnum(0);
    public final PBStringField account = PBField.initString("");
    public final PBUInt32Field scene_id = PBField.initUInt32(0);
    public final PBEnumField auth_method = PBField.initEnum(0);
    public KidModePassword$FaceKey face_key = new KidModePassword$FaceKey();
    public final PBInt64Field timestamp = PBField.initInt64(0);
    public final PBInt64Field nonce = PBField.initInt64(0);
    public KidModePassword$PrivateSig private_sig = new MessageMicro<KidModePassword$PrivateSig>() { // from class: com.tencent.mobileqq.studymode.proto.KidModePassword$PrivateSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{PreloadTRTCPlayerParams.KEY_SIG}, new Object[]{""}, KidModePassword$PrivateSig.class);
        public final PBStringField sig = PBField.initString("");
    };
}
