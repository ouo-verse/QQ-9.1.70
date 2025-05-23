package com.tencent.mobileqq.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;

/* loaded from: classes16.dex */
public final class accountPage {

    /* loaded from: classes16.dex */
    public static final class GetAccountPageURLReq extends MessageMicro<GetAccountPageURLReq> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetAccountPageURLReq.class);
    }

    /* loaded from: classes16.dex */
    public static final class GetAccountPageURLRsp extends MessageMicro<GetAccountPageURLRsp> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"url", VasQQSettingMeImpl.EXPIRE_TIME}, new Object[]{"", 0L}, GetAccountPageURLRsp.class);
        public final PBStringField url = PBField.initString("");
        public final PBInt64Field expire_time = PBField.initInt64(0);
    }

    accountPage() {
    }
}
