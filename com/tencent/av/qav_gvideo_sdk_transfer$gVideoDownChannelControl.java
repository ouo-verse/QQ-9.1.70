package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_gvideo_sdk_transfer$gVideoDownChannelControl extends MessageMicro<qav_gvideo_sdk_transfer$gVideoDownChannelControl> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_switch", "uint32_videoacceptTypeSize", "msg_video_accept_type"}, new Object[]{0, 0, null}, qav_gvideo_sdk_transfer$gVideoDownChannelControl.class);
    public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_videoacceptTypeSize = PBField.initUInt32(0);
    public final PBRepeatMessageField<qav_gvideo_sdk_transfer$gVideoAcceptType> msg_video_accept_type = PBField.initRepeatMessage(qav_gvideo_sdk_transfer$gVideoAcceptType.class);
}
