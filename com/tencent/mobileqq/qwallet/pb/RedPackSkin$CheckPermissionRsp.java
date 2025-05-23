package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes16.dex */
public final class RedPackSkin$CheckPermissionRsp extends MessageMicro<RedPackSkin$CheckPermissionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"selected_time", "special_pop_id"}, new Object[]{0L, 0}, RedPackSkin$CheckPermissionRsp.class);
    public final PBInt64Field selected_time = PBField.initInt64(0);
    public final PBInt32Field special_pop_id = PBField.initInt32(0);
}
