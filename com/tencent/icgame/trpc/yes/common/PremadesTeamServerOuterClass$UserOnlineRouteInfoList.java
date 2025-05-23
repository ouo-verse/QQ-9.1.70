package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$UserOnlineRouteInfoList extends MessageMicro<PremadesTeamServerOuterClass$UserOnlineRouteInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uid", "list", "user_id"}, new Object[]{0L, null, null}, PremadesTeamServerOuterClass$UserOnlineRouteInfoList.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public CommonOuterClass$OnlineRouteInfoList list = new CommonOuterClass$OnlineRouteInfoList();
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
