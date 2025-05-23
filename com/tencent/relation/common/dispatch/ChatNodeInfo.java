package com.tencent.relation.common.dispatch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ChatNodeInfo extends MessageMicro<ChatNodeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"to_tinyid"}, new Object[]{0L}, ChatNodeInfo.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
}
