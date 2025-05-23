package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_write$ModFeedRsp extends MessageMicro<ilive_feeds_write$ModFeedRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField err_msg;
    public final PBBytesField feed_id;
    public final PBUInt32Field ret;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"feed_id", "ret", "err_msg"}, new Object[]{byteStringMicro, 0, byteStringMicro}, ilive_feeds_write$ModFeedRsp.class);
    }

    public ilive_feeds_write$ModFeedRsp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.feed_id = PBField.initBytes(byteStringMicro);
        this.ret = PBField.initUInt32(0);
        this.err_msg = PBField.initBytes(byteStringMicro);
    }
}
