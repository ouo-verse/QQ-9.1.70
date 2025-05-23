package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class RedPackSkin$GetUserSkinRsp extends MessageMicro<RedPackSkin$GetUserSkinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"skins", "selected_skin_from", "selected_skin_id", "selected_outer_skin_id", "activities"}, new Object[]{null, 0, 0, "", null}, RedPackSkin$GetUserSkinRsp.class);
    public final PBRepeatMessageField<RedPackSkin$SkinInfo> skins = PBField.initRepeatMessage(RedPackSkin$SkinInfo.class);
    public final PBEnumField selected_skin_from = PBField.initEnum(0);
    public final PBInt32Field selected_skin_id = PBField.initInt32(0);
    public final PBStringField selected_outer_skin_id = PBField.initString("");
    public final PBRepeatMessageField<RedPackSkin$Activity> activities = PBField.initRepeatMessage(RedPackSkin$Activity.class);
}
