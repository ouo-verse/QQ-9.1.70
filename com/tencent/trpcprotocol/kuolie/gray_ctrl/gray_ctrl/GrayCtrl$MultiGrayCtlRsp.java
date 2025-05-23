package com.tencent.trpcprotocol.kuolie.gray_ctrl.gray_ctrl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class GrayCtrl$MultiGrayCtlRsp extends MessageMicro<GrayCtrl$MultiGrayCtlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "game_infos"}, new Object[]{0, "", null}, GrayCtrl$MultiGrayCtlRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<GrayCtrl$GameInfo> game_infos = PBField.initRepeatMessage(GrayCtrl$GameInfo.class);
}
