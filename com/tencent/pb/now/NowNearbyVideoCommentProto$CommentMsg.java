package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class NowNearbyVideoCommentProto$CommentMsg extends MessageMicro<NowNearbyVideoCommentProto$CommentMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"type", "msg"}, new Object[]{0, ByteStringMicro.EMPTY}, NowNearbyVideoCommentProto$CommentMsg.class);
    public final PBUInt32Field type = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBBytesField f342139msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
