package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetSubscribeInfoRsp extends MessageMicro<QQGamePubSubscribe$GetSubscribeInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"appList"}, new Object[]{null}, QQGamePubSubscribe$GetSubscribeInfoRsp.class);
    public final PBRepeatMessageField<QQGamePubSubscribe$AppSubscribeInfo> appList = PBField.initRepeatMessage(QQGamePubSubscribe$AppSubscribeInfo.class);
}
