package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes12.dex */
public final class GameLinkShareReportPB$ReportReq extends MessageMicro<GameLinkShareReportPB$ReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"items"}, new Object[]{null}, GameLinkShareReportPB$ReportReq.class);
    public final PBRepeatMessageField<GameLinkShareReportPB$ReportItem> items = PBField.initRepeatMessage(GameLinkShareReportPB$ReportItem.class);
}
