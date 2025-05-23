package com.tencent.mobileqq;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleWeakNetReporter;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class WebSsoBody$STServiceMonitItem extends MessageMicro<WebSsoBody$STServiceMonitItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"cmd", "url", "errcode", QCircleWeakNetReporter.KEY_COST, "src"}, new Object[]{"", "", 0, 0, 0}, WebSsoBody$STServiceMonitItem.class);
    public final PBStringField cmd = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBUInt32Field cost = PBField.initUInt32(0);
    public final PBUInt32Field src = PBField.initUInt32(0);
}
