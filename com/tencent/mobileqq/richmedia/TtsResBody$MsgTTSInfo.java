package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class TtsResBody$MsgTTSInfo extends MessageMicro<TtsResBody$MsgTTSInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"msg_rand", "msg_nt_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "stream_group_id"}, new Object[]{0L, 0L, 0L, 0}, TtsResBody$MsgTTSInfo.class);
    public final PBUInt64Field msg_rand = PBField.initUInt64(0);
    public final PBUInt64Field msg_nt_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBUInt32Field stream_group_id = PBField.initUInt32(0);
}
