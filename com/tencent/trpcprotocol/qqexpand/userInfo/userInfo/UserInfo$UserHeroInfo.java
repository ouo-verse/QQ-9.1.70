package com.tencent.trpcprotocol.qqexpand.userInfo.userInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserInfo$UserHeroInfo extends MessageMicro<UserInfo$UserHeroInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"hero_id", "icon", "skill"}, new Object[]{0L, "", 0}, UserInfo$UserHeroInfo.class);
    public final PBInt64Field hero_id = PBField.initInt64(0);
    public final PBStringField icon = PBField.initString("");
    public final PBEnumField skill = PBField.initEnum(0);
}
