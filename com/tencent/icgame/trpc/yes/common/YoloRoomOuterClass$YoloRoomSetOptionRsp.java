package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomSetOptionRsp extends MessageMicro<YoloRoomOuterClass$YoloRoomSetOptionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"push_switch", "sound_switch"}, new Object[]{null, null}, YoloRoomOuterClass$YoloRoomSetOptionRsp.class);
    public YoloRoomOuterClass$YoloRoomPushSwitch push_switch = new YoloRoomOuterClass$YoloRoomPushSwitch();
    public YoloRoomOuterClass$YoloRoomSoundSwitch sound_switch = new YoloRoomOuterClass$YoloRoomSoundSwitch();
}
