package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class QQShopTabConfig$GetTabReq extends MessageMicro<QQShopTabConfig$GetTabReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field trigger_type = PBField.initInt32(0);
    public final PBBoolField qyy_switch = PBField.initBool(false);
    public final PBBoolField is_youth_mode = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"trigger_type", "qyy_switch", "is_youth_mode"}, new Object[]{0, bool, bool}, QQShopTabConfig$GetTabReq.class);
    }
}
