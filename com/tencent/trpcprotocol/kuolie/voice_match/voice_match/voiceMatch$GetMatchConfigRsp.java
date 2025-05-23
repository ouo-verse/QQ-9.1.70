package com.tencent.trpcprotocol.kuolie.voice_match.voice_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class voiceMatch$GetMatchConfigRsp extends MessageMicro<voiceMatch$GetMatchConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{"code", "msg", "remain_count", "max_loding_time", "max_enter_room_time"}, new Object[]{0, "", 0, 0L, 0L}, voiceMatch$GetMatchConfigRsp.class);
    public final PBEnumField code = PBField.initEnum(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381586msg = PBField.initString("");
    public final PBUInt32Field remain_count = PBField.initUInt32(0);
    public final PBUInt64Field max_loding_time = PBField.initUInt64(0);
    public final PBUInt64Field max_enter_room_time = PBField.initUInt64(0);
}
