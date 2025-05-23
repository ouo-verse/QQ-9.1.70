package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class GameDataServerOuterClass$SmobaBigGradeLevel extends MessageMicro<GameDataServerOuterClass$SmobaBigGradeLevel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"big_grade_level", "level_name", "merge_show", "merge_show_begin", "merge_show_end", "short_level_name"}, new Object[]{0, "", 0, "", "", ""}, GameDataServerOuterClass$SmobaBigGradeLevel.class);
    public final PBInt32Field big_grade_level = PBField.initInt32(0);
    public final PBStringField level_name = PBField.initString("");
    public final PBInt32Field merge_show = PBField.initInt32(0);
    public final PBStringField merge_show_begin = PBField.initString("");
    public final PBStringField merge_show_end = PBField.initString("");
    public final PBStringField short_level_name = PBField.initString("");
}
