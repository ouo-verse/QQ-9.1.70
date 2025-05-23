package com.tencent.pb.now;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class ilive_feeds_read$FollowTabRedPointRsp extends MessageMicro<ilive_feeds_read$FollowTabRedPointRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "red"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, ilive_feeds_read$FollowTabRedPointRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field red = PBField.initInt32(0);
}
