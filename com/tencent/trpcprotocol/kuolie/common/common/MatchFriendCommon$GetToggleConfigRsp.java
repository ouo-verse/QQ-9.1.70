package com.tencent.trpcprotocol.kuolie.common.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class MatchFriendCommon$GetToggleConfigRsp extends MessageMicro<MatchFriendCommon$GetToggleConfigRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"toogle_value", "is_open"}, new Object[]{"", Boolean.FALSE}, MatchFriendCommon$GetToggleConfigRsp.class);
    public final PBStringField toogle_value = PBField.initString("");
    public final PBBoolField is_open = PBField.initBool(false);
}
