package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameFriendSelectorSvr$GetRoleByIDReq extends MessageMicro<GameFriendSelectorSvr$GetRoleByIDReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"id", "send_type"}, new Object[]{"", 0}, GameFriendSelectorSvr$GetRoleByIDReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f213221id = PBField.initString("");
    public final PBEnumField send_type = PBField.initEnum(0);
}
