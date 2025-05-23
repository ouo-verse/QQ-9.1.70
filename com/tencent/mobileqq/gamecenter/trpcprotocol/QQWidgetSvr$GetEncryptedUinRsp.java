package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class QQWidgetSvr$GetEncryptedUinRsp extends MessageMicro<QQWidgetSvr$GetEncryptedUinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"encrypted_uin"}, new Object[]{""}, QQWidgetSvr$GetEncryptedUinRsp.class);
    public final PBStringField encrypted_uin = PBField.initString("");
}
