package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_gvideo_sdk_transfer$RespInfo extends MessageMicro<qav_gvideo_sdk_transfer$RespInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "gAudioInfo"}, new Object[]{0, null}, qav_gvideo_sdk_transfer$RespInfo.class);
    public final PBEnumField uint32_result = PBField.initEnum(0);
    public qav_gvideo_sdk_transfer$GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer$GAudioInfo();
}
