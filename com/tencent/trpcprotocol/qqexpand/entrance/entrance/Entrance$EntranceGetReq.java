package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Entrance$EntranceGetReq extends MessageMicro<Entrance$EntranceGetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{80000}, new String[]{"uin"}, new Object[]{0L}, Entrance$EntranceGetReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
