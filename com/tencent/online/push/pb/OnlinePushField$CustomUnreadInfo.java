package com.tencent.online.push.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class OnlinePushField$CustomUnreadInfo extends MessageMicro<OnlinePushField$CustomUnreadInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{1364808, 1364816, 1364824, 1364832}, new String[]{"type", "key", "unread", "status"}, new Object[]{0, 0L, 0, 0}, OnlinePushField$CustomUnreadInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBInt64Field key = PBField.initInt64(0);
    public final PBUInt32Field unread = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
}
