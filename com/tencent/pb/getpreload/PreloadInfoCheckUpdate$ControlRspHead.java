package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$ControlRspHead extends MessageMicro<PreloadInfoCheckUpdate$ControlRspHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"code", "err_msg"}, new Object[]{0, ""}, PreloadInfoCheckUpdate$ControlRspHead.class);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
