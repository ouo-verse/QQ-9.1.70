package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveHomepageProto$RcmdTopicOrVideo extends MessageMicro<NowQQLiveHomepageProto$RcmdTopicOrVideo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34, 42, 48, 58, 66, 72, 80}, new String[]{"topic_word", "topic_word_color", "pic", "url", "type", "native_url", "pic_samll", "color_a", "color_b"}, new Object[]{"", 0, "", "", 0, "", "", 0L, 0L}, NowQQLiveHomepageProto$RcmdTopicOrVideo.class);
    public final PBStringField topic_word = PBField.initString("");
    public final PBUInt32Field topic_word_color = PBField.initUInt32(0);
    public final PBStringField pic = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField native_url = PBField.initString("");
    public final PBStringField pic_samll = PBField.initString("");
    public final PBUInt64Field color_a = PBField.initUInt64(0);
    public final PBUInt64Field color_b = PBField.initUInt64(0);
}
