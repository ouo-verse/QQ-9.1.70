package com.tencent.trpcprotocol.kuolie.login_svr.login_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$DocumentConfig;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class LoginSvr$LoginInfoReportRsp extends MessageMicro<LoginSvr$LoginInfoReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBStringField open_id = PBField.initString("");
    public final PBBoolField is_new_user = PBField.initBool(false);
    public userInfo$DocumentConfig document_config = new userInfo$DocumentConfig();
    public final PBBoolField new_register = PBField.initBool(false);
    public final PBEnumField user_type = PBField.initEnum(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"ret_code", "open_id", "is_new_user", "document_config", "new_register", "user_type"}, new Object[]{0, "", bool, null, bool, 0}, LoginSvr$LoginInfoReportRsp.class);
    }
}
