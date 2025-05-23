package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ActivityOuterClass$ShareLiveRoomLinkReq extends MessageMicro<ActivityOuterClass$ShareLiveRoomLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"param_list"}, new Object[]{null}, ActivityOuterClass$ShareLiveRoomLinkReq.class);
    public final PBRepeatMessageField<ActivityOuterClass$Param> param_list = PBField.initRepeatMessage(ActivityOuterClass$Param.class);
}
