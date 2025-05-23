package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransInterfaceTranslate$IntTransRspBody extends MessageMicro<AudioTransInterfaceTranslate$IntTransRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"msg_failed_rsp", "msg_join_session_rsp", "msg_change_session_rsp", "msg_exit_session_rsp", "msg_raw_data_rsp", "msg_client_report_rsp", "msg_push_data_rsp", "msg_data_timeout_rsp", "msg_report_change_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null}, AudioTransInterfaceTranslate$IntTransRspBody.class);
    public AudioTransInterfaceTranslate$IntTransFailedRsp msg_failed_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransFailedRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransFailedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_errcode", "str_errmsg"}, new Object[]{0, ""}, AudioTransInterfaceTranslate$IntTransFailedRsp.class);
        public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
    };
    public AudioTransInterfaceTranslate$IntTransJoinSessionRsp msg_join_session_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransJoinSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransJoinSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransJoinSessionRsp.class);
    };
    public AudioTransInterfaceTranslate$IntTransChangeSessionRsp msg_change_session_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransChangeSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransChangeSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransChangeSessionRsp.class);
    };
    public AudioTransInterfaceTranslate$IntTransExitSessionRsp msg_exit_session_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransExitSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransExitSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransExitSessionRsp.class);
    };
    public AudioTransInterfaceTranslate$IntTransRawDataRsp msg_raw_data_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransRawDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransRawDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransRawDataRsp.class);
    };
    public AudioTransInterfaceTranslate$IntTransClientReportRsp msg_client_report_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransClientReportRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransClientReportRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransClientReportRsp.class);
    };
    public AudioTransInterfaceTranslate$TransIntPushDataRsp msg_push_data_rsp = new MessageMicro<AudioTransInterfaceTranslate$TransIntPushDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$TransIntPushDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$TransIntPushDataRsp.class);
    };
    public AudioTransInterfaceTranslate$TransIntTimeoutRsp msg_data_timeout_rsp = new MessageMicro<AudioTransInterfaceTranslate$TransIntTimeoutRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$TransIntTimeoutRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$TransIntTimeoutRsp.class);
    };
    public AudioTransInterfaceTranslate$IntTransReportRsp msg_report_change_rsp = new MessageMicro<AudioTransInterfaceTranslate$IntTransReportRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate$IntTransReportRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransInterfaceTranslate$IntTransReportRsp.class);
    };
}
