package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomSetOptionReq extends MessageMicro<YoloRoomOuterClass$YoloRoomSetOptionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{AudienceReportConst.ROOM_ID, "push_switch", "sound_switch"}, new Object[]{0L, null, null}, YoloRoomOuterClass$YoloRoomSetOptionReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public YoloRoomOuterClass$YoloRoomPushSwitch push_switch = new YoloRoomOuterClass$YoloRoomPushSwitch();
    public YoloRoomOuterClass$YoloRoomSoundSwitch sound_switch = new YoloRoomOuterClass$YoloRoomSoundSwitch();
}
