package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientInfo$InfoRspBody extends MessageMicro<AudioTransClientInfo$InfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_failed_rsp", "msg_create_session_rsp"}, new Object[]{null, null}, AudioTransClientInfo$InfoRspBody.class);
    public AudioTransClientInfo$InfoC2SFailedRsp msg_failed_rsp = new MessageMicro<AudioTransClientInfo$InfoC2SFailedRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInfo$InfoC2SFailedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_errcode", "str_errmsg"}, new Object[]{0, ""}, AudioTransClientInfo$InfoC2SFailedRsp.class);
        public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
    };
    public AudioTransClientInfo$InfoC2SCreateSessionRsp msg_create_session_rsp = new MessageMicro<AudioTransClientInfo$InfoC2SCreateSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInfo$InfoC2SCreateSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"enum_channel_type", "rpt_msg_interface_list", "bool_client_ans"}, new Object[]{1, null, Boolean.FALSE}, AudioTransClientInfo$InfoC2SCreateSessionRsp.class);
        public final PBEnumField enum_channel_type = PBField.initEnum(1);
        public final PBRepeatMessageField<AudioTransCommon$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon$NetAddr.class);
        public final PBBoolField bool_client_ans = PBField.initBool(false);
    };
}
