package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameDataAuthorizeSvr$GetVisibleRangeReply extends MessageMicro<GameDataAuthorizeSvr$GetVisibleRangeReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"authoritys", "jump_url", "bottom_remarks", "qq_status", "login_guide"}, new Object[]{null, "", "", 0, null}, GameDataAuthorizeSvr$GetVisibleRangeReply.class);
    public final PBRepeatMessageField<GameDataAuthorizeSvr$Authorization> authoritys = PBField.initRepeatMessage(GameDataAuthorizeSvr$Authorization.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField bottom_remarks = PBField.initString("");
    public final PBEnumField qq_status = PBField.initEnum(0);
    public GameDataAuthorizeSvr$LoginGuide login_guide = new GameDataAuthorizeSvr$LoginGuide();
}
