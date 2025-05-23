package com.tencent.mobileqq.avifcodec.config.pb;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AvifCodecConfig$CertainAbility extends MessageMicro<AvifCodecConfig$CertainAbility> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{AudienceReportConst.PROTOCOL, "codec_type", "ability_enum", "ability_info"}, new Object[]{0L, 0L, 0L, null}, AvifCodecConfig$CertainAbility.class);

    /* renamed from: protocol, reason: collision with root package name */
    public final PBUInt64Field f200173protocol = PBField.initUInt64(0);
    public final PBUInt64Field codec_type = PBField.initUInt64(0);
    public final PBUInt64Field ability_enum = PBField.initUInt64(0);
    public final PBRepeatMessageField<AvifCodecConfig$AbilityInfo> ability_info = PBField.initRepeatMessage(AvifCodecConfig$AbilityInfo.class);
}
