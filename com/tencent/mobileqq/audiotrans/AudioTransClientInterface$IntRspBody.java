package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientInterface$IntRspBody extends MessageMicro<AudioTransClientInterface$IntRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"msg_failed_rsp", "msg_join_session_rsp", "msg_exit_session_rsp", "msg_change_session_rsp", "msg_raw_data_rsp", "msg_heart_beat_rsp", "msg_push_data_rsp", "msg_notify_exit_rsp"}, new Object[]{null, null, null, null, null, null, null, null}, AudioTransClientInterface$IntRspBody.class);
    public AudioTransClientInterface$IntC2SFailedRsp msg_failed_rsp = new MessageMicro<AudioTransClientInterface$IntC2SFailedRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SFailedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_errcode", "str_errmsg"}, new Object[]{0, ""}, AudioTransClientInterface$IntC2SFailedRsp.class);
        public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
        public final PBStringField str_errmsg = PBField.initString("");
    };
    public AudioTransClientInterface$IntC2SJoinSessionRsp msg_join_session_rsp = new MessageMicro<AudioTransClientInterface$IntC2SJoinSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SJoinSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_heartbeat_duration", "uint32_combine_num"}, new Object[]{0, 0}, AudioTransClientInterface$IntC2SJoinSessionRsp.class);
        public final PBUInt32Field uint32_heartbeat_duration = PBField.initUInt32(0);
        public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
    };
    public AudioTransClientInterface$IntC2SExitSessionRsp msg_exit_session_rsp = new MessageMicro<AudioTransClientInterface$IntC2SExitSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SExitSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntC2SExitSessionRsp.class);
    };
    public AudioTransClientInterface$IntC2SChangeSessionRsp msg_change_session_rsp = new MessageMicro<AudioTransClientInterface$IntC2SChangeSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SChangeSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_combine_num", "enum_channel_type", "rpt_msg_interface_list"}, new Object[]{0, 1, null}, AudioTransClientInterface$IntC2SChangeSessionRsp.class);
        public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
        public final PBEnumField enum_channel_type = PBField.initEnum(1);
        public final PBRepeatMessageField<AudioTransCommon$NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon$NetAddr.class);
    };
    public AudioTransClientInterface$IntC2SRawDataRsp msg_raw_data_rsp = new MessageMicro<AudioTransClientInterface$IntC2SRawDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SRawDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntC2SRawDataRsp.class);
    };
    public AudioTransClientInterface$IntC2SHeartBeatRsp msg_heart_beat_rsp = new MessageMicro<AudioTransClientInterface$IntC2SHeartBeatRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntC2SHeartBeatRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntC2SHeartBeatRsp.class);
    };
    public AudioTransClientInterface$IntS2CPushDataRsp msg_push_data_rsp = new MessageMicro<AudioTransClientInterface$IntS2CPushDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntS2CPushDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntS2CPushDataRsp.class);
    };
    public AudioTransClientInterface$IntS2CNotifyExitRsp msg_notify_exit_rsp = new MessageMicro<AudioTransClientInterface$IntS2CNotifyExitRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientInterface$IntS2CNotifyExitRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientInterface$IntS2CNotifyExitRsp.class);
    };
}
