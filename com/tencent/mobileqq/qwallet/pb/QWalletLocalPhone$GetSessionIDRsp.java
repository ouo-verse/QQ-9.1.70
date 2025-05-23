package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* loaded from: classes16.dex */
public final class QWalletLocalPhone$GetSessionIDRsp extends MessageMicro<QWalletLocalPhone$GetSessionIDRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{ServiceConst.PARA_SESSION_ID}, new Object[]{""}, QWalletLocalPhone$GetSessionIDRsp.class);
    public final PBStringField session_id = PBField.initString("");
}
