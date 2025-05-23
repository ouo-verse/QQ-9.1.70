package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$GroupPersonalInfo extends MessageMicro<giftMidgroundPanel$GroupPersonalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"source", "version", "group_id"}, new Object[]{"", "", ""}, giftMidgroundPanel$GroupPersonalInfo.class);
    public final PBStringField source = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
}
