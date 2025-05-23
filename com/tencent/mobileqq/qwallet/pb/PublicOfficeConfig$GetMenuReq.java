package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class PublicOfficeConfig$GetMenuReq extends MessageMicro<PublicOfficeConfig$GetMenuReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField qyy_switch = PBField.initBool(false);
    public final PBBoolField is_youth_mode = PBField.initBool(false);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"qyy_switch", "is_youth_mode"}, new Object[]{bool, bool}, PublicOfficeConfig$GetMenuReq.class);
    }
}
