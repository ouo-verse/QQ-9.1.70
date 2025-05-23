package com.tencent.trpcprotocol.qqstranger.channel_share_svr.channel_share_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class ChannelShareSvr$ArkShareCheckReq extends MessageMicro<ChannelShareSvr$ArkShareCheckReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"meta_data", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, "share_object"}, new Object[]{"", 0, 0, ""}, ChannelShareSvr$ArkShareCheckReq.class);
    public final PBStringField meta_data = PBField.initString("");
    public final PBEnumField share_type = PBField.initEnum(0);
    public final PBEnumField qq_mode = PBField.initEnum(0);
    public final PBStringField share_object = PBField.initString("");
}
