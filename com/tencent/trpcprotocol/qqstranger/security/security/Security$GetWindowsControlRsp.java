package com.tencent.trpcprotocol.qqstranger.security.security;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class Security$GetWindowsControlRsp extends MessageMicro<Security$GetWindowsControlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "window_infos"}, new Object[]{0, "", null}, Security$GetWindowsControlRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<Security$WindowInfo> window_infos = PBField.initRepeatMessage(Security$WindowInfo.class);
}
