package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_0xe9b$QCircle extends MessageMicro<oidb_0xe9b$QCircle> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"rpt_msg_imgs", "ext"}, new Object[]{null, ""}, oidb_0xe9b$QCircle.class);
    public final PBRepeatMessageField<oidb_0xe9b$QcircleImg> rpt_msg_imgs = PBField.initRepeatMessage(oidb_0xe9b$QcircleImg.class);
    public final PBStringField ext = PBField.initString("");
}
