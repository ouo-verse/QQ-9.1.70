package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import cooperation.qzone.QZoneHelper;

/* loaded from: classes38.dex */
public final class FeedPB$GetLikeInfoRsp extends MessageMicro<FeedPB$GetLikeInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QZoneHelper.QZoneAlbumConstants.KEY_LIKE_INFO}, new Object[]{null}, FeedPB$GetLikeInfoRsp.class);
    public FeedPB$LikeInfo like_info = new FeedPB$LikeInfo();
}
