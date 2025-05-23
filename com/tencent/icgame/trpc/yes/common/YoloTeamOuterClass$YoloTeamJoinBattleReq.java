package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloTeamOuterClass$YoloTeamJoinBattleReq extends MessageMicro<YoloTeamOuterClass$YoloTeamJoinBattleReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"team_id", IPhotoLogicFactory.ENTER_FROM, "game_id", "show_info"}, new Object[]{0L, 0, 0, null}, YoloTeamOuterClass$YoloTeamJoinBattleReq.class);
    public final PBUInt64Field team_id = PBField.initUInt64(0);
    public final PBInt32Field enter_from = PBField.initInt32(0);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public YoloTeamOuterClass$YoloTeamUserShowInfo show_info = new YoloTeamOuterClass$YoloTeamUserShowInfo();
}
