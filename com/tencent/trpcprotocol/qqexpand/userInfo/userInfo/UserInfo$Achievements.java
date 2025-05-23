package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserInfo$Achievements extends MessageMicro<UserInfo$Achievements> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 42}, new String[]{"id", "title", "icon", "content"}, new Object[]{"", "", "", ""}, UserInfo$Achievements.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f381598id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
