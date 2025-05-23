package com.tencent.ecommerce.repo.proto.ecom.qshop_order_query_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$DeviceInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes31.dex */
public final class ECQshopOrderQuerySvr$OrderPageDetailReq extends MessageMicro<ECQshopOrderQuerySvr$OrderPageDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 40, 162, 808, 818}, new String[]{"sku_id", "sku_num", "active_id", "group_id", "buy_all", "req_ext", WadlProxyConsts.CHANNEL, "device_info"}, new Object[]{"", 0, "", "", Boolean.FALSE, "", 0, null}, ECQshopOrderQuerySvr$OrderPageDetailReq.class);
    public final PBStringField sku_id = PBField.initString("");
    public final PBUInt32Field sku_num = PBField.initUInt32(0);
    public final PBStringField active_id = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public final PBBoolField buy_all = PBField.initBool(false);
    public final PBStringField req_ext = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
    public ECOrderInfo$DeviceInfo device_info = new ECOrderInfo$DeviceInfo();
}
