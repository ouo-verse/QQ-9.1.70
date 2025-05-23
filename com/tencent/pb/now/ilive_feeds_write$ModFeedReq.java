package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$ModFeedReq extends MessageMicro<ilive_feeds_write$ModFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 50}, new String[]{QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_source", "feed_video", QCircleLpReportDc05507.KEY_PIC_INFO, "live_info", "chang_info"}, new Object[]{1, 0, null, null, null, null}, ilive_feeds_write$ModFeedReq.class);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBEnumField feed_source = PBField.initEnum(0);
    public ilive_feeds_tmem$VideoFeed feed_video = new ilive_feeds_tmem$VideoFeed();
    public ilive_feeds_tmem$PicFeed pic_info = new ilive_feeds_tmem$PicFeed();
    public ilive_feeds_tmem$LiveFeed live_info = new ilive_feeds_tmem$LiveFeed();
    public ilive_feeds_tmem$ChangFeed chang_info = new ilive_feeds_tmem$ChangFeed();
}
