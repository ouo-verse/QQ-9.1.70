package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameMsgMgrSvr$GetMsgBoxGameListRsp extends MessageMicro<GameMsgMgrSvr$GetMsgBoxGameListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"games"}, new Object[]{null}, GameMsgMgrSvr$GetMsgBoxGameListRsp.class);
    public final PBRepeatMessageField<GameMsgMgrSvr$GameDetail> games = PBField.initRepeatMessage(GameMsgMgrSvr$GameDetail.class);
}
