package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$BattlepassWidget extends MessageMicro<QQWidgetSvr$BattlepassWidget> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"status", "task", "progress", "bottom", "jump_url"}, new Object[]{0, null, null, null, ""}, QQWidgetSvr$BattlepassWidget.class);
    public final PBEnumField status = PBField.initEnum(0);
    public QQWidgetSvr$BattlepassTask task = new QQWidgetSvr$BattlepassTask();
    public QQWidgetSvr$BattlepassProgress progress = new QQWidgetSvr$BattlepassProgress();
    public QQWidgetSvr$BattlepassBottom bottom = new QQWidgetSvr$BattlepassBottom();
    public final PBStringField jump_url = PBField.initString("");
}
