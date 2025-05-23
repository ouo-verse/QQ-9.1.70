package com.tencent.mobileqq.qwallet.pb;

import com.tencent.ads.data.AdParam;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class MidasOrder$SsoMakeOrderReq extends MessageMicro<MidasOrder$SsoMakeOrderReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 50, 58, 66}, new String[]{ReportDataBuilder.KEY_PRODUCT_ID, "provide_offer_id", "quantity", "pay_channel", "selling_price", "offer_id", AdParam.PF, "pf_key"}, new Object[]{"", "", 0, "", 0, "", "", ""}, MidasOrder$SsoMakeOrderReq.class);
    public final PBStringField product_id = PBField.initString("");
    public final PBStringField provide_offer_id = PBField.initString("");
    public final PBInt32Field quantity = PBField.initInt32(0);
    public final PBStringField pay_channel = PBField.initString("");
    public final PBInt32Field selling_price = PBField.initInt32(0);
    public final PBStringField offer_id = PBField.initString("");

    /* renamed from: pf, reason: collision with root package name */
    public final PBStringField f278697pf = PBField.initString("");
    public final PBStringField pf_key = PBField.initString("");
}
