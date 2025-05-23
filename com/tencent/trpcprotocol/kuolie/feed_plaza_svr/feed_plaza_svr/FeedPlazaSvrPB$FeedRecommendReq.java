package com.tencent.trpcprotocol.kuolie.feed_plaza_svr.feed_plaza_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes38.dex */
public final class FeedPlazaSvrPB$FeedRecommendReq extends MessageMicro<FeedPlazaSvrPB$FeedRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16, 24, 34}, new String[]{"req_count", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "ext_data"}, new Object[]{0, 0, ""}, FeedPlazaSvrPB$FeedRecommendReq.class);
    public final PBUInt32Field req_count = PBField.initUInt32(0);
    public final PBEnumField feed_type = PBField.initEnum(0);
    public final PBStringField ext_data = PBField.initString("");
}
