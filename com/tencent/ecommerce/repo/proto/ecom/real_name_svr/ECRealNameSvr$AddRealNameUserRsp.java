package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$AddRealNameUserRsp extends MessageMicro<ECRealNameSvr$AddRealNameUserRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"alert_msg", QCircleAlphaUserReporter.KEY_USER}, new Object[]{"", null}, ECRealNameSvr$AddRealNameUserRsp.class);
    public final PBStringField alert_msg = PBField.initString("");
    public ECRealNameSvr$User user = new ECRealNameSvr$User();
}
