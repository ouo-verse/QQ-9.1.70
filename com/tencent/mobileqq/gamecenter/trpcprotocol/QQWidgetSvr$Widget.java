package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$Widget extends MessageMicro<QQWidgetSvr$Widget> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"id", "pic", "beg_ts", "end_ts", "jump_url"}, new Object[]{"", "", 0L, 0L, ""}, QQWidgetSvr$Widget.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213229id = PBField.initString("");
    public final PBStringField pic = PBField.initString("");
    public final PBInt64Field beg_ts = PBField.initInt64(0);
    public final PBInt64Field end_ts = PBField.initInt64(0);
    public final PBStringField jump_url = PBField.initString("");
}
