package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes12.dex */
public final class GameLinkShareReportPB$GetReportRulesRsp extends MessageMicro<GameLinkShareReportPB$GetReportRulesRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 17}, new String[]{"rules", IjkMediaMeta.IJKM_KEY_SAMPLE_RATE}, new Object[]{null, Double.valueOf(0.0d)}, GameLinkShareReportPB$GetReportRulesRsp.class);
    public final PBRepeatMessageField<GameLinkShareReportPB$ReportRule> rules = PBField.initRepeatMessage(GameLinkShareReportPB$ReportRule.class);
    public final PBDoubleField sample_rate = PBField.initDouble(0.0d);
}
