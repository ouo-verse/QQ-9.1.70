package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetSubscribeListRsp extends MessageMicro<QQGamePubSubscribe$GetSubscribeListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"subscribeList", "playList", "rankList"}, new Object[]{null, null, null}, QQGamePubSubscribe$GetSubscribeListRsp.class);
    public final PBRepeatMessageField<QQGamePubSubscribe$AppSubscribeInfo> subscribeList = PBField.initRepeatMessage(QQGamePubSubscribe$AppSubscribeInfo.class);
    public final PBRepeatMessageField<QQGamePubSubscribe$AppSubscribeInfo> playList = PBField.initRepeatMessage(QQGamePubSubscribe$AppSubscribeInfo.class);
    public final PBRepeatMessageField<QQGamePubSubscribe$AppSubscribeInfo> rankList = PBField.initRepeatMessage(QQGamePubSubscribe$AppSubscribeInfo.class);
}
