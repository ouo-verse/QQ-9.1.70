package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$YesGameRoleAchievement extends MessageMicro<YesGameInfoOuterClass$YesGameRoleAchievement> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"icon", "type", "text", "background"}, new Object[]{"", 0, "", ""}, YesGameInfoOuterClass$YesGameRoleAchievement.class);
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField background = PBField.initString("");
}
