package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp extends MessageMicro<trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40}, new String[]{"ret_code", "ret_msg", "appid", "openid", "sub_source_id"}, new Object[]{0, "", 0L, "", 0}, trpcNearbyAccount$SsoGetOpenIDByTinyIDRsp.class);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field sub_source_id = PBField.initUInt32(0);
}
