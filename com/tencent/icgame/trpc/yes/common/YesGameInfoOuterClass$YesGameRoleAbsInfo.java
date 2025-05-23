package com.tencent.icgame.trpc.yes.common;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$YesGameRoleAbsInfo extends MessageMicro<YesGameInfoOuterClass$YesGameRoleAbsInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 48, 58, 66, 72, 82, 88, 96}, new String[]{GdtGetUserInfoHandler.KEY_AREA, "partition", "role_name", "role_id", "logic_grade_level", "disp_grade_level", "grade_level_name", "grade_level_short_name", "role_level", "role_desc", "is_default", "big_grade_level"}, new Object[]{0, 0, "", "", 0, 0, "", "", 0, "", Boolean.FALSE, 0}, YesGameInfoOuterClass$YesGameRoleAbsInfo.class);
    public final PBUInt32Field area = PBField.initUInt32(0);
    public final PBUInt32Field partition = PBField.initUInt32(0);
    public final PBStringField role_name = PBField.initString("");
    public final PBStringField role_id = PBField.initString("");
    public final PBUInt32Field logic_grade_level = PBField.initUInt32(0);
    public final PBUInt32Field disp_grade_level = PBField.initUInt32(0);
    public final PBStringField grade_level_name = PBField.initString("");
    public final PBStringField grade_level_short_name = PBField.initString("");
    public final PBUInt32Field role_level = PBField.initUInt32(0);
    public final PBStringField role_desc = PBField.initString("");
    public final PBBoolField is_default = PBField.initBool(false);
    public final PBUInt32Field big_grade_level = PBField.initUInt32(0);
}
