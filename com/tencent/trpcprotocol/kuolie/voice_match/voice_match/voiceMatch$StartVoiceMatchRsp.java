package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$StartVoiceMatchRsp extends MessageMicro<voiceMatch$StartVoiceMatchRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50}, new String[]{"code", "msg", AudienceReportConst.ROOM_ID, "owner", "matched_user", "sign"}, new Object[]{0, "", 0, null, null, ByteStringMicro.EMPTY}, voiceMatch$StartVoiceMatchRsp.class);
    public final PBEnumField code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381588msg = PBField.initString("");
    public final PBInt32Field room_id = PBField.initInt32(0);
    public voiceMatch$MatchUser owner = new voiceMatch$MatchUser();
    public voiceMatch$MatchUser matched_user = new voiceMatch$MatchUser();
    public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
}
