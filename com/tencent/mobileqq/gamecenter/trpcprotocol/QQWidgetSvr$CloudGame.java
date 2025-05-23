package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$CloudGame extends MessageMicro<QQWidgetSvr$CloudGame> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"appid", "jump_url", "icon", "text"}, new Object[]{"", "", "", ""}, QQWidgetSvr$CloudGame.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField text = PBField.initString("");
}
