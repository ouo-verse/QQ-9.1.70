package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CommonOuterClass$QQUserId extends MessageMicro<CommonOuterClass$QQUserId> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uid", WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "guild_id", "yes_uid"}, new Object[]{0L, 0, 0L, 0L}, CommonOuterClass$QQUserId.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field user_from = PBField.initInt32(0);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field yes_uid = PBField.initUInt64(0);
}
