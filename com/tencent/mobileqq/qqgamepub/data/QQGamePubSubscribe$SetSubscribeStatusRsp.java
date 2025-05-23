package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$SetSubscribeStatusRsp extends MessageMicro<QQGamePubSubscribe$SetSubscribeStatusRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appList"}, new Object[]{null}, QQGamePubSubscribe$SetSubscribeStatusRsp.class);
    public final PBRepeatMessageField<QQGamePubSubscribe$AppSubscribeInfo> appList = PBField.initRepeatMessage(QQGamePubSubscribe$AppSubscribeInfo.class);
}
