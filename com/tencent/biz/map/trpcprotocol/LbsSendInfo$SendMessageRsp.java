package com.tencent.biz.map.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LbsSendInfo$SendMessageRsp extends MessageMicro<LbsSendInfo$SendMessageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"return_code"}, new Object[]{0}, LbsSendInfo$SendMessageRsp.class);
    public final PBEnumField return_code = PBField.initEnum(0);
}
