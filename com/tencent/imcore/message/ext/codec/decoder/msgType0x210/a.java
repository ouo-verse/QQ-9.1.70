package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.g;
import com.tencent.mobileqq.data.MessageRecord;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface a<T extends com.tencent.imcore.message.g> {
    MessageRecord decode(T t16, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo);
}
