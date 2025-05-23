package com.tencent.online.push.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$BindUinUnreadItem extends MessageMicro<OnlinePushField$BindUinUnreadItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1362408, 1362416, 1362426}, new String[]{"bind_uin_unread", "bind_uin", "cookie"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, OnlinePushField$BindUinUnreadItem.class);
    public final PBInt64Field bind_uin_unread = PBField.initInt64(0);
    public final PBInt64Field bind_uin = PBField.initInt64(0);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
}
