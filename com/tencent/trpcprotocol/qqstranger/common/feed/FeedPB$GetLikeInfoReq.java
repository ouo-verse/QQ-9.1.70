package com.tencent.trpcprotocol.qqstranger.common.feed;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;

/* loaded from: classes38.dex */
public final class FeedPB$GetLikeInfoReq extends MessageMicro<FeedPB$GetLikeInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, new String[]{AppConstants.Key.SHARE_REQ_TYPE, "need_count", "user_id", IQzoneMsgApi.LIKE_KEY, "round_param", "count"}, new Object[]{0, 0, "", "", "", 0}, FeedPB$GetLikeInfoReq.class);
    public final PBInt32Field req_type = PBField.initInt32(0);
    public final PBInt32Field need_count = PBField.initInt32(0);
    public final PBStringField user_id = PBField.initString("");
    public final PBStringField like_key = PBField.initString("");
    public final PBStringField round_param = PBField.initString("");
    public final PBUInt32Field count = PBField.initUInt32(0);
}
