package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$Location extends MessageMicro<UserProxyCmdOuterClass$Location> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"longitude", "latitude"}, new Object[]{0, 0}, UserProxyCmdOuterClass$Location.class);
    public final PBInt32Field longitude = PBField.initInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
}
