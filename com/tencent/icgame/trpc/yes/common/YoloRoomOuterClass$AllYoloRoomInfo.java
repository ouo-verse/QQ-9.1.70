package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$AllYoloRoomInfo extends MessageMicro<YoloRoomOuterClass$AllYoloRoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{AegisLogger.ROOM_INFO, "speaking_pos_info_list", "online_num"}, new Object[]{null, null, 0}, YoloRoomOuterClass$AllYoloRoomInfo.class);
    public YoloRoomOuterClass$YoloRoomInfo room_info = new YoloRoomOuterClass$YoloRoomInfo();
    public final PBRepeatMessageField<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> speaking_pos_info_list = PBField.initRepeatMessage(YoloRoomOuterClass$YoloRoomSpeakingPosInfo.class);
    public final PBInt32Field online_num = PBField.initInt32(0);
}
