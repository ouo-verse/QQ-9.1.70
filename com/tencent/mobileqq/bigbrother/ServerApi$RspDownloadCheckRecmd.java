package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$RspDownloadCheckRecmd extends MessageMicro<ServerApi$RspDownloadCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"err_info", "check_pass"}, new Object[]{null, Boolean.TRUE}, ServerApi$RspDownloadCheckRecmd.class);
    public ServerApi$ErrorInfo err_info = new ServerApi$ErrorInfo();
    public final PBBoolField check_pass = PBField.initBool(true);
}
