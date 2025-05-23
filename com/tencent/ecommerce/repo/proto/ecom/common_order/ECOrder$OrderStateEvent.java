package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$OrderStateEvent extends MessageMicro<ECOrder$OrderStateEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 48, 56, 64}, new String[]{CGNonAgeReport.EVENT_TYPE, "order_id", "goods_type", "settlement_state", "settlement_time", "settlement_cash", "settlement_type", "pdd_subsidy_settlement_state"}, new Object[]{0, "", 0, 0, 0L, 0L, 0, 0}, ECOrder$OrderStateEvent.class);
    public final PBUInt32Field event_type = PBField.initUInt32(0);
    public final PBStringField order_id = PBField.initString("");
    public final PBUInt32Field goods_type = PBField.initUInt32(0);
    public final PBUInt32Field settlement_state = PBField.initUInt32(0);
    public final PBInt64Field settlement_time = PBField.initInt64(0);
    public final PBInt64Field settlement_cash = PBField.initInt64(0);
    public final PBUInt32Field settlement_type = PBField.initUInt32(0);
    public final PBUInt32Field pdd_subsidy_settlement_state = PBField.initUInt32(0);
}
