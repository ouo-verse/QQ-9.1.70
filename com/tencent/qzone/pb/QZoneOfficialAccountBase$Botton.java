package com.tencent.qzone.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class QZoneOfficialAccountBase$Botton extends MessageMicro<QZoneOfficialAccountBase$Botton> {
    public static final int BOTTON_TYPE_INVALID = 0;
    public static final int BOTTON_TYPE_ON_RIGHT_BOTTOM = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"id", "botton_type", "caption", "background_img", "jump_url"}, new Object[]{"", 0, "", "", ""}, QZoneOfficialAccountBase$Botton.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f364013id = PBField.initString("");
    public final PBEnumField botton_type = PBField.initEnum(0);
    public final PBStringField caption = PBField.initString("");
    public final PBStringField background_img = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
