package com.tencent.trpcprotocol.gamecenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes11.dex */
public final class QqCardSvrPB$SetSwitchReq extends MessageMicro<QqCardSvrPB$SetSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{16}, new String[]{"status"}, new Object[]{0}, QqCardSvrPB$SetSwitchReq.class);
    public final PBEnumField status = PBField.initEnum(0);
}
