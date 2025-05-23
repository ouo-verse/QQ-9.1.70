package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetCommentListReq extends MessageMicro<NowNearbyVideoCommentProto$GetCommentListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40}, new String[]{QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, "feed_id", "page", "count", "filter"}, new Object[]{0L, "", 0L, 0L, 0L}, NowNearbyVideoCommentProto$GetCommentListReq.class);
    public final PBUInt64Field feed_type = PBField.initUInt64(0);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field page = PBField.initUInt64(0);
    public final PBUInt64Field count = PBField.initUInt64(0);
    public final PBUInt64Field filter = PBField.initUInt64(0);
}
