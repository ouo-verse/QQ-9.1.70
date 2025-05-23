package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$DressKey extends MessageMicro<AvatarDressInfo$DressKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"original_dress_key", "dress_key", "dress_key_short"}, new Object[]{"", "", ""}, AvatarDressInfo$DressKey.class);
    public final PBStringField original_dress_key = PBField.initString("");
    public final PBStringField dress_key = PBField.initString("");
    public final PBStringField dress_key_short = PBField.initString("");
}
