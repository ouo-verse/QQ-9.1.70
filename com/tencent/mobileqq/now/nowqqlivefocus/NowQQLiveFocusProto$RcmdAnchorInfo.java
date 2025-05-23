package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$RcmdAnchorInfo extends MessageMicro<NowQQLiveFocusProto$RcmdAnchorInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"logo_url", "uin"}, new Object[]{"", 0L}, NowQQLiveFocusProto$RcmdAnchorInfo.class);
    public final PBStringField logo_url = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
