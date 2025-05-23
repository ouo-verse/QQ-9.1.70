package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class Hongbao$HbEntry extends MessageMicro<Hongbao$HbEntry> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50}, new String[]{"id", "title", "aio_scene", "hb_entry_type", "icon_url", "params"}, new Object[]{"", "", 0L, 0, "", ""}, Hongbao$HbEntry.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f278695id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt64Field aio_scene = PBField.initUInt64(0);
    public final PBEnumField hb_entry_type = PBField.initEnum(0);
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField params = PBField.initString("");
}
