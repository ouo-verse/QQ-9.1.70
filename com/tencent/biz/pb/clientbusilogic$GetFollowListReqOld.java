package com.tencent.biz.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class clientbusilogic$GetFollowListReqOld extends MessageMicro<clientbusilogic$GetFollowListReqOld> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 32}, new String[]{"follow_seqno", "limit"}, new Object[]{0, 0}, clientbusilogic$GetFollowListReqOld.class);
    public final PBUInt32Field follow_seqno = PBField.initUInt32(0);
    public final PBUInt32Field limit = PBField.initUInt32(0);
}
