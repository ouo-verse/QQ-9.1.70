package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloRoomSoundSwitch extends MessageMicro<YoloRoomOuterClass$YoloRoomSoundSwitch> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_off_listen_sound"}, new Object[]{Boolean.FALSE}, YoloRoomOuterClass$YoloRoomSoundSwitch.class);
    public final PBBoolField is_off_listen_sound = PBField.initBool(false);
}
