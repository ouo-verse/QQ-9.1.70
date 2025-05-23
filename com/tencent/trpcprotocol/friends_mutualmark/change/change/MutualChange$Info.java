package com.tencent.trpcprotocol.friends_mutualmark.change.change;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class MutualChange$Info extends MessageMicro<MutualChange$Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 32}, new String[]{"level", "sub_level"}, new Object[]{0L, 0L}, MutualChange$Info.class);
    public final PBUInt64Field level = PBField.initUInt64(0);
    public final PBUInt64Field sub_level = PBField.initUInt64(0);
}
