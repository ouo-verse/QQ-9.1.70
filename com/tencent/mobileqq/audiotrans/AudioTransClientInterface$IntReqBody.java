package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientInterface$IntReqBody extends MessageMicro<AudioTransClientInterface$IntReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"msg_join_session_req", "msg_exit_session_req", "msg_change_session_req", "msg_raw_data_req", "msg_heart_beat_req", "msg_push_data_req", "msg_notify_exit_req"}, new Object[]{null, null, null, null, null, null, null}, AudioTransClientInterface$IntReqBody.class);
    public AudioTransClientInterface$IntC2SJoinSessionReq msg_join_session_req = new MessageMicro<AudioTransClientInterface$IntC2SJoinSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SJoinSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate"}, new Object[]{0, 1, 1, 0, 1, 1, Boolean.FALSE}, AudioTransClientInterface$IntC2SJoinSessionReq.class);
        public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
        public final PBEnumField enum_term = PBField.initEnum(1);
        public final PBEnumField enum_net_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBEnumField enum_business_direction = PBField.initEnum(1);
        public final PBEnumField enum_data_source = PBField.initEnum(1);
        public final PBBoolField bool_translate = PBField.initBool(false);
    };
    public AudioTransClientInterface$IntC2SExitSessionReq msg_exit_session_req = new MessageMicro<AudioTransClientInterface$IntC2SExitSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SExitSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntC2SExitSessionReq.class);
    };
    public AudioTransClientInterface$IntC2SChangeSessionReq msg_change_session_req = new MessageMicro<AudioTransClientInterface$IntC2SChangeSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SChangeSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"enum_net_type", "uint32_client_port", "enum_business_direction", "enum_data_source", "bool_translate"}, new Object[]{1, 0, 1, 1, Boolean.FALSE}, AudioTransClientInterface$IntC2SChangeSessionReq.class);
        public final PBEnumField enum_net_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
        public final PBEnumField enum_business_direction = PBField.initEnum(1);
        public final PBEnumField enum_data_source = PBField.initEnum(1);
        public final PBBoolField bool_translate = PBField.initBool(false);
    };
    public AudioTransClientInterface$IntC2SRawDataReq msg_raw_data_req = new MessageMicro<AudioTransClientInterface$IntC2SRawDataReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SRawDataReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_data", "str_key"}, new Object[]{ByteStringMicro.EMPTY, ""}, AudioTransClientInterface$IntC2SRawDataReq.class);
        public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_key = PBField.initString("");
    };
    public AudioTransClientInterface$IntC2SHeartBeatReq msg_heart_beat_req = new MessageMicro<AudioTransClientInterface$IntC2SHeartBeatReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SHeartBeatReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntC2SHeartBeatReq.class);
    };
    public AudioTransClientInterface$IntS2CPushDataReq msg_push_data_req = new MessageMicro<AudioTransClientInterface$IntS2CPushDataReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntS2CPushDataReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"translate_result", "str_key"}, new Object[]{ByteStringMicro.EMPTY, ""}, AudioTransClientInterface$IntS2CPushDataReq.class);
        public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBStringField str_key = PBField.initString("");
    };
    public AudioTransClientInterface$IntS2CNotifyExitReq msg_notify_exit_req = new MessageMicro<AudioTransClientInterface$IntS2CNotifyExitReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntS2CNotifyExitReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_reason"}, new Object[]{0}, AudioTransClientInterface$IntS2CNotifyExitReq.class);
        public final PBUInt32Field uint32_reason = PBField.initUInt32(0);
    };
}
