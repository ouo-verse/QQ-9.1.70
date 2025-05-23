package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$UserLabel extends MessageMicro<sgame_skin_wall$UserLabel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"category", "labels"}, new Object[]{"", ""}, sgame_skin_wall$UserLabel.class);
    public final PBStringField category = PBField.initString("");
    public final PBRepeatField<String> labels = PBField.initRepeat(PBStringField.__repeatHelper__);
}
