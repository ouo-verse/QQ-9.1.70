package com.tencent.ecommerce.repo.proto.ecom.window_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECWindowInfoSvr$Condition extends MessageMicro<ECWindowInfoSvr$Condition> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 80, 88, 96, 160}, new String[]{"label", "is_reach_threshold", "threshold", "cur_value", "img_type"}, new Object[]{"", Boolean.FALSE, 0, 0, 0}, ECWindowInfoSvr$Condition.class);
    public final PBStringField label = PBField.initString("");
    public final PBBoolField is_reach_threshold = PBField.initBool(false);
    public final PBUInt32Field threshold = PBField.initUInt32(0);
    public final PBUInt32Field cur_value = PBField.initUInt32(0);
    public final PBUInt32Field img_type = PBField.initUInt32(0);
}
