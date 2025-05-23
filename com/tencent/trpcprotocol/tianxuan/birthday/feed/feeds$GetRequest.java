package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds$GetRequest extends MessageMicro<feeds$GetRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, feeds$GetRequest.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
