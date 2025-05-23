package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$ChannelStateInfo extends MessageMicro<cmd0xf88$ChannelStateInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"state", "priority"}, new Object[]{0, 0}, cmd0xf88$ChannelStateInfo.class);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBUInt32Field priority = PBField.initUInt32(0);
}
