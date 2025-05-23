package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccount$GetMessageListReq extends MessageMicro<QZoneOfficialAccount$GetMessageListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"ext_info", "attach_info"}, new Object[]{null, ""}, QZoneOfficialAccount$GetMessageListReq.class);
    public QZoneBase$CommonExt ext_info = new QZoneBase$CommonExt();
    public final PBStringField attach_info = PBField.initString("");
}
