package com.tencent.mobileqq.aio.msglist.holder.component.tofu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class oidb_0xe9b$QcircleImg extends MessageMicro<oidb_0xe9b$QcircleImg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"str_url", "is_pic", "str_jump"}, new Object[]{"", Boolean.FALSE, ""}, oidb_0xe9b$QcircleImg.class);
    public final PBStringField str_url = PBField.initString("");
    public final PBBoolField is_pic = PBField.initBool(false);
    public final PBStringField str_jump = PBField.initString("");
}
