package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$RealNameUser extends MessageMicro<ECRealNameSvr$RealNameUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"id", "media_id", QCircleAlphaUserReporter.KEY_USER}, new Object[]{"", "", null}, ECRealNameSvr$RealNameUser.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105261id = PBField.initString("");
    public final PBStringField media_id = PBField.initString("");
    public ECRealNameSvr$User user = new ECRealNameSvr$User();
}
