package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$WelfareInfo extends MessageMicro<giftMidgroundPanel$WelfareInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"is_open", "url", "tab_name"}, new Object[]{Boolean.FALSE, "", ""}, giftMidgroundPanel$WelfareInfo.class);
    public final PBBoolField is_open = PBField.initBool(false);
    public final PBStringField url = PBField.initString("");
    public final PBStringField tab_name = PBField.initString("");
}
