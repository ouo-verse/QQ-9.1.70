package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes7.dex */
public final class PremadesTeamServerOuterClass$GuideBubbleInfo extends MessageMicro<PremadesTeamServerOuterClass$GuideBubbleInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"bubble_id", "proposal", QCircleLpReportDc05502.KEY_BEGIN_TIME, "is_show"}, new Object[]{0, "", 0L, Boolean.FALSE}, PremadesTeamServerOuterClass$GuideBubbleInfo.class);
    public final PBInt32Field bubble_id = PBField.initInt32(0);
    public final PBStringField proposal = PBField.initString("");
    public final PBInt64Field begin_time = PBField.initInt64(0);
    public final PBBoolField is_show = PBField.initBool(false);
}
