package com.tencent.trpcprotocol.friends_mutualmark.wear.wear;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes10.dex */
public final class wear$Req extends MessageMicro<wear$Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uin", "id", "action"}, new Object[]{0L, 0L, 0}, wear$Req.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f381296id = PBField.initUInt64(0);
    public final PBEnumField action = PBField.initEnum(0);
}
