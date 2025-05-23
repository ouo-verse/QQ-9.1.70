package com.tencent.trpcprotocol.gamecenter.sgameSkinWall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_skin_wall$QualifyingDegreeInfo extends MessageMicro<sgame_skin_wall$QualifyingDegreeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 82}, new String[]{"qualifying", "degree", "star", "integral", "qualifying_degree", "icon_url"}, new Object[]{"", 0, 0, 0, 0, ""}, sgame_skin_wall$QualifyingDegreeInfo.class);
    public final PBStringField qualifying = PBField.initString("");
    public final PBInt32Field degree = PBField.initInt32(0);
    public final PBInt32Field star = PBField.initInt32(0);
    public final PBInt32Field integral = PBField.initInt32(0);
    public final PBInt32Field qualifying_degree = PBField.initInt32(0);
    public final PBStringField icon_url = PBField.initString("");
}
