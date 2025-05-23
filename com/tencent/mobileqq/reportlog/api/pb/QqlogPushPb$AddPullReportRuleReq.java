package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* loaded from: classes18.dex */
public final class QqlogPushPb$AddPullReportRuleReq extends MessageMicro<QqlogPushPb$AddPullReportRuleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 26, 34, 40, 48, 56, 64, 82}, new String[]{TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "product", "platform", "start_time", "end_time", "xg_log_size", "log_field", "rtx"}, new Object[]{"", "", "", 0L, 0L, 0, 0L, ""}, QqlogPushPb$AddPullReportRuleReq.class);
    public final PBStringField qimei = PBField.initString("");
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBInt32Field xg_log_size = PBField.initInt32(0);
    public final PBInt64Field log_field = PBField.initInt64(0);
    public final PBStringField rtx = PBField.initString("");
}
