package com.tencent.mobileqq.webdownload;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class DownloadURLCheck$RspDownloadUrlCheckRecmd extends MessageMicro<DownloadURLCheck$RspDownloadUrlCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "is_white_url", "pkg_name", "extra_info"}, new Object[]{0, "", Boolean.FALSE, "", ""}, DownloadURLCheck$RspDownloadUrlCheckRecmd.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBBoolField is_white_url = PBField.initBool(false);
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
}
