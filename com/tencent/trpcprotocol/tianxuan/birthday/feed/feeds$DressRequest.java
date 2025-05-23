package com.tencent.trpcprotocol.tianxuan.birthday.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class feeds$DressRequest extends MessageMicro<feeds$DressRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"act_id", "rule_id", "qzone_share"}, new Object[]{"", "", Boolean.FALSE}, feeds$DressRequest.class);
    public final PBStringField act_id = PBField.initString("");
    public final PBStringField rule_id = PBField.initString("");
    public final PBBoolField qzone_share = PBField.initBool(false);
}
