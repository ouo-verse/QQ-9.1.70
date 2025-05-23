package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$UserMsgInfo extends MessageMicro<NowQQLiveHomepageProto$UserMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "desc"}, new Object[]{0, ""}, NowQQLiveHomepageProto$UserMsgInfo.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
}
