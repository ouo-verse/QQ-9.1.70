package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes25.dex */
public final class QZoneOfficialAccount$PushMessageRsp extends MessageMicro<QZoneOfficialAccount$PushMessageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"ext_info", "next_push_time_sec"}, new Object[]{null, 0L}, QZoneOfficialAccount$PushMessageRsp.class);
    public QZoneBase$CommonExt ext_info = new QZoneBase$CommonExt();
    public final PBInt64Field next_push_time_sec = PBField.initInt64(0);
}
