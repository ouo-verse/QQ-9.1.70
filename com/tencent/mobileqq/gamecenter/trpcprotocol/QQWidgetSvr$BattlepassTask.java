package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$BattlepassTask extends MessageMicro<QQWidgetSvr$BattlepassTask> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"desc", "exp_item", "current_exp", "total_exp", "task_name"}, new Object[]{"", "", 0, 0, ""}, QQWidgetSvr$BattlepassTask.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField exp_item = PBField.initString("");
    public final PBInt32Field current_exp = PBField.initInt32(0);
    public final PBInt32Field total_exp = PBField.initInt32(0);
    public final PBStringField task_name = PBField.initString("");
}
