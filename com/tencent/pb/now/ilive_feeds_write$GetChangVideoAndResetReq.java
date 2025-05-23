package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$GetChangVideoAndResetReq extends MessageMicro<ilive_feeds_write$GetChangVideoAndResetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"chang_feedsid"}, new Object[]{ByteStringMicro.EMPTY}, ilive_feeds_write$GetChangVideoAndResetReq.class);
    public final PBBytesField chang_feedsid = PBField.initBytes(ByteStringMicro.EMPTY);
}
