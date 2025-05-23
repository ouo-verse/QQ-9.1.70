package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$AuthorizeRequest extends MessageMicro<GameDataAuthorizeSvr$AuthorizeRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"app_id", "authoritys", "source"}, new Object[]{"", null, 0}, GameDataAuthorizeSvr$AuthorizeRequest.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBRepeatMessageField<GameDataAuthorizeSvr$Authorization> authoritys = PBField.initRepeatMessage(GameDataAuthorizeSvr$Authorization.class);
    public final PBEnumField source = PBField.initEnum(0);
}
