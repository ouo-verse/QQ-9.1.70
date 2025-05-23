package com.tencent.mobileqq.reportlog.api.pb;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;

/* loaded from: classes18.dex */
public final class QqlogPushPb$ListPullReportRuleReq extends MessageMicro<QqlogPushPb$ListPullReportRuleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"page", "pageSize", "condition"}, new Object[]{0, 0, null}, QqlogPushPb$ListPullReportRuleReq.class);
    public final PBInt32Field page = PBField.initInt32(0);
    public final PBInt32Field pageSize = PBField.initInt32(0);
    public QqlogPushPb$PullReportRule condition = new MessageMicro<QqlogPushPb$PullReportRule>() { // from class: com.tencent.mobileqq.reportlog.api.pb.QqlogPushPb$PullReportRule
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 98}, new String[]{"task_id", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "product", "platform", "start_time", "end_time", "xg_log_size", "log_field", "status", "rtx", AlbumCacheData.CREATE_TIME, "update_time"}, new Object[]{0L, "", "", "", 0L, 0L, 0, 0L, 0, "", "", ""}, QqlogPushPb$PullReportRule.class);
        public final PBInt64Field task_id = PBField.initInt64(0);
        public final PBStringField qimei = PBField.initString("");
        public final PBStringField product = PBField.initString("");
        public final PBStringField platform = PBField.initString("");
        public final PBInt64Field start_time = PBField.initInt64(0);
        public final PBInt64Field end_time = PBField.initInt64(0);
        public final PBInt32Field xg_log_size = PBField.initInt32(0);
        public final PBInt64Field log_field = PBField.initInt64(0);
        public final PBInt32Field status = PBField.initInt32(0);
        public final PBStringField rtx = PBField.initString("");
        public final PBStringField create_time = PBField.initString("");
        public final PBStringField update_time = PBField.initString("");
    };
}
