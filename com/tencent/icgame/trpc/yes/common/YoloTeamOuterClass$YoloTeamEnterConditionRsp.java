package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloTeamOuterClass$YoloTeamEnterConditionRsp extends MessageMicro<YoloTeamOuterClass$YoloTeamEnterConditionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QZoneDTLoginReporter.SCHEMA}, new Object[]{""}, YoloTeamOuterClass$YoloTeamEnterConditionRsp.class);
    public final PBStringField schema = PBField.initString("");
}
