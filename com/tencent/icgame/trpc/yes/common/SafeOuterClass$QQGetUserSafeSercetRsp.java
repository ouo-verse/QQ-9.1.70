package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class SafeOuterClass$QQGetUserSafeSercetRsp extends MessageMicro<SafeOuterClass$QQGetUserSafeSercetRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uin_key", "aes_decrypt_key"}, new Object[]{"", ""}, SafeOuterClass$QQGetUserSafeSercetRsp.class);
    public final PBStringField uin_key = PBField.initString("");
    public final PBStringField aes_decrypt_key = PBField.initString("");
}
