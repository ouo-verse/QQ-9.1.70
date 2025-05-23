package com.tencent.mobileqq.wxmini.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.upload.network.session.cache.SessionDbHelper;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class AccountLogic$SigInfo extends MessageMicro<AccountLogic$SigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"sig_type", "face_sig_info", "sms_sig_info", "appeal_sig_info"}, new Object[]{0, null, null, null}, AccountLogic$SigInfo.class);
    public final PBEnumField sig_type = PBField.initEnum(0);
    public AccountLogic$FaceSigInfo face_sig_info = new MessageMicro<AccountLogic$FaceSigInfo>() { // from class: com.tencent.mobileqq.wxmini.pb.AccountLogic$FaceSigInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appid", "openid", RemoteCommand.RESULT_KEY, SessionDbHelper.SESSION_ID}, new Object[]{"", "", "", ""}, AccountLogic$FaceSigInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField openid = PBField.initString("");
        public final PBStringField result_key = PBField.initString("");
        public final PBStringField session = PBField.initString("");
    };
    public AccountLogic$SmsSigInfo sms_sig_info = new MessageMicro<AccountLogic$SmsSigInfo>() { // from class: com.tencent.mobileqq.wxmini.pb.AccountLogic$SmsSigInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"country_code", "phone", "key_type", "sms_token"}, new Object[]{"", "", 0, ""}, AccountLogic$SmsSigInfo.class);
        public final PBStringField country_code = PBField.initString("");
        public final PBStringField phone = PBField.initString("");
        public final PBUInt32Field key_type = PBField.initUInt32(0);
        public final PBStringField sms_token = PBField.initString("");
    };
    public AccountLogic$AppealInfo appeal_sig_info = new MessageMicro<AccountLogic$AppealInfo>() { // from class: com.tencent.mobileqq.wxmini.pb.AccountLogic$AppealInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"appid", "receipt", "phone"}, new Object[]{0, 0, ""}, AccountLogic$AppealInfo.class);
        public final PBUInt32Field appid = PBField.initUInt32(0);
        public final PBUInt32Field receipt = PBField.initUInt32(0);
        public final PBStringField phone = PBField.initString("");
    };
}
