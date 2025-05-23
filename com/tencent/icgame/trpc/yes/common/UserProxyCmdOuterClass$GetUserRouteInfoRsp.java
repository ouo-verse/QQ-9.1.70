package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetUserRouteInfoRsp extends MessageMicro<UserProxyCmdOuterClass$GetUserRouteInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"route_list"}, new Object[]{null}, UserProxyCmdOuterClass$GetUserRouteInfoRsp.class);
    public CommonOuterClass$OnlineRouteInfoList route_list = new CommonOuterClass$OnlineRouteInfoList();
}
