package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransInterfaceTranslate$IntTransReqBody extends MessageMicro<AudioTransInterfaceTranslate$IntTransReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"msg_join_session_req", "msg_change_session_req", "msg_exit_session_req", "msg_raw_data_req", "msg_client_report_req", "msg_push_data_req", "msg_data_timeout_req", "msg_report_change_req"}, new Object[]{null, null, null, null, null, null, null, null}, AudioTransInterfaceTranslate$IntTransReqBody.class);
    public AudioTransInterfaceTranslate$IntTransJoinSessionReq msg_join_session_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransJoinSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransJoinSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"enum_business_type", "msg_crypt_info", "bool_translate", "uint32_data_timeout"}, new Object[]{1, null, Boolean.FALSE, 0}, AudioTransInterfaceTranslate$IntTransJoinSessionReq.class);
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public AudioTransCommon$AudioCryptInfo msg_crypt_info = new MessageMicro<AudioTransCommon$AudioCryptInfo>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransCommon$AudioCryptInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"enum_crypt_type", "uint32_key_len", "bytes_key_buf"}, new Object[]{1, 0, ByteStringMicro.EMPTY}, AudioTransCommon$AudioCryptInfo.class);
            public final PBEnumField enum_crypt_type = PBField.initEnum(1);
            public final PBUInt32Field uint32_key_len = PBField.initUInt32(0);
            public final PBBytesField bytes_key_buf = PBField.initBytes(ByteStringMicro.EMPTY);
        };
        public final PBBoolField bool_translate = PBField.initBool(false);
        public final PBUInt32Field uint32_data_timeout = PBField.initUInt32(0);
    };
    public AudioTransInterfaceTranslate$IntTransChangeSessionReq msg_change_session_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransChangeSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransChangeSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"bool_translate"}, new Object[]{Boolean.FALSE}, AudioTransInterfaceTranslate$IntTransChangeSessionReq.class);
        public final PBBoolField bool_translate = PBField.initBool(false);
    };
    public AudioTransInterfaceTranslate$IntTransExitSessionReq msg_exit_session_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransExitSessionReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransExitSessionReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransExitSessionReq.class);
    };
    public AudioTransInterfaceTranslate$IntTransRawDataReq msg_raw_data_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransRawDataReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransRawDataReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_data"}, new Object[]{ByteStringMicro.EMPTY}, AudioTransInterfaceTranslate$IntTransRawDataReq.class);
        public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public AudioTransInterfaceTranslate$IntTransClientReportReq msg_client_report_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransClientReportReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransClientReportReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransClientReportReq.class);
    };
    public AudioTransInterfaceTranslate$TransIntPushDataReq msg_push_data_req = new MessageMicro<AudioTransInterfaceTranslate$TransIntPushDataReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$TransIntPushDataReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"translate_result"}, new Object[]{ByteStringMicro.EMPTY}, AudioTransInterfaceTranslate$TransIntPushDataReq.class);
        public final PBBytesField translate_result = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public AudioTransInterfaceTranslate$TransIntTimeoutReq msg_data_timeout_req = new MessageMicro<AudioTransInterfaceTranslate$TransIntTimeoutReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$TransIntTimeoutReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$TransIntTimeoutReq.class);
    };
    public AudioTransInterfaceTranslate$IntTransReportReq msg_report_change_req = new MessageMicro<AudioTransInterfaceTranslate$IntTransReportReq>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransReportReq
        public static final int INT_TRANS_CREATE_REPORT = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"enum_business_type", "enum_report_reason"}, new Object[]{1, 1}, AudioTransInterfaceTranslate$IntTransReportReq.class);
        public final PBEnumField enum_business_type = PBField.initEnum(1);
        public final PBEnumField enum_report_reason = PBField.initEnum(1);
    };
}
