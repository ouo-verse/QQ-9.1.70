package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class QQGamePubSubscribe$GetPublicAccountInfoReq extends MessageMicro<QQGamePubSubscribe$GetPublicAccountInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN}, new Object[]{0L}, QQGamePubSubscribe$GetPublicAccountInfoReq.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
}
