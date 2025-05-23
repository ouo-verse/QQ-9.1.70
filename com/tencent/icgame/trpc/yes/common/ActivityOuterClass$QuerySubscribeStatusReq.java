package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ActivityOuterClass$QuerySubscribeStatusReq extends MessageMicro<ActivityOuterClass$QuerySubscribeStatusReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"activity_id"}, new Object[]{0}, ActivityOuterClass$QuerySubscribeStatusReq.class);
    public final PBInt32Field activity_id = PBField.initInt32(0);
}
