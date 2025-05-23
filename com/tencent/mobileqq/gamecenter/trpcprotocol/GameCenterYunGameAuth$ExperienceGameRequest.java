package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$ExperienceGameRequest extends MessageMicro<GameCenterYunGameAuth$ExperienceGameRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"appids", "plat"}, new Object[]{"", 0}, GameCenterYunGameAuth$ExperienceGameRequest.class);
    public final PBRepeatField<String> appids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField plat = PBField.initEnum(0);
}
