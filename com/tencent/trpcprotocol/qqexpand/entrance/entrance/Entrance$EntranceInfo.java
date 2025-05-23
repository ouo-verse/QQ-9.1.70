package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Entrance$EntranceInfo extends MessageMicro<Entrance$EntranceInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"id", "title", "subtitle", "icon_url", "backgroud_url", "jump_url"}, new Object[]{0, "", "", "", "", ""}, Entrance$EntranceInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f381596id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField subtitle = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField backgroud_url = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
