package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$GameRoleAbsInfo extends MessageMicro<GameDataServerOuterClass$GameRoleAbsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 56, 66}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "role_name", "register_time", "grade_level", "ranking_star", "pvplevel", "head_url"}, new Object[]{0, 0, "", 0, 0, 0, 0, ""}, GameDataServerOuterClass$GameRoleAbsInfo.class);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBStringField role_name = PBField.initString("");
    public final PBUInt32Field register_time = PBField.initUInt32(0);
    public final PBInt32Field grade_level = PBField.initInt32(0);
    public final PBInt32Field ranking_star = PBField.initInt32(0);
    public final PBInt32Field pvplevel = PBField.initInt32(0);
    public final PBStringField head_url = PBField.initString("");
}
