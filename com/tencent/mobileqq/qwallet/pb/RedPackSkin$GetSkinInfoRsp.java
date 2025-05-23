package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetSkinInfoRsp extends MessageMicro<RedPackSkin$GetSkinInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 34, 40}, new String[]{"version", "skins", "next_period"}, new Object[]{"", null, 0L}, RedPackSkin$GetSkinInfoRsp.class);
    public final PBStringField version = PBField.initString("");
    public final PBRepeatMessageField<RedPackSkin$SkinInfo> skins = PBField.initRepeatMessage(RedPackSkin$SkinInfo.class);
    public final PBInt64Field next_period = PBField.initInt64(0);
}
