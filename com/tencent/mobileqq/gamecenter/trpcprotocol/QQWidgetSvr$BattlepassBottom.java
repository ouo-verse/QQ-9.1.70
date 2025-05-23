package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$BattlepassBottom extends MessageMicro<QQWidgetSvr$BattlepassBottom> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"exp_item", "prize_name_level", "icon", "desc"}, new Object[]{"", "", "", ""}, QQWidgetSvr$BattlepassBottom.class);
    public final PBStringField exp_item = PBField.initString("");
    public final PBStringField prize_name_level = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
}
