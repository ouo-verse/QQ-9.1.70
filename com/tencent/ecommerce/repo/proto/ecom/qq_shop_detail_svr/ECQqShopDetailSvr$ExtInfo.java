package com.tencent.ecommerce.repo.proto.ecom.qq_shop_detail_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQqShopDetailSvr$ExtInfo extends MessageMicro<ECQqShopDetailSvr$ExtInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, ECQqShopDetailSvr$ExtInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
