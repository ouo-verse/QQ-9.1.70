package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$UserHeroInfo extends MessageMicro<sgame_qgroup_datacard$UserHeroInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"heroId", "icon", "skill"}, new Object[]{0L, "", 0}, sgame_qgroup_datacard$UserHeroInfo.class);
    public final PBInt64Field heroId = PBField.initInt64(0);
    public final PBStringField icon = PBField.initString("");
    public final PBEnumField skill = PBField.initEnum(0);
}
