package com.tencent.trpcprotocol.qqstranger.channel_share_svr.channel_share_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ChannelShareSvr$GetArkShareInfoReq extends MessageMicro<ChannelShareSvr$GetArkShareInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"share_object", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE}, new Object[]{"", 0}, ChannelShareSvr$GetArkShareInfoReq.class);
    public final PBStringField share_object = PBField.initString("");
    public final PBEnumField share_type = PBField.initEnum(0);
}
