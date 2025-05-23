package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$GetNewWidgetReq extends MessageMicro<QQWidgetSvr$GetNewWidgetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 72}, new String[]{"source", "encrypted_uin", "device_type", "mobile_version", "device_number", AppConstants.Preferences.QQ_VERSION, "platform", "pskey", "scene"}, new Object[]{0, "", "", "", "", "", 0, "", 0}, QQWidgetSvr$GetNewWidgetReq.class);
    public final PBEnumField source = PBField.initEnum(0);
    public final PBStringField encrypted_uin = PBField.initString("");
    public final PBStringField device_type = PBField.initString("");
    public final PBStringField mobile_version = PBField.initString("");
    public final PBStringField device_number = PBField.initString("");
    public final PBStringField qq_version = PBField.initString("");
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBStringField pskey = PBField.initString("");
    public final PBEnumField scene = PBField.initEnum(0);
}
