package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$AddCommentNoFilterResp extends MessageMicro<NowNearbyVideoCommentProto$AddCommentNoFilterResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"result", "comment_id", "wording"}, new Object[]{0L, 0L, ByteStringMicro.EMPTY}, NowNearbyVideoCommentProto$AddCommentNoFilterResp.class);
    public final PBUInt64Field result = PBField.initUInt64(0);
    public final PBUInt64Field comment_id = PBField.initUInt64(0);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
