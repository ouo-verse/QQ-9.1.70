package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class PreloadInfoCheckUpdate$PreloadInfoReq extends MessageMicro<PreloadInfoCheckUpdate$PreloadInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"head", "app_behavior"}, new Object[]{null, null}, PreloadInfoCheckUpdate$PreloadInfoReq.class);
    public PreloadInfoCheckUpdate$ControlReqHead head = new PreloadInfoCheckUpdate$ControlReqHead();
    public final PBRepeatMessageField<PreloadInfoCheckUpdate$AppBehavior> app_behavior = PBField.initRepeatMessage(PreloadInfoCheckUpdate$AppBehavior.class);
}
