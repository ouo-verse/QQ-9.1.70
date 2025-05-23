package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetSubscribeListReq extends MessageMicro<QQGamePubSubscribe$GetSubscribeListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"query"}, new Object[]{0}, QQGamePubSubscribe$GetSubscribeListReq.class);
    public final PBEnumField query = PBField.initEnum(0);
}
