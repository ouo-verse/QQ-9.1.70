package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$EmptyInfo extends MessageMicro<giftMidgroundPanel$EmptyInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"empty_msg", "button", "url"}, new Object[]{"", "", ""}, giftMidgroundPanel$EmptyInfo.class);
    public final PBStringField empty_msg = PBField.initString("");
    public final PBStringField button = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
