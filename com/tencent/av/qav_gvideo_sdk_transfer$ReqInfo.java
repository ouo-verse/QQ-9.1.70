package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class qav_gvideo_sdk_transfer$ReqInfo extends MessageMicro<qav_gvideo_sdk_transfer$ReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"req_event", "gAudioInfo"}, new Object[]{1, null}, qav_gvideo_sdk_transfer$ReqInfo.class);
    public final PBEnumField req_event = PBField.initEnum(1);
    public qav_gvideo_sdk_transfer$GAudioInfo gAudioInfo = new qav_gvideo_sdk_transfer$GAudioInfo();
}
