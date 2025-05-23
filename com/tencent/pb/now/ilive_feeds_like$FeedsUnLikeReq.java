package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_like$FeedsUnLikeReq extends MessageMicro<ilive_feeds_like$FeedsUnLikeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"id"}, new Object[]{ByteStringMicro.EMPTY}, ilive_feeds_like$FeedsUnLikeReq.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBBytesField f342143id = PBField.initBytes(ByteStringMicro.EMPTY);
}
