package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class ConfigurationService$ReportConfig extends MessageMicro<ConfigurationService$ReportConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"type", "task_id", "version", TVKDataBinder.KEY_REPORT_TYPE, "result", "real_size", "total_size", "err_msgs"}, new Object[]{0, 0, 0, 0, 0, 0, 0, ""}, ConfigurationService$ReportConfig.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field report_type = PBField.initUInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field real_size = PBField.initUInt32(0);
    public final PBUInt32Field total_size = PBField.initUInt32(0);
    public final PBRepeatField<String> err_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
}
