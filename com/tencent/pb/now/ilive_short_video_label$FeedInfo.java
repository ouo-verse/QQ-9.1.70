package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$FeedInfo extends MessageMicro<ilive_short_video_label$FeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"feed_id", "topic", "url"}, new Object[]{ByteStringMicro.EMPTY, "", ""}, ilive_short_video_label$FeedInfo.class);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField topic = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
