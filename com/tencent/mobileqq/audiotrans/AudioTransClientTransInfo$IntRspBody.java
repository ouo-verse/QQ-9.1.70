package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$IntRspBody extends MessageMicro<AudioTransClientTransInfo$IntRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"msg_failed_rsp", "msg_join_session_rsp", "msg_exit_session_rsp", "msg_change_session_rsp", "msg_raw_data_rsp", "msg_heart_beat_rsp", "msg_push_data_rsp", "msg_notify_exit_rsp"}, new Object[]{null, null, null, null, null, null, null, null}, AudioTransClientTransInfo$IntRspBody.class);
    public AudioTransClientTransInfo$IntC2SFailedRsp msg_failed_rsp = new AudioTransClientTransInfo$IntC2SFailedRsp();
    public AudioTransClientTransInfo$IntC2SJoinSessionRsp msg_join_session_rsp = new AudioTransClientTransInfo$IntC2SJoinSessionRsp();
    public AudioTransClientTransInfo$IntC2SExitSessionRsp msg_exit_session_rsp = new MessageMicro<AudioTransClientTransInfo$IntC2SExitSessionRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SExitSessionRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientTransInfo$IntC2SExitSessionRsp.class);
    };
    public AudioTransClientTransInfo$IntC2SChangeSessionRsp msg_change_session_rsp = new AudioTransClientTransInfo$IntC2SChangeSessionRsp();
    public AudioTransClientTransInfo$IntC2SRawDataRsp msg_raw_data_rsp = new MessageMicro<AudioTransClientTransInfo$IntC2SRawDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SRawDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientTransInfo$IntC2SRawDataRsp.class);
    };
    public AudioTransClientTransInfo$IntC2SHeartBeatRsp msg_heart_beat_rsp = new MessageMicro<AudioTransClientTransInfo$IntC2SHeartBeatRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntC2SHeartBeatRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientTransInfo$IntC2SHeartBeatRsp.class);
    };
    public AudioTransClientTransInfo$IntS2CPushDataRsp msg_push_data_rsp = new MessageMicro<AudioTransClientTransInfo$IntS2CPushDataRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntS2CPushDataRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientTransInfo$IntS2CPushDataRsp.class);
    };
    public AudioTransClientTransInfo$IntS2CNotifyExitRsp msg_notify_exit_rsp = new MessageMicro<AudioTransClientTransInfo$IntS2CNotifyExitRsp>() { // from class: com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo$IntS2CNotifyExitRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], AudioTransClientTransInfo$IntS2CNotifyExitRsp.class);
    };
}
