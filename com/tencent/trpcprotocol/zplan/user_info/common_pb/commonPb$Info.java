package com.tencent.trpcprotocol.zplan.user_info.common_pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.oskplayer.util.SecretUtils;

/* loaded from: classes27.dex */
public final class commonPb$Info extends MessageMicro<commonPb$Info> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{SecretUtils.DES, "value"}, new Object[]{null, ""}, commonPb$Info.class);
    public commonPb$InfoDes des = new commonPb$InfoDes();
    public final PBStringField value = PBField.initString("");
}
