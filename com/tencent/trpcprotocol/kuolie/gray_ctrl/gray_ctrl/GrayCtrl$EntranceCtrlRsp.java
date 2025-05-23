package com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class GrayCtrl$EntranceCtrlRsp extends MessageMicro<GrayCtrl$EntranceCtrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"ret_code", "display"}, new Object[]{0, Boolean.FALSE}, GrayCtrl$EntranceCtrlRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBBoolField display = PBField.initBool(false);
}
