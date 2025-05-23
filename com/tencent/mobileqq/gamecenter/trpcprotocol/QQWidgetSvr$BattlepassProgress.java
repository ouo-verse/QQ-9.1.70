package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes12.dex */
public final class QQWidgetSvr$BattlepassProgress extends MessageMicro<QQWidgetSvr$BattlepassProgress> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"icon", "level", "progress", "is_advanced"}, new Object[]{"", 0, 0, Boolean.FALSE}, QQWidgetSvr$BattlepassProgress.class);
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBInt32Field progress = PBField.initInt32(0);
    public final PBBoolField is_advanced = PBField.initBool(false);
}
