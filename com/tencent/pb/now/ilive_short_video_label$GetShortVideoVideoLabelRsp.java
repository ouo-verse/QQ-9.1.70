package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_short_video_label$GetShortVideoVideoLabelRsp extends MessageMicro<ilive_short_video_label$GetShortVideoVideoLabelRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "video_status", "feed_info", "video_info"}, new Object[]{0, null, null, null}, ilive_short_video_label$GetShortVideoVideoLabelRsp.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public ilive_short_video_label$VideoStatus video_status = new ilive_short_video_label$VideoStatus();
    public ilive_short_video_label$FeedInfo feed_info = new ilive_short_video_label$FeedInfo();
    public ilive_short_video_label$VideoInfo video_info = new ilive_short_video_label$VideoInfo();
}
