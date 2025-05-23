package com.tencent.ecommerce.repo.proto.ecom.qshop_customer_reader_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopCustomerReaderSvr$GetLinkURLReq extends MessageMicro<ECQshopCustomerReaderSvr$GetLinkURLReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"scene", "shop_id", "spu_id", "order_id", XWalkReaderBasePlugin.PARAM_KEY_DARK_MODE}, new Object[]{0, "", "", "", Boolean.FALSE}, ECQshopCustomerReaderSvr$GetLinkURLReq.class);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField spu_id = PBField.initString("");
    public final PBStringField order_id = PBField.initString("");
    public final PBBoolField dark_mode = PBField.initBool(false);
}
