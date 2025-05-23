package com.tencent.mobileqq.qqshop.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes17.dex */
public final class QQShopMsgPB$GetDefaultRsp extends MessageMicro<QQShopMsgPB$GetDefaultRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg"}, new Object[]{null}, QQShopMsgPB$GetDefaultRsp.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<QQShopMsgPB$DefaultMsg> f274500msg = PBField.initRepeatMessage(QQShopMsgPB$DefaultMsg.class);
}
