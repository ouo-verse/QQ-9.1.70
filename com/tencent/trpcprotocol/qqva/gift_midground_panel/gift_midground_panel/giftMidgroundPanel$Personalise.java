package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$Personalise extends MessageMicro<giftMidgroundPanel$Personalise> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "live_info", CGNonAgeReport.EVENT_CHANNEL, "group_info"}, new Object[]{0, null, null, null}, giftMidgroundPanel$Personalise.class);
    public final PBEnumField type = PBField.initEnum(0);
    public giftMidgroundPanel$LivePersonalInfo live_info = new giftMidgroundPanel$LivePersonalInfo();
    public giftMidgroundPanel$ChannelPersonalInfo channel_info = new giftMidgroundPanel$ChannelPersonalInfo();
    public giftMidgroundPanel$GroupPersonalInfo group_info = new giftMidgroundPanel$GroupPersonalInfo();
}
