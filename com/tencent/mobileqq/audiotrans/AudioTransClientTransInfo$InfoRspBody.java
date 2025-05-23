package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransClientTransInfo$InfoRspBody extends MessageMicro<AudioTransClientTransInfo$InfoRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_failed_rsp", "msg_create_session_rsp"}, new Object[]{null, null}, AudioTransClientTransInfo$InfoRspBody.class);
    public AudioTransClientTransInfo$InfoC2SFailedRsp msg_failed_rsp = new AudioTransClientTransInfo$InfoC2SFailedRsp();
    public AudioTransClientTransInfo$InfoC2SCreateSessionRsp msg_create_session_rsp = new AudioTransClientTransInfo$InfoC2SCreateSessionRsp();
}
