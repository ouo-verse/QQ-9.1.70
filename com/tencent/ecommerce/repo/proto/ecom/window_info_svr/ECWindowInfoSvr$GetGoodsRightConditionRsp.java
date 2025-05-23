package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$GetGoodsRightConditionRsp extends MessageMicro<ECWindowInfoSvr$GetGoodsRightConditionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"goods_right_condition"}, new Object[]{null}, ECWindowInfoSvr$GetGoodsRightConditionRsp.class);
    public final PBRepeatMessageField<ECWindowInfoSvr$Condition> goods_right_condition = PBField.initRepeatMessage(ECWindowInfoSvr$Condition.class);
}
