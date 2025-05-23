package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$ConfirmReceiptReq extends MessageMicro<ECQshopOrderSvr$ConfirmReceiptReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 810, 816}, new String[]{"order_id", "need_latest_order", "token", WadlProxyConsts.CHANNEL}, new Object[]{"", Boolean.FALSE, "", 0}, ECQshopOrderSvr$ConfirmReceiptReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBBoolField need_latest_order = PBField.initBool(false);
    public final PBStringField token = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
}
