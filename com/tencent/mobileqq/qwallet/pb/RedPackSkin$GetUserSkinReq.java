package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetUserSkinReq extends MessageMicro<RedPackSkin$GetUserSkinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"aio_type"}, new Object[]{0}, RedPackSkin$GetUserSkinReq.class);
    public final PBInt32Field aio_type = PBField.initInt32(0);
}
