package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$LivePersonalInfo extends MessageMicro<giftMidgroundPanel$LivePersonalInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"source", "game_type", AudienceReportConst.ANCHOR_ID}, new Object[]{"", "", ""}, giftMidgroundPanel$LivePersonalInfo.class);
    public final PBStringField source = PBField.initString("");
    public final PBStringField game_type = PBField.initString("");
    public final PBStringField anchor_id = PBField.initString("");
}
