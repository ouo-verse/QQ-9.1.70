package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetPublicAccountInfoRsp extends MessageMicro<QQGamePubSubscribe$GetPublicAccountInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"isFollowed"}, new Object[]{Boolean.FALSE}, QQGamePubSubscribe$GetPublicAccountInfoRsp.class);
    public final PBBoolField isFollowed = PBField.initBool(false);
}
