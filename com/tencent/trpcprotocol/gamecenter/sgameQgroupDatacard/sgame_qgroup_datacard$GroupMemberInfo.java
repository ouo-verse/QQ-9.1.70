package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$GroupMemberInfo extends MessageMicro<sgame_qgroup_datacard$GroupMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"uin", "ret", "msg", "grade", "gradeName", "gradeIcon"}, new Object[]{0L, 0, "", 0, "", ""}, sgame_qgroup_datacard$GroupMemberInfo.class);
    public final PBInt64Field uin = PBField.initInt64(0);
    public final PBInt32Field ret = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381297msg = PBField.initString("");
    public final PBEnumField grade = PBField.initEnum(0);
    public final PBStringField gradeName = PBField.initString("");
    public final PBStringField gradeIcon = PBField.initString("");
}
