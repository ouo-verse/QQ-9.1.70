package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ActivityOuterClass$QuerySubscribeStatusRsp extends MessageMicro<ActivityOuterClass$QuerySubscribeStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"status"}, new Object[]{0}, ActivityOuterClass$QuerySubscribeStatusRsp.class);
    public final PBInt32Field status = PBField.initInt32(0);
}
