package com.tencent.mobileqq.reportlog.api.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* loaded from: classes18.dex */
public final class QqlogPushPb$PullReportRuleRsp extends MessageMicro<QqlogPushPb$PullReportRuleRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 64, 72}, new String[]{"need", "task_id", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "product", "platform", "start_time", "end_time", "xg_log_size", "log_field"}, new Object[]{Boolean.FALSE, 0L, "", "", "", 0L, 0L, 0, 0L}, QqlogPushPb$PullReportRuleRsp.class);
    public final PBBoolField need = PBField.initBool(false);
    public final PBInt64Field task_id = PBField.initInt64(0);
    public final PBStringField qimei = PBField.initString("");
    public final PBStringField product = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBInt64Field start_time = PBField.initInt64(0);
    public final PBInt64Field end_time = PBField.initInt64(0);
    public final PBInt32Field xg_log_size = PBField.initInt32(0);
    public final PBInt64Field log_field = PBField.initInt64(0);
}
