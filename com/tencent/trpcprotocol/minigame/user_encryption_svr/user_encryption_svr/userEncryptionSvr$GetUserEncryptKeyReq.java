package com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userEncryptionSvr$GetUserEncryptKeyReq extends MessageMicro<userEncryptionSvr$GetUserEncryptKeyReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_id", "open_id"}, new Object[]{"", ""}, userEncryptionSvr$GetUserEncryptKeyReq.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField open_id = PBField.initString("");
}
