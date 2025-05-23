package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$Friend extends MessageMicro<GameFriendSelectorSvr$Friend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48}, new String[]{"id", "avatar", "role_name", "qq_nick", "intimacy_value", "intimacy_type"}, new Object[]{"", "", "", "", 0, 0}, GameFriendSelectorSvr$Friend.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213219id = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField role_name = PBField.initString("");
    public final PBStringField qq_nick = PBField.initString("");
    public final PBInt32Field intimacy_value = PBField.initInt32(0);
    public final PBInt32Field intimacy_type = PBField.initInt32(0);
}
