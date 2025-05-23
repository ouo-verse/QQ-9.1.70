package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq extends MessageMicro<GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"to_uin", "type", "ark_info", "roles"}, new Object[]{0L, 0, null, null}, GameCenterArkMsgSenderSvr$SendSgameCouponRedEnvelopeMsgReq.class);
    public final PBInt64Field to_uin = PBField.initInt64(0);
    public final PBEnumField type = PBField.initEnum(0);
    public GameCenterArkMsgSenderSvr$ArkData ark_info = new GameCenterArkMsgSenderSvr$ArkData();
    public GameCenterArkMsgSenderSvr$GameMsgRoles roles = new GameCenterArkMsgSenderSvr$GameMsgRoles();
}
