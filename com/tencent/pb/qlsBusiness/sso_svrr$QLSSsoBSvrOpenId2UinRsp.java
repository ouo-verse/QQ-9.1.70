package com.tencent.pb.qlsBusiness;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class sso_svrr$QLSSsoBSvrOpenId2UinRsp extends MessageMicro<sso_svrr$QLSSsoBSvrOpenId2UinRsp> {
    public static final int APPID_FIELD_NUMBER = 2;
    public static final int HEADER_FIELD_NUMBER = 1;
    public static final int OPENID_FIELD_NUMBER = 3;
    public static final int QQUIN_FIELD_NUMBER = 5;
    public static final int RESULT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"header", "appid", "openid", "result", "qquin"}, new Object[]{null, 0, "", 0, 0}, sso_svrr$QLSSsoBSvrOpenId2UinRsp.class);
    public sso_svrr$QLSSsoBSvrHeader header = new sso_svrr$QLSSsoBSvrHeader();
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field qquin = PBField.initUInt32(0);
}
