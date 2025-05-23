package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* loaded from: classes12.dex */
public final class GameCenterRobotReport$ExtParam extends MessageMicro<GameCenterRobotReport$ExtParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"name", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, GameCenterRobotReport$ExtParam.class);
    public final PBStringField name = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
