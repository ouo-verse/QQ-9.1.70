package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$GetShortVideoVideoLabelReq extends MessageMicro<ilive_short_video_label$GetShortVideoVideoLabelReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uid", "feed_id"}, new Object[]{0L, ByteStringMicro.EMPTY}, ilive_short_video_label$GetShortVideoVideoLabelReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
}
