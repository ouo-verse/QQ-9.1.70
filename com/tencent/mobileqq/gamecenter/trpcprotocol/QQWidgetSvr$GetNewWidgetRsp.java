package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$GetNewWidgetRsp extends MessageMicro<QQWidgetSvr$GetNewWidgetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42}, new String[]{AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "next_pull_time", "pull_gap", "widget_type", "battlepass_widget"}, new Object[]{null, 0L, 0L, 0, null}, QQWidgetSvr$GetNewWidgetRsp.class);
    public QQWidgetSvr$NewWidget widget = new QQWidgetSvr$NewWidget();
    public final PBInt64Field next_pull_time = PBField.initInt64(0);
    public final PBInt64Field pull_gap = PBField.initInt64(0);
    public final PBEnumField widget_type = PBField.initEnum(0);
    public QQWidgetSvr$BattlepassWidget battlepass_widget = new QQWidgetSvr$BattlepassWidget();
}
