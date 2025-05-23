package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class GameCenterYunGameAuth$ExperienceGameResponse extends MessageMicro<GameCenterYunGameAuth$ExperienceGameResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"infos"}, new Object[]{null}, GameCenterYunGameAuth$ExperienceGameResponse.class);
    public final PBRepeatMessageField<Info> infos = PBField.initRepeatMessage(Info.class);

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class Info extends MessageMicro<Info> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"appid", "allow", "hippy_link"}, new Object[]{"", Boolean.FALSE, ""}, Info.class);
        public final PBStringField appid = PBField.initString("");
        public final PBBoolField allow = PBField.initBool(false);
        public final PBStringField hippy_link = PBField.initString("");
    }
}
