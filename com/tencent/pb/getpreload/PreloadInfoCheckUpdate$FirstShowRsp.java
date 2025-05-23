package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$FirstShowRsp extends MessageMicro<PreloadInfoCheckUpdate$FirstShowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "data"}, new Object[]{null, ""}, PreloadInfoCheckUpdate$FirstShowRsp.class);
    public PreloadInfoCheckUpdate$ControlRspHead head = new PreloadInfoCheckUpdate$ControlRspHead();
    public final PBStringField data = PBField.initString("");
}
