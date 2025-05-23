package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$InteractionInfo extends MessageMicro<QZoneOfficialAccountBase$InteractionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"view_count", "comment_count", "like_count"}, new Object[]{0, 0, 0}, QZoneOfficialAccountBase$InteractionInfo.class);
    public final PBUInt32Field view_count = PBField.initUInt32(0);
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
}
