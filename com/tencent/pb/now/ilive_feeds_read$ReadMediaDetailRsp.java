package com.tencent.pb.now;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadMediaDetailRsp extends MessageMicro<ilive_feeds_read$ReadMediaDetailRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"media_list", CheckForwardServlet.KEY_ERR_CODE, "err_msg", "is_end", "total"}, new Object[]{null, 0, ByteStringMicro.EMPTY, 0, 0}, ilive_feeds_read$ReadMediaDetailRsp.class);
    public final PBRepeatMessageField<FeedsProtocol$MediaInfo> media_list = PBField.initRepeatMessage(FeedsProtocol$MediaInfo.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
}
