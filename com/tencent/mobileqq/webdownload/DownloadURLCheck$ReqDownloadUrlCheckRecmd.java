package com.tencent.mobileqq.webdownload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.weiyun.transmission.db.JobDbManager;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class DownloadURLCheck$ReqDownloadUrlCheckRecmd extends MessageMicro<DownloadURLCheck$ReqDownloadUrlCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uin", JobDbManager.COL_UP_MIME_TYPE, "host_url", "download_url", "extra_info"}, new Object[]{0L, "", "", "", ""}, DownloadURLCheck$ReqDownloadUrlCheckRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField mime_type = PBField.initString("");
    public final PBStringField host_url = PBField.initString("");
    public final PBStringField download_url = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
}
