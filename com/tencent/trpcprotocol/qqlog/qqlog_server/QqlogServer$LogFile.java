package com.tencent.trpcprotocol.qqlog.qqlog_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QqlogServer$LogFile extends MessageMicro<QqlogServer$LogFile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50}, new String[]{"log_file_name", "log_size", "zip_log_size", "log_line_num", "file_uri", "public_key"}, new Object[]{"", 0, 0, 0, "", ""}, QqlogServer$LogFile.class);
    public final PBStringField log_file_name = PBField.initString("");
    public final PBInt32Field log_size = PBField.initInt32(0);
    public final PBInt32Field zip_log_size = PBField.initInt32(0);
    public final PBInt32Field log_line_num = PBField.initInt32(0);
    public final PBStringField file_uri = PBField.initString("");
    public final PBStringField public_key = PBField.initString("");
}
