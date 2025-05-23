package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class GameLinkShareReportPB$ReportRule extends MessageMicro<GameLinkShareReportPB$ReportRule> {
    public static final int TYPE_BLACK = 1;
    public static final int TYPE_WHITE = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"full_domain_match", "regexp", "type"}, new Object[]{"", "", 0}, GameLinkShareReportPB$ReportRule.class);
    public final PBStringField full_domain_match = PBField.initString("");
    public final PBStringField regexp = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
}
