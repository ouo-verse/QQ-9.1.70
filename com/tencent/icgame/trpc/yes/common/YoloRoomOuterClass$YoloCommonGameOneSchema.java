package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloCommonGameOneSchema extends MessageMicro<YoloRoomOuterClass$YoloCommonGameOneSchema> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uid", QZoneDTLoginReporter.SCHEMA, "launch_game", "user_id"}, new Object[]{0L, "", Boolean.FALSE, null}, YoloRoomOuterClass$YoloCommonGameOneSchema.class);
    public final PBInt64Field uid = PBField.initInt64(0);
    public final PBStringField schema = PBField.initString("");
    public final PBBoolField launch_game = PBField.initBool(false);
    public CommonOuterClass$QQUserId user_id = new CommonOuterClass$QQUserId();
}
