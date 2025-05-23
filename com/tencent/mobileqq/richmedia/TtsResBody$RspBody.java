package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class TtsResBody$RspBody extends MessageMicro<TtsResBody$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48, 56, 64, 72, 80, 90}, new String[]{"ret_code", ServiceConst.PARA_SESSION_ID, "out_seq", "voice_data", "islast", "pcm_sample_rate", "opus_sample_rate", "opus_channels", "opus_bit_rate", "opus_frame_size", "err_msg"}, new Object[]{0, "", 0, null, Boolean.FALSE, 0, 0, 0, 0, 0, ""}, TtsResBody$RspBody.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField session_id = PBField.initString("");
    public final PBUInt32Field out_seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<TtsResBody$voice_item> voice_data = PBField.initRepeatMessage(TtsResBody$voice_item.class);
    public final PBBoolField islast = PBField.initBool(false);
    public final PBUInt32Field pcm_sample_rate = PBField.initUInt32(0);
    public final PBUInt32Field opus_sample_rate = PBField.initUInt32(0);
    public final PBUInt32Field opus_channels = PBField.initUInt32(0);
    public final PBUInt32Field opus_bit_rate = PBField.initUInt32(0);
    public final PBUInt32Field opus_frame_size = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
