package com.tencent.online.push.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$SpecialMessageUnRead extends MessageMicro<OnlinePushField$SpecialMessageUnRead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1363208, 1363216}, new String[]{"bind_uin_unread", "unread_number"}, new Object[]{0, 0}, OnlinePushField$SpecialMessageUnRead.class);
    public final PBInt32Field bind_uin_unread = PBField.initInt32(0);
    public final PBInt32Field unread_number = PBField.initInt32(0);
}
