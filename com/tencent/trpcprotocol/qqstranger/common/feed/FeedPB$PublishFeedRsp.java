package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$PublishFeedRsp extends MessageMicro<FeedPB$PublishFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "msg", "feed"}, new Object[]{0, "", null}, FeedPB$PublishFeedRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f381609msg = PBField.initString("");
    public FeedPB$Feed feed = new FeedPB$Feed();
}
