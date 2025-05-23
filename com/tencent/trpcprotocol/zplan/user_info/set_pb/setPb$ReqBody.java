package com.tencent.trpcprotocol.zplan.user_info.set_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.trpcprotocol.zplan.user_info.common_pb.commonPb$UserInfo;

/* loaded from: classes27.dex */
public final class setPb$ReqBody extends MessageMicro<setPb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_info"}, new Object[]{null}, setPb$ReqBody.class);
    public commonPb$UserInfo user_info = new commonPb$UserInfo();
}
