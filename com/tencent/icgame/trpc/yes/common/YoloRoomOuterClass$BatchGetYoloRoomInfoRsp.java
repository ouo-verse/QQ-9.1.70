package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$BatchGetYoloRoomInfoRsp extends MessageMicro<YoloRoomOuterClass$BatchGetYoloRoomInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"all_room_info"}, new Object[]{null}, YoloRoomOuterClass$BatchGetYoloRoomInfoRsp.class);
    public final PBRepeatMessageField<YoloRoomOuterClass$AllYoloRoomInfo> all_room_info = PBField.initRepeatMessage(YoloRoomOuterClass$AllYoloRoomInfo.class);
}
