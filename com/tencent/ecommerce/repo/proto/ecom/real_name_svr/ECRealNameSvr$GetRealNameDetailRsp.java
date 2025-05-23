package com.tencent.ecommerce.repo.proto.ecom.real_name_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRealNameSvr$GetRealNameDetailRsp extends MessageMicro<ECRealNameSvr$GetRealNameDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QCircleAlphaUserReporter.KEY_USER}, new Object[]{null}, ECRealNameSvr$GetRealNameDetailRsp.class);
    public ECRealNameSvr$User user = new ECRealNameSvr$User();
}
