package com.tencent.av.avsdkconfig.pb;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class CommonConfig$CertainAbility extends MessageMicro<CommonConfig$CertainAbility> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{AudienceReportConst.PROTOCOL, "codec_type", "ability_enum", "ability_info"}, new Object[]{0L, 0L, 0L, null}, CommonConfig$CertainAbility.class);

    /* renamed from: protocol, reason: collision with root package name */
    public final PBUInt64Field f73258protocol = PBField.initUInt64(0);
    public final PBUInt64Field codec_type = PBField.initUInt64(0);
    public final PBUInt64Field ability_enum = PBField.initUInt64(0);
    public final PBRepeatMessageField<CommonConfig$AbilityInfo> ability_info = PBField.initRepeatMessage(CommonConfig$AbilityInfo.class);
}
