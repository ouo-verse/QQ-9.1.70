package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aioMsg$SoulMatchData extends MessageMicro<aioMsg$SoulMatchData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"topic_id"}, new Object[]{0L}, aioMsg$SoulMatchData.class);
    public final PBInt64Field topic_id = PBField.initInt64(0);
}
