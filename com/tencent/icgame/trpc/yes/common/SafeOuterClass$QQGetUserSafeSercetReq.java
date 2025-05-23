package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SafeOuterClass$QQGetUserSafeSercetReq extends MessageMicro<SafeOuterClass$QQGetUserSafeSercetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uin", "qq_user_id"}, new Object[]{0L, null}, SafeOuterClass$QQGetUserSafeSercetReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public CommonOuterClass$QQUserId qq_user_id = new CommonOuterClass$QQUserId();
}
