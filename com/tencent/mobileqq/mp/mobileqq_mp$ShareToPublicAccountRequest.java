package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$ShareToPublicAccountRequest extends MessageMicro<mobileqq_mp$ShareToPublicAccountRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uin", "url", "luin"}, new Object[]{0, "", 0L}, mobileqq_mp$ShareToPublicAccountRequest.class);
    public final PBUInt32Field uin = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt64Field luin = PBField.initUInt64(0);
}
