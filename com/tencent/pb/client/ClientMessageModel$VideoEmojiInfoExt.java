package com.tencent.pb.client;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ClientMessageModel$VideoEmojiInfoExt extends MessageMicro<ClientMessageModel$VideoEmojiInfoExt> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_auther_uin"}, new Object[]{0L}, ClientMessageModel$VideoEmojiInfoExt.class);
    public final PBUInt64Field uint64_auther_uin = PBField.initUInt64(0);
}
