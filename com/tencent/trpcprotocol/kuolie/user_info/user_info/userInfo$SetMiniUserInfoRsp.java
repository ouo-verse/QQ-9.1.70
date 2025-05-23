package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$SetMiniUserInfoRsp extends MessageMicro<userInfo$SetMiniUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", "value", "document_config"}, new Object[]{0, "", 0, null}, userInfo$SetMiniUserInfoRsp.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field value = PBField.initUInt32(0);
    public userInfo$DocumentConfig document_config = new userInfo$DocumentConfig();
}
