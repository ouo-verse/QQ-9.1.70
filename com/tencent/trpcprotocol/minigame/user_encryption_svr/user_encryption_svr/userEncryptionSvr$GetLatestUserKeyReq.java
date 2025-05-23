package com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userEncryptionSvr$GetLatestUserKeyReq extends MessageMicro<userEncryptionSvr$GetLatestUserKeyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_id"}, new Object[]{""}, userEncryptionSvr$GetLatestUserKeyReq.class);
    public final PBStringField app_id = PBField.initString("");
}
