package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnAction$GetLatestInteractActionRsp extends MessageMicro<WowoConnAction$GetLatestInteractActionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"friend_uin", "master_action_id", "guest_action_id"}, new Object[]{0L, 0, 0}, WowoConnAction$GetLatestInteractActionRsp.class);
    public final PBUInt64Field friend_uin = PBField.initUInt64(0);
    public final PBUInt32Field master_action_id = PBField.initUInt32(0);
    public final PBUInt32Field guest_action_id = PBField.initUInt32(0);
}
