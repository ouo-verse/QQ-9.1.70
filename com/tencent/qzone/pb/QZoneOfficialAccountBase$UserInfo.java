package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$UserInfo extends MessageMicro<QZoneOfficialAccountBase$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "nick"}, new Object[]{0L, ""}, QZoneOfficialAccountBase$UserInfo.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
}
