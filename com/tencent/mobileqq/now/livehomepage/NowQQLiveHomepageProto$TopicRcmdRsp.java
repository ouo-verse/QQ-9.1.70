package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$TopicRcmdRsp extends MessageMicro<NowQQLiveHomepageProto$TopicRcmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_ret", "string_errmsg", "string_offical_topics", "string_hot_topics"}, new Object[]{0, "", "", ""}, NowQQLiveHomepageProto$TopicRcmdRsp.class);
    public final PBRepeatField<String> string_hot_topics;
    public final PBRepeatField<String> string_offical_topics;
    public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
    public final PBStringField string_errmsg = PBField.initString("");

    public NowQQLiveHomepageProto$TopicRcmdRsp() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.string_offical_topics = PBField.initRepeat(pBStringField);
        this.string_hot_topics = PBField.initRepeat(pBStringField);
    }
}
