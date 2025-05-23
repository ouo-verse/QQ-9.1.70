package com.tencent.ecommerce.repo.proto.ecom.qshop_order_svr;

import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_info.ECOrderInfo$OrderInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECQshopOrderSvr$CommitOrderRsp extends MessageMicro<ECQshopOrderSvr$CommitOrderRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"has_biz_error", "order_commit_biz_error_msg", "order_info", "commit_order_result"}, new Object[]{Boolean.FALSE, null, null, null}, ECQshopOrderSvr$CommitOrderRsp.class);
    public final PBBoolField has_biz_error = PBField.initBool(false);
    public ECQshopOrderSvr$OrderCommitBizErrorMsg order_commit_biz_error_msg = new ECQshopOrderSvr$OrderCommitBizErrorMsg();
    public ECOrderInfo$OrderInfo order_info = new ECOrderInfo$OrderInfo();
    public ECQshopOrderSvr$CommitOrderResult commit_order_result = new ECQshopOrderSvr$CommitOrderResult();
}
