package com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userEncryptionSvr$GetLatestUserKeyRsp extends MessageMicro<userEncryptionSvr$GetLatestUserKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"key_info"}, new Object[]{null}, userEncryptionSvr$GetLatestUserKeyRsp.class);
    public userEncryptionSvr$KeyInfo key_info = new userEncryptionSvr$KeyInfo();
}
