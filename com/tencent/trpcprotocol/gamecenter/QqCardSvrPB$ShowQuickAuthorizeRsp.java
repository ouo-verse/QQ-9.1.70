package com.tencent.trpcprotocol.gamecenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes11.dex */
public final class QqCardSvrPB$ShowQuickAuthorizeRsp extends MessageMicro<QqCardSvrPB$ShowQuickAuthorizeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"should_show"}, new Object[]{Boolean.FALSE}, QqCardSvrPB$ShowQuickAuthorizeRsp.class);
    public final PBBoolField should_show = PBField.initBool(false);
}
