package com.tencent.trpcprotocol.kuolie.message_list.message_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class message_list$GetMsgUnreadCountRsp extends MessageMicro<message_list$GetMsgUnreadCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"unread_count"}, new Object[]{0}, message_list$GetMsgUnreadCountRsp.class);
    public final PBUInt32Field unread_count = PBField.initUInt32(0);
}
