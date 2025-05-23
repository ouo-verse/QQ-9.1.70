package com.tencent.ecommerce.repo.proto.ecom.common_order;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrder$BuyerOrderOptions extends MessageMicro<ECOrder$BuyerOrderOptions> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField keyword = PBField.initString("");
    public final PBBoolField enable_state = PBField.initBool(false);
    public final PBInt32Field state = PBField.initInt32(0);
    public final PBBoolField enable_evaluation_state = PBField.initBool(false);
    public final PBInt32Field evaluation_state = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 80, 88, 160, 168}, new String[]{"keyword", "enable_state", "state", "enable_evaluation_state", "evaluation_state"}, new Object[]{"", bool, 0, bool, 0}, ECOrder$BuyerOrderOptions.class);
    }
}
