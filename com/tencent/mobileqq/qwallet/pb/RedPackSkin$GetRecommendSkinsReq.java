package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetRecommendSkinsReq extends MessageMicro<RedPackSkin$GetRecommendSkinsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"skin_id", "scene"}, new Object[]{0, 0}, RedPackSkin$GetRecommendSkinsReq.class);
    public final PBInt32Field skin_id = PBField.initInt32(0);
    public final PBEnumField scene = PBField.initEnum(0);
}
