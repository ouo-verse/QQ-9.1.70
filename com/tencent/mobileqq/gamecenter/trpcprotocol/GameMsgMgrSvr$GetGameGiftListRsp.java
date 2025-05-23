package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$GetGameGiftListRsp extends MessageMicro<GameMsgMgrSvr$GetGameGiftListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"gifts", "current_play_gift"}, new Object[]{null, null}, GameMsgMgrSvr$GetGameGiftListRsp.class);
    public final PBRepeatMessageField<GameMsgMgrSvr$Gift> gifts = PBField.initRepeatMessage(GameMsgMgrSvr$Gift.class);
    public GameMsgMgrSvr$Gift current_play_gift = new GameMsgMgrSvr$Gift();
}
