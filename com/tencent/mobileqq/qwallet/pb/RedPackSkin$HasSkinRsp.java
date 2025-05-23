package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class RedPackSkin$HasSkinRsp extends MessageMicro<RedPackSkin$HasSkinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"has_skin"}, new Object[]{Boolean.FALSE}, RedPackSkin$HasSkinRsp.class);
    public final PBBoolField has_skin = PBField.initBool(false);
}
