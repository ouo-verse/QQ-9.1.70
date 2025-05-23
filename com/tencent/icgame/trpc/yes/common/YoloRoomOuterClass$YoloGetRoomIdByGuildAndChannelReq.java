package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YoloRoomOuterClass$YoloGetRoomIdByGuildAndChannelReq extends MessageMicro<YoloRoomOuterClass$YoloGetRoomIdByGuildAndChannelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{48, 56}, new String[]{"guild_id", "channel_id"}, new Object[]{0L, 0L}, YoloRoomOuterClass$YoloGetRoomIdByGuildAndChannelReq.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field channel_id = PBField.initUInt64(0);
}
