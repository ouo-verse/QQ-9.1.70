package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$WujiNotifyReq extends MessageMicro<sellerMsgConfig$WujiNotifyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"target", "app_id", "schema_id", "action", "id", QCircleAlphaUserReporter.KEY_USER, "last_data", "next_data"}, new Object[]{"", "", "", "", "", "", "", ""}, sellerMsgConfig$WujiNotifyReq.class);
    public final PBStringField target = PBField.initString("");
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField schema_id = PBField.initString("");
    public final PBStringField action = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f263438id = PBField.initString("");
    public final PBStringField user = PBField.initString("");
    public final PBStringField last_data = PBField.initString("");
    public final PBStringField next_data = PBField.initString("");
}
