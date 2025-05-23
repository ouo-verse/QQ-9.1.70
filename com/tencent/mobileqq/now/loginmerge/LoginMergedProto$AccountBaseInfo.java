package com.tencent.mobileqq.now.loginmerge;

import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class LoginMergedProto$AccountBaseInfo extends MessageMicro<LoginMergedProto$AccountBaseInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{MsfConstants.ATTRIBUTE_LOGIN_TYPE, "uid", "tinyid"}, new Object[]{0, 0L, 0L}, LoginMergedProto$AccountBaseInfo.class);
    public final PBUInt32Field login_type = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
}
