package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientInfo$InfoReqBody extends MessageMicro<AudioTransClientInfo$InfoReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_create_session_req"}, new Object[]{null}, AudioTransClientInfo$InfoReqBody.class);
    public AudioTransClientInfo$InfoC2SCreateSessionReq msg_create_session_req = new MessageMicro<AudioTransClientInfo$InfoC2SCreateSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInfo$InfoC2SCreateSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_business_type", "rpt_member_list"}, new Object[]{1, ""}, AudioTransClientInfo$InfoC2SCreateSessionReq.class);
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public final PBRepeatField<String> rpt_member_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
