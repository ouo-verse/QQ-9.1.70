package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$RetInfo extends MessageMicro<NowQQLiveFocusProto$RetInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg"}, new Object[]{0, ""}, NowQQLiveFocusProto$RetInfo.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
}
