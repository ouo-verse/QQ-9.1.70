package com.tencent.trpcprotocol.qqlog.qqlog_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class QqlogServer$Process extends MessageMicro<QqlogServer$Process> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 25}, new String[]{"status", "status_info", "upload_progress"}, new Object[]{0, "", Double.valueOf(0.0d)}, QqlogServer$Process.class);
    public static final int status_check_log = 3;
    public static final int status_compress_log = 5;
    public static final int status_err_check_log = 4;
    public static final int status_err_compress_log = 6;
    public static final int status_err_exist_same_task = 2;
    public static final int status_err_upload_log = 8;
    public static final int status_get_push_cmd = 1;
    public static final int status_success = 9;
    public static final int status_undefined = 0;
    public static final int status_upload_log = 7;
    public final PBEnumField status = PBField.initEnum(0);
    public final PBStringField status_info = PBField.initString("");
    public final PBDoubleField upload_progress = PBField.initDouble(0.0d);
}
