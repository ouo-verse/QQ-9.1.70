package com.tencent.mobileqq.search.business.game;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class GameCenterSearchGame$UnifySearchGameRsp extends MessageMicro<GameCenterSearchGame$UnifySearchGameRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"games"}, new Object[]{null}, GameCenterSearchGame$UnifySearchGameRsp.class);
    public final PBRepeatMessageField<GameCenterSearchGame$UnifyGameInfo> games = PBField.initRepeatMessage(GameCenterSearchGame$UnifyGameInfo.class);
}
