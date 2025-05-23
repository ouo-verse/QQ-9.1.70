package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$DelayConfirmReq extends MessageMicro<ECQshopOrderSvr$DelayConfirmReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 810, 816}, new String[]{"order_id", "duration", "token", WadlProxyConsts.CHANNEL}, new Object[]{"", 0L, "", 0}, ECQshopOrderSvr$DelayConfirmReq.class);
    public final PBStringField order_id = PBField.initString("");
    public final PBInt64Field duration = PBField.initInt64(0);
    public final PBStringField token = PBField.initString("");
    public final PBInt32Field channel = PBField.initInt32(0);
}
