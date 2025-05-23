package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ExpeDataAcc$AppInfo extends MessageMicro<ExpeDataAcc$AppInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appVersion", "qua", "productId", "appid"}, new Object[]{"", "", "", ""}, ExpeDataAcc$AppInfo.class);
    public final PBStringField appVersion = PBField.initString("");
    public final PBStringField qua = PBField.initString("");
    public final PBStringField productId = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
}
