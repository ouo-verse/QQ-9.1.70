package com.tencent.trpcprotocol.qqlog.qqlog_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QqlogServer$SsoReportReq extends MessageMicro<QqlogServer$SsoReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 58, 66, 74, 82}, new String[]{"seq", "sub_seq", "uin", TVKDataBinder.KEY_REPORT_TYPE, "imei", "os", "model", "client_device", "log_file", "process"}, new Object[]{0, 0, 0L, 0, "", "", "", null, null, null}, QqlogServer$SsoReportReq.class);
    public static final int report_type_active_report_device = 3;
    public static final int report_type_active_report_process = 4;
    public static final int report_type_passive_report_device = 1;
    public static final int report_type_passive_report_process = 2;
    public static final int report_type_undefined = 0;
    public static final int report_type_upload_file_process = 5;
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field sub_seq = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBInt32Field report_type = PBField.initInt32(0);
    public final PBStringField imei = PBField.initString("");

    /* renamed from: os, reason: collision with root package name */
    public final PBStringField f381601os = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public QqlogServer$ClientDevice client_device = new QqlogServer$ClientDevice();
    public QqlogServer$LogFile log_file = new QqlogServer$LogFile();
    public QqlogServer$Process process = new QqlogServer$Process();
}
