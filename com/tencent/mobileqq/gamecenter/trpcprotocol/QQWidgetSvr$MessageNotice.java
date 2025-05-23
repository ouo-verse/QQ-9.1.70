package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$MessageNotice extends MessageMicro<QQWidgetSvr$MessageNotice> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"msg", "unique_id", "jump_url", "id"}, new Object[]{"", "", "", ""}, QQWidgetSvr$MessageNotice.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f213227msg = PBField.initString("");
    public final PBStringField unique_id = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213226id = PBField.initString("");
}
