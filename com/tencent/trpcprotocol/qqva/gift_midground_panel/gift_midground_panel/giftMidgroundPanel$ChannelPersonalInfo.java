package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$ChannelPersonalInfo extends MessageMicro<giftMidgroundPanel$ChannelPersonalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"source", "version", "channel_id"}, new Object[]{"", "", ""}, giftMidgroundPanel$ChannelPersonalInfo.class);
    public final PBStringField source = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField channel_id = PBField.initString("");
}
