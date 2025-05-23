package com.tencent.trpcprotocol.gamecenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes11.dex */
public final class QqCardSvrPB$GetSwitchReq extends MessageMicro<QqCardSvrPB$GetSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, QqCardSvrPB$GetSwitchReq.class);
    public final PBInt64Field uin = PBField.initInt64(0);
}
