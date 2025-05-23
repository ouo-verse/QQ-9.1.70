package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$GetStickReq extends MessageMicro<NowNearbyVideoCommentProto$GetStickReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"feeds_id", QCircleFolderFunnelCollect.EXTRA_FEED_TYPE}, new Object[]{ByteStringMicro.EMPTY, 0L}, NowNearbyVideoCommentProto$GetStickReq.class);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field feed_type = PBField.initUInt64(0);
}
