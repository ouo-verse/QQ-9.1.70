package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SmobaDataOuterClass$YoloMultiGameEnd extends MessageMicro<SmobaDataOuterClass$YoloMultiGameEnd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 106, 112}, new String[]{RoomServiceConstants.PARAMS_GAME_ID, "battleid", "campsettlelist", "eventtime"}, new Object[]{0, "", null, 0}, SmobaDataOuterClass$YoloMultiGameEnd.class);
    public final PBInt32Field gameid = PBField.initInt32(0);
    public final PBStringField battleid = PBField.initString("");
    public final PBRepeatMessageField<SmobaDataOuterClass$GameCampSettleInfo> campsettlelist = PBField.initRepeatMessage(SmobaDataOuterClass$GameCampSettleInfo.class);
    public final PBUInt32Field eventtime = PBField.initUInt32(0);
}
