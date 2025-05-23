package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloBattleQsmOuterClass$YoloQSMOneSchema extends MessageMicro<YoloBattleQsmOuterClass$YoloQSMOneSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 82}, new String[]{"uid", "game_openid", QZoneDTLoginReporter.SCHEMA}, new Object[]{0L, "", ""}, YoloBattleQsmOuterClass$YoloQSMOneSchema.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBStringField game_openid = PBField.initString("");
    public final PBStringField schema = PBField.initString("");
}
