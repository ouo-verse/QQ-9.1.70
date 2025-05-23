package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$FirstShowReq extends MessageMicro<PreloadInfoCheckUpdate$FirstShowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"head", "appid"}, new Object[]{null, 0}, PreloadInfoCheckUpdate$FirstShowReq.class);
    public PreloadInfoCheckUpdate$ControlReqHead head = new PreloadInfoCheckUpdate$ControlReqHead();
    public final PBInt32Field appid = PBField.initInt32(0);
}
