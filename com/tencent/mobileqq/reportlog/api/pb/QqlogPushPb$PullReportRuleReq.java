package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* loaded from: classes18.dex */
public final class QqlogPushPb$PullReportRuleReq extends MessageMicro<QqlogPushPb$PullReportRuleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 26, 34}, new String[]{TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "product", "platform"}, new Object[]{"", "", ""}, QqlogPushPb$PullReportRuleReq.class);
    public final PBStringField qimei = PBField.initString("");
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
}
