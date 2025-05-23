package com.tencent.open.pcpush;

import com.qq.e.comm.constants.TangramAppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class MessageContent$MsgContent extends MessageMicro<MessageContent$MsgContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 50, 58, 66, 72, 82, 90}, new String[]{"appid", "via", "pkgname", "versioncode", "appname", "appurl", TangramAppConstants.ICON_URL, "appsize", "filetype", "source", "srciconurl"}, new Object[]{0L, "", "", 0, "", "", "", "", 0, "", ""}, MessageContent$MsgContent.class);
    public final PBInt64Field appid = PBField.initInt64(0);
    public final PBStringField via = PBField.initString("");
    public final PBStringField pkgname = PBField.initString("");
    public final PBInt32Field versioncode = PBField.initInt32(0);
    public final PBStringField appname = PBField.initString("");
    public final PBStringField appurl = PBField.initString("");
    public final PBStringField iconurl = PBField.initString("");
    public final PBStringField appsize = PBField.initString("");
    public final PBInt32Field filetype = PBField.initInt32(0);
    public final PBStringField source = PBField.initString("");
    public final PBStringField srciconurl = PBField.initString("");
}
