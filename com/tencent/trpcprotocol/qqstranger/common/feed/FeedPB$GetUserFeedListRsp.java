package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class FeedPB$GetUserFeedListRsp extends MessageMicro<FeedPB$GetUserFeedListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"feed_infos", "is_end", "cookies", "visable_count"}, new Object[]{null, Boolean.FALSE, ByteStringMicro.EMPTY, 0}, FeedPB$GetUserFeedListRsp.class);
    public final PBRepeatMessageField<FeedPB$Feed> feed_infos = PBField.initRepeatMessage(FeedPB$Feed.class);
    public final PBBoolField is_end = PBField.initBool(false);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field visable_count = PBField.initUInt32(0);
}
