package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GetTeamConfigRsp extends MessageMicro<YesGameInfoOuterClass$GetTeamConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"game_id", "team_info"}, new Object[]{0, null}, YesGameInfoOuterClass$GetTeamConfigRsp.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public YesGameInfoOuterClass$GameConfigTeamInfo team_info = new YesGameInfoOuterClass$GameConfigTeamInfo();
}
