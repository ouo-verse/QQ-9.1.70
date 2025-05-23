package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$StartLiveTopicRcmdRsp extends MessageMicro<NowQQLiveHomepageProto$StartLiveTopicRcmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_ret", "string_errmsg", "string_topic", "uint32_member_count"}, new Object[]{0, "", "", 0}, NowQQLiveHomepageProto$StartLiveTopicRcmdRsp.class);
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBStringField string_errmsg = PBField.initString("");
    public final PBStringField string_topic = PBField.initString("");
    public final PBUInt32Field uint32_member_count = PBField.initUInt32(0);
}
