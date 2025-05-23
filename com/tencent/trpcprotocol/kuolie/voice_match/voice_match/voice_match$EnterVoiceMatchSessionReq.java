package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class voice_match$EnterVoiceMatchSessionReq extends MessageMicro<voice_match$EnterVoiceMatchSessionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 64}, new String[]{AudienceReportConst.ROOM_ID, "sign", "max_waiting_time", INetChannelCallback.KEY_TINY_ID, "open_id", "nickname", "avatar", "self_tiny_id"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L, "", "", "", 0L}, voice_match$EnterVoiceMatchSessionReq.class);
    public final PBInt32Field room_id = PBField.initInt32(0);
    public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field max_waiting_time = PBField.initUInt64(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField open_id = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBUInt64Field self_tiny_id = PBField.initUInt64(0);
}
