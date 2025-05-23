package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes17.dex */
public final class QQShopPAMenuPB$GetBottomMenuReq extends MessageMicro<QQShopPAMenuPB$GetBottomMenuReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField qyy_switch = PBField.initBool(false);
    public final PBBoolField is_youth_mode = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"qyy_switch", "is_youth_mode"}, new Object[]{bool, bool}, QQShopPAMenuPB$GetBottomMenuReq.class);
    }
}
