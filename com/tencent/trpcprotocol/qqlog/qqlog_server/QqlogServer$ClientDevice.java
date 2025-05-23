package com.tencent.trpcprotocol.qqlog.qqlog_server;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QqlogServer$ClientDevice extends MessageMicro<QqlogServer$ClientDevice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"appid", "client_uins", "net_type", "version", AppConstants.Preferences.QQ_VERSION}, new Object[]{"", "", "", "", ""}, QqlogServer$ClientDevice.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField client_uins = PBField.initString("");
    public final PBStringField net_type = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField qq_version = PBField.initString("");
}
