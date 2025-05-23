package com.tencent.trpcprotocol.minigame.user_encryption_svr.user_encryption_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userEncryptionSvr$GetUserEncryptKeyRsp extends MessageMicro<userEncryptionSvr$GetUserEncryptKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"key_info_list"}, new Object[]{null}, userEncryptionSvr$GetUserEncryptKeyRsp.class);
    public final PBRepeatMessageField<userEncryptionSvr$KeyInfo> key_info_list = PBField.initRepeatMessage(userEncryptionSvr$KeyInfo.class);
}
