package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import s4.c;

/* loaded from: classes38.dex */
public final class FeedPB$PublishFeedReq extends MessageMicro<FeedPB$PublishFeedReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"text_content", c.PICS, MessageForRichState.SIGN_MSG_TOPICS, QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "publish_src", "publish_scene"}, new Object[]{ByteStringMicro.EMPTY, null, null, 0, 0, 0}, FeedPB$PublishFeedReq.class);
    public final PBBytesField text_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedPB$StImage> pics = PBField.initRepeatMessage(FeedPB$StImage.class);
    public final PBRepeatMessageField<FeedPB$Topic> topics = PBField.initRepeatMessage(FeedPB$Topic.class);
    public final PBEnumField feed_type = PBField.initEnum(0);
    public final PBEnumField publish_src = PBField.initEnum(0);
    public final PBEnumField publish_scene = PBField.initEnum(0);
}
